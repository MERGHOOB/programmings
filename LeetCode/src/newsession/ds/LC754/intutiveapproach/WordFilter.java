package newsession.ds.LC754.intutiveapproach;

/**
 * Given many words, words[i] has weight i.
 * <p>
 * Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.
 * <p>
 * Examples:
 * <p>
 * Input:
 * WordFilter(["apple"])
 * WordFilter.f("a", "e") // returns 0
 * WordFilter.f("b", "") // returns -1
 * <p>
 * <p>
 * Note:
 * <p>
 * words has length in range [1, 15000].
 * For each test case, up to words.length queries WordFilter.f may be made.
 * words[i] has length in range [1, 10].
 * prefix, suffix have lengths in range [0, 10].
 * words[i] and prefix, suffix queries consist of lowercase letters only.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Solution:
 * Create a trie with suffix and also a trie with prefix.
 * <p>
 * Find all words with suffix from suffix trie
 * Find all words with prefix from prefix trie
 * <p>
 * get Intersection set of above words
 * <p>
 * return word with maximum weight from intersection
 */
public class WordFilter {

    private class TrieNode {
        TrieNode[] children;
        Set<Integer> weight;

        TrieNode() {
            children = new TrieNode[27];
            weight = new HashSet<>();
        }
    }

    TrieNode pTrie, sTrie;

    public WordFilter(String[] words) {
        pTrie = new TrieNode();
        sTrie = new TrieNode();
        for (int i = 0; i < words.length; i++) {

            char[] chars = words[i].toCharArray();

            TrieNode curr = pTrie;
            curr.weight.add(i);

            for (int j = 0; j < chars.length; j++) {
                if (curr.children[chars[j] - 'a'] == null) {
                    curr.children[chars[j] - 'a'] = new TrieNode();
                }
                curr = curr.children[chars[j] - 'a'];
                curr.weight.add(i); // i is the wigtht here as weight[words[i]] = i;

            }

            curr = sTrie;
            curr.weight.add(i);

            for (int j = chars.length - 1; j >= 0; j--) {
                if (curr.children[chars[j] - 'a'] == null) {
                    curr.children[chars[j] - 'a'] = new TrieNode();
                }
                curr = curr.children[chars[j] - 'a'];
                curr.weight.add(i); // i is the wigtht here as weight[words[i]] = i;
            }

        }

    }

    public int f(String prefix, String suffix) {

        TrieNode pCurr = pTrie;
        for(char ch: prefix.toCharArray()) {
            if(pCurr.children[ch-'a'] == null) return -1;
            pCurr = pCurr.children[ch-'a'];
        }

        TrieNode sCurr = sTrie;
        char [] chars = suffix.toCharArray();
        for(int i = chars.length-1; i>=0; i--) {
//            if(sCurr.children[chars[i] - 'a'] == null) return -1; // if prefix is present it means suffix must be there too.
            sCurr = sCurr.children[chars[i]-'a'];
        }

        int ans = -1;
        for(int wt: pCurr.weight) {
            if(wt > ans && sCurr.weight.contains(wt)) {
                ans = wt;
            }
        }

        return ans;
    }


}
