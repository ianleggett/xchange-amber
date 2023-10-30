package org.knowm.xchange.amber.dto.trade;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import org.junit.Test;
import org.knowm.xchange.amber.dto.AmberResult;
import org.knowm.xchange.amber.dto.marketdata.AmberTrade.Type;
import org.knowm.xchange.amber.dto.trade.AmberTradeList;

public class AmberTradeListJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        AmberTradeListJSONTest.class.getResourceAsStream(
            "/org/xchange/amber/dto/trade/example-trade-list-data.json");

    // Parse JSON Example Using Jackson
    ObjectMapper mapper = new ObjectMapper();
    AmberResult<AmberTradeList[]> coinEggResult =
        mapper.readValue(is, new TypeReference<AmberResult<AmberTradeList[]>>() {});

    AmberTradeList[] coinEggTradeLists = coinEggResult.getData();
    AmberTradeList coinEggTradeList = coinEggTradeLists[0];

    // Verify The Ticker Unmarshalls Correctly
    assertThat(coinEggResult).isNotNull();
    assertThat(coinEggTradeLists).isNotNull();
    assertThat(coinEggTradeLists).isNotEmpty();

    assertThat(coinEggTradeList).isNotNull();
    assertThat(coinEggTradeList.getID()).isEqualTo(28);
    // assertThat(coinEggTradeList.getDateTime().toString()).isEqualTo("2016-10-26 14:47:54");
    assertThat(coinEggTradeList.getType()).isEqualTo(Type.SELL);
    assertThat(coinEggTradeList.getPrice()).isEqualTo(new BigDecimal("0.000123"));
    assertThat(coinEggTradeList.getAmountOriginal()).isEqualTo(new BigDecimal("1213"));
    assertThat(coinEggTradeList.getAmountOutstanding()).isEqualTo(new BigDecimal("1213"));
  }
}
