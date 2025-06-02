package com.market.util;

import java.sql.Timestamp;

// 时间工具类
public class DatetimeUtil {
	// 获取当前时间
	public static Timestamp getNow() {
		// 获取系统当前时间戳
		long t=System.currentTimeMillis();
		Timestamp ts=new Timestamp(t);
		return ts;
	}
}
