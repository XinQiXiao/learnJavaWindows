package com.market.util;

import java.sql.Timestamp;

// ʱ�乤����
public class DatetimeUtil {
	// ��ȡ��ǰʱ��
	public static Timestamp getNow() {
		// ��ȡϵͳ��ǰʱ���
		long t=System.currentTimeMillis();
		Timestamp ts=new Timestamp(t);
		return ts;
	}
}
