package trie;

import java.util.HashMap;

/**
 * Created by rahulchakraborty on 7/24/16.
 */
public class TrieNode {

    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;

    public TrieNode() {}

    public TrieNode(char c){
        this.c = c;
    }
}
