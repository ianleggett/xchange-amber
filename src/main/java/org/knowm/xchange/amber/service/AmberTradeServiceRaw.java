package org.knowm.xchange.amber.service;

import java.io.IOException;
import java.math.BigDecimal;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.amber.AmberAuthenticated;
import org.knowm.xchange.amber.AmberDigest;
import org.knowm.xchange.amber.dto.trade.AmberTradeAdd;
import org.knowm.xchange.amber.dto.trade.AmberTradeCancel;
import org.knowm.xchange.amber.dto.trade.AmberTradeView;
import org.knowm.xchange.client.ExchangeRestProxyBuilder;

import si.mazi.rescu.SynchronizedValueFactory;

public class AmberTradeServiceRaw extends AmberBaseService {

  private AmberAuthenticated bvnexAuthenticated;

  private String apiKey;
  private String tradePassword;
  private AmberDigest signer;
  private SynchronizedValueFactory<Long> nonceFactory;

  public AmberTradeServiceRaw(Exchange exchange) {
    super(exchange);

    ExchangeSpecification spec = exchange.getExchangeSpecification();

    this.apiKey = spec.getApiKey();
    this.signer = AmberDigest.createInstance(spec.getSecretKey());
    this.tradePassword = spec.getPassword();
    this.nonceFactory = exchange.getNonceFactory();
    this.bvnexAuthenticated =
        ExchangeRestProxyBuilder.forInterface(
                AmberAuthenticated.class, exchange.getExchangeSpecification())
            .build();
  }

  // TODO: Sort Out Method Grammar
  public AmberTradeAdd getCoinEggTradeAdd(
      BigDecimal amount, BigDecimal price, String type, String coin) throws IOException {
    return bvnexAuthenticated.getTradeAdd(
        apiKey, signer, nonceFactory.createValue(), amount, price, type, coin);
  }

  public AmberTradeCancel getCoinEggTradeCancel(String id, String coin) throws IOException {
    return bvnexAuthenticated.getTradeCancel(
        apiKey, signer, nonceFactory.createValue(), id, coin);
  }

  public AmberTradeView getCoinEggTradeView(String tradeID, String coin) throws IOException {
    return bvnexAuthenticated.getTradeView(
        apiKey, signer, nonceFactory.createValue(), tradeID, coin);
  }
}
