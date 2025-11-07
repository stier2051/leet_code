package streams.practice_5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CreateStream {
    public static void main(String[] args) throws IOException {

        //create stream
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        /**
         * Вернуть список всех уникальных символов, содержащихся в списке слов
         */
        List<String> wordsList1 = Arrays.asList("Hello", "World");
        //возвращает список массива String
        List<String[]> uniqueCharacters1 = wordsList1.stream()
                .map(w -> w.split(""))
                .distinct()
                .collect(toList());

        List<String> wordsList2 = Arrays.asList("Hello", "World");
        //возвращает список потоков из String
        List<Stream<String>> uniqueCharacters2 = wordsList2.stream()
                .map(w -> w.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        List<String> wordsList3 = Arrays.asList("Hello", "World");
        //возвращает то что надо - список String
        List<String> uniqueCharacters3 = wordsList3
                .stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)//схлопывает несколько потоков в один поток
                .distinct()
                .collect(toList());

        System.out.println(uniqueCharacters3);

        //create empty stream
        Stream<String> emptyStream = Stream.empty();

        //create stream with nullable object
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream =
                homeValue == null ? Stream.empty() : Stream.of(homeValue);

        homeValueStream.forEach(System.out::println);
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        System.out.println(uniqueWords);

        numsQuad();
        numPairs();
    }

    private static void numsQuad() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbersQuad = numbers
                .stream()
                .map(e -> e * e)
                .collect(toList());
        System.out.println(numbersQuad);
    }

    private static void numPairs() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1
                .stream()
                .flatMap(i -> numbers2
                        .stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(toList());
        pairs.forEach(e -> System.out.println(Arrays.toString(e)));
    }
}
