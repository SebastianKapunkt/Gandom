package com.github.gandom.steam.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price_overview {
	private String currency;
	private Number discount_percent;
	@JsonProperty("final")
	private Number finalPrica;
	private Number initial;

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Number getDiscount_percent() {
		return this.discount_percent;
	}

	public void setDiscount_percent(Number discount_percent) {
		this.discount_percent = discount_percent;
	}

	public Number getFinal() {
		return this.finalPrica;
	}

	public void setFinal(Number finalPrica) {
		this.finalPrica = finalPrica;
	}

	public Number getInitial() {
		return this.initial;
	}

	public void setInitial(Number initial) {
		this.initial = initial;
	}
}
