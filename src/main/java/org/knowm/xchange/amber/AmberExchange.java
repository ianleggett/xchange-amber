package org.knowm.xchange.amber;

import java.io.IOException;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.amber.dto.marketdata.AmberContractResult;
import org.knowm.xchange.amber.service.AmberAccountService;
import org.knowm.xchange.amber.service.AmberMarketDataService;
import org.knowm.xchange.amber.service.AmberMarketDataServiceRaw;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.service.trade.TradeService;

public class AmberExchange extends BaseExchange implements Exchange {

  @Override
  protected void initServices() {
    //this.marketDataService = new AmberMarketDataService(this);
    if (exchangeSpecification.getApiKey() != null) {      
	    this.accountService = new AmberAccountService(this);
	    this.marketDataService = new AmberMarketDataService(this);
    }
  }

  @Override
  public void remoteInit() throws IOException, ExchangeException {
	  AmberMarketDataServiceRaw amkdt = (AmberMarketDataServiceRaw)this.getMarketDataService();
	  AmberContractResult assetPairs = amkdt.getContracts();
	   //Note: CurrencyPair Metadata will not contain accurate maker/taker fees
	   //Note: Currency Metadata will only contain price scale
	   exchangeMetaData = AmberAdapters.adaptToExchangeMetaData(
	            exchangeMetaData, assetPairs.getData());	  
  }
    
  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {
    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass());
    exchangeSpecification.setSslUri("https://alpha.amberotc.com");
    exchangeSpecification.setHost("alpha.amberotc.com");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("Amber");
    exchangeSpecification.setExchangeDescription(
        "Amber Pro exchange.");

    return exchangeSpecification;
  }

  @Override
  public TradeService getTradeService() {
    throw new NotAvailableFromExchangeException();
  }
}
