package com.cathay.coindesk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dateString = "Oct 19, 2022 02:08:00 UTC";
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss zzz", Locale.ENGLISH);
		try {
			Date date = format.parse(dateString);
			System.out.print(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
