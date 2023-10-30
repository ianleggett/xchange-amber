package org.knowm.xchange.amber.dto.marketdata;

import java.util.Map;

import org.knowm.xchange.amber.dto.AmberResult;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AmberContractResult extends AmberResult<Map<String, AmberAssetPair>> {
	
	public AmberContractResult(@JsonProperty("errmsg") String msg, @JsonProperty("errno") int code,
			@JsonProperty("data") Map<String, AmberAssetPair> result) {
		super(msg, code, result);
	}

}
