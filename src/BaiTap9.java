import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BaiTap9 {

    public static final String ASIA_TOKYO = "Asia/Tokyo";
    public static final String SAO_PAULO = "America/Sao_Paulo";
    public static final String SYDNEY = "Australia/Sydney";

    public static void main(String[] args) {
        /*

        Bài tập 1: Viết chương trình để lấy ngày hiện tại của hệ thống và các nơi bao gồm : Asia/Tokyo, Australia/Sydney ,America/Sao_Paulo
        Bài tập 2: Viết chương trình để lấy thời gian hiện tại (giờ phút giây).
        Bài tập 3: Viết chương trình để tính toán số ngày giữa hai ngày (LocalDate) nhập vào .
        Bài tập 4: Viết chương trình để tính toán số ngày trong tháng hiện tại.
        Bài tập 5: Viết chương trình để tính toán số ngày trong năm hiện tại.
        Bài tập 6: Viết chương trình để chuyển đổi một chuỗi ngày sang một đối tượng LocalDate.
        Bài tập 7: Viết chương trình để chuyển đổi một đối tượng LocalDate sang một chuỗi ngày (dd/MM/yyyy).
        Bài tập 8: Viết chương trình để chuyển đổi một đối tượng LocalDateTime sang một chuỗi ngày(dd/MM/yyyy HH:mm:ss).
        Bài tập 9: Viết chương trình để so sánh hai ngày LocalDate ( trả về int ).
        Bài tập 10: Viết chương trình để so sánh hai thời gian  LocalTime.
        Bài tập 11: Viết chương trình để thêm hoặc bớt một số ngày, giờ, phút, giây hoặc mili giây vào một ngày hoặc thời gian nhập vào.
        Bài tập 12: Viết chương trình để tính toán ngày (LocalDate) tiếp theo hoặc ngày trước đó của một ngày.
         */

        // b1
        ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of(ASIA_TOKYO));
        System.out.println("Thời gian hiện ta của tokyo : " + tokyoTime.format(DateTimeFormatter.ISO_DATE_TIME));
        ZonedDateTime saoPaulo = ZonedDateTime.now(ZoneId.of(SAO_PAULO));
        System.out.println("Thời gian hiện ta của sao_paulo : " + tokyoTime.format(DateTimeFormatter.ISO_DATE_TIME));
        ZonedDateTime sydney = ZonedDateTime.now(ZoneId.of(SYDNEY));
        System.out.println("Thời gian hiện ta của sydney : " + tokyoTime.format(DateTimeFormatter.ISO_DATE_TIME));
        // b4
        LocalDate day1 = LocalDate.of(2024, 12, 12);
        LocalDate day2 = LocalDate.of(2023, 8, 10);
        long dayCount = ChronoUnit.DAYS.between(day2, day1);
        System.out.println(dayCount);
        //
        YearMonth y = YearMonth.of(LocalDate.now().getYear(), LocalDate.now().getMonth());
        System.out.println(y.lengthOfYear());
        System.out.println(y.lengthOfMonth());

        //
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = localDate.format(dtf);
        System.out.println(date);
        // so sánh 2 ngày và trả về int
        System.out.println(compareDate(day1,day2));
        System.out.println(addOrMinusLocalDate(ActionType.ADD,100,ChronoUnit.DAYS,LocalDateTime.now()));


    }

    public static int compareDate(LocalDate date1,LocalDate date2){
        return date1.compareTo(date2);
    }

    public  static LocalDateTime addOrMinusLocalDate(ActionType action, int count , ChronoUnit chronoUnit,LocalDateTime inputDate){
        switch (action){
            case ADD:
                return inputDate.plus(count,chronoUnit);
            case MINUS:
                return inputDate.minus(count,chronoUnit);
        }
        return null;
    }
}
