package genspark.assignments.section7;

import genspark.assignments.Assignment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class QueryTheFile implements Assignment {
    public ArrayList<String> solution() throws IOException {
        ArrayList<String> words = new ArrayList<>();
        File file = new File("C:\\Users\\Aubrey\\Documents\\GensparkCore\\src\\main\\resources\\filter_problem.text");
        words.addAll(Files.readAllLines(file.toPath()));

        return words.stream().filter(n -> !n.contains("2")).collect(Collectors.toCollection(ArrayList::new));
    }
}
