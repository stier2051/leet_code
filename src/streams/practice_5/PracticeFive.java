package streams.practice_5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeFive {
    public static void main(String[] args) {
        iterateWithLimit();
    }

    public static void fibonacciSequence() {
        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .forEach(n -> System.out.println("(" + n[0] + ", " + n[1] + ")"));
    }

    public static void iterateWithLimit() {
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);
    }
}
