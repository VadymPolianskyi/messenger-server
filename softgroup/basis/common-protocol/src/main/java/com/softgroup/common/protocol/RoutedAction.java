package com.softgroup.common.protocol;

import java.io.Serializable;

public class RoutedAction<T extends Serializable> extends Action<T> {
	private static final long serialVersionUID = -318012176965757271L;

	private String rotingData;

	private String deviceId;

	private String serverId;

	public String getRotingData() {
		return rotingData;
	}

	public void setRotingData(String rotingData) {
		this.rotingData = rotingData;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
}
