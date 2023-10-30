package org.knowm.xchange.amber.dto.accounts;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmberBalance {

	
	String name;
	BigDecimal amount;
	BigDecimal frozen;
	long coinId;
	BigDecimal price;
	BigDecimal withdrawable;
	
	@JsonCreator
	public AmberBalance(@JsonProperty("name") String name,@JsonProperty("amount") BigDecimal amount,@JsonProperty("frozen") BigDecimal frozen,
			@JsonProperty("coinId") long coinId,@JsonProperty("price")  BigDecimal price,@JsonProperty("withdrawable")BigDecimal withdrawable) {		
		super();
		this.name = name;
		this.amount = amount;
		this.frozen = frozen;
		this.coinId = coinId;
		this.price = price;
		this.withdrawable = withdrawable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getFrozen() {
		return frozen;
	}

	public void setFrozen(BigDecimal frozen) {
		this.frozen = frozen;
	}

	public long getCoinId() {
		return coinId;
	}

	public void setCoinId(long coinId) {
		this.coinId = coinId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getWithdrawable() {
		return withdrawable;
	}

	public void setWithdrawable(BigDecimal withdrawable) {
		this.withdrawable = withdrawable;
	}	
	
	
	
}
