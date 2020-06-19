/**
 * Created by rahulchakraborty on 8/6/16.
 */
import org.omg.CORBA.Object;

import java.util.*;

public class TreeSetDemo {

    public static void main(String args[]) {
        // Create a tree set
        TreeSet ts = new TreeSet(new Comparator() {
            @Override
            public int compare(java.lang.Object o1, java.lang.Object o2) {
                String first = (String)o1;
                String second = (String)o2;
                return second.compareTo(first);
            }
        });
        // Add elements to the tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

//Iterator
     Iterator it = ts.iterator();
        while(it.hasNext()){
            System.out.println("  "+it.next());
        }
        // Headset iterator

        System.out.println(ts);
    }
}
