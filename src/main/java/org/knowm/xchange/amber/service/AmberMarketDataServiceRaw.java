package org.knowm.xchange.amber.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.amber.AmberUtils;
import org.knowm.xchange.amber.dto.accounts.AmberRFQ;
import org.knowm.xchange.amber.dto.accounts.AmberRFQResult;
import org.knowm.xchange.amber.dto.marketdata.AmberContractResult;
import org.knowm.xchange.amber.dto.marketdata.AmberTicker;
import org.knowm.xchange.amber.dto.marketdata.AmberTrade;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;

public class AmberMarketDataServiceRaw extends AmberBaseService {

	
  public AmberMarketDataServiceRaw(Exchange exchange) {
    super(exchange);
    ExchangeSpecification spec = exchange.getExchangeSpecification();
    apiKey = spec.getApiKey();     
  }
  
  public AmberContractResult getContracts() throws IOException {
	  return amberUnauth.getContracts(new Date().getTime(), apiKey, this.signatureCreator);
  }
  
  // TODO: Exception Handling - See Bitfinex
  public AmberTicker getTicker(String coin) throws IOException {
    return amberUnauth.getTicker(coin);
  }

  // TODO: Exception Handling - See Bitfinex
  public AmberTrade[] getTrades(String coin) throws IOException {
    return amberUnauth.getTrades(coin);
  }

  public AmberRFQ getAmberRFQ(CurrencyPair currencyPair, BigDecimal qty, OrderType buySell) throws IOException {

	    String ccyPair = AmberUtils.getCurrencyPair(currencyPair);
	    AmberRFQResult result = amberUnauth.getRFQ(new Date().getTime(), apiKey, this.signatureCreator,ccyPair,qty, AmberUtils.getSide(buySell) );

	    return result.getData();
  }
  

}
