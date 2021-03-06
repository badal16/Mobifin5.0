package com.panamax.init;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;

import org.apache.commons.lang3.RandomStringUtils;

public class Utility {

	public static Properties readPropertyFile(String fileName) throws Exception {
		Properties localeFileprop = new Properties();
		FileInputStream in = null;
		InputStreamReader reader = null;
		in = new FileInputStream(new File(fileName));
		reader = new InputStreamReader(in, "UTF-8");
		localeFileprop.load(reader);
		return localeFileprop;
	}

	public static String getTimeStamp() {
		return (new SimpleDateFormat("yyMMddHHmmssSSS")).format(new Date());
	}

	/**
	 * Returns a pseudo-random number between min and max, inclusive. The
	 * difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 * 
	 * @param min
	 *            Minimum value
	 * @param max
	 *            Maximum value. Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int getRandomInt(int min, int max) {

		// Usually this should be a field rather than a method variable so
		// that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public static String getStringFromArray(String[] arr) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str += arr[i] + ",";
		}
		if (str.endsWith(","))
			str = str.substring(0, str.length() - 1);
		return str;
	}

	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();
		return dateFormat.format(date);

	}

	public static void appendTextToFile(String filePath, String text) {

		try {
			File fileObj = new File(filePath);
			fileObj.getParentFile().mkdirs();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)))) 
		{
			out.println(text);
		} catch (IOException e) {
			System.out.println("Error while writing content to file '"
					+ filePath + "'");
			e.printStackTrace();
		}
	}

	public static String getDiffInString(Date startDate, Date endDate) {

		// milliseconds
		long different = endDate.getTime() - startDate.getTime();

		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		// long daysInMilli = hoursInMilli * 24;

		// long elapsedDays = different / daysInMilli;
		// different = different % daysInMilli;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;

		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;

		long elapsedSeconds = different / secondsInMilli;

		String diffInString = String.format("%02d:%02d:%02d", elapsedHours,
				elapsedMinutes, elapsedSeconds);
		return diffInString;
	}

	public static String getCurrentDateMalaysia() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));

		String date = sdf.format(new Date());
		return date;
	}

	public static String generatRandomString(int stringLen) {
		String randomString = RandomStringUtils.random(stringLen, true, true);
		return randomString;
	}

}