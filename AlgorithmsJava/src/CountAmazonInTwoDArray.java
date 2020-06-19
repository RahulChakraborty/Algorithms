/**
 * Created by rahulchakraborty on 7/23/16.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class CountAmazonInTwoDArray {

    public static void main(String[] args) {
// TODO Auto-generated method stub

        char[][] arr =
                {{'B', 'B', 'A', 'B', 'B', 'N'},
                {'B', 'B', 'M', 'Z', 'B', 'O'},
                {'B', 'B', 'A', 'X', 'B', 'Z'},
                {'N', 'O', 'Z', 'M', 'B', 'A'},
                {'B', 'B', 'B', 'B', 'B', 'M'},
                {'X', 'B', 'B', 'B', 'B', 'A'}};

        HashMap<Character, Integer> hm = new HashMap<>();

        ArrayList<Character> arrayList = new ArrayList<>();
        String s = "AMAZON";
        for (char ch : s.toCharArray())
            arrayList.add(ch);

        int rows = arr.length;
        int colums = arr[0].length;
        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < colums; k++) {
                char ch = arr[j][k];
                if (arrayList.contains(ch)) {
                    if (hm.containsKey(ch)) {
                        hm.put(ch, hm.get(ch) + 1);
                    } else {
                        hm.put(ch, 1);
                    }
                }
            }
        }
        System.out.println(" Hashmap "+hm);

//what we are doing is trying to sort the list entry object by frequency of given charcter in 2 d array.
//limiting factor in creating string will be one with lowest number of charcters/
        List<Entry<Character, Integer>> list = new ArrayList<>(
                hm.entrySet());

        Collections.sort(list, new Comparator<Entry<Character, Integer>>() {

            @Override
            public int compare(Entry<Character, Integer> o1,
                               Entry<Character, Integer> o2) {
// TODO Auto-generated method stub
                return o1.getValue() - o2.getValue();
            }
        });
        System.out.println(" list "+list);

        Entry<Character, Integer> entry1 = list.get(0);
        if (entry1.getKey() == 'A') {
            if (entry1.getValue() % 2 != 0) {
                System.out.println(entry1.getValue() - 1);
            }

            else {
                System.out.println(entry1.getValue() / 2);

            }
        } else {
            System.out.println(entry1.getValue());
        }

    }
}


