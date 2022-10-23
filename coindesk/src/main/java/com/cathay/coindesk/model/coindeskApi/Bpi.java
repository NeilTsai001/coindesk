package com.cathay.coindesk.model.coindeskApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bpi {
	
	@JsonProperty(value = "USD")
	private Currency uds;
	
	@JsonProperty(value = "GBP")
	private Currency gbp;
	
	@JsonProperty(value = "EUR")
	private Currency eur;

	public Currency getUds() {
		return uds;
	}

	public void setUds(Currency uds) {
		this.uds = uds;
	}

	public Currency getGbp() {
		return gbp;
	}

	public void setGbp(Currency gbp) {
		this.gbp = gbp;
	}

	public Currency getEur() {
		return eur;
	}

	public void setEur(Currency eur) {
		this.eur = eur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bpi [uds=");
		builder.append(uds);
		builder.append(", gbp=");
		builder.append(gbp);
		builder.append(", eur=");
		builder.append(eur);
		builder.append("]");
		return builder.toString();
	}

}
