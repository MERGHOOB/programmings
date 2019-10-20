package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_1233_Remove_SubFolders_from_the_Filesystem {
    private static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        String word = null;
    }


    List<String> rootFolders = new ArrayList<>();
    public List<String> removeSubfolders(String[] folders) {

        TrieNode root = new TrieNode();

        for(String folder: folders) {

            TrieNode curr = root;
            String []parts = folder.substring(1).split("/");
            for(String part: parts) {
                if(!curr.children.containsKey(part)) {
                    curr.children.put(part, new TrieNode());
                }
                curr = curr.children.get(part);
            }
            curr.word = folder; // once folder path completed store in the last node.
        }
        rootFolders.clear();
        getResults(root);
        return rootFolders;
    }

    private void getResults(TrieNode root) {
        for(Map.Entry<String, TrieNode> entry: root.children.entrySet() ) {
            if(entry.getValue().word != null) {
                rootFolders.add(entry.getValue().word);
            }
            else{
                getResults(entry.getValue());
            }
        }
    }


}
