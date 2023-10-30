package org.knowm.xchange.amber.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import org.junit.Test;
import org.knowm.xchange.amber.dto.marketdata.AmberTrade;
import org.knowm.xchange.amber.dto.marketdata.AmberTrade.Type;

public class AmberTradesJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        AmberTradesJSONTest.class.getResourceAsStream(
            "/org/xchange/amber/dto/marketdata/example-orders-data.json");

    // Parse JSON Example Using Jackson
    ObjectMapper mapper = new ObjectMapper();
    AmberTrade[] coinEggTrades = mapper.readValue(is, AmberTrade[].class);

    // Verify The Ticker Unmarshalls Correctly
    assertThat(coinEggTrades).isNotNull();

    // Verify Buy Order

    assertThat(coinEggTrades[0].getTimestamp()).isEqualTo(0);
    assertThat(coinEggTrades[0].getPrice()).isEqualTo(new BigDecimal("3"));
    assertThat(coinEggTrades[0].getAmount()).isEqualTo(new BigDecimal("0.1"));
    assertThat(coinEggTrades[0].getTransactionID()).isEqualTo(1);
    assertThat(coinEggTrades[0].getType()).isEqualTo(Type.BUY);

    // Verify Sell Order
    assertThat(coinEggTrades[1].getTimestamp()).isEqualTo(0);
    assertThat(coinEggTrades[1].getPrice()).isEqualTo(new BigDecimal("32323"));
    assertThat(coinEggTrades[1].getAmount()).isEqualTo(new BigDecimal("2"));
    assertThat(coinEggTrades[1].getTransactionID()).isEqualTo(2);
    assertThat(coinEggTrades[1].getType()).isEqualTo(Type.SELL);
  }
}
