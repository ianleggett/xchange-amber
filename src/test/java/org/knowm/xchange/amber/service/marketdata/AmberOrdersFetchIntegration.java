package org.knowm.xchange.amber.service.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.amber.AmberExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class AmberOrdersFetchIntegration {

  @Test
  public void ordersFetchTest() throws Exception {

    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(AmberExchange.class);
    MarketDataService marketDataService = exchange.getMarketDataService();
    OrderBook orders = marketDataService.getOrderBook(CurrencyPair.ETH_BTC);

    // Verify Not Null Values
    assertThat(orders).isNotNull();
  }

  @Test
  public void ordersFetchTest_BTC_USDT() throws Exception {

    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(AmberExchange.class);
    MarketDataService marketDataService = exchange.getMarketDataService();
    OrderBook orders = marketDataService.getOrderBook(CurrencyPair.BTC_USDT);

    // Verify Not Null Values
    assertThat(orders).isNotNull();
  }
}
