package com.bank.BSTMS.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.javassist.expr.NewArray;

/**
 * 获取时间工具类
 * @ClassName: TimeUtil
 * @Description: 获取时间工具类
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
public class TimeUtil {

	public static Date getCurrentTime() {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		
		try {
			return df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
