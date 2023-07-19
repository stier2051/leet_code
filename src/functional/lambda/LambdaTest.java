package functional.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdaTest {
    public static void main(String[] args) throws IOException {
        System.out.println(processFile());

        String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(result);
    }

    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    /**
     * метод для разного поведения
     */
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}
