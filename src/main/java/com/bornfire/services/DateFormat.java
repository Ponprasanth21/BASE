package com.bornfire.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.icu.util.Calendar;

public class DateFormat {

	public String formatdate(String dateinput) {
		if (dateinput.length() > 0) {
			String finalDate = dateinput.trim();
			String splitDates[] = finalDate.split("-");
			String day = splitDates[0];
			String month = splitDates[1];
			String year = splitDates[2];
			if (month.equalsIgnoreCase("01")) {
				dateinput = day + "-" + "JAN" + "-" + year;
			}
			if (month.equalsIgnoreCase("02")) {
				dateinput = day + "-" + "FEB" + "-" + year;
			}
			if (month.equalsIgnoreCase("03")) {
				dateinput = day + "-" + "MAR" + "-" + year;
			}
			if (month.equalsIgnoreCase("04")) {
				dateinput = day + "-" + "APR" + "-" + year;
			}
			if (month.equalsIgnoreCase("05")) {
				dateinput = day + "-" + "MAY" + "-" + year;
			}
			if (month.equalsIgnoreCase("06")) {
				dateinput = day + "-" + "JUN" + "-" + year;
			}
			if (month.equalsIgnoreCase("07")) {
				dateinput = day + "-" + "JUL" + "-" + year;
			}
			if (month.equalsIgnoreCase("08")) {
				dateinput = day + "-" + "AUG" + "-" + year;
			}
			if (month.equalsIgnoreCase("09")) {
				dateinput = day + "-" + "SEP" + "-" + year;
			}
			if (month.equalsIgnoreCase("10")) {
				dateinput = day + "-" + "OCT" + "-" + year;
			}
			if (month.equalsIgnoreCase("11")) {
				dateinput = day + "-" + "NOV" + "-" + year;
			}
			if (month.equalsIgnoreCase("12")) {
				dateinput = day + "-" + "DEC" + "-" + year;
			}
		}

		return dateinput;
	}

	public String formatdate2(String dateinput) {
		if (dateinput.length() > 0) {
			String finalDate = dateinput.trim();
			String splitDates[] = finalDate.split("/");
			String day = splitDates[0];
			String month = splitDates[1];
			String year = splitDates[2];
			if (month.equalsIgnoreCase("01")) {
				dateinput = day + "-" + "JAN" + "-" + year;
			}
			if (month.equalsIgnoreCase("02")) {
				dateinput = day + "-" + "FEB" + "-" + year;
			}
			if (month.equalsIgnoreCase("03")) {
				dateinput = day + "-" + "MAR" + "-" + year;
			}
			if (month.equalsIgnoreCase("04")) {
				dateinput = day + "-" + "APR" + "-" + year;
			}
			if (month.equalsIgnoreCase("05")) {
				dateinput = day + "-" + "MAY" + "-" + year;
			}
			if (month.equalsIgnoreCase("06")) {
				dateinput = day + "-" + "JUN" + "-" + year;
			}
			if (month.equalsIgnoreCase("07")) {
				dateinput = day + "-" + "JUL" + "-" + year;
			}
			if (month.equalsIgnoreCase("08")) {
				dateinput = day + "-" + "AUG" + "-" + year;
			}
			if (month.equalsIgnoreCase("09")) {
				dateinput = day + "-" + "SEP" + "-" + year;
			}
			if (month.equalsIgnoreCase("10")) {
				dateinput = day + "-" + "OCT" + "-" + year;
			}
			if (month.equalsIgnoreCase("11")) {
				dateinput = day + "-" + "NOV" + "-" + year;
			}
			if (month.equalsIgnoreCase("12")) {
				dateinput = day + "-" + "DEC" + "-" + year;
			}
		}

		return dateinput;
	}

	public String formatdate1(String dateinput) {
		if (dateinput.length() > 0) {
			String finalDate = dateinput.trim();
			String splitDates[] = finalDate.split("-");
			String day = splitDates[0];
			String month = splitDates[1];
			String year = splitDates[2];
			if (month.equalsIgnoreCase("01")) {
				dateinput = day + "-" + "JAN" + "-" + year;
			}
			if (month.equalsIgnoreCase("02")) {
				dateinput = day + "-" + "FEB" + "-" + year;
			}
			if (month.equalsIgnoreCase("03")) {
				dateinput = day + "-" + "MAR" + "-" + year;
			}
			if (month.equalsIgnoreCase("04")) {
				dateinput = day + "-" + "APR" + "-" + year;
			}
			if (month.equalsIgnoreCase("05")) {
				dateinput = day + "-" + "MAY" + "-" + year;
			}
			if (month.equalsIgnoreCase("06")) {
				dateinput = day + "-" + "JUN" + "-" + year;
			}
			if (month.equalsIgnoreCase("07")) {
				dateinput = day + "-" + "JUL" + "-" + year;
			}
			if (month.equalsIgnoreCase("08")) {
				dateinput = day + "-" + "AUG" + "-" + year;
			}
			if (month.equalsIgnoreCase("09")) {
				dateinput = day + "-" + "SEP" + "-" + year;
			}
			if (month.equalsIgnoreCase("10")) {
				dateinput = day + "-" + "OCT" + "-" + year;
			}
			if (month.equalsIgnoreCase("11")) {
				dateinput = day + "-" + "NOV" + "-" + year;
			}
			if (month.equalsIgnoreCase("12")) {
				dateinput = day + "-" + "DEC" + "-" + year;
			}
		}

		return dateinput;
	}

