package org.knowm.xchange.amber.dto.accounts;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AmberBalanceData {
	
	  private final BigDecimal credit;	
	  private final BigDecimal totalBalance;
	  private final List<AmberBalance> balanceDetails;
	  
	  @JsonCreator
	  public AmberBalanceData(@JsonProperty("credit") BigDecimal credit, @JsonProperty("totalBalance") BigDecimal totalBalance, 
			  @JsonProperty("balanceDetails")  List<AmberBalance> balanceDetails) {
			this.credit = credit;
			this.totalBalance = totalBalance;
			this.balanceDetails = balanceDetails;						
		}

	  
}
