package org.knowm.xchange.amber.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AmberTradeCancel {

  private final boolean result;
  private final int id;

  public AmberTradeCancel(@JsonProperty("result") boolean result, @JsonProperty("id") int id) {
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