	public int numberDays(int year, int month) {

		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		System.out.println(daysInMonth);
		return daysInMonth;
	}

	public int countWeekendDays(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		// Note that month is 0-based in calendar, bizarrely.
		calendar.set(year, month - 1, 1);
		int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		int count = 0;
		for (int day = 1; day <= daysInMonth; day++) {
			calendar.set(year, month - 1, day);
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) {
				count++;
				// Or do whatever you need to with the result.
			}
		}
		return count;
	}

	public int calculateDate(String startDate, String endDate) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		int workingDays = 0;
		int weekend = 0;
		ConnectionManager connMgr = new ConnectionManager();
		Connection conn = connMgr.getConnection();
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer();
		int cnt = 0;
		try {
			Calendar start = Calendar.getInstance();
			start.setTime(sdf.parse(startDate));
			Calendar end = Calendar.getInstance();
			end.setTime(sdf.parse(endDate));

			while (!start.after(end)) {
				int day = start.get(Calendar.DAY_OF_WEEK);
				if ((day != Calendar.SATURDAY) && (day != Calendar.SUNDAY)) {
					workingDays++;

				} else {
					weekend++;
				}
				start.add(Calendar.DATE, 1);
			}

			// System.out.println(workingDays+""+weekend);
			DateFormat df = new DateFormat();
			List<Date> dates = new ArrayList<Date>();
			Date starts = (Date) sdf.parse(startDate);
			Date ends = (Date) sdf.parse(endDate);
			long interval = 24 * 1000 * 60 * 60; // 1 hour in millis
			long endTime = ends.getTime(); // create your endtime here, possibly using Calendar or Date
			long curTime = starts.getTime();
			while (curTime <= endTime) {
				dates.add(new Date(curTime));
				curTime += interval;
			}

			for (int i = 0; i < dates.size(); i++) {
				Date lDate = (Date) dates.get(i);
				String ds = sdf.format(lDate);
				// System.out.println(" Date is ..." + ds);
				sql.setLength(0);
				sql.append("Select count(RECORD_DATE) as holicount from HOLIDAY_MASTER where RECORD_DATE='"
						+ df.formatdate(ds) + "' and DEL_FLG='N' ");
				System.out.println("sql QUERY" + sql.toString());
				try {
					ps = conn.prepareStatement(sql.toString());
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						cnt = rs.getInt("holicount");
						weekend += cnt;
						System.out.println("cnt--->" + cnt);
					}

				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		} // System.out.println(workingDays+"ff"+weekend);

		return weekend;
	}

	public String formatmonth(String monthinput) {

		if (monthinput.equalsIgnoreCase("1")) {
			monthinput = "January";
		}
		if (monthinput.equalsIgnoreCase("2")) {
			monthinput = "February";
		}
		if (monthinput.equalsIgnoreCase("3")) {
			monthinput = "March";
		}
		if (monthinput.equalsIgnoreCase("4")) {
			monthinput = "April";
		}
		if (monthinput.equalsIgnoreCase("5")) {
			monthinput = "May";
		}
		if (monthinput.equalsIgnoreCase("6")) {
			monthinput = "June";
		}
		if (monthinput.equalsIgnoreCase("7")) {
			monthinput = "July";
		}
		if (monthinput.equalsIgnoreCase("8")) {
			monthinput = "August";
		}
		if (monthinput.equalsIgnoreCase("9")) {
			monthinput = "Septemper";
		}
		if (monthinput.equalsIgnoreCase("10")) {
			monthinput = "October";
		}
		if (monthinput.equalsIgnoreCase("11")) {
			monthinput = "November";
		}
		if (monthinput.equalsIgnoreCase("12")) {
			monthinput = "December";
		}

		return monthinput;
	}

	public int countHoliDays(int year, int month) {
		/*
		 * System.out.println("YEARRRRRR"+year); System.out.println("MONTHHHHH"+month);
		 */
		Calendar calendar = Calendar.getInstance();
		// Note that month is 0-based in calendar, bizarrely.
		calendar.set(year, month - 1, 1);
		String monthalp = "";

		int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("DAYSinMONTH===" + daysInMonth);
		int count = 0;
		DateFormat df = new DateFormat();
		String monthname = df.formatmonth(Integer.toString(month));

		ConnectionManager connMgr = new ConnectionManager();
		Connection conn = connMgr.getConnection();
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer();

		sql.append("Select count(HOLIDAY_DESC) as holicount from HOLIDAY_MASTER where cal_year='" + year
				+ "' and cal_month='" + monthname + "' and DEL_FLG='N'");
		System.out.println("sql QUERY" + sql.toString());
		try {
			ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("rs.getInt====>" + rs.getInt("holicount"));
				count = rs.getInt("holicount");
				System.out.println("holiday===COUNTTTT" + count);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}

		return count;
	}

}
