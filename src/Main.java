import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ICrud student = new StudentImpl();
        ICrud.displayName();

        // FunctionalInterface
        // chi có duy nhất 1 abstract method
//                Predicate
//        Consumer
//        Supplier
//        Function

        // tạo ra đối tượng functionalInterface
        MoveAble moveAble = ()->{
            System.out.println("moving....");
        };

        Predicate<String> predicate = (str)->true;
        Comparator<String> comparator = String::compareTo;

        Collections.sort(new ArrayList<String>(),comparator);


        List<Integer> arr = Arrays.asList(1,2,3,4,5,6);
        arr.forEach(System.out::println);


        // Stream - luồng - dòng chảy
       // JS : map , filter, foreach, reduce , find
        // JV
        Math math = new Math();

//        List<Integer> list = arr.stream().map(t->t*t).collect(Collectors.toList());
        Function<Integer,Integer> function = new Math()::square;

        int sum = arr.stream().map(function).reduce(0,(temp, element) ->temp+element);
//        arr.stream().map(Math::square).forEach(System.out::println);



        System.out.println(arr);


        // các thao tác hay dùng : filter (lọc) , map (chuyển đối) , foreach(),reduce
        // collect (map, colection, array)
        // sum, min, max, limit , distinct (ko trùng lặp)

        //    tạo ngẫu nhiên danh sách 100 phần tử ko trùng lặp có khoảng giá tri từ 1 - 1000;
        List<Integer> random = Stream.generate(()->new Random().nextInt(1000))
                .distinct()
                .limit(100)
                .sorted()
                .filter(num-> num%5==0)
                .collect(Collectors.toList());
        System.out.println(random);
        // lọc ra những số chia hết cho 5


        // chuyển dổi từ 1 List<String> -> List<Student>
        List<String> strings = Arrays.asList("nam", "anh", "đuc");
        List<Student> students = strings.stream().map(Student::new).collect(Collectors.toList());
//        tính 100 ngày sau ngày hôm này
        System.out.println(System.currentTimeMillis());  // in ra số giây hiện tại từ 1970
        Date today = new Date(System.currentTimeMillis());
        System.out.println(new Date());
        System.out.println(today);
        Date _100nextDay = new Date(System.currentTimeMillis()+ 100L *86400000);
        System.out.println(_100nextDay);


        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println("sau 100 ngay"+localDate.plus(100, ChronoUnit.DAYS));


        // nhập vào ngày tháng năm theo đinh dạng dd/MM/yyyy;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//        LocalDate localDate1 = LocalDate.parse("12/02/2004",DateTimeFormatter.ISO_LOCAL_DATE); // ép kiểu tường minh
//        System.out.println(localDate1);

        // tính tuổi của bạn theo ngày sinh
        String quAnh = "29/12/2000";

        LocalDate quAnhBod = LocalDate.of(2000,12,29);
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime  = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();


        int age = Period.between(quAnhBod,localDate).getYears();
        System.out.println( Period.between(quAnhBod,localDate));
        long dayOfLive = Duration.between(quAnhBod.atStartOfDay(),localDate.atStartOfDay()).toDays();
        System.out.println("Tuổi q anh = "+ age);
        System.out.println("Ngày đã sống q anh = "+ dayOfLive);



        List<String> list = null;

        list.add("Nam");

        Optional<List<String>> listOptional = Optional.ofNullable(list);
        // kiểm tra null
        if(listOptional.isPresent()){
            // thuc hien cac thao tac vs gia trị
            System.out.println(listOptional.get());
        }

        List<String> result = listOptional.orElse(new ArrayList<>());
        List<String> result1 = listOptional.orElseThrow(() -> new RuntimeException("errorrrr ..."));




    }
}