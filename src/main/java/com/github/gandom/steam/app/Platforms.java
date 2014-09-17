package com.github.gandom.steam.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Platforms {
	private boolean linux;
	private boolean mac;
	private boolean windows;

	public boolean getLinux() {
		return this.linux;
	}

	public void setLinux(boolean linux) {
		this.linux = linux;
	}

	public boolean getMac() {
		return this.mac;
	}

	public void setMac(boolean mac) {
		this.mac = mac;
	}

	public boolean getWindows() {
		return this.windows;
	}

	public void setWindows(boolean windows) {
		this.windows = windows;
	}
}
