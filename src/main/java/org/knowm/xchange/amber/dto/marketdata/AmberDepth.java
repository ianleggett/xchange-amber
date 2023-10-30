package org.knowm.xchange.amber.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Data object representing depth from Kraken */
public class AmberDepth {

  private final List<AmberPublicOrder> asks;
  private final List<AmberPublicOrder> bids;

  /**
   * Constructor
   *
   * @param asks
   * @param bids
   */
  public AmberDepth(
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
