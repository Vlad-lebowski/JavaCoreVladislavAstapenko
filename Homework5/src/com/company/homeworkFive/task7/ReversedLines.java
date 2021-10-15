package com.company.homeworkFive.task7;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReversedLines {
    public static void reverseLinesFromFileAndWriteThem() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/com/company/homeworkFive/task7/INPUT.txt"), StandardCharsets.UTF_8);
        Collections.reverse(lines);

        PrintWriter writer = new PrintWriter("src/com/company/homeworkFive/task7/OUTPUT.txt", StandardCharsets.UTF_8);
        for (String line:
                lines) {
            writer.println(line);
        }
        writer.close();
    }
}
