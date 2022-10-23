package com.cathay.coindesk.model.dto;

import com.cathay.coindesk.model.coindeskApi.Bpi;
import com.cathay.coindesk.model.coindeskApi.Time;

public class CoindeskDto {

	private Time time;

	private String disclaimer;

	private String chartName;

	private Bpi bpi;

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public Bpi getBpi() {
		return bpi;
	}

	public void setBpi(Bpi bpi) {
		this.bpi = bpi;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coindesk [time=");
		builder.append(time);
		builder.append(", disclaimer=");
		builder.append(disclaimer);
		builder.append(", chartName=");
		builder.append(chartName);
		builder.append(", bpi=");
		builder.append(bpi);
		builder.append("]");
		return builder.toString();
	}

}
