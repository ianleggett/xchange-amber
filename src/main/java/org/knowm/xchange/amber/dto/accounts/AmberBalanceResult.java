package org.knowm.xchange.amber.dto.accounts;

import org.knowm.xchange.amber.dto.AmberResult;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AmberBalanceResult extends AmberResult<AmberBalanceData>{
	
	public AmberBalanceResult(@JsonProperty("errmsg") String msg, @JsonProperty("errno") int code,@JsonProperty("data") AmberBalanceData result) {
		super(msg, code, result);		
	}

}
