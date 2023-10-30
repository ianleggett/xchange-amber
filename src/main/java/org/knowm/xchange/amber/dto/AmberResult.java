package org.knowm.xchange.amber.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AmberResult<V> {

	private final V data;
	private final String errmsg;
	private final int errno;
	
	 @JsonCreator
	public AmberResult(@JsonProperty("errmsg") String msg, @JsonProperty("errno") int code, @JsonProperty("data") V data) {
		// TODO: Some Validation - See GatecoinResult.java
		this.errmsg = msg;
		this.errno = code;
		this.data = data;
	}

	public V getData() {
		return data;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public int getErrno() {
		return errno;
	}


}
