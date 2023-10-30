package org.knowm.xchange.amber.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

import org.knowm.xchange.amber.dto.marketdata.AmberTrade.Type;

public class AmberTradeView extends AmberTradeList {

  private final String status;

  public AmberTradeView(
      @JsonProperty("id") int id,
      @JsonProperty("datetime") String datetime,
      @JsonProperty("type") Type type,
      @JsonProperty("price") BigDecimal price,
      @JsonProperty("amount_original") BigDecimal amountOriginal,
      @JsonProperty("amount_outstanding") BigDecimal amountOutstanding,
      @JsonProperty("status") String status) {

    super(id, datetime, type, price, amountOriginal, amountOutstanding);
    this.status = status;
  }

  public boolean isOpen() {
    return status.toUpperCase().equals("OPEN");
  }
}
