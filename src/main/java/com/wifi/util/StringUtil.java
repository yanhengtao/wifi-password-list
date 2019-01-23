package com.wifi.util;
/**
 * 
 * @author yanhengtao
 *
 */
public class StringUtil {

	/**
	 * @Description ��ȡ�ַ���":"�Ҳ�����
	 * @param line ��ȡ��һ���ַ���
	 * @return
	 */
	public static String getSplitRight(String line) {
		String val = line.substring(line.lastIndexOf(":") + 1).trim();
		return !isBlank(val) ? val : "";
	}

	/**
	 * @Description �Ƿ�Ϊ��
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
