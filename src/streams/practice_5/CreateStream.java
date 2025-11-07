package streams.practice_5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {

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
                .collect(Collectors.toList());

        List<String> wordsList2 = Arrays.asList("Hello", "World");
        //возвращает список потоков из String
        List<Stream<String>> uniqueCharacters2 = wordsList2.stream()
                .map(w -> w.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        List<String> wordsList3 = Arrays.asList("Hello", "World");
        //возвращает то что надо - список String
        List<String> uniqueCharacters3 = wordsList3
                .stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)//схлопывает несколько потоков в один поток
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueCharacters3);

        //create empty stream
        Stream<String> emptyStream = Stream.empty();

        //create stream with nullable object
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream =
                homeValue == null ? Stream.empty() : Stream.of(homeValue);


        Stream<String> homeValueStream1 = Stream.ofNullable(System.getProperty("home"));

        Stream<String> values =
                Stream.of("config", "home", "user")
                        .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        long uniqueWords = 0;
        try (Stream<String> lines =
                     Files.lines(Paths.get("files/file_1.txt"), Charset.defaultCharset())) {

            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {

        }

        System.out.println(uniqueWords);
    }
}
