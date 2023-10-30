package org.knowm.xchange.amber.dto.marketdata;

import java.math.BigDecimal;

import org.knowm.xchange.currency.CurrencyPair;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AmberAssetPair {

	/**
	 * Created for easy utils operation in exchange
	 */
	@JsonIgnore
	static final char DELIM = '_';
	@JsonIgnore
	String baseCcy;
	@JsonIgnore
	String counterCcy;
	
	BigDecimal order_minimum;
	@JsonCreator
	  public AmberAssetPair(@JsonProperty("order_minimum") BigDecimal order_minimum) {
			this.order_minimum = order_minimum;
		}
	
	public void setCCYPair(String fromRaw) {	
		baseCcy = fromRaw.substring(0,fromRaw.indexOf( DELIM) ).toUpperCase();
		counterCcy = fromRaw.substring(fromRaw.indexOf( DELIM )+1).toUpperCase();
	}
}
