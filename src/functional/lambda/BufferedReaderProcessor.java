package functional.lambda;

import java.io.BufferedReader;
import java.io.IOException;
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
