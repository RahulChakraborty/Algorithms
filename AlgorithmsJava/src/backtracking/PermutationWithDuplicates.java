package backtracking;

import java.util.*;

/**
 * Created by rahulchakraborty on 6/25/16.
 */
public class PermutationWithDuplicates {

    public static void main(String... args){

        int[] num = {1,2,3};
        ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
        returnList.add(new ArrayList<Integer>());
        Set<ArrayList<Integer>> currentSet = null;

        for (int i = 0; i < num.length; i++) {
             currentSet = new HashSet<ArrayList<Integer>>();
            for (List<Integer> l : returnList) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, num[i]);
                    ArrayList<Integer> T = new ArrayList<Integer>(l);
                    l.remove(j);
                    currentSet.add(T);
                }
            }
            returnList = new ArrayList<ArrayList<Integer>>(currentSet);
        }

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream().map(s->s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);

        System.out.println(returnList);
    }
}
