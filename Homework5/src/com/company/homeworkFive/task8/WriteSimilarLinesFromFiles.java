package com.company.homeworkFive.task8;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteSimilarLinesFromFiles {
    public static void writeSimilarLinesFromTwoFiles() throws IOException {
        List<String> linesOne = Files.readAllLines(Paths.get("src/com/company/homeworkFive/task8/INPUT_1.txt"), StandardCharsets.UTF_8);
        List<String> linesTwo = Files.readAllLines(Paths.get("src/com/company/homeworkFive/task8/INPUT_2.txt"), StandardCharsets.UTF_8);

        PrintWriter writer = new PrintWriter("src/com/company/homeworkFive/task8/OUTPUT.txt", StandardCharsets.UTF_8);
        for (String line:
             linesOne) {
            if (linesTwo.contains(line)) {
                writer.println(line);
            }
        }
        writer.close();
    }
}
