package genspark.assignments.section5;

import genspark.assignments.Assignment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AnagramWithSets implements Assignment {
    public boolean solution(String word1, String word2) {
        if( word1.equals(word2)){
            return false;
        } else {
            Set<Character> charSet1 = new HashSet<>();
            Set<Character> charSet2 = new HashSet<>();
            char[] charArray1;
            char[] charArray2;

            charArray1 = word1.toCharArray();
            charArray2 = word2.toCharArray();

            for(int i = 0; i < charArray1.length; i++){
                charSet1.add(charArray1[i]);
            }

            for(int i = 0; i < charArray2.length; i++){
                charSet2.add(charArray2[i]);
            }

            return charSet1.containsAll(charSet2);
        }
    }
}
