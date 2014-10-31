package com.somnus.zip;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 补充字符串处理的相关方法： 如join ,padding
 * 
 * @author Administrator
 * 
 */
public class StringUtil {
	private static Log log = LogFactory.getLog(StringUtil.class);

	/**
	 * 转化POJO为String
	 * @param obj
	 * @return
	 */
	public static String asString(Object obj) {
		return obj != null ? obj.toString() : "";
	}

	/**
	 * 判断是否空字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

    public static boolean isNotEmpty(String str) {
    	return (str.trim().length() > 0 || str != null);
    }

	/**
	 * 
	 * 左侧用字符串补足到一定长度
	 * 
	 * @see select LPAD('DFSDf',9,'w') from dual;
	 * @param srcString
	 * @param padded_length
	 * @param paddingString
	 * @return
	 */
	public static String lpad(String srcString, int padded_length,
			String paddingString) {
		int srcLength = asString(srcString).length();
		int padStrLength = asString(paddingString).length();

		if (srcLength < padded_length && !isEmpty(paddingString)
				&& !isEmpty(paddingString)) {
			int leftLength = padded_length - srcLength;
			int cnt = leftLength / padStrLength
					+ (leftLength % padStrLength > 0 ? 1 : 0);
			StringBuffer sb = new StringBuffer(padStrLength * cnt);
			for (int i = 0; i < cnt; i++) {
				sb.append(paddingString);
			}
			return sb.substring(0, leftLength) + srcString;
		} else if (srcLength > padded_length)
			return srcString.substring(0, padded_length);
		else
			return srcString;
	}

	/**
	 * 右侧用字符串补足到一定长度
	 * 
	 * @see select RPAD('DFSDf',9,'w') from dual;
	 * @param srcString
	 * @param padded_length
	 * @param paddingString
	 * @return  DFSDfwwww
	 */
	public static String rpad(String srcString, int padded_length,
			String paddingString) {
		int srcLength = asString(srcString).length();
		int padStrLength = asString(paddingString).length();

		if (srcLength < padded_length && !isEmpty(paddingString)
				&& !isEmpty(paddingString)) {
			int leftLength = padded_length - srcLength;
			int cnt = leftLength / padStrLength
					+ (leftLength % padStrLength > 0 ? 1 : 0);
			StringBuffer sb = new StringBuffer(padStrLength * cnt);
			for (int i = 0; i < cnt; i++) {
				sb.append(paddingString);
			}
			return srcString + sb.substring(0, leftLength);
		} else if (srcLength > padded_length)
			return srcString.substring(0, padded_length);
		else
			return srcString;
	}

	/**
	 * 将字符串数组链接成字符串
	 * 
	 * @param list
	 * @param joinStr
	 * @return
	 */
	public static String join(String[] list, String joinStr) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; list != null && i < list.length; i++) {
			if ((i + 1) == list.length) {
				s.append(list[i]);
			} else {
				s.append(list[i]).append(joinStr);
			}
		}
		return s.toString();
	}
	
	/**
	 * firstCharLowerCase
	 * 
	 * @param s
	 *            String
	 * @return String
	 */
	public static String firstCharLowerCase(String str)
	{
		if (StringUtil.isEmpty(str))
			return ("");
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	/**
	 * firstCharUpperCase
	 * 
	 * @param s
	 *            String
	 * @return String
	 */
	public static String firstCharUpperCase(String str)
	{
		if (StringUtil.isEmpty(str))
			return ("");
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	/**
	 * 将bss_org_id转换成bssOrgId
	 * 
	 * @param str
	 * @return
	 */
	public static String toBeanPatternStr(String src)
	{
		String dist = src.toLowerCase();
		Pattern pattern = Pattern.compile("_([a-z0-9])");
		Matcher matcher = pattern.matcher(dist);
		while (matcher.find())
		{
			dist = dist.replaceFirst(matcher.group(0), matcher.group(1).toUpperCase());
		}
		return dist;
	}

	/**
	 * 把所有的回车换行符换成"\n"，避免页面上的Javascript错误
	 * 
	 * @param src
	 * @return
	 */
	public static String toJSLineSeparateStr(String src)
	{
		if (src == null)
		{
			return "";
		}
		String dist = src;
		dist = dist.replaceAll("\r\n", "\\\\n");
		dist = dist.replaceAll("\r", "\\\\n");
		dist = dist.replaceAll("\n", "\\\\n");
		return dist;
	}


	/**
	 * 取得GBK编码
	 * 
	 * @return
	 */
	public static String getBytesString(String input, String code) {
		try {
			byte[] b = input.getBytes(code);
			return Arrays.toString(b);
		} catch (UnsupportedEncodingException e) {
			return String.valueOf(code.hashCode());
		}
	}

	/**
	 * 读取ORACLE的CLOB，转化为String
	 * 
	 * @param clob
	 * @return
	 */
	public static String getStringFromClob(java.sql.Clob clob) {
		String result = "";
		try {
			if (clob == null) {
				return null;
			}
			Reader reader = clob.getCharacterStream();// 得到流
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			StringBuffer sb = new StringBuffer(1024);
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception ex) {

		}
		return result;
	}

	public static void main(String[] args) {
		String[] jsString = { "aa" };
		System.out.println(StringUtil.join(jsString, ","));
		for (int i = 0; i < 100; i++) {
			System.out.println(StringUtil.rpad(String.valueOf(i), 4, "AB"));
		}
		for (int i = 0; i < 100; i++) {
			System.out.println(StringUtil.lpad(String.valueOf(i), 4, "AB"));
		}
		
	}

}
