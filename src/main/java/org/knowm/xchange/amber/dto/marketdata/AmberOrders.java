package org.knowm.xchange.amber.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

public class AmberOrders {

	private final List<AmberPublicOrder> asks;
	  private final List<AmberPublicOrder> bids;

	  /**
	   * Constructor
	   *
	   * @param asks
	   * @param bids
	   */
	  public AmberOrders(
	      @JsonProperty("asks") List<AmberPublicOrder> asks,
	      @JsonProperty("bids") List<AmberPublicOrder> bids) {

	    this.asks = asks;
	    this.bids = bids;
	  }

	  public List<AmberPublicOrder> getAsks() {

	    return asks;
	  }

	  public List<AmberPublicOrder> getBids() {

	    return bids;
	  }

	  @Override
	  public String toString() {

	    return "KrakenDepth [asks=" + asks + ", bids=" + bids + "]";
	  }
}
