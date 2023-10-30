package org.knowm.xchange.amber;

import java.math.BigDecimal;
import java.util.*;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.amber.AmberAdapters.OrdersContainer;
import org.knowm.xchange.amber.dto.AmberOrderBook;
import org.knowm.xchange.amber.dto.accounts.AmberBalanceData;
import org.knowm.xchange.amber.dto.marketdata.AmberAssetPair;
import org.knowm.xchange.amber.dto.marketdata.AmberDepth;
import org.knowm.xchange.amber.dto.marketdata.AmberPublicOrder;
import org.knowm.xchange.amber.dto.marketdata.AmberTicker;
import org.knowm.xchange.amber.dto.marketdata.AmberTrade.Type;
import org.knowm.xchange.amber.dto.trade.AmberTradeAdd;
import org.knowm.xchange.amber.dto.trade.AmberTradeCancel;
import org.knowm.xchange.amber.dto.trade.AmberTradeView;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;

public class AmberAdapters {

//	public static OrderBook adaptOrderBook(AmberDepth btceDepth, CurrencyPair currencyPair) {
//
//		OrdersContainer asksOrdersContainer = adaptOrders(btceDepth.getAsks(), currencyPair, OrderType.ASK);
//		OrdersContainer bidsOrdersContainer = adaptOrders(btceDepth.getBids(), currencyPair, OrderType.BID);
//
//		return new OrderBook(new Date(Math.max(asksOrdersContainer.getTimestamp(), bidsOrdersContainer.getTimestamp())),
//				asksOrdersContainer.getLimitOrders(), bidsOrdersContainer.getLimitOrders());
//	}
	
	public static OrderBook adaptOrderBook(AmberOrderBook ord,CurrencyPair currencyPair ) {
		  OrdersContainer asksOrdersContainer =
			        adaptOrders(ord.getMetadata().getAsks(), currencyPair, OrderType.ASK);
		   OrdersContainer bidsOrdersContainer =
			        adaptOrders(ord.getMetadata().getBids(), currencyPair, OrderType.BID);

			    return new OrderBook(
			        new Date(Math.max(asksOrdersContainer.getTimestamp(), bidsOrdersContainer.getTimestamp())),
			        asksOrdersContainer.getLimitOrders(),
			        bidsOrdersContainer.getLimitOrders());
	}		
	
	
	 public static OrdersContainer adaptOrders(
		      List<AmberPublicOrder> amberLevels, CurrencyPair currencyPair, OrderType orderType) {

		    Date maxTimestamp = new Date();
		    List<LimitOrder> limitOrders = new ArrayList<>(amberLevels.size());
		    amberLevels.forEach( al -> { limitOrders.add(
		    		new LimitOrder(orderType, al.getVolume(), currencyPair, "",new Date(), al.getPrice()));
		    		});
		  //  long maxTimestampInMillis = maxTimestamp.multiply(new BigDecimal(1000L)).longValue();
		    return new OrdersContainer(maxTimestamp.getTime(), limitOrders);
		  }

//	public static OpenPositions adaptOpenPositions(Map<String, AmberOpenPosition> krakenOpenPositionMap) {
//		List<OpenPosition> openPositionsList = new ArrayList<>();
//
//		krakenOpenPositionMap.values().forEach(krakenOpenPosition -> {
//			openPositionsList
//					.add(new OpenPosition.Builder().instrument(new CurrencyPair(krakenOpenPosition.getAssetPair()))
//							.type(krakenOpenPosition.getType() == KrakenType.BUY ? OpenPosition.Type.LONG
//									: OpenPosition.Type.SHORT)
//							.size(krakenOpenPosition.getCost())
//							.price(krakenOpenPosition.getCost()
//									.divide(krakenOpenPosition.getVolume()
//											.subtract(krakenOpenPosition.getVolumeClosed()), RoundingMode.HALF_EVEN))
//							.build());
//		});
//
//		return new OpenPositions(openPositionsList);
//	}

//	public static List<Order> adaptOrders(Map<String, AmberOrder> krakenOrdersMap) {
//
//		return krakenOrdersMap.entrySet().stream()
//				.map(krakenOrderEntry -> adaptOrder(krakenOrderEntry.getKey(), krakenOrderEntry.getValue()))
//				.collect(Collectors.toList());
//	}
//
//	public static Order adaptOrder(String orderId, AmberOrder krakenOrder) {
//
//		OrderType orderType = adaptOrderType(krakenOrder.getOrderDescription().getType());
//		CurrencyPair currencyPair = adaptCurrencyPair(krakenOrder.getOrderDescription().getAssetPair());
//
//		OrderStatus orderStatus = adaptOrderStatus(krakenOrder.getStatus());
//		BigDecimal filledAmount = krakenOrder.getVolumeExecuted();
//		BigDecimal originalAmount = krakenOrder.getVolume();
//		BigDecimal fee = krakenOrder.getFee();
//
//		if (orderStatus == OrderStatus.NEW && filledAmount.compareTo(BigDecimal.ZERO) > 0
//				&& filledAmount.compareTo(originalAmount) < 0) {
//			orderStatus = OrderStatus.PARTIALLY_FILLED;
//		}
//
//		Double time = krakenOrder.getOpenTimestamp() * 1000; // eg: "opentm":1519731205.9987
//		Date timestamp = new Date(time.longValue());
//
//		if (krakenOrder.getOrderDescription().getOrderType().equals(AmberOrderType.LIMIT))
//			return new LimitOrder(orderType, krakenOrder.getVolume(), currencyPair, orderId, timestamp,
//					krakenOrder.getOrderDescription().getPrice(), krakenOrder.getPrice(),
//					krakenOrder.getVolumeExecuted(), fee, orderStatus, krakenOrder.getUserRefId());
//
//		if (krakenOrder.getOrderDescription().getOrderType().equals(KrakenOrderType.MARKET))
//			return new MarketOrder(orderType, krakenOrder.getVolume(), currencyPair, orderId, timestamp,
//					krakenOrder.getPrice(), krakenOrder.getVolumeExecuted(), fee, orderStatus,
//					krakenOrder.getUserRefId());
//
//		throw new NotYetImplementedForExchangeException();
//	}

