package org.knowm.xchange.amber.dto.accounts;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AmberRFQ {

	private final String rfqId;
	private final Date validUntil;
	private final BigDecimal price;

	@JsonCreator
	public AmberRFQ(@JsonProperty("rfqId") String rfqId, @JsonProperty("validUntil") Date validUntil,
			@JsonProperty("price") BigDecimal price) {
		this.rfqId = rfqId;
		this.validUntil = validUntil;
		this.price = price;
	}

}
