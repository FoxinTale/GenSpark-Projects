package genspark.assignments.section4;

import genspark.assignments.Assignment;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class AnagramComputation implements Assignment {
    public boolean solution(String word1, String word2) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if( word1.equals(word2)){
            return false;
         } else {
            Character[] charArray1 = new Character[word1.length()];
            Character[] charArray2 = new Character[word2.length()];

            for(int i = 0; i < word1.length(); i++){
                charArray1[i] = word1.charAt(i);
            }

            for(int i = 0; i < word2.length(); i++){
                charArray2[i] = word2.charAt(i);
            }

            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            return Arrays.equals(charArray1, charArray2);
        }
    }
}
