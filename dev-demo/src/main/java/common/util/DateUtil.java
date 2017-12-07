package common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.*;

/**
 *@Description:日期处理相关工具类
 */
public class DateUtil {

	/** 定义常量 **/
	public static final String DATE_JFP_STR = "yyyyMM";
	public static final String DATE_FULL_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_KEY_STR = "yyMMddHHmmss";

	public static final String TIME_PATTERN = "HH:mm:ss";
	public static final String DAY_PATTERN = "yyyy-MM-dd";

	public static final String DAY_MONTH_YEAR_PATTERN = "yyyyMMdd";
	public static final String DATE_KEY_STR_PATTERN = "yyyyMMddHHmmss";
	
	public static final String DATE_WITH_MILESECOND = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * @Description:使用预设格式提取字符串日期
	 * @param strDate
	 *            日期字符串
	 * @return Date
	 */
	public static Date parse(String strDate) {
		return parse(strDate, DATE_FULL_PATTERN);
	}

	public static Date getDateByTime(String strTime, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(c.DATE, day);
		Date temp_date = c.getTime();
		String strDate = parseDate(temp_date, DAY_PATTERN) + " " + strTime;
		return parse(strDate, DATE_FULL_PATTERN);
	}

	public static Date getDate(Date date, int day, int second) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		calender.add(Calendar.DATE, day);
		calender.add(Calendar.SECOND, second);
		return calender.getTime();
	}

	/**
	 * @Description:使用用户格式提取字符串日期
	 * @param strDate
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return Date
	 */
	public static Date parse(String strDate, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String parseDate(Date date, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * @Description:获取系统当前时间
	 * @return String
	 */
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FULL_PATTERN);
		return df.format(new Date());
	}

	/**
	 * @Description:获取系统当前指定格式的时间
	 * @param type
	 *            时间格式
	 * @return String
	 */
	public static String getNowTime(String type) {
		SimpleDateFormat df = new SimpleDateFormat(type);
		return df.format(new Date());
	}

	/**
	 * @Description:将指定的日期转换成Unix时间戳
	 * @param date
	 *            需要转换的日期 yyyy-MM-dd HH:mm:ss
	 * @return long
	 */
	public static long dateToUnixTimestamp(String date) {
		long timestamp = 0;
		try {
			timestamp = new SimpleDateFormat(DATE_FULL_PATTERN).parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}

	/**
	 * @Description:将指定的日期转换成Unix时间戳
	 * @param date
	 *            需要转换的日期 yyyy-MM-dd
	 * @param dateFormat
	 *            日期格式
	 * @return long
	 */
	public static long dateToUnixTimestamp(String date, String dateFormat) {
		long timestamp = 0;
		try {
			timestamp = new SimpleDateFormat(dateFormat).parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}

	/**
	 * @Description:将当前日期转换成Unix时间戳
	 * @return long
	 */
	public static long dateToUnixTimestamp() {
		long timestamp = new Date().getTime();
		return timestamp;
	}

	/**
	 * @Description:将Unix时间戳转换成日期
	 * @param long timestamp 时间戳
	 * @return String
	 */
	public static String unixTimestampToDate(long timestamp) {
		SimpleDateFormat sd = new SimpleDateFormat(DATE_FULL_PATTERN);
		sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sd.format(new Date(timestamp));
	}

	/**
	 * @Description:将Date格式化成符合默认格式的字符串
	 * @param date
	 * @return String 返回样例:2012-03-29 14:32:23
	 */
	public static String format(Date date) {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(DAY_PATTERN + " " + TIME_PATTERN);
		return formatTool.format(date);
	}

	/**
	 * @Description:将Date格式化成符合默认日期格式的字符串
	 * @param date
	 * @return String 返回样例:2012-03-29
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(DAY_PATTERN);
		return formatTool.format(date);
	}

	/**
	 * @Description:将Date格式化成符合默认时间格式的字符串
	 * @param date
	 * @return String 返回样例:14:32:23
	 */
	public static String formatTime(Date date) {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(TIME_PATTERN);
		return formatTool.format(date);
	}

	/**
	 * @Description:设置Calendar时间
	 * @param @param cal
	 * @param @param hourOfDay 小时
	 * @param @param minute 分钟
	 * @param @param second 秒
	 * @param @param milliSecond 毫秒
	 */
	private static void setCalendarTime(Calendar cal, int hourOfDay, int minute, int second, int milliSecond) {
		cal.set(HOUR_OF_DAY, hourOfDay);
		cal.set(MINUTE, minute);
		cal.set(SECOND, second);
		cal.set(MILLISECOND, milliSecond);
	}

	/**
	 * @Description:设定date的时间细节
	 * @param date
	 *            要设定时间细节的date
	 * @param hourOfDay
	 *            0-23
	 * @param minute
	 *            0-59
	 * @param second
	 *            0-59
	 * @param milliSecond
	 *            0-999
	 * @return Date
	 */
	public static Date parseTime(Date date, int hourOfDay, int minute, int second, int milliSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		setCalendarTime(cal, hourOfDay, minute, second, milliSecond);
		return cal.getTime();
	}

	/**
	 * @Description:设定date的时间细节
	 * @param date
	 *            要设定时间细节的date
	 * @param timeDetail
	 *            以:号分隔的24小时制的时间，例:16:23:42:267 或 16(等同于16:00:00:000)
	 * @return Date
	 */
	public static Date parseTime(Date date, String timeDetail) {

		List<String> strList = new ArrayList<String>();
		strList.addAll(Arrays.asList(timeDetail.split(":")));

		while (strList.size() < 4) {
			strList.add("0");
		}
		return parseTime(date, Integer.parseInt(strList.get(0)), Integer.parseInt(strList.get(1)), Integer.parseInt(strList.get(2)), Integer.parseInt(strList.get(3)));
	}

	/**
	 * @Description:返回这一天的最早的时候
	 * @param date
	 * @return Date
	 */
	public static Date getEarliest(Date date) {
		return parseTime(date, 0, 0, 0, 0);
	}

	/**
	 * @Description:指定时间 是否在 当前时间 之后，注：和日期无关
	 * @param time
	 *            指定的时间， 传入样例:16:23:42:267 或 16(等同于16:00:00:000)
	 * @return boolean
	 */
	public static boolean isAfterTime(String time) {
		Date date = parseTime(new Date(), time);
		return date.after(new Date());
	}

	/**
	 * @Description:指定时间 是否在 当前时间 之前，注：和日期无关
	 * @param time
	 *            指定的时间， 传入样例:16:23:42:267 或 16(等同于16:00:00:000)
	 * @return boolean
	 */
	public static boolean isBeforeTime(String time) {
		Date date = parseTime(new Date(), time);
		return date.before(new Date());
	}

	/**
	 * @Description: 两个时间比较
	 * @param date1
	 * @return int
	 */
	public static int compareDateWithNow(Date date1) {
		Date date2 = new Date();
		int rnum = date1.compareTo(date2);
		return rnum;
	}

	/**
	 * @Description:两个时间比较(时间戳比较)
	 * @param date1
	 * @return int
	 */
	public static int compareDateWithNow(long date1) {
		long date2 = dateToUnixTimestamp();
		if (date1 > date2) {
			return 1;
		} else if (date1 < date2) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * @Description:返回星期对应的数字
	 * @param strWeek
	 * @return int
	 * @See getWeekNum
	 */
	public static int getWeekNum(String strWeek) {
		int returnValue = 0;
		if (strWeek.equals("Mon")) {
			returnValue = 1;
		} else if (strWeek.equals("Tue")) {
			returnValue = 2;
		} else if (strWeek.equals("Wed")) {
			returnValue = 3;
		} else if (strWeek.equals("Thu")) {
			returnValue = 4;
		} else if (strWeek.equals("Fri")) {
			returnValue = 5;
		} else if (strWeek.equals("Sat")) {
			returnValue = 6;
		} else if (strWeek.equals("Sun")) {
			returnValue = 0;
		} else
			returnValue = 0;
		return returnValue;
	}

	/**
	 * @Description:将Date格式化成符合默认时间格式的字符串
	 * @param date
	 * @return String 返回样例:14:32:23
	 */
	public static String formatDate2Str(Date date) {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(DATE_KEY_STR_PATTERN);
		return formatTool.format(date);
	}

	/**
	 * @Description:将Date格式化成符合默认时间格式的字符串
	 * @param date
	 * @return String 返回样例:14:32:23
	 */
	public static String formatDateDMY(Date date) {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(DAY_MONTH_YEAR_PATTERN);
		return formatTool.format(date);
	}

	public static String getCurrentDateStr() {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(DAY_MONTH_YEAR_PATTERN);
		return formatTool.format(new Date());
	}

	/**
	 * 判断当前日期是星期几
	 * 
	 * @param String
	 *            strDate_ 格式yyyy-MM-dd 修要判断的时间
	 * @return dayForWeek 判断结果
	 * @param
	 * @Exception 发生异常
	 */
	public static boolean isHoliday(String strDate) throws Exception {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(DAY_PATTERN);
		StringBuffer sBuffer = new StringBuffer(strDate.substring(0, 4)).append("-").append(strDate.substring(4, 6)).append("-").append(strDate.substring(6, 8));
		// String strDate = formatTool.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(formatTool.parse(sBuffer.toString()));
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek > 5;
	}

	/**
	 * 得到当前日期的前一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYesterday(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 得到当前日期的后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getTomorrow(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 
	 *@Description:字符串日期类型转换
	 *@Since:2014-11-20下午3:10:01
	 *@param dateString 要转换的日期字符串
	 *@param DateStringPattern 当前字符串 格式
	 *@param pattern 转换后的格式
	 *@return
	 * @throws ParseException
	 *@throws Exception
	 */
	public static String formatDateString(String dateString, String DateStringPattern, String pattern) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat(DateStringPattern);
		Date date = sdf1.parse(dateString);
		SimpleDateFormat sdf2 = new SimpleDateFormat(pattern);
		return sdf2.format(date);
	}

	public static void main(String[] args) throws Exception {
		/*
		 * Date nextDate = new Date(); for (int i = 0; i < 31; i++) {
		 * 
		 * nextDate = getYesterday(nextDate); System.out.println(nextDate); }
		 * System.out.println(getDateByTime("15:00:00",0));
		 * System.out.println(getDateByTime("15:00:00",-1));
		 */

//		Date date = parse("20142523", DAY_MONTH_YEAR_PATTERN);
//		System.out.println(date);
	}
}
