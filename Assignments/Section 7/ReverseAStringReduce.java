package genspark.assignments.section7;

import genspark.assignments.Assignment;
import java.util.stream.Stream;

public class ReverseAStringReduce implements Assignment {
    public String solution(String word) {
         return Stream.of(word.split("")).reduce((c, d )-> d + c).orElse("");
    }
}
