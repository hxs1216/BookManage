package com.biyao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import org.apache.log4j.Logger;

public class DateUtil {
	private static final Logger logger = Logger.getLogger(DateUtil.class);

	public static final long DAY = 24 * 60 * 60 * 1000L;

	// 默认格式
	public static String defaultSimpleFormater = "yyyy-MM-dd HH:mm";
	public static String defaultSimpleFormater2 = "yyyy-MM-dd HH:mm:ss";
	public static String FORMAT_DATE="yyyy-MM-dd";
	public static final SimpleDateFormat FORMAT_DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat FORMAT_DATE_ = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 表示年份
	 */
	public static final int YEAR = 1;

	/**
	 * 表示月份 <br>
	 * 与Java官方月份是从0开始的表示形式不同，这里的月份是从1开始的。
	 */
	public static final int MONTH = 2;

	/**
	 * 表示某月中的某天（即年月日中的“日”）
	 */
	public static final int DAY_OF_MONTH = 3;

	/**
	 * 以24小时制表示的小时数
	 */
	public static final int HOUR_OF_DAY = 4;

	/**
	 * 以12小时制表示的小时数
	 */
	public static final int HOUR = 5;

	/**
	 * 表示分钟数
	 */
	public static final int MINUTE = 6;

	/**
	 * 表示秒数
	 */
	public static final int SECOND = 7;

	/**
	 * 表述毫秒
	 */
	public static final int MILLISECOND = 8;

	/**
	 * 表示星期几
	 */
	public static final int DAY_OF_WEEK = 9;

	/**
	 * 默认简单日期字符串
	 * 
	 * @return
	 */
	public static String getDefaultSimpleFormater() {
		return defaultSimpleFormater;
	}

	/** ******字符串、日期转换Start******************************************* */
	/**
	 * 设置默认简单日期格式字符串
	 * 
	 * @param defaultFormatString
	 */
	public static void setDefaultSimpleFormater(String defaultFormatString) {
		DateUtil.defaultSimpleFormater = defaultFormatString;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param formatString
	 * @return
	 */
	public static String format(Date date, String formatString) {
		if (logger.isDebugEnabled()) {
			logger.debug("format(Date, String) - start"); //$NON-NLS-1$
		}

		SimpleDateFormat df = new SimpleDateFormat(formatString);
		String returnString = df.format(date);
		if (logger.isDebugEnabled()) {
			logger.debug("format(Date, String) - end"); //$NON-NLS-1$
		}
		return returnString;
	}

	/**
	 * 格式化时间
	 * 
	 * @param DateStr
	 *            (格式yyyyMMddHHmmss)
	 * @return
	 */
	public static Date parseDate(String DateStr) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			DateStr = DateStr.substring(0, 4) + "-" + DateStr.substring(4, 6)
					+ "-" + DateStr.substring(6, 8) + " "
					+ DateStr.substring(8, 10) + ":"
					+ DateStr.substring(10, 12) + ":" + DateStr.substring(12);
			return format.parse(DateStr);
		} catch (Exception ex) {

		}

