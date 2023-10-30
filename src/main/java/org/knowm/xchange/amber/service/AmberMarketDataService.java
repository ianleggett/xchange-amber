package org.knowm.xchange.amber.service;

import java.io.IOException;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.amber.AmberAdapters;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class AmberMarketDataService extends AmberMarketDataServiceRaw
    implements MarketDataService {

  public AmberMarketDataService(Exchange exchange) {
    super(exchange);
  }
  
//  @Override
//  public List<Ticker> getTickers(Params params) throws IOException {
////    if (!(params instanceof CurrencyPairsParam)) {
////      throw new IllegalArgumentException("Params must be instance of CurrencyPairsParam");
////    }
////    Collection<CurrencyPair> pairs = ((CurrencyPairsParam) params).getCurrencyPairs();
////    CurrencyPair[] pair = pairs.toArray(new CurrencyPair[pairs.size()]);
////    return AmberAdapters.adaptTickers(getAmberTickers(pair));
//  }
  
  @Override
  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws IOException {
    return AmberAdapters.adaptTicker(
        getTicker(currencyPair.base.getCurrencyCode().toLowerCase()), currencyPair);
  }

//  @Override
//  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws IOException {
//    return AmberAdapters.adaptOrders(
//        getOrderBook(
//            currencyPair.counter.getCurrencyCode().toLowerCase(),
//            currencyPair.base.getCurrencyCode().toLowerCase()),
//        currencyPair);
//  }

//  @Override
//  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws IOException {
//    return AmberAdapters.adaptTrades(
//        getCoinEggTrades(currencyPair.base.getCurrencyCode().toLowerCase()), currencyPair);
//  }
}
