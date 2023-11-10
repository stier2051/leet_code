package streams.practice_5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {

        //create stream
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

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
