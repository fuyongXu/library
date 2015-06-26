package beyond.library.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理类
 * @author Administrator
 *
 */
public class DateUtil {
	
	/**
	 * 得出两个日期之间相差的天数
	 * @param date1 前一个日期
	 * @param date2 后一个日期
	 * @return
	 */
	public static int getDays(Date date1, Date date2) {
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar.setTime(date1);
		calendar2.setTime(date2);
		int days = 0;
		while(calendar.compareTo(calendar2) == -1){
			calendar.add(Calendar.DATE, 1);
			days++;
		}
		while(calendar.compareTo(calendar2) > 0){
			calendar.add(Calendar.DATE, -1);
			days--;
		}
		return days;
	}

	/**
	 * 得到与date日期相差time天的日期
	 * @param date 给出的日期
	 * @param time 相差的天数，正的为date前time天的日期，负的为date后time天的日期
	 * @return
	 */
	public static Date getDateAfterDate(Date date, int time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, time);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 由字符串格式化输出日期(yyyy-mm-dd)
	 * @param date
	 * @return
	 */
	public static Date formatDate(String date) {	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date time = null;
		try {
			time = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}
	/**
	 * 格式化输出日期的字符串(yyyy-mm-dd)
	 * @param date
	 * @return
	 */
	public static String formatDateToString(Date date) {	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time = df.format(date);
		return time;
	}
	
	/**
	 * 得到当天的日期
	 * @return
	 */
	public static Date getNowDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 0);
		return calendar.getTime();
	}
}
