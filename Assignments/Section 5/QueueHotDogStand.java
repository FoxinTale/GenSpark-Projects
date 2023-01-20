package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class QueueHotDogStand implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> list) {
        if(list.isEmpty()){
            return list;
        } else {
            Queue<Integer> q = new LinkedList<>();
            ArrayList<Integer> al = new ArrayList<>();

            q.addAll(list);

            q.add(q.remove());
            q.add(q.remove());
            q.add(q.remove());

            al.addAll(q);

            return al;
        }

    }
}
