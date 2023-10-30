package org.knowm.xchange.amber.dto.trade;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.knowm.xchange.amber.dto.trade.AmberTradeAdd;

public class AmberTradeAddJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        AmberTradeAddJSONTest.class.getResourceAsStream(
            "/org/xchange/amber/dto/trade/example-trade-add-data.json");

    // Parse JSON Example Using Jackson
    ObjectMapper mapper = new ObjectMapper();
    AmberTradeAdd coinEggTradeAdd = mapper.readValue(is, AmberTradeAdd.class);

    // Verify The Ticker Unmarshalls Correctly
    assertThat(coinEggTradeAdd).isNotNull();

    assertThat(coinEggTradeAdd.getResult()).isEqualTo(true);
    assertThat(coinEggTradeAdd.getID()).isEqualTo(11);
  }
}
