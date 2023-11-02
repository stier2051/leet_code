package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MappingTest {
    public static void main(String[] args) {

        //вернуть квадраты элементов из списка
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sqrtNumbers = numbers
                .stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        sqrtNumbers.forEach(System.out::println);

        //по двум заданным спискам чисел вернуть все их попарные сочетания
        //array1 = [1,2,3]
        //array2 = [3,4]
        //result = [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1
                .stream()
                .flatMap(i -> numbers2
                        .stream()
                        .map(j -> new int[]{i, j})
                )
                        .collect(Collectors.toList());
    }
}