		return new Date();
	}

	/**
	 * 将某个<code>Date</code>对象转化为格式化的时间字符串
	 * 
	 * @param date
	 *            提供的<code>Date</code>对象
	 * @param format
	 *            需要得到的时间的格式
	 * @return <code>String</code>类型 格式化的时间字符串
	 */
	public static String getFormatDateStr(Date date, String format) {
		if (logger.isDebugEnabled()) {
			logger.debug("getFormatDateStr(Date, String) - start"); //$NON-NLS-1$
		}

		String returnString = new SimpleDateFormat(format).format(date);
		if (logger.isDebugEnabled()) {
			logger.debug("getFormatDateStr(Date, String) - end"); //$NON-NLS-1$
		}
		return returnString;
	}

	/**
	 * 格式化日期(使用默认格式)
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		if (logger.isDebugEnabled()) {
			logger.debug("format(Date) - start"); //$NON-NLS-1$
		}

		String returnString = format(date, defaultSimpleFormater);
		if (logger.isDebugEnabled()) {
			logger.debug("format(Date) - end"); //$NON-NLS-1$
		}
		return returnString;
	}

	/**
	 * 格式化日期(使用标准格式)
	 * 
	 * @param date
	 * @return
	 */
	public static String format2(Date date) {
		if (logger.isDebugEnabled()) {
			logger.debug("format(Date) - start"); //$NON-NLS-1$
		}

		String returnString = format(date, defaultSimpleFormater2);
		if (logger.isDebugEnabled()) {
			logger.debug("format(Date) - end"); //$NON-NLS-1$
		}
		return returnString;
	}

	/**
	 * 转换成日期
	 * 
	 * @param dateString
	 * @param formatString
	 * @return
	 */
	public static Date parse(String dateString, String formatString) {
		if (logger.isDebugEnabled()) {
			logger.debug("parse(String, String) - start"); //$NON-NLS-1$
		}

		SimpleDateFormat df = new SimpleDateFormat(formatString);
		try {
			Date returnDate = df.parse(dateString);
			if (logger.isDebugEnabled()) {
				logger.debug("parse(String, String) - end"); //$NON-NLS-1$
			}
			return returnDate;
		} catch (ParseException e) {
			logger.error("parse(String, String)", e); //$NON-NLS-1$

			if (logger.isDebugEnabled()) {
				logger.debug("parse(String, String) - end"); //$NON-NLS-1$
			}
			return null;
		}
	}

	/**
	 * 返回两个日期间差
	 * 
	 * @param date1
	 *            参照日期
	 * @param date2
	 *            比较日期
	 * @return 参照日期与比较日期之间的时间差异
	 */
	public static long timeDiff(Date date1, Date date2) {
		long diff = date1.getTime() - date2.getTime();
		return diff;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysDiff(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 转换成日期(使用默认格式)
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date parse(String dateString) {
		if (logger.isDebugEnabled()) {
			logger.debug("parse(String) - start"); //$NON-NLS-1$
		}

		Date returnDate = parse(dateString, defaultSimpleFormater);
		if (logger.isDebugEnabled()) {
			logger.debug("parse(String) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}
	
	/**
	 * 转换成日期(使用默认格式)
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date parse2(String dateString) {
		if (logger.isDebugEnabled()) {
			logger.debug("parse(String) - start"); //$NON-NLS-1$
		}

		Date returnDate = parse(dateString, defaultSimpleFormater2);
		if (logger.isDebugEnabled()) {
			logger.debug("parse(String) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * @param year
	 *            年
	 * @param month
	 *            月(1-12)
	 * @param day
	 *            日(1-31)
	 * @return 输入的年、月、日是否是有效日期
	 */
	public static boolean isValid(int year, int month, int day) {
		if (logger.isDebugEnabled()) {
			logger.debug("isValid(int, int, int) - start"); //$NON-NLS-1$
		}

		if (month > 0 && month < 13 && day > 0 && day < 32) {
			// month of calendar is 0-based
			int mon = month - 1;
			Calendar calendar = new GregorianCalendar(year, mon, day);
			if (calendar.get(Calendar.YEAR) == year
					&& calendar.get(Calendar.MONTH) == mon
					&& calendar.get(Calendar.DAY_OF_MONTH) == day) {
				if (logger.isDebugEnabled()) {
					logger.debug("isValid(int, int, int) - end"); //$NON-NLS-1$
				}
				return true;
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("isValid(int, int, int) - end"); //$NON-NLS-1$
		}
		return false;
	}

	/** ******字符串、日期转换End******************************************* */

	/**
	 * 返回当月第一天的日期
	 */
	public static Date firstDay(Date date) {
		if (logger.isDebugEnabled()) {
			logger.debug("firstDay(Date) - start"); //$NON-NLS-1$
		}

		Calendar calendar = convert(date);
		calendar.set(Calendar.DATE, 1);
		Date returnDate = calendar.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("firstDay(Date) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 返回当月最后一天的日期
	 */
	public static Date lastDay(Date date) {
		if (logger.isDebugEnabled()) {
			logger.debug("lastDay(Date) - start"); //$NON-NLS-1$
		}

		Calendar calendar = convert(date);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		Date returnDate = calendar.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("lastDay(Date) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	private static Calendar convert(Date date) {
		if (logger.isDebugEnabled()) {
			logger.debug("convert(Date) - start"); //$NON-NLS-1$
		}

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		if (logger.isDebugEnabled()) {
			logger.debug("convert(Date) - end"); //$NON-NLS-1$
		}
		return calendar;
	}
	
	/**
	 * 返回本周指定的星期
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date dayOfWeek(int value) {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DAY_OF_WEEK, value);
		return now.getTime();
	}
	
	/**
	 * 返回当周指定的星期
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date dayOfWeek(Date date, int value) {
		Calendar calendar = convert(date);
		calendar.set(Calendar.DAY_OF_WEEK, value);
		return calendar.getTime();
	}

	/**
	 * 昨天
	 * 
	 * @return
	 */
	public static Date yesterday() {
		if (logger.isDebugEnabled()) {
			logger.debug("yesterday() - start"); //$NON-NLS-1$
		}

		Date returnDate = addDay(-1);
		if (logger.isDebugEnabled()) {
			logger.debug("yesterday() - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 明天
	 * 
	 * @return
	 */
	public static Date tomorrow() {
		if (logger.isDebugEnabled()) {
			logger.debug("tomorrow() - start"); //$NON-NLS-1$
		}

		Date returnDate = addDay(1);
		if (logger.isDebugEnabled()) {
			logger.debug("tomorrow() - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 现在
	 * 
	 * @return
	 */
	public static Date now() {
		if (logger.isDebugEnabled()) {
			logger.debug("now() - start"); //$NON-NLS-1$
		}

		Date returnDate = new Date(System.currentTimeMillis());
		if (logger.isDebugEnabled()) {
			logger.debug("now() - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 获取现在被格式化的时间
	 **/
	public static String Formatnow() {
		if (logger.isDebugEnabled()) {
			logger.debug("now() - start"); //$NON-NLS-1$
		}

		Date returnDate = new Date(System.currentTimeMillis());
		if (logger.isDebugEnabled()) {
			logger.debug("now() - end"); //$NON-NLS-1$
		}
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(returnDate);
	}

	/**
	 * 按日加
	 * 
	 * @param value
	 * @return
	 */
	public static Date addDay(int value) {
		if (logger.isDebugEnabled()) {
			logger.debug("addDay(int) - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_YEAR, value);
		Date returnDate = now.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("addDay(int) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 按日加,指定日期
	 * 
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addDay(Date date, int value) {
		if (logger.isDebugEnabled()) {
			logger.debug("addDay(Date, int) - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.DAY_OF_YEAR, value);
		Date returnDate = now.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("addDay(Date, int) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 按月加
	 * 
	 * @param value
	 * @return
	 */
	public static Date addMonth(int value) {
		if (logger.isDebugEnabled()) {
			logger.debug("addMonth(int) - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, value);
		Date returnDate = now.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("addMonth(int) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 按月加,指定日期
	 * 
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addMonth(Date date, int value) {
		if (logger.isDebugEnabled()) {
			logger.debug("addMonth(Date, int) - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MONTH, value);
		Date returnDate = now.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("addMonth(Date, int) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 按年加
	 * 
	 * @param value
	 * @return
	 */
	public static Date addYear(int value) {
		if (logger.isDebugEnabled()) {
			logger.debug("addYear(int) - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		now.add(Calendar.YEAR, value);
		Date returnDate = now.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("addYear(int) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 按年加,指定日期
	 * 
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addYear(Date date, int value) {
		if (logger.isDebugEnabled()) {
			logger.debug("addYear(Date, int) - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.YEAR, value);
		Date returnDate = now.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("addYear(Date, int) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 按小时加
	 * 
	 * @param value
	 * @return
	 */
	public static Date addHour(int value) {
		if (logger.isDebugEnabled()) {
			logger.debug("addHour(int) - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		now.add(Calendar.HOUR_OF_DAY, value);
		Date returnDate = now.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("addHour(int) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 按小时加,指定日期
	 * 
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addHour(Date date, int value) {
		if (logger.isDebugEnabled()) {
			logger.debug("addHour(Date, int) - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.HOUR_OF_DAY, value);
		Date returnDate = now.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("addHour(Date, int) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 按分钟加
	 * 
	 * @param value
	 * @return
	 */
	public static Date addMinute(int value) {
		if (logger.isDebugEnabled()) {
			logger.debug("addMinute(int) - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, value);
		Date returnDate = now.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("addMinute(int) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 按分钟加,指定日期
	 * 
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addMinute(Date date, int value) {
		if (logger.isDebugEnabled()) {
			logger.debug("addMinute(Date, int) - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MINUTE, value);
		Date returnDate = now.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("addMinute(Date, int) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 按分钟加,指定日期
	 * 
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addMinute(Date date, Long value) {
		if (logger.isDebugEnabled()) {
			logger.debug("addMinute(Date, int) - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MINUTE, Integer.parseInt(value.toString()));
		Date returnDate = now.getTime();
		if (logger.isDebugEnabled()) {
			logger.debug("addMinute(Date, int) - end"); //$NON-NLS-1$
		}
		return returnDate;
	}

	/**
	 * 返回两个日期间的差异天数
	 * 
	 * @param date1
	 *            参照日期
	 * @param date2
	 *            比较日期
	 * @return 参照日期与比较日期之间的天数差异，正数表示参照日期在比较日期之后，0表示两个日期同天，负数表示参照日期在比较日期之前
	 */
	public static int dayDiff(Date date1, Date date2) {
		try {
			date1 = DateUtil.parse((DateUtil.format(date1, "yyyyMMdd")),
					"yyyyMMdd");
			date2 = DateUtil.parse((DateUtil.format(date2, "yyyyMMdd")),
					"yyyyMMdd");
			long diff = date1.getTime() - date2.getTime();
			int returnint = (int) (diff / DAY);
			return returnint;
		} catch (Exception ex) {
			logger.error("get dayDiff error"); //$NON-NLS-1$
			return 0;
		}
	}

	/**
	 * 年份
	 * 
	 * @return
	 */
	public static int year() {
		if (logger.isDebugEnabled()) {
			logger.debug("year() - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		int returnint = now.get(Calendar.YEAR);
		if (logger.isDebugEnabled()) {
			logger.debug("year() - end"); //$NON-NLS-1$
		}
		return returnint;
	}

	/**
	 * 月份
	 * 
	 * @return
	 */
	public static int month() {
		if (logger.isDebugEnabled()) {
			logger.debug("month() - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		int returnint = now.get(Calendar.MONTH);
		if (logger.isDebugEnabled()) {
			logger.debug("month() - end"); //$NON-NLS-1$
		}
		return returnint;
	}

	/**
	 * 日(号)
	 * 
	 * @return
	 */
	public static int day() {
		if (logger.isDebugEnabled()) {
			logger.debug("day() - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		int returnint = now.get(Calendar.DAY_OF_MONTH);
		if (logger.isDebugEnabled()) {
			logger.debug("day() - end"); //$NON-NLS-1$
		}
		return returnint;
	}

	/**
	 * 小时(点)(12小时制)
	 * 
	 * @return
	 */
	public static int hour() {
		if (logger.isDebugEnabled()) {
			logger.debug("hour() - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		int returnint = now.get(Calendar.HOUR);
		if (logger.isDebugEnabled()) {
			logger.debug("hour() - end"); //$NON-NLS-1$
		}
		return returnint;
	}

	/**
	 * 小时(点)(24小时制)
	 * 
	 * @return
	 */
	public static int hour24() {
		if (logger.isDebugEnabled()) {
			logger.debug("hour() - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		int returnint = now.get(Calendar.HOUR_OF_DAY);
		if (logger.isDebugEnabled()) {
			logger.debug("hour() - end"); //$NON-NLS-1$
		}
		return returnint;
	}

	/**
	 * 分钟
	 * 
	 * @return
	 */
	public static int minute() {
		if (logger.isDebugEnabled()) {
			logger.debug("minute() - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		int returnint = now.get(Calendar.MINUTE);
		if (logger.isDebugEnabled()) {
			logger.debug("minute() - end"); //$NON-NLS-1$
		}
		return returnint;
	}

	/**
	 * 秒
	 * 
	 * @return
	 */
	public static int second() {
		if (logger.isDebugEnabled()) {
			logger.debug("second() - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		int returnint = now.get(Calendar.SECOND);
		if (logger.isDebugEnabled()) {
			logger.debug("second() - end"); //$NON-NLS-1$
		}
		return returnint;
	}

	/**
	 * 星期几(礼拜几)
	 * 
	 * @return
	 */
	public static int weekday() {
		if (logger.isDebugEnabled()) {
			logger.debug("weekday() - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		int returnint = now.get(Calendar.DAY_OF_WEEK) - 1;
		if (logger.isDebugEnabled()) {
			logger.debug("weekday() - end"); //$NON-NLS-1$
		}
		return returnint;
	}
	
	public static int getCalendarType(Date date, int calendarType) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCalendarType() - start"); //$NON-NLS-1$
		}

		Calendar c = convert(date);
		int result = c.get(calendarType);
		if (logger.isDebugEnabled()) {
			logger.debug("getCalendarType() - end"); //$NON-NLS-1$
		}
		return result;
	}
	
	public static int getCalendarType(int calendarType) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCalendarType() - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		int result = now.get(calendarType);
		if (logger.isDebugEnabled()) {
			logger.debug("getCalendarType() - end"); //$NON-NLS-1$
		}
		return result;
	}

	/**
	 * 是上午吗?
	 * 
	 * @return
	 */
	public static boolean isAm() {
		if (logger.isDebugEnabled()) {
			logger.debug("isAm() - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		boolean returnboolean = now.get(Calendar.AM_PM) == 0;
		if (logger.isDebugEnabled()) {
			logger.debug("isAm() - end"); //$NON-NLS-1$
		}
		return returnboolean;
	}

	/**
	 * 是下午吗?
	 * 
	 * @return
	 */
	public static boolean isPm() {
		if (logger.isDebugEnabled()) {
			logger.debug("isPm() - start"); //$NON-NLS-1$
		}

		Calendar now = Calendar.getInstance();
		boolean returnboolean = now.get(Calendar.AM_PM) == 1;
		if (logger.isDebugEnabled()) {
			logger.debug("isPm() - end"); //$NON-NLS-1$
		}
		return returnboolean;
	}

	/**
	 * 判断某年是否是闰年
	 * 
	 * @param year
	 *            需要判断的年份
	 * @return <code>boolean</code>类型 该年份是否是闰年<br>
	 *         <code>TRUE</code>: 是闰年<br>
	 *         <code>FALSE</code> : 不是闰年
	 */
	public static boolean isLeapYear(int year) {
		if (logger.isDebugEnabled()) {
			logger.debug("isLeapYear(int) - start"); //$NON-NLS-1$
		}

		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			if (logger.isDebugEnabled()) {
				logger.debug("isLeapYear(int) - end"); //$NON-NLS-1$
			}
			return true;
		} else
			return false;
	}

	/**
	 * 获取当前系统时间的某个部分，如年份，月份等等 <br>
	 * 目前可以提取到的部分：年、月、日、时、分、秒、毫秒、星期几 <br>
	 * 如果需要提取的部分不存在，则返回0
	 * 
	 * @param type
	 *            需要获取的部分,这个常量可以从本类中获取
	 * @return <code>int</code>类型 获取到的部分<br>
	 *         如果需要提取的部分不存在，则返回0
	 */
	public static int getNow(int type) {
		if (logger.isDebugEnabled()) {
			logger.debug("getNow(int) - start"); //$NON-NLS-1$
		}

		GregorianCalendar gc = new GregorianCalendar();
		switch (type) {
		case DateUtil.YEAR:
			return gc.get(Calendar.YEAR);
		case DateUtil.MONTH:
			return gc.get(Calendar.MONTH) + 1;
		case DateUtil.DAY_OF_MONTH:
			return gc.get(Calendar.DAY_OF_MONTH);
		case DateUtil.HOUR:
			return gc.get(Calendar.HOUR);
		case DateUtil.HOUR_OF_DAY:
			return gc.get(Calendar.HOUR_OF_DAY);
		case DateUtil.MINUTE:
			return gc.get(Calendar.MINUTE);
		case DateUtil.SECOND:
			return gc.get(Calendar.SECOND);
		case DateUtil.MILLISECOND:
			return gc.get(Calendar.MILLISECOND);
		case DateUtil.DAY_OF_WEEK:
			return ((gc.get(Calendar.DAY_OF_WEEK)) - 1);
		default:
			return 0;
		}
	}

	/**
	 * 根据提供的格式，将某个时间字符串格式化 <br>
	 * 如果发生异常，将返回原字符串
	 * 
	 * @param date
	 *            提供的时间字符串
	 * @param inFormat
	 *            提供的时间字符串的格式
	 * @param outFormat
	 *            需要得到的时间字符串的格式
	 * @return <code>String</code>类型 格式化的时间字符串<br>
	 *         如果发生异常，将返回原字符串
	 */
	public static String getFormatDateStr(String date, String inFormat,
			String outFormat) {
		if (logger.isDebugEnabled()) {
			logger.debug("getFormatDateStr(String, String, String) - start"); //$NON-NLS-1$
		}

		SimpleDateFormat sdf = new SimpleDateFormat(inFormat);
		Date datetemp = new Date();
		try {
			datetemp = sdf.parse(date);
			String returnString = format(datetemp, outFormat);
			if (logger.isDebugEnabled()) {
				logger.debug("getFormatDateStr(String, String, String) - end"); //$NON-NLS-1$
			}
			return returnString;
		} catch (ParseException e) {
			logger.error("getFormatDateStr(String, String, String)", e); //$NON-NLS-1$

			e.printStackTrace();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getFormatDateStr(String, String, String) - end"); //$NON-NLS-1$
		}
		return date;
	}

	/**
	 * 提取给定的时间字符串的某个部分 <br>
	 * 可以提取到的部分有：年，月，日，时，分，秒，毫秒，星期几
	 * 
	 * @param date
	 *            需要提取的时间字符串
	 * @param format
	 *            提供的时间字符串的格式
	 * @param type
	 *            需要提取的部分,这个常量可以从本类中获取
	 * @return <code>int</code>类型 提取到的某部分<br>
	 *         注意！如果提供的时间字符串没有包含要提取的部分或提取的部分不被支持，方法将返回0
	 */
	public static int get(String date, String format, int type) {
		if (logger.isDebugEnabled()) {
			logger.debug("get(String, String, int) - start"); //$NON-NLS-1$
		}

		switch (type) {
		case DateUtil.YEAR:
			return Integer.parseInt(DateUtil.getFormatDateStr(date, format,
					"yyyy"));
		case DateUtil.MONTH:
			return Integer.parseInt(DateUtil.getFormatDateStr(date, format,
					"MM"));
		case DateUtil.DAY_OF_MONTH:
			return Integer.parseInt(DateUtil.getFormatDateStr(date, format,
					"dd"));
		case DateUtil.HOUR_OF_DAY:
			return Integer.parseInt(DateUtil.getFormatDateStr(date, format,
					"HH"));
		case DateUtil.HOUR:
			return Integer.parseInt(DateUtil.getFormatDateStr(date, format,
					"hh"));
		case DateUtil.MINUTE:
			return Integer.parseInt(DateUtil.getFormatDateStr(date, format,
					"mm"));
		case DateUtil.SECOND:
			return Integer.parseInt(DateUtil.getFormatDateStr(date, format,
					"ss"));
		case DateUtil.MILLISECOND:
			return Integer.parseInt(DateUtil.getFormatDateStr(date, format,
					"SSS"));
		case DateUtil.DAY_OF_WEEK:
			return DateUtil.getGreGorianCalendar(date, format).get(
					Calendar.DAY_OF_WEEK) - 1;
		default:
			return 0;

		}
	}

	/**
	 * 获取指定的<code>Date</code>对象的某部分时间 <br>
	 * 可以提取的部分有 年、月、日、时、分、秒、毫秒、星期几
	 * 
	 * @param date
	 *            指定的<code>Date</code>对象
	 * @param type
	 *            需要提取的部分,这个常量可以从本类中获取
	 * @return <code>int</code>类型 提取出的部分<br>
	 *         如果需要提取的部分不被支持，则返回0
	 */
	public static int get(Date date, int type) {
		if (logger.isDebugEnabled()) {
			logger.debug("get(Date, int) - start"); //$NON-NLS-1$
		}

		GregorianCalendar gc = DateUtil.getGreGorianCalendar(date);
		switch (type) {
		case DateUtil.YEAR:
			return gc.get(Calendar.YEAR);
		case DateUtil.MONTH:
			return (gc.get(Calendar.MONTH)) + 1;
		case DateUtil.DAY_OF_MONTH:
			return gc.get(Calendar.DAY_OF_MONTH);
		case DateUtil.HOUR:
			return gc.get(Calendar.HOUR);
		case DateUtil.HOUR_OF_DAY:
			return gc.get(Calendar.HOUR_OF_DAY);
		case DateUtil.MINUTE:
			return gc.get(Calendar.MINUTE);
		case DateUtil.SECOND:
			return gc.get(Calendar.SECOND);
		case DateUtil.DAY_OF_WEEK:
			return (gc.get(Calendar.DAY_OF_WEEK) - 1);
		case DateUtil.MILLISECOND:
			return (int) (date.getTime() - DateUtil.parse(
					DateUtil.format(date, "yyyy-MM-dd HH-mm-ss"),
					"yyyy-MM-dd HH-mm-ss").getTime());
		default:
			return 0;
		}
	}

	/**
	 * 根据指定的时间字符串和格式，获得一个<code>GregorianCalendar</code>对象
	 * 
	 * @param date
	 *            指定的时间字符串
	 * @param format
	 *            指定的时间字符串的格式
	 * @return 创建的<code>GregorianCalendar</code>对象
	 * @see JavaAPI java.util.GregorianCalendar
	 */
	public static GregorianCalendar getGreGorianCalendar(String date,
			String format) {
		if (logger.isDebugEnabled()) {
			logger.debug("getGreGorianCalendar(String, String) - start"); //$NON-NLS-1$
		}

		GregorianCalendar returnGregorianCalendar = new GregorianCalendar(
				DateUtil.get(date, format, DateUtil.YEAR), DateUtil.get(date,
						format, DateUtil.MONTH) - 1, DateUtil.get(date, format,
						DateUtil.DAY_OF_MONTH), DateUtil.get(date, format,
						DateUtil.HOUR_OF_DAY), DateUtil.get(date, format,
						DateUtil.MINUTE), DateUtil.get(date, format,
						DateUtil.SECOND));
		if (logger.isDebugEnabled()) {
			logger.debug("getGreGorianCalendar(String, String) - end"); //$NON-NLS-1$
		}
		return returnGregorianCalendar;
	}

	/**
	 * 将一个<code>Date</code>对象转化为一个<code>GregorianCalendar</code>对象 <br>
	 * 这是一个非常有用的方法，因为我们常常需要调用一 个<code>GregorianCalendar</code>对象的某些方法， 但是
	 * <code>GregorianCalendar</code>没有提供直接转 换。通过这个方法可以快速实现转化。这 样就可以使用
	 * <code>GregorianCalendar</code>的很多 方法了 <br>
	 * 警告！该方法转换的时候会损失精度,转换后将无法保留毫秒部分 <br>
	 * 如果在转换的过程中出现异常，这个方法返回的将是默认的，以当前系统时间创建的<code>GregorianCalendar</code>对象
	 * 
	 * @param date
	 *            提供的<code>Date<c/ode>对象
	 * @return 
	 *         转换得到的GregorianCalendar对象<br>如果失败则返回以当前系统时间创建的<code>GregorianCalendar
	 *         </code>对象
	 * @see JavaAPI java.util.GregorianCalendar
	 */
	public static GregorianCalendar getGreGorianCalendar(Date date) {
		if (logger.isDebugEnabled()) {
			logger.debug("getGreGorianCalendar(Date) - start"); //$NON-NLS-1$
		}

		try {
			GregorianCalendar returnGregorianCalendar = new GregorianCalendar(
					Integer.parseInt(DateUtil.getFormatDateStr(date, "yyyy")),
					Integer.parseInt(DateUtil.getFormatDateStr(date, "MM")),
					Integer.parseInt(DateUtil.getFormatDateStr(date, "dd")),
					Integer.parseInt(DateUtil.getFormatDateStr(date, "HH")),
					Integer.parseInt(DateUtil.getFormatDateStr(date, "mm")),
					Integer.parseInt(DateUtil.getFormatDateStr(date, "ss")));
			if (logger.isDebugEnabled()) {
				logger.debug("getGreGorianCalendar(Date) - end"); //$NON-NLS-1$
			}
			return returnGregorianCalendar;
		} catch (Exception e) {
			logger.error("getGreGorianCalendar(Date)", e); //$NON-NLS-1$

			e.printStackTrace();
			GregorianCalendar returnGregorianCalendar = new GregorianCalendar();
			if (logger.isDebugEnabled()) {
				logger.debug("getGreGorianCalendar(Date) - end"); //$NON-NLS-1$
			}
			return returnGregorianCalendar;
		}
	}

	/**
	 * 返回两个日期之间的日期：如(2010-05-01----2010-05-04)
	 * 返回值是：(2010-05-01,2010-05-02,2010-05-03,2010-05-04)
	 * 
	 * @param d1
	 *            开始的日期
	 * @param d2
	 *            结束的日期
	 * @return
	 */
	public static Date[] getBetweenDate(Date d1, Date d2) {
		Vector<Date> v = new Vector<Date>();
		GregorianCalendar gc1 = new GregorianCalendar(), gc2 = new GregorianCalendar();
		gc1.setTime(d1);
		gc2.setTime(d2);
		do {
			GregorianCalendar gc3 = (GregorianCalendar) gc1.clone();
			v.add(gc3.getTime());
			gc1.add(Calendar.DAY_OF_MONTH, 1);
		} while (!gc1.after(gc2));
		return v.toArray(new Date[v.size()]);
	}

	/**
	 * 返回两个日期之间的字符串日期：如(2010-05-01----2010-05-04)
	 * 返回值是：(2010-05-01,2010-05-02,2010-05-03,2010-05-04)
	 * 
	 * @param d1
	 *            开始的日期
	 * @param d2
	 *            结束的日期
	 * @param formatString
	 *            格式化字符串格式化 如果格式化字符串出错，默认按yyyy-MM-dd类型
	 * @return
	 */
	public static String[] getBetweenFormatStringDate(Date d1, Date d2,
			String formatString) {
		SimpleDateFormat sdf = null;
		try {
			sdf = new SimpleDateFormat(formatString);
		} catch (RuntimeException e) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		Vector<String> v = new Vector<String>();
		GregorianCalendar gc1 = new GregorianCalendar(), gc2 = new GregorianCalendar();
		gc1.setTime(d1);
		gc2.setTime(d2);
		do {
			GregorianCalendar gc3 = (GregorianCalendar) gc1.clone();
			v.add(sdf.format(gc3.getTime()));
			gc1.add(Calendar.DAY_OF_MONTH, 1);
		} while (!gc1.after(gc2));
		return v.toArray(new String[v.size()]);
	}

	public static GregorianCalendar[] getBetweenGregorDate(Date d1, Date d2) {
		Vector<GregorianCalendar> v = new Vector<GregorianCalendar>();
		GregorianCalendar gc1 = new GregorianCalendar(), gc2 = new GregorianCalendar();
		gc1.setTime(d1);
		gc2.setTime(d2);
		do {
			GregorianCalendar gc3 = (GregorianCalendar) gc1.clone();
			v.add(gc3);
			gc1.add(Calendar.DAY_OF_MONTH, 1);
		} while (!gc1.after(gc2));
		return v.toArray(new GregorianCalendar[v.size()]);
	}

	public static int getDay_Of_Month() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取当前日期是星期几<br>
	 * 
	 * @param dt
	 * @return 当前日期是星期几
	 */
	public static int getWeekOfDate(Date dt) {
		int[] weekDays = { 0, 1, 2, 3, 4, 5, 6 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
	
	/**
	 * 获取某个月的天数
	 * @param month
	 * @return
	 */
	public static int getMonthDay(int month){
		Calendar time = Calendar.getInstance () ;
        int yearNow = time.get(Calendar.YEAR);//当前年份
      //  int monthNow = time.get(Calendar.MONTH); //当前月份的上一月(Calendar对象默认一月为0)
        time.clear () ;
        time.set (Calendar.YEAR , yearNow) ;
        time.set (Calendar.MONTH , month) ; //Calendar对象默认一月为0,月份要加1
        int maxday = time.getActualMaximum (Calendar.DAY_OF_MONTH) ; //本月份的天数
        return maxday;
	}
	
	public static void main(String[] args){
		System.out.println(""+DateUtil.month());
	}

}
