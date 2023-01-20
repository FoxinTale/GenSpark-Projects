package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.HashMap;

public class CreateAHuman implements Assignment {
    public HashMap<String, Object> solution(String name, Long age) {
        HashMap<String, Object> beings = new HashMap<>();

        beings.put("name", name);
        beings.put("age", age);
        return beings;
    }
}
