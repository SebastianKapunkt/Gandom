package com.github.gandom.steam.app;

public class Subs {
	private String can_get_free_license;
	private String option_description;
	private String option_text;
	private String packageid;
	private Number percent_savings;
	private String percent_savings_text;

	public String getCan_get_free_license() {
		return this.can_get_free_license;
	}

	public void setCan_get_free_license(String can_get_free_license) {
		this.can_get_free_license = can_get_free_license;
	}

	public String getOption_description() {
		return this.option_description;
	}

	public void setOption_description(String option_description) {
		this.option_description = option_description;
	}

	public String getOption_text() {
		return this.option_text;
	}

	public void setOption_text(String option_text) {
		this.option_text = option_text;
	}

	public String getPackageid() {
		return this.packageid;
	}

	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}

	public Number getPercent_savings() {
		return this.percent_savings;
	}

	public void setPercent_savings(Number percent_savings) {
		this.percent_savings = percent_savings;
	}

	public String getPercent_savings_text() {
		return this.percent_savings_text;
	}

	public void setPercent_savings_text(String percent_savings_text) {
		this.percent_savings_text = percent_savings_text;
	}
}
