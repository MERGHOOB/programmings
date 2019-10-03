package string.hashtable;

import java.util.*;
/*
https://leetcode.com/problems/group-anagrams/

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strings) {

        Map<String, List<String>> hashMap = new HashMap<>();

        for (String str : strings) {
            if (!hashMap.containsKey(getHashKey(str))) {
                hashMap.put(getHashKey(str), new ArrayList<>());

            }
            hashMap.get(getHashKey(str)).add(str);
        }

        List<List<String>> lists = new ArrayList<>();
        lists.addAll(hashMap.values());


        return lists;
    }

    private String getHashKey(String str) {

        int [] count = new int[26];
        char[] chars = str.toCharArray();
        for(char ch: chars) {
            count[ch-'a']++;
        }
        StringBuilder stringJoiner = new StringBuilder("");
        for(int num: count) {
            stringJoiner.append("#").append(num);
        }
        return stringJoiner.toString();
    }


    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

    private String getHashKey2(String str) {

        int key = 1;
        char[] chars = str.toCharArray();
        for(char ch: chars) {
            key *= prime[ch-'a'];
        }
        return String.valueOf(key);
    }
    public static void main(String[] args) {
//        String [] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        System.out.println(new GroupAnagrams().groupAnagrams(strings));

//        String[] arr = {"3","30","34","5","9"};
        String[] arr = {"30","9"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String first1, String second2) {
               return (first1+second2).compareTo(second2+first1);
            }
        });

        for(String str: arr) {
            System.out.println(str);
        }
    }
}
