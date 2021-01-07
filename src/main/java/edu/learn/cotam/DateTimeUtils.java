package edu.learn.cotam;


import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Class {@code Date} hỗ trợ các hàm tính toán , chuyển đổi linh hoạt giữa các dạng thời gian
 * trong java như {@code Java 8 Time API} {@code java.sql.Date} và nhiều thứ nữa :)
 */
public class DateTimeUtils {

    /**
     * lầy thời gian
     * <p>
     *
     * @param year năm
     * @param month tháng
     * @param day ngày
     *             <p>
     * @return trả về thời gian đầu tiên của ngày đó <code>2021-01-05 00:00:00.000</code>
     */
    public static Date getDate(int year,int month,int day){
        LocalDate localDate = LocalDate.of(year, month, day);
        return  Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * lầy thời gian
     * <p>
     *
     * @param year năm
     * @param month tháng
     * @param day ngày
     * @param hour giờ
     * @param minute phút
     * @param second giây
     * @param nanoOfSecond na nô giây
     *             <p>
     * @return trả về thời gian đầu tiên của ngày đó <code>2021-01-05 00:00:00.000</code>
     */
    public static Date getDate(int year,int month,int day,int hour,int minute,int second,int nanoOfSecond){
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second, nanoOfSecond);
        return  Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * lầy thời gian đầu tiên của 1 ngày
     * <p>
     *
     * @param date ngày mà bạn muốn lấy
     *             <p>
     * @return trả về thời gian đầu tiên của ngày đó <code>2021-01-05 00:00:00.000</code>
     */
    public static Date atStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        localDateTime = localDateTime.with(LocalTime.MIN);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * lầy thời gian đầu tiên của 1 ngày
     * <p>
     * mặc địn là thời gian hiện tại
     * <p>
     *
     * @return trả về thời gian đầu tiên của ngày đó <code>2021-01-05 00:00:00.000</code>
     */
    public static Date atStartOfDay() {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.with(LocalTime.MIN);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * lầy thời gian cuối cùng của 1 ngày
     * <p>
     *
     * @param date thời gian mà bạn muốn lấy
     *             <p>
     * @return trả về thời gian đầu tiên của ngày đó <code>2021-01-05 23:59:59.999</code>
     */
    public static Date atEndOfDay(Date date) {
        LocalDateTime endOfDay = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        endOfDay = endOfDay.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * lầy thời gian cuối cùng của 1 ngày
     * <p>
     *
     * mặc định là thời gian hiện tại
     * @return trả về thời gian đầu tiên của ngày đó <code>2021-01-05 23:59:59.999</code>
     */
    public static Date atEndOfDay() {
        LocalDateTime endOfDay = LocalDateTime.now();
        endOfDay = endOfDay.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * lầy năm từ ngày
     * <p>
     * @param date thười gian mà bạn muốn lấy
     * @return trả về năm từ ngày vd 2020
     */
    public static int getYear(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).getYear();
    }

    /**
     * lầy năm từ ngày
     * <p>
     * mặc địnk là thời gian hiện tại
     *  @return trả về năm từ ngày vd 2020
     */
    public static int getYear() {
        return Year.now().getValue();
    }

    /**
     * Chuyển đổi từ kiểu <code>java date</code> sang <code>java.time.LocalDate</code>
     * <p>
     * @param date thời gian dạng <code>java.util.Date</code>
     *  @return thời gian dạng <code>java.time.LocalDate</code>
     */
    public static LocalDate convertLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Chuyển đổi từ kiểu <code>java date</code> sang <code>java.time.LocalDatTime</code>
     * <p>
     * @param date thời gian dạng <code>java.util.Date</code>
     *  @return thời gian dạng <code>java.time.LocalDateTime</code>
     */
    public static LocalDateTime convertLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Chuyển đổi từ kiểu <code>java date</code> sang <code>java.time.LocalDatTime</code>
     * <p>
     * @param date thời gian dạng <code>java.util.Date</code>
     *  @return thời gian dạng <code>java.sql.Date</code>
     */
    public static java.sql.Date convertSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * Chuyển đổi từ kiểu <code>java.time.LocalDatTime</code> sang <code>java.util.Date</code>
     * <p>
     * @param localDateTime thời gian dạng <code>java.time.LocalDateTime</code>
     *  @return thời gian dạng <code>java.util.Date</code>
     */
    public static Date convertDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    /**
     * Tính khoảng cách(ngày) giữa 2 khoảng thời gian
     * <p>
     * @param start ngày bắt đầu
     * @param end ngày kết thúc
     *  @return trả về khoảng cách giữa 2 ngày(Long)
     */
    public static Long countDateFromTwoDate(Date start, Date end) {
        //convert to localDate
        LocalDate fromDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //convert to localDate
        LocalDate toDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return ChronoUnit.DAYS.between(fromDate, toDate);
    }


    /**
     * lấy tháng từ ngày
     * <p>
     * @param date thời gian muốn lấy
     *  @return trả về tháng từ 1 đến 12
     */
    public static int getMonth(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).getMonthValue();
    }

    public static Date getDayStartOffMonth(int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, 1);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getDayStartOffMonth(int month) {
        LocalDate localDate = LocalDate.of(Year.now().getValue(), month, 1);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * lấy ngày cuối cùng trong tháng hiện tại
     * <p>
     *
     * @param month tháng mà bạn muốn lấy
     * @param year  năm mà bạn muốn lấy
     *              <p>
     * @return trả về ngày cuối cùng trong tháng hiện đạng <code>Date</code>
     */
    public static Date getDayLastOffMonth(int month, int year) {
        int lengthOfMonth = Month.of(month).maxLength();
        LocalDate localDate = LocalDate.of(year, month, lengthOfMonth);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * lấy ngày cuối cùng trong tháng hiện tại
     * <p>
     *
     * @param month tháng mà bạn muốn lấy
     *              , mặc định sẽ là năm hiện tại
     *              <p>
     * @return trả về ngày cuối cùng trong tháng hiện đạng <code>Date</code>
     */
    public static Date getDayLastOffMonth(int month) {
        LocalDate localDate = LocalDate.of(Year.now().getValue(), month, Month.of(month).maxLength());
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * lấy ngày cuối cùng trong tháng hiện tại
     * <p>
     * mặc định sẽ là năm và tháng hiện tại
     * <p>
     *
     * @return trả về ngày cuối cùng trong tháng hiện đạng <code>Date</code>
     */
    public static Date getDayLastOffMonth() {
        LocalDate localDate = LocalDate.now();
        int year = Year.now().getValue();
        int month = localDate.getMonthValue();
        int lengthOfMonth = Month.of(month).maxLength();
        localDate = LocalDate.of(year, month, lengthOfMonth);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * lấy ngày trong tháng hiện tại
     * <p>
     *
     * @return trả về ngày trong tháng hiện tại từ 1 đến 31
     */
    public static int getDayOfMonth() {
        return LocalDate.now().getDayOfMonth();
    }

    /**
     * lấy về thời gian ko có giờ phút giây
     * <p>
     *
     * @param date thời gian truyền vào
     * @return trả về thời gian dạng yyyy-MM-dd vd 2020-12-22
     */
    public static String getDateNoTime(Date date) {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
    }

    /**
     * lấy về thời gian ko có giờ phút giây
     * <p>
     *
     * @param year  năm
     * @param month tháng
     * @param day   ngày
     * @return trả về thời gian dạng yyyy-MM-dd vd 2020-12-22
     */
    public static Date getDateNoTime(Integer year, Integer month, Integer day) {
        return Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * kiểm tra xem có phải là cuối tuần thứ 7 hoặc chủ nhật hay không
     *
     * @param date thời gian truyền vào dạng java.util.Date
     * @return trả về true nếu là thứ 7 hoặc chủ nhật , false nếu ko
     */
    public static boolean isWeekEnd(Date date) {
        int day = date.getDay();
        return day == DayOfWeek.SUNDAY.getValue() || day == DayOfWeek.SATURDAY.getValue();
    }
}
