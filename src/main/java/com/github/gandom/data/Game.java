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
	
//	public Game(Number appid, Number playtime_forever, Number playtime_2weeks){
//		this.appid = appid;
//		this.playtime_2weeks = playtime_2weeks;
//		this.playtime_forever = playtime_forever;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appid == null) ? 0 : appid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Game)) {
			return false;
		}
		Game other = (Game) obj;
		if (appid == null) {
			if (other.appid != null) {
				return false;
			}
		} else if (!appid.equals(other.appid)) {
			return false;
		}
		return true;
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
