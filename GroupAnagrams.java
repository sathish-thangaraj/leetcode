package leetcode;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output = groupAnagrams(strs);

        for (List<String> list : output) {
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] char_set = strs[i].toCharArray();
            Arrays.sort(char_set);
            String sorted = new String(char_set);
            if (anagramGroups.containsKey(sorted)) {
                List<String> existingValues = anagramGroups.get(sorted);
                existingValues.add(strs[i]);
                anagramGroups.put(sorted, existingValues);
            } else {
                List<String> newAnagram = new ArrayList();
                newAnagram.add(strs[i]);
                anagramGroups.put(sorted, newAnagram);
            }
        }
        return new ArrayList<>(anagramGroups.values());
    }
}
