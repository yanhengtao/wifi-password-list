package com.wifi.util;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.wifi.common.KeyContent;

public class WifiUtil {

	/**
	 * @Description cmd��ѯname��Ӧ��WiFi���������ļ���������cmdִ�еĽ��
	 * @param name WIFI����
	 * @return
	 */
	public static String getPassWordByName(String name) {
		String command = "netsh wlan show profile name=" + name + " key=clear";
		String result = CmdUtil.exeCmd(command);
		return result;
	}

	/**
	 * @Description ��ȡ���ӹ���WiFi�������б�
	 * @return WIFI���Ƽ���
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
	 * @Description ��wifiϸ����Ϣ�л�ȡwifi���ƺ�����
	 * @param wifiDetail wifiϸ����Ϣ
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
