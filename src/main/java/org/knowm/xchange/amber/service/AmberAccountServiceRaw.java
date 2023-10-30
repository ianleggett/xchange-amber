package org.knowm.xchange.amber.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.amber.Amber;
import org.knowm.xchange.amber.AmberAuthenticated;
import org.knowm.xchange.amber.AmberDigest;
import org.knowm.xchange.amber.dto.AmberWebsocketTokenResult;
import org.knowm.xchange.amber.dto.accounts.AmberBalance;
import org.knowm.xchange.amber.dto.accounts.AmberBalanceData;
import org.knowm.xchange.amber.dto.accounts.AmberBalanceResult;
import org.knowm.xchange.amber.dto.accounts.AmberWebsocketToken;
import org.knowm.xchange.client.ExchangeRestProxyBuilder;
import si.mazi.rescu.SynchronizedValueFactory;

public class AmberAccountServiceRaw extends AmberBaseService {


  public AmberAccountServiceRaw(Exchange exchange) {
    super(exchange);   
  }
  
//  public AmberWebsocketToken getAmbernWebsocketToken() throws IOException {
//	    AmberWebsocketTokenResult tokenResult =
//	        amberAuthenticated.getWebsocketToken(
//	            null,
//	            null,
//	            exchange.getExchangeSpecification().getApiKey(),
//	            signatureCreator,
//	            exchange.getNonceFactory());
//
//	    return checkResult(tokenResult);
//	  }
  
  public AmberBalanceData getAmberBalanceData() throws IOException {
	  AmberBalanceResult abd = amberUnauth.getBalance(new Date().getTime(), apiKey, this.signatureCreator); 
    return abd.getData();
  }
  
  
  public AmberWebsocketToken getAmbernWebsocketToken() {
	  return new AmberWebsocketToken("token-not yet defined", 100000);
  }
  
}
