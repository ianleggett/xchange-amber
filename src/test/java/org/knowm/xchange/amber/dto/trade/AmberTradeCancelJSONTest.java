package org.knowm.xchange.amber.dto.trade;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.knowm.xchange.amber.dto.trade.AmberTradeCancel;

public class AmberTradeCancelJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        AmberTradeCancelJSONTest.class.getResourceAsStream(
            "/org/xchange/amber/dto/trade/example-trade-cancel-data.json");

    // Parse JSON Example Using Jackson
    ObjectMapper mapper = new ObjectMapper();
    AmberTradeCancel coinEggTradeCancel = mapper.readValue(is, AmberTradeCancel.class);

    // Verify The Ticker Unmarshalls Correctly
    assertThat(coinEggTradeCancel).isNotNull();

    assertThat(coinEggTradeCancel.getResult()).isEqualTo(true);
    assertThat(coinEggTradeCancel.getID()).isEqualTo(11);
  }
}
