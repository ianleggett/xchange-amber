package org.knowm.xchange.amber;

import java.util.HashMap;
import java.util.Map;

import org.knowm.xchange.amber.dto.marketdata.AmberAssetPair;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.exceptions.ExchangeException;

/** @author timmolter */
public class AmberUtils {

  private static Map<String, CurrencyPair> assetPairMap = new HashMap<String, CurrencyPair>();
  private static Map<CurrencyPair, String> assetPairMapReverse =
      new HashMap<CurrencyPair, String>();
  private static Map<String, Currency> assetsMap = new HashMap<String, Currency>();
  private static Map<Currency, String> assetsMapReverse = new HashMap<Currency, String>();

  /** https://support.kraken.com/hc/en-us/articles/360001185506-How-to-interpret-asset-codes */
  private static Map<String, String> discontinuedCurrencies;

  static {
    discontinuedCurrencies = new HashMap<>();
//    discontinuedCurrencies.put("XICN", "ICN");
//    discontinuedCurrencies.put("BSV", "BSV");
//    discontinuedCurrencies.put("XDAO", "DAO");
//    discontinuedCurrencies.put("XNMC", "NMC");
//    discontinuedCurrencies.put("XXVN", "XVN");
//    discontinuedCurrencies.put("ZKRW", "KRW");
  }

  /** Private Constructor */
  private AmberUtils() {}

  static public String getSide(OrderType side) {
	  switch(side) {
	  	case ASK: return "sell";
	  	case BID: return "buy";
	  	default: throw new IllegalAccessError("Not expecting side of type "+side);
	  }	  
  }
  
  public static Map<String, Currency> getAssetsMap(){
	  return assetsMap;
  }
  
  public static Map<String, CurrencyPair> getAssetPairMap(){
	  return assetPairMap;
  }
  
  public static void setAssetPairs(Map<String, AmberAssetPair> pairs) {
    if (assetPairMap.isEmpty()) {
      for (Map.Entry<String, AmberAssetPair> entry : pairs.entrySet()) {  
    	  entry.getValue().setCCYPair( entry.getKey() );
    	  Currency baseCcy = Currency.getInstance(entry.getValue().getBaseCcy());
    	  Currency counterCcy = Currency.getInstance(entry.getValue().getCounterCcy());
          // now build asset map
          assetsMap.put(entry.getValue().getBaseCcy(),baseCcy);
          assetsMap.put(entry.getValue().getCounterCcy(),counterCcy);
    	  
          CurrencyPair pair =
              new CurrencyPair(
            	translateAmberCurrencyCode( entry.getValue().getBaseCcy() ),
            	translateAmberCurrencyCode( entry.getValue().getCounterCcy() ) );
          assetPairMap.put(entry.getKey(), pair);
          assetPairMapReverse.put(pair, entry.getKey());    
      }
    }
  }

  static public String getCurrencyPair(CurrencyPair cp) {
	  return assetPairMapReverse.get(cp);
  }

//  public static String createAmberCurrencyPair(CurrencyPair currencyPair) {
//    return assetPairMapReverse.get(currencyPair);
//  }

//  public static CurrencyPair translateAmberCurrencyPair(String currencyPairIn) {
//    CurrencyPair pair = assetPairMap.get(currencyPairIn);
//    if (pair == null) {
//      // kraken can give short pairs back from open orders ?
//      if (currencyPairIn.length() >= 6 && currencyPairIn.length() <= 8) {
//        int firstCurrencyLength = currencyPairIn.length() - 3;
//        Currency base = Currency.getInstance(currencyPairIn.substring(0, firstCurrencyLength));
//        if (base.getCommonlyUsedCurrency() != null) {
//          base = base.getCommonlyUsedCurrency();
//        }
//        Currency counter =
//            Currency.getInstance(
//                currencyPairIn.substring(firstCurrencyLength, currencyPairIn.length()));
//        if (counter.getCommonlyUsedCurrency() != null) {
//          counter = counter.getCommonlyUsedCurrency();
//        }
//        pair = new CurrencyPair(base, counter);
//      }
//    }
//    return pair;
//  }

//  public static String createAmberCurrencyPair(Currency tradableIdentifier, Currency currency) {
//    return createAmberCurrencyPair(new CurrencyPair(tradableIdentifier, currency));
//  }
//
//  public static String getAmberCurrencyCode(Currency currency) {
//    if (currency.getIso4217Currency() != null) {
//      currency = currency.getIso4217Currency();
//    }
//    String krakenCode = assetsMapReverse.get(currency);
//    if (krakenCode == null) {
//      throw new ExchangeException("Amber does not support the currency code " + currency);
//    }
//    return krakenCode;
//  }

  public static Currency translateAmberCurrencyCode(String currencyIn) {
    if (discontinuedCurrencies.containsKey(currencyIn)) {
      return Currency.getInstance(discontinuedCurrencies.get(currencyIn));
    }
    Currency currencyOut = assetsMap.get(currencyIn);
    if (currencyOut == null) {
      throw new ExchangeException("Amber does not support the currency code " + currencyIn);
    }
    return currencyOut.getCommonlyUsedCurrency();
  }

  public static void clearAssets() {
    assetPairMap.clear();
    assetPairMapReverse.clear();
    assetsMap.clear();
    assetsMapReverse.clear();
  }
}
