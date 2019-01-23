package com.wifi.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Description CmdUtil.java
 * @author yanhengtao
 *
 */
public class CmdUtil {

	/**
	 * @Description cmdִ���������������
	 * @param command cmd ����̨����
	 * @return
	 */
	public static String exeCmd(String command) {
		String result = null;
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec(command);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
