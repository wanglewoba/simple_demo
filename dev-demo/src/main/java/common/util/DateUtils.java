package common.util;/**
 * Created by admin on 2017/12/7.
 */

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author sunwenwu
 * @create 2017-12-07 15:46
 **/
public class DateUtils {
    /**
     *   格式化当前时间
     * @param pattern   默认格式 hhmmss
     * @return
     */
    public static final String formatCurrentTime(String pattern){
        if(StringUtils.isBlank(pattern)){
            pattern = "HHmmss";
        }

        return format(pattern);
    }


    /**
     *  格式化当前日期
     * @param pattern   默认格式 yyyyMMdd
     * @return
     */
    public static final String formatCurrentDate(String pattern){
        if(StringUtils.isBlank(pattern)){
            pattern = "yyyyMMdd";
        }
        return format(pattern);
    }


    private static String format(String pattern){
        return DateFormatUtils.format(System.currentTimeMillis(), pattern);
    }

    public static String getNextDay(String pattern) {
        if(StringUtils.isBlank(pattern)){
            pattern = "yyyyMMdd";
        }
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();
        return DateFormatUtils.format(date, pattern);
    }
}
