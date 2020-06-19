package dynamicprogramming;

import java.util.*;

/**
 * Created by rahulchakraborty on 7/26/16.
 *
 *
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"], the solution is ["cats and dog", "cat sand dog"].
 */
public class WordHelper {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String>[] pos = new ArrayList[s.length()+1];
        pos[0]=new ArrayList<String>();

        for(int i=0; i<s.length(); i++){

            if(pos[i]!=null){
                for(int j=i+1; j<=s.length(); j++){

                    String sub = s.substring(i,j);
                    if(wordDict.contains(sub)){
                         if(pos[j]==null){
                            ArrayList<String> list = new ArrayList<String>();
                            list.add(sub);
                            pos[j]=list;
                        }else{
                            pos[j].add(sub);
                        }

                    }
                }
            }
        }

       /* if(pos[s.length()]==null){
            return new ArrayList<String>();
        }else{*/
            ArrayList<String> result = new ArrayList<String>();
            dfs(pos, result, "", s.length());
            return result;
//        }
    }

    public void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
        if(i==0){
            result.add(curr.trim());
            return;
        }

        for(String k: pos[i]){
            String combined = k + " "+ curr;
            dfs(pos, result, combined, i-k.length());
        }
    }

    public static void main(String args[]){
        WordHelper helper = new WordHelper();
        Set<String> s = new HashSet<>(5);
        s.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        helper.wordBreak("catsanddog",s).stream().forEach(e->System.out.println(e));

        HashMap<String, String> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        sb.append("the");
        sb.append("great");
        sb.replace(0,3,"rahul");
        sb.reverse();
        System.out.println(sb.toString());

    }
}
