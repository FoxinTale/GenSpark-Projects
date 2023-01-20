package genspark.assignments.section7;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FilterMap implements Assignment {
    public Object[] solution(ArrayList<ArrayList<Integer>> listolists) {
       return listolists.stream().filter(n->n.size()%2==1).map(n->n.stream().map(m->m*10).collect(Collectors.toList())).collect(Collectors.toList()).toArray();
    }
}
