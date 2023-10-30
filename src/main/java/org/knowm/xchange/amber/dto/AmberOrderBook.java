package org.knowm.xchange.amber.dto;

import java.util.ArrayList;
import java.util.Date;

import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.trade.LimitOrder;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author pchertalev */
public class AmberOrderBook {
	
	private final String contract_type;
	private final String contract;
	private final Date timestamp;

	private final AmberDepths metadata;
	
	public AmberOrderBook(@JsonProperty(value = "contract_type")String contract_type,@JsonProperty(value = "contract") String contract,@JsonProperty(value = "timestamp") Date timestamp,
			@JsonProperty(value = "metadata") AmberDepths meta) {
		super();	
		this.contract_type = contract_type;
		this.contract = contract;
		this.timestamp = timestamp;
		this.metadata = meta;		
	}
	
	public String getContract_type() {
		return contract_type;
	}

	public String getContract() {
		return contract;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public AmberDepths getMetadata() {
		return metadata;
	}

	@Override
	public String toString() {
		return "AmberOrderBook [contract_type=" + contract_type + ", contract=" + contract + ", timestamp=" + timestamp
				+ ", metadata=" + metadata + "]";
	}

	
}
