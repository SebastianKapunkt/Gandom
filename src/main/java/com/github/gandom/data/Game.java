package com.github.gandom.data;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Game {
	private Number appid;
	private Number playtime_forever;
	private Number playtime_2weeks;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public Number getAppid() {
		return this.appid;
	}

	public void setAppid(Number appid) {
		this.appid = appid;
	}

	public Number getPlaytime_forever() {
		return this.playtime_forever;
	}

	public void setPlaytime_forever(Number playtime_forever) {
		this.playtime_forever = playtime_forever;
	}

	public Number getPlaytime_2weeks() {
		return playtime_2weeks;
	}

	public void setPlaytime_2weeks(Number playtime_2weeks) {
		this.playtime_2weeks = playtime_2weeks;
	}
}
