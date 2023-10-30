package org.knowm.xchange.amber.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.amber.Amber;
import org.knowm.xchange.amber.AmberAuthenticated;
import org.knowm.xchange.amber.AmberDigest;
import org.knowm.xchange.client.ExchangeRestProxyBuilder;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;

import si.mazi.rescu.ParamsDigest;

public class AmberBaseService extends BaseExchangeService implements BaseService {

  protected Amber amberUnauth;
  protected AmberAuthenticated amberAuthenticated;
  protected ParamsDigest signatureCreator; 
  protected String apiKey;

  public AmberBaseService(Exchange exchange) {
    super(exchange);
    ExchangeSpecification spec = exchange.getExchangeSpecification();
    this.apiKey = spec.getApiKey();
    this.amberUnauth =
        ExchangeRestProxyBuilder.forInterface(Amber.class, exchange.getExchangeSpecification())
            .build();
    this.amberAuthenticated =
            ExchangeRestProxyBuilder.forInterface(
                    AmberAuthenticated.class, exchange.getExchangeSpecification())
                .build();
    signatureCreator =
            AmberDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());    
  }
  
  
  
}
