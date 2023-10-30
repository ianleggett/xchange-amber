package org.knowm.xchange.amber.dto.accounts;

import org.knowm.xchange.amber.dto.AmberResult;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AmberRFQResult extends AmberResult<AmberRFQ>{
	
	public AmberRFQResult(@JsonProperty("errmsg") String msg, @JsonProperty("errno") int code,@JsonProperty("data") AmberRFQ result) {
		super(msg, code, result);		
	}

}
