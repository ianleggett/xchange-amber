package org.knowm.xchange.amber.dto;

import org.knowm.xchange.amber.dto.accounts.AmberWebsocketToken;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AmberWebsocketTokenResult extends AmberWSocketResult<AmberWebsocketToken> {
	  /**
	   * Constructor
	   *
	   * @param result
	   * @param error
	   */
	  public AmberWebsocketTokenResult(@JsonProperty("type") String type, @JsonProperty("data") AmberWebsocketToken result) {
			super(type, result);		
		}	  
	
}
