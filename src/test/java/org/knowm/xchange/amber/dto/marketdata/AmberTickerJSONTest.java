package org.knowm.xchange.amber.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import org.junit.Test;
import org.knowm.xchange.amber.dto.marketdata.AmberTicker;

public class AmberTickerJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        AmberTickerJSONTest.class.getResourceAsStream(
            "/org/xchange/amber/dto/marketdata/example-ticker-data.json");

    // Parse JSON Example Using Jackson
    ObjectMapper mapper = new ObjectMapper();
    AmberTicker coinEggTicker = mapper.readValue(is, AmberTicker.class);

    // Verify The Ticker Unmarshalls Correctly
    assertThat(coinEggTicker).isNotNull();

    assertThat(coinEggTicker.getHigh()).isEqualTo(new BigDecimal("22"));
    assertThat(coinEggTicker.getLow()).isEqualTo(new BigDecimal("20"));
    assertThat(coinEggTicker.getBuy()).isEqualTo(new BigDecimal("1.879"));
    assertThat(coinEggTicker.getSell()).isEqualTo(new BigDecimal("0"));
    assertThat(coinEggTicker.getLast()).isEqualTo(new BigDecimal("38800"));
    assertThat(coinEggTicker.getVolume()).isEqualTo(new BigDecimal("283.954"));
  }
}
