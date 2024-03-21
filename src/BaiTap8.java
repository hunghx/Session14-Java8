import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;

public class BaiTap8 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }


//        tim ra số chăn
        boolean check =Arrays.stream(arr).anyMatch(value -> value%2==0);

        // nếu có in ra so dau tien
        // neus ko , nem ra  loi ko tim thay

        OptionalInt optionalInt = Arrays.stream(arr).filter(value -> value%2==0).findFirst();

        System.out.println("So chan dau tien la :"+optionalInt.orElseThrow(() -> new RuntimeException("ko có so chăn")));

    }
}
