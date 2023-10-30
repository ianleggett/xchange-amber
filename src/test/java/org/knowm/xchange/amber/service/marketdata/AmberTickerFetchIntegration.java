package org.knowm.xchange.amber.service.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.amber.AmberExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class AmberTickerFetchIntegration {

  @Test
  public void tickerFetchTest() throws Exception {

    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(AmberExchange.class);
    MarketDataService marketDataService = exchange.getMarketDataService();
    Ticker ticker = marketDataService.getTicker(CurrencyPair.ETH_BTC);

    // Verify Not Null Values
    assertThat(ticker).isNotNull();

    assertThat(ticker.getLast()).isNotNull();
    assertThat(ticker.getAsk()).isNotNull();
    assertThat(ticker.getBid()).isNotNull();
    assertThat(ticker.getHigh()).isNotNull();
    assertThat(ticker.getLow()).isNotNull();
    assertThat(ticker.getVolume()).isNotNull();
  }
}
