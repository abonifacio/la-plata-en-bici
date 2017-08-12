package com.laplataenbici.model.domain.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static Timestamp now(){
		return new Timestamp((new Date()).getTime());
	}
	
	public static Timestamp now(Long milis){
		return new Timestamp(milis);
	}
	
	public static Timestamp endOfDay(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE,59);
		return new Timestamp(c.getTimeInMillis());
	}

}
