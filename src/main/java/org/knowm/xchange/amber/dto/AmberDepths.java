package org.knowm.xchange.amber.dto;

import java.util.Arrays;
import java.util.List;

import org.knowm.xchange.amber.dto.marketdata.AmberPublicOrder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AmberDepths {

	@JsonProperty(value = "asks")
	private final List<AmberPublicOrder> asks;
	@JsonProperty(value = "bids")
	private final List<AmberPublicOrder> bids;
	
	public AmberDepths(@JsonProperty(value = "asks")List<AmberPublicOrder> asks,@JsonProperty(value = "bids") List<AmberPublicOrder> bids) {
		super();
		this.asks = asks;
		this.bids = bids;
	}

	public List<AmberPublicOrder> getAsks() {
		return asks;
	}

	public List<AmberPublicOrder> getBids() {
		return bids;
	}

	@Override
	public String toString() {
		return "AmberDepths [asks=" + asks + ", bids=" + bids + "]";
	}
	
}
