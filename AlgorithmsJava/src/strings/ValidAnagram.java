package strings;

/**
 * Created by rahulchakraborty on 7/27/16.
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s==null || t==null)
            return false;

        if(s.length()!=t.length())
            return false;

        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for(int i: arr){
            if(i!=0)
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println("Is anagram "+isAnagram("sitar","itars"));

        int[] arr ={1,2,3};
        arr[0]++;
    }
}
