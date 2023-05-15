package kopo23.service;

import kopo23.domain.WifiItem;

public class WifiItemService { // 현재 지점과 거리 구하는 서비스
	public double getDistance(WifiItem wifiItem1, WifiItem wifiItem2) {

		double dist = Math.sqrt(Math.pow(wifiItem2.getLatitude() - wifiItem1.getLatitude(), 2)
				+ Math.pow(wifiItem2.getLongitude() - wifiItem1.getLongitude(), 2));

		return dist;
	}

}
