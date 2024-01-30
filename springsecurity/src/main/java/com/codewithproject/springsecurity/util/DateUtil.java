package com.codewithproject.springsecurity.util;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {

    public static final long SECOND = 1000;

    public static final String MIN_DATE = "1980-01-01";
    public static final String MAX_DATE = "2999-01-01";
    public static final String DATE_DD_MM_YY = "dd/MM/yy";
    public static final String DATE_YYYYMMDDHHMMSS_ZIP = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_FULL_STR = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FORMAT_FULL_STR = "hh:mm dd/MM/yyyy";
    public static final String DATE_FORMAT_EXCEL_FILE = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_EN_STR = "yyyy-MM-dd";
    public static final String DATE_FORMAT_VI_STR = "dd/MM/yyyy";
    public static final Integer TYPE_MOVE_DATE = 1;
    public static final Integer TYPE_MOVE_MONTH = 2;

    public static final String TIME_ZONE_SAIGON = "Asia/Saigon";

    private DateUtil(){}
    public static Date getMinDate() {
        return DateUtil.toDate(DateUtil.MIN_DATE);
    }

    public static Date getMaxDate() {
        return DateUtil.toDate(DateUtil.MAX_DATE);
    }

    public static Date toDate(String dateStr) {
        Date date = null;
        try {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT_EN_STR, Locale.ENGLISH);
            date = format.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    public static String toDateString(Date date) {
        String dateString = "";
        String format = null;
        if (date == null)
            return dateString;
        Object[] params = new Object[]{date};
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        format = DateUtil.DATE_FORMAT_EN_STR;
        try {
            dateString = MessageFormat.format(new StringBuilder().append("{0,date,").append(format).append("}").toString(), params);
        } catch (Exception e) {
            return "";
        }
        return dateString;
    }

    /**
     * Compare to.
     *
     * @param date1              the date1
     * @param date2              the date2
     * @param ignoreMilliseconds the ignore milliseconds
     * @return the int
     */
    public static int compareTo(Date date1, Date date2, boolean ignoreMilliseconds) {

        if ((date1 != null) && (date2 == null)) {
            return -1;
        } else if ((date1 == null) && (date2 != null)) {
            return 1;
        } else if (date1 == null) {
            return 0;
        }

        long time1 = date1.getTime();
        long time2 = date2.getTime();

        if (ignoreMilliseconds) {
            time1 = time1 / SECOND;
            time2 = time2 / SECOND;
        }

        if (time1 == time2) {
            return 0;
        } else if (time1 < time2) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Get current date by Gregorian Calendar
     * @return Date
     */
    public static Date getCurrentGMTDate() {
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        int offset = calendar.getTimeZone().getOffset(now.getTime());
        return new Date(now.getTime() - offset);
    }

    public static String toDateString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        return sdf.format(date);
    }

    public static Date compareGetDate(Date input, Date default0) {
        return input == null ? default0 : input;
    }

    public static boolean isBeforeCurrentDate(Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate().isBefore(LocalDate.now());
    }
    public static boolean isAfterCurrentDate(Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate().isAfter(LocalDate.now());
    }

    public static boolean isEqualCurrentDate(Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate().isEqual(LocalDate.now());
    }

    public static Date formatDateWithoutTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    public static Date formatDateWithMaxTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    public static Date moveDate(Date date, Integer val, Integer type) { //type = 1 Date,2: Month
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(type.equals(TYPE_MOVE_DATE)) {
            cal.add(Calendar.DATE, val);
        }
        else if(type.equals(TYPE_MOVE_MONTH)) {
            cal.add(Calendar.MONTH, val);
        }
        return cal.getTime();
    }

    public static Date moveFirstDateOfNextTwoMonth(Date date) {
        LocalDateTime localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        YearMonth nextTwoMonth = YearMonth.of(localDate.getYear(), localDate.getMonth().plus(2));
        LocalDateTime nextTime = LocalDateTime.of(nextTwoMonth.getYear(), nextTwoMonth.getMonth(), 1, localDate.getHour(), localDate.getMinute());
        return Date.from(nextTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date moveLastDateOfMonth(Date date, int monthToAdd) {
        LocalDateTime localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        YearMonth month = YearMonth.of(localDate.getYear(), localDate.getMonth().plus(monthToAdd));
        LocalDateTime lastDateOfMonth = LocalDateTime.of(month.getYear(), month.getMonth(), localDate.getDayOfMonth(), localDate.getHour(), localDate.getMinute());
        return Date.from(lastDateOfMonth.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static boolean checkDateExistInMonth(Date givenDate, int monthToAdd) {
        LocalDateTime givenLocalDateTime = givenDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        YearMonth nextMonth = YearMonth.of(givenLocalDateTime.getYear(), givenLocalDateTime.getMonth().plus(monthToAdd));
        int daysInCurrentMonth = nextMonth.lengthOfMonth();
        return givenLocalDateTime.getDayOfMonth() <= daysInCurrentMonth;
    }

    /*
     * NVHAI: convert days of week from Date/Integer to String
     * */
    public static String getDaysOfWeekDateToString(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int daysOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return getDaysOfWeekIntegerToString(daysOfWeek);
    }

    public static String getDaysOfWeekIntegerToString(Integer daysOfWeek) {
        if (daysOfWeek == null) {
            return "";
        }
        return daysOfWeek == 1 ? "CN" : "T" + daysOfWeek;
    }

    // NVHAI: Đếm số ngày/tuần/tháng/năm trong khoảng thời gian
//    public static long getDaysBetweenTwoDates(Date fromDate, Date toDate, Integer type) {
//        LocalDate from = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        LocalDate to = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        if (ScheduleType.DAILY.equals(type)) {
//            return ChronoUnit.DAYS.between(from, to);
//        } else if (ScheduleType.WEEKLY.equals(type)) {
//            return ChronoUnit.WEEKS.between(from, to);
//        } else if (ScheduleType.MONTHLY.equals(type)) {
//            return ChronoUnit.MONTHS.between(from, to);
//        } else if (ScheduleType.YEARLY.equals(type)) {
//            return ChronoUnit.YEARS.between(from, to);
//        }
//        return 0;
//    }

    public static Date convertToGMTDate(Date localDate, int timezoneInMin) {
        return convertDate(localDate, -timezoneInMin);
    }

    public static Date convertToServerDate(Date gmtDate, int timezoneInMin) {
        return convertDate(gmtDate, timezoneInMin);
    }

    private static Date convertDate(Date srcDate, int timezoneInMin) {
        if( srcDate == null ) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(srcDate);
        calendar.add(Calendar.MINUTE, timezoneInMin);
        return calendar.getTime();
    }

    public static int compareDateWithoutTime(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);
        if( cal1.equals(cal2) ) {
            return 0;
        }
        else if( cal1.after(cal2) ) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
