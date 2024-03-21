import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaiTap1 {
    public static void main(String[] args) {
        List<Integer> random = Stream.generate(()->new Random().nextInt(1000))
                .limit(100)
                .collect(Collectors.toList());
        System.out.println("List : "+random);
        // tìm ra phần tu lớn nhất
//        Optional<Integer> max = random.stream().max((Comparator.comparingInt(o -> o)));
        Optional<Integer> max = random.stream().max(Comparator.naturalOrder());
        System.out.println("Giá trị lớn nhất "+
                max.orElseThrow(() -> new RuntimeException("khong có phan tu nào trong danh sach")));

    }
}
