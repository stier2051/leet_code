package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 3, 9);

        //суммирование всех элементов
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum1 = numbers.stream().reduce(0, Integer::sum);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);

    }
}
