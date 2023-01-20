package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class TypeConversion implements Assignment {
    public Object solution(Object object) {
        if (object.getClass() == Integer.class){
            return Integer.toString((int) object);
        } else if(object.getClass() == String.class ){
            return Integer.parseInt((String) object);
        } else if(object.getClass() == Character.class){
            return Character.toString((Character) object);
        }
        return null;
    }
}
