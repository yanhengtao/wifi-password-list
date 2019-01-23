package com.wifi.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.wifi.util.CmdUtil;
import com.wifi.util.StringUtil;
import com.wifi.util.WifiUtil;

public class WifiTest {

	public static void main(String[] args) throws Exception {
		ArrayList<String> wiFiNameList = WifiUtil.getWiFiNameList();

		System.out.printf("%-20s", "wifi-name");
		System.out.printf("%-20s\n", "password");
		System.out.println("------------------------------------------");
		for (String wifiName : wiFiNameList) {
			String result = WifiUtil.getPassWordByName(wifiName);
			HashMap<String, String> map = WifiUtil.getWiFiMap(result);
			if (!StringUtil.isBlank(map.get("name"))) {
				System.out.printf("%-20s", map.get("name"));
				System.out.printf("%-20s\n", map.get("password"));
				System.out.println("------------------------------------------");
			}
		}
	}

	public static void printWifiInfo() {
		ArrayList<String> wifiList = WifiUtil.getWiFiNameList();
		for (int i = 0; i < wifiList.size(); i++) {
			System.out.println("WIFI: " + wifiList.get(i));
		}
	}

	public static void printWifiInfoDetail() {
		String password = WifiUtil.getPassWordByName("TP-LINK_B72F42");
		print(password);
	}

	public static void printIpInfo() {
		String exeCmd = CmdUtil.exeCmd("ipconfig /all");
		print(exeCmd);
	}

	public static void print(String str) {
		System.out.println(str);
	}
}
