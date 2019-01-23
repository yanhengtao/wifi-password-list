package com.wifi.util;
/**
 * 
 * @author yanhengtao
 *
 */
public class StringUtil {

	/**
	 * @Description 获取字符串":"右侧文字
	 * @param line 读取的一行字符串
	 * @return
	 */
	public static String getSplitRight(String line) {
		String val = line.substring(line.lastIndexOf(":") + 1).trim();
		return !isBlank(val) ? val : "";
	}

	/**
	 * @Description 是否为空
	 * @param str 
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}
}
