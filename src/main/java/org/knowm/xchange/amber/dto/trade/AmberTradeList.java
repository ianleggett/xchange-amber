package org.knowm.xchange.amber.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.math.BigDecimal;
import java.util.Date;

import org.knowm.xchange.amber.dto.marketdata.AmberTrade.Type;
import org.knowm.xchange.utils.DateUtils;

public class AmberTradeList {

  private final int id;
  private final Type type;
  private final BigDecimal price;
  private final BigDecimal amountOriginal;
  private final BigDecimal amountOutstanding;
  private Date datetime;

  public AmberTradeList(
      @JsonProperty("id") int id,
      @JsonProperty("datetime") String datetime,
      @JsonProperty("type") Type type,
      @JsonProperty("price") BigDecimal price,
      @JsonProperty("amount_original") BigDecimal amountOriginal,
      @JsonProperty("amount_outstanding") BigDecimal amountOutstanding) {

    this.id = id;
    this.type = type;
    this.price = price;
    this.amountOriginal = amountOriginal;
    this.amountOutstanding = amountOutstanding;

    try {
      this.datetime = DateUtils.fromISO8601DateString(datetime);
    } catch (InvalidFormatException e) {
      this.datetime = null;
    }
  }

  public Date getDateTime() {
    return datetime;
  }

  public int getID() {
    return id;
  }

  public Type getType() {
    return type;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getAmountOriginal() {
    return amountOriginal;
  }

  public BigDecimal getAmountOutstanding() {
    return amountOutstanding;
  }
}
