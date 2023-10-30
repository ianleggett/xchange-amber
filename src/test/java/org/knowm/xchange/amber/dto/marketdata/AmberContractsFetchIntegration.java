package org.knowm.xchange.amber.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.amber.AmberExchange;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class AmberContractsFetchIntegration {

  @Test
  public void ordersFetchTest() throws Exception {
	  
    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(AmberExchange.class,"150345e54c68c4a20dee13dd483c5170", "0590b6caa7796f94eb3c8042ec41a30c");
    ExchangeSpecification exchSpec = exchange.getExchangeSpecification();   
//    exchSpec.setApiKey("150345e54c68c4a20dee13dd483c5170"); 
//    exchSpec.setSecretKey( "0590b6caa7796f94eb3c8042ec41a30c" );					 
//    exchange.applySpecification(exchSpec);
    
    MarketDataService mktService = exchange.getMarketDataService();
    //AccountInfo acc = mktService..getAccountInfo();
    // Verify Not Null Values
    //assertThat(acc).isNotNull();
    //Balance bal = acc.getWallet().getBalance(Currency.BTC);
    //assertEquals(bal.getAvailable().doubleValue(),0,0.0001);
    
  }

 
}