	public static LimitOrder adaptOrder(AmberPublicOrder order, OrderType orderType, CurrencyPair currencyPair) {

		//Date timeStamp = new Date(order.getTimestamp() * 1000);
		BigDecimal volume = order.getVolume();

		return new LimitOrder(orderType, volume, currencyPair, "", new Date(), order.getPrice());
	}

	/**
	 * The API does not have Asset list, just asset pairs!!
	 * 
	 * @param originalMetaData
	 * @param assetPairs
	 * @return
	 */
	public static ExchangeMetaData adaptToExchangeMetaData(ExchangeMetaData originalMetaData,
			Map<String, AmberAssetPair> assetPairs) {

		Map<CurrencyPair, CurrencyPairMetaData> pairs = new HashMap<>();
		// add assets before pairs to Utils!
		AmberUtils.setAssetPairs(assetPairs);
		// DEBUG show asset pairs
//		    AmberUtils.getAssetPairMap().forEach( (k,v) ->{
//				  System.out.println(k+" "+v.toString());
//			  });

		// split out asset pairs into single currency list
		Map<String, Currency> ccyMap = AmberUtils.getAssetsMap();
		Map<Currency, CurrencyMetaData> ccyMeta = new HashMap<Currency, CurrencyMetaData>();

		return new ExchangeMetaData(pairs, ccyMeta,
				originalMetaData == null ? null : originalMetaData.getPublicRateLimits(),
				originalMetaData == null ? null : originalMetaData.getPrivateRateLimits(),
				originalMetaData == null ? null : originalMetaData.isShareRateLimits());
	}

	public static Ticker adaptTicker(AmberTicker bvnexTicker, CurrencyPair currencyPair) {
		BigDecimal last = bvnexTicker.getLast();
		BigDecimal bid = bvnexTicker.getSell();
		BigDecimal ask = bvnexTicker.getBuy();
		BigDecimal high = bvnexTicker.getHigh();
		BigDecimal low = bvnexTicker.getLow();
		BigDecimal volume = bvnexTicker.getVolume();

		Ticker ticker = new Ticker.Builder().currencyPair(currencyPair).last(last).bid(bid).ask(ask).high(high).low(low)
				.volume(volume).build();

		return ticker;
	}

	public static AccountInfo adaptAccountInfo(AmberBalanceData amberBalanceData, Exchange exchange) {

		List<Balance> balances = new ArrayList<>();
		// Amber has single wallet with a collection of currency 'balances'
		amberBalanceData.getBalanceDetails().forEach(iter -> {
			balances.add(new Balance(Currency.getInstance(iter.getName()), iter.getAmount(), iter.getWithdrawable(),
					iter.getFrozen()));
		});

		String userName = exchange.getExchangeSpecification().getUserName();
		Wallet wallet = Wallet.Builder.from(balances).build();

		return new AccountInfo(userName, wallet);
	}

	// TODO: Cleanup Code
	// TODO: Make Use Of Adapt Trade
	public static UserTrades adaptTradeHistory(AmberTradeView coinEggTradeView) {
		List<UserTrade> trades = new ArrayList<UserTrade>();
		Trade trade = new Trade.Builder()
				// .currencyPair(null)
				.id(String.valueOf(coinEggTradeView.getID()))
				.type(coinEggTradeView.getType() == Type.BUY ? OrderType.ASK : OrderType.BID)
				.price(coinEggTradeView.getPrice()).originalAmount(coinEggTradeView.getAmountOriginal())
				.timestamp(coinEggTradeView.getDateTime()).build();

		trades.add((UserTrade) UserTrade.Builder.from(trade).build());

		return new UserTrades(trades, null);
	}

	public static String adaptTradeAdd(AmberTradeAdd coinEggTradeAdd) {
		return String.valueOf(coinEggTradeAdd.getID());
	}

	public static boolean adaptTradeCancel(AmberTradeCancel coinEggTradeCancel) {
		return coinEggTradeCancel.getResult();
	}

	public static class OrdersContainer {

		private final long timestamp;
		private final List<LimitOrder> limitOrders;

		/**
		 * Constructor
		 *
		 * @param timestamp
		 * @param limitOrders
		 */
		public OrdersContainer(long timestamp, List<LimitOrder> limitOrders) {

			this.timestamp = timestamp;
			this.limitOrders = limitOrders;
		}

		public long getTimestamp() {

			return timestamp;
		}

		public List<LimitOrder> getLimitOrders() {

			return limitOrders;
		}
	}

}
