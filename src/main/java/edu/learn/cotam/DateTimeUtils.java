package edu.learn.cotam;


import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * Class {@code Date} hỗ trợ các hàm tính toán , chuyển đổi linh hoạt giữa các dạng thời gian
 * trong java như {@code Java 8 Time API} {@code java.sql.Date} và nhiều thứ nữa :)
 */
public class DateTimeUtils {

    public static final String PATTERN_01 = "yyyy/MM/dd";

    public static final String PATTERN_02 = "yyyy-MM-dd";


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

    /**
     * Returns the hour represented by this <tt>Date</tt> object. The
     * returned value is a number (<tt>0</tt> through <tt>23</tt>)
     * representing the hour within the day that contains or begins
     * with the instant in time represented by this <tt>Date</tt>
     * object, as interpreted in the local time zone.
     * @param date date input
     * @return  the hour represented by this date.
     */
    public static int getHours(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).getHour();
    }

    /**
     * Returns the number of minutes past the hour represented by this date,
     * as interpreted in the local time zone.
     * The value returned is between <code>0</code> and <code>59</code>.
     * @param date date input
     * @return  the number of minutes past the hour represented by this date.
     */
    public static int getMinutes(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).getMinute();
    }

    /**
     * Returns the number of seconds past the minute represented by this date.
     * The value returned is between <code>0</code> and <code>61</code>. The
     * values <code>60</code> and <code>61</code> can only occur on those
     * @param date date input
     * @return  the number of seconds past the minute represented by this date.
     */
    public static int getSeconds(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).getSecond();
    }

    public static Calendar getCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
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
     * lấy ngày trong tháng hiện tại
     * <p>
     * @param date thời gian
     * @return trả về ngày trong tháng hiện tại từ 1 đến 31
     */
    public static int getDayOfMont(Date date){
        Calendar calendar = getCalendar(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Obtains an instance of {@code DayOfWeek} from an {@code int} value.
     * <p>
     * {@code DayOfWeek} is an enum representing the 7 days of the week.
     * This factory allows the enum to be obtained from the {@code int} value.
     * The {@code int} value follows the ISO-8601 standard, from 1 (Monday) to 7 (Sunday).
     * <p>
     * The singleton instance for the day-of-week of Monday.
     * This has the numeric value of {@code 1}.
     * <p>
     * The singleton instance for the day-of-week of Tuesday.
     * This has the numeric value of {@code 2}.
     * <p>
     * The singleton instance for the day-of-week of Wednesday.
     * This has the numeric value of {@code 3}.
     * <p>
     * The singleton instance for the day-of-week of Thursday.
     * This has the numeric value of {@code 4}.
     * <p>
     * The singleton instance for the day-of-week of Friday.
     * This has the numeric value of {@code 5}.
     * <p>
     * The singleton instance for the day-of-week of Saturday.
     * This has the numeric value of {@code 6}.
     * <p>
     * The singleton instance for the day-of-week of Sunday.
     * This has the numeric value of {@code 7}.
     */
    public static int getDayOfWeek(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).getDayOfWeek().getValue();
    }

    /**
     * lấy về thời gian ko có giờ phút giây
     * <p>
     *
     * @param date thời gian truyền vào
     * @return trả về thời gian dạng yyyy-MM-dd vd 2020-12-22
     */
    public static String getDateNoTime(Date date) {
        return (new SimpleDateFormat(PATTERN_02)).format(date);
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
        int day = getDayOfWeek(date);
        return day == DayOfWeek.SUNDAY.getValue() || day == DayOfWeek.SATURDAY.getValue();
    }

    /**
     * cộng thêm 1 khoảng <code>day ngày</code> khoảng ngày
     *
     * @param date thời gian truyền vào dạng java.util.Date
     * @param day khoảng thời gian dạng int
     * @return trả về kết quả là ngày muốn cộng
     */
    public static Date plusDays(Date date, int day){
        return java.util.Date.from(
                LocalDateTime.from(
                        date.toInstant()
                                .atZone(ZoneId.systemDefault())
                )
                        .plusDays(day)
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );
    }

    /**
     * trừ thêm 1 khoảng <code>day ngày</code> khoảng ngày
     *
     * @param date thời gian truyền vào dạng java.util.Date
     * @param day khoảng thời gian dạng int
     * @return trả về kết quả là ngày muốn trừ
     */
    public static Date minusDays(Date date, int day){
        return java.util.Date.from(
                LocalDateTime.from(
                        date.toInstant()
                                .atZone(ZoneId.systemDefault())
                )
                        .minusDays(day)
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );
    }

    public static Date changeTimeInDate(Date date,int hour, int minute, int second){
        int year = getYear(date);
        int month = getMonth(date);
        int dayOfMonth = getDayOfMont(date);
        return java.util.Date.from(
                LocalDateTime.of(year,month,dayOfMonth,hour,minute,second)
                .atZone(ZoneId.systemDefault())
                .toInstant()
        );
    }
}
