package org.knowm.xchange.amber.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AmberWSocketResult<V> {

	private final V data;
	private final String type;
	
	 @JsonCreator
	public AmberWSocketResult(@JsonProperty("type") String type, @JsonProperty("data") V data) {
		// TODO: Some Validation - See GatecoinResult.java
		this.type = type;		
		this.data = data;
	}

	public V getData() {
		return data;
	}

	public String getType() {
		return type;
	}


}
