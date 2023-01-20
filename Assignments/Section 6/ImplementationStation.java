package genspark.assignments.section6;

import genspark.assignments.Assignment;

public interface ImplementationStation extends Assignment {
    default String speak(){
        return "I came to probe the globe";
    }
}
