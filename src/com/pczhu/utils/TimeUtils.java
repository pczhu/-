package com.pczhu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	public static long getTime(){
		return new Date().getTime();
	}
	public static String getFormatTime(String format){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(new Date());
	}
	public static String getFormatTime(String format,Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}
}
