package org.knowm.xchange.amber.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AmberTradeAdd {

  private final boolean result;
  private final int id;

  public AmberTradeAdd(@JsonProperty("result") boolean result, @JsonProperty("id") int id) {
    this.result = result;
    this.id = id;
  }

  public boolean getResult() {
    return result;
  }

  public int getID() {
    return id;
  }
}
