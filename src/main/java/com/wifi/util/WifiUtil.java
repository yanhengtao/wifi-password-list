package com.wifi.util;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.wifi.common.KeyContent;

public class WifiUtil {

	/**
	 * @Description cmd查询name对应的WiFi名称配置文件，并返回cmd执行的结果
	 * @param name WIFI名称
	 * @return
	 */
	public static String getPassWordByName(String name) {
		String command = "netsh wlan show profile name=" + name + " key=clear";
		String result = CmdUtil.exeCmd(command);
		return result;
	}

	/**
	 * @Description 获取连接过的WiFi的名称列表
	 * @return WIFI名称集合
	 */
	@SuppressWarnings("resource")
	public static ArrayList<String> getWiFiNameList() {
		String allWifiName = "netsh wlan show profiles";
		String cmdResult = CmdUtil.exeCmd(allWifiName);
		Scanner scanner = new Scanner(cmdResult);
		ArrayList<String> wifiNameList = new ArrayList<String>();
		String line = null;
		try {
			while ((line = scanner.nextLine()) != null) {
				if (line.contains(":")) {
					String name = StringUtil.getSplitRight(line);
					if (!name.equals("")) {
						wifiNameList.add(name);
					}

				}
			}
		} catch (Exception e) {

		}
		return wifiNameList;
	}

	/**
	 * @Description 从wifi细节信息中获取wifi名称和密码
	 * @param wifiDetail wifi细节信息
	 * @return
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("resource")
	public static HashMap<String, String> getWiFiMap(String wifiDetail) throws FileNotFoundException {

		HashMap<String, String> map = new HashMap<String, String>();
		Scanner scanner = new Scanner(wifiDetail);
		String line;
		try {
			while ((line = scanner.nextLine()) != null) {
				if (line.contains(KeyContent.WIFI_NAME)) {
					map.put("name", line.replaceAll(KeyContent.WIFI_NAME, "").replaceAll(":", ""));
				}
				if (line.contains(KeyContent.KEY_CONTENT)) {
					map.put("password", StringUtil.getSplitRight(line));
				}
			}
			return map;
		} catch (Exception e) {

		}
		return map;
	}
}
