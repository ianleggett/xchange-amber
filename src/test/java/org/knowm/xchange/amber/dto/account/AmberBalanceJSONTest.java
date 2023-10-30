package org.knowm.xchange.amber.dto.account;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.knowm.xchange.amber.dto.AmberResult;
import org.knowm.xchange.amber.dto.accounts.AmberBalance;
import org.knowm.xchange.amber.dto.accounts.AmberBalanceData;
import org.knowm.xchange.amber.dto.accounts.AmberBalanceResult;


public class AmberBalanceJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        AmberBalanceJSONTest.class.getResourceAsStream(
            "/org/xchange/amber/dto/account/example-balance-data.json");

    // Parse JSON Example Using Jackson
    ObjectMapper mapper = new ObjectMapper();
    AmberBalanceResult bvnexBalances =
        mapper.readValue(is, new TypeReference<AmberBalanceResult>() {});
    
    AmberBalanceData balData = bvnexBalances.getData();
    AmberBalance bal = balData.getBalanceDetails().get(0);
    assertThat(bal.getName()).isEqualTo("usdt");
    assertThat(bal.getAmount().doubleValue()).isEqualTo(-1254.88758166);
    assertThat(bal.getFrozen()).isEqualTo(new BigDecimal(1004));
    assertThat(bal.getCoinId()).isEqualTo(1);
    assertThat(bal.getPrice()).isEqualTo(new BigDecimal(1));
    assertThat(bal.getWithdrawable()).isEqualTo(new BigDecimal(0));


  }
}
