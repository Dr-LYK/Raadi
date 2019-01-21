package Raadi.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

public class Converter {

    public static HashSet<String> StopWordsJsonToHashSet(String path) throws IOException {


        byte[] encoded = Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/main/java/Raadi/util/StopWords.json"));
        String stopWordsString = new String(encoded, Charset.defaultCharset());
        stopWordsString = stopWordsString.substring(1, stopWordsString.length() - 1);

        String[] items = stopWordsString.split(",");
        for (int i = 0; i < items.length; i++)
            items[i] = items[i].substring(1, items[i].length() - 1);

        return new HashSet<>(Arrays.asList(items));
    }
}