package com.somnus.date;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	// 格式：年－月－日 小时：分钟：秒
	public static final String FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";

	// 格式：年－月－日 小时：分钟
	public static final String FORMAT_TWO = "yyyy-MM-dd HH:mm";

	// 格式：年月日
	public static final String FORMAT_THREE = "yyyyMMdd";

	// 格式：年－月－日
	public static final String FORMAT_FOUR = "yyyy-MM-dd";

	// 格式：年－月
	public static final String FORMAT_FIVE = "yyyy-MM";

	// 格式：年月
	public static final String FORMAT_SIX = "yyyyMM";

	static final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四",
			"星期五", "星期六" };

	/**
	 * @description yyyy-MM-dd 转换为 yyyyMMdd
	 * @param datestr
	 * @return
	 */
	public static String convert2yyyyMMdd(String datestr){
		return datestr.replaceAll("(\\d{4})-(\\d{2})-(\\d{2})","$1$2$3");
	}
	/**
	 * @description yyyyMMdd 转换为 yyyy-MM-dd
	 * @param datestr
	 * @return
	 */
	public static String convert2yyyy_MM_dd(String datestr){
		return datestr.replaceAll("(\\d{4})(\\d{2})(\\d{2})","$1-$2-$3");
	}

	/**
	 * 把符合日期格式的字符串转换为日期类型
	 */
	public static java.util.Date stringtoDate(String dateStr, String format) {
		Date d = null;
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			formater.setLenient(false);// 指定日期\时间解析是否不严格
			d = formater.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 把符合日期格式的字符串转换为日期类型 ParsePosition(1) 从第几位开始处理
	 */
	public static java.util.Date stringtoDate(String dateStr, String format,
			ParsePosition pos) {
		Date d = null;
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			formater.setLenient(false);
			d = formater.parse(dateStr, pos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 把日期转换为字符串
	 */
	public static String dateToString(java.util.Date date, String format) {
		String result = "";
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			result = formater.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param dateKind
	 *            指定处理年、月、日
	 * @param dateStr
	 *            指定日期
	 * @param amount
	 *            指定长度
	 * @return
	 */
	public static String dateSub(int dateKind, String dateStr, int amount) {
		Date date = stringtoDate(dateStr, FORMAT_ONE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(dateKind, amount);
		return dateToString(calendar.getTime(), FORMAT_ONE);
	}

	/**
	 * 
	 * @param days
	 * @return 返回一个相加减后的日期 yyyy-MM-dd
	 */
	public static String dateSub(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, days);
		return dateToString(calendar.getTime(), FORMAT_FOUR);
	}

	/**
	 * 两个日期相减
	 * 
	 * @return 相减得到的秒数
	 */
	public static long timeSub(String firstTime, String secTime) {
		long first = stringtoDate(firstTime, FORMAT_ONE).getTime();
		long second = stringtoDate(secTime, FORMAT_ONE).getTime();
		return (second - first) / 1000;
	}

	/**
	 * 获取某年某月的天数 Method1
	 */
	public static int getDaysOfMonth(String year, String month) {
		Date date = stringtoDate(year + "-" + month, FORMAT_FIVE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取某年某月的天数 Method2
	 */
	public static int getDaysOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回日期的年
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 返回日期的月份，1-12
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 返回日期的日1-31
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 返回日期的时
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR);
	}

	/**
	 * 返回日期的分
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 返回日期的秒
	 */
	public static int getSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 返回日期在一个年中是第几天
	 */
	public static int getDayOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 返回日期在一个月中是第几天
	 */
	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回日期在一个周中是第几天
	 */
	public static int getDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 返回日期在一个月中是第几周
	 */
	public static int getDayOfWeekInMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
	}

	/**
	 * 返回日期在一个年中是第几周
	 */
	public static int getWeekOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 计算两个日期相差的天数，如果date1 > date2 返回正数，否则返回负数
	 */
	public static long dayDiff(Date date1, Date date2) {
		long diff = Math.abs(date1.getTime() - date2.getTime());
		diff /= 3600 * 1000 * 24;
		return diff;
	}

	/**
	 * 比较两个日期的年差
	 */
	public static int yearDiff(String before, String after) {
		Date beforeDay = stringtoDate(before, FORMAT_FOUR);
		Date afterDay = stringtoDate(after, FORMAT_FOUR);
		return getYear(afterDay) - getYear(beforeDay);
	}

	/**
	 * 比较指定日期与当前日期的差
	 */
	public static int yearDiffCurr(String after) {
		return yearDiff(getNow(), after);
	}

	/**
	 * 获取当前日期字符串，格式"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @return
	 */
	public static String getNow() {
		Calendar today = Calendar.getInstance();
		return dateToString(today.getTime(), FORMAT_ONE);
	}

	/**
	 * 获取当前时间的指定格式
	 */
	public static String getCurrDate(String format) {
		return dateToString(new Date(), format);
	}

	public static void main(String[] args) {
		System.out.println("当前时间：" + DateUtil.getCurrDate(FORMAT_ONE));
		System.out.println("当前时间：" + DateUtil.getNow());
		System.out.println("某年某月的最大天数：" + DateUtil.getDaysOfMonth(2011, 5));
		System.out.println("某年某月的最大天数：" + DateUtil.getDaysOfMonth("2014", "2"));

		System.out.println("当前日期+2：" + DateUtil.dateSub(2));
		System.out.println("指定日期+2："
				+ DateUtil.dateSub(Calendar.DAY_OF_YEAR, "2014-01-01 00:00:00",
						2));
		System.out.println("yyyy-MM-dd转换成yyyyMMdd："
				+ DateUtil.convert2yyyyMMdd("2014-03-08"));
		System.out.println("yyyyMMdd转换成yyyy-MM-dd："
				+ DateUtil.convert2yyyy_MM_dd("20140308"));

		System.out.println("Date转换为String："
				+ DateUtil.dateToString(new Date(), FORMAT_ONE));
		System.out.println("String转换为Date："
				+ DateUtil.stringtoDate("2014-03-07 15:12:27", FORMAT_ONE));
		System.out.println("String转换为Date："
				+ DateUtil.stringtoDate("22014-03-07 15:12:27", FORMAT_ONE,
						new ParsePosition(1)));

		System.out.println("两个日期相差的天数："
				+ DateUtil.dayDiff(new Date(), DateUtil.stringtoDate(
						"2014-01-01 00:00:00", FORMAT_ONE)));

		System.out.println("返回日期的年：" + DateUtil.getYear(new Date()));// YEAR
		System.out.println("返回日期的月：" + DateUtil.getMonth(new Date()));// MONTH
		System.out.println("返回日期的日：" + DateUtil.getDay(new Date()));// DATE
		System.out.println("返回日期的时：" + DateUtil.getHour(new Date()));// HOUR
		System.out.println("返回日期的分：" + DateUtil.getMinute(new Date()));// MINUTE
		System.out.println("返回日期的秒：" + DateUtil.getSecond(new Date()));// SECOND

		System.out.println("日期在一个年中是第几天：" + DateUtil.getDayOfYear(new Date()));// WEEK_OF_YEAR
		System.out.println("日期在一个月中是第几天：" + DateUtil.getDayOfMonth(new Date()));// DAY_OF_MONTH
		System.out.println("日期在一个周中是第几天：" + DateUtil.getDayOfWeek(new Date()));// DAY_OF_WEEK
		System.out.println("日期在一个月中是第几周："
				+ DateUtil.getDayOfWeekInMonth(new Date()));// DAY_OF_WEEK_IN_MONTH
		System.out.println("返回日期在一个年中是第几周："
				+ DateUtil.getWeekOfYear(new Date()));// WEEK_OF_MONTH

		System.out.println("两个日期的年差："
				+ DateUtil.yearDiff("2013-01-01", "2014-01-01"));
		System.out
				.println("指定日期与当前日期的差：" + DateUtil.yearDiffCurr("2013-01-01"));
	}
}
