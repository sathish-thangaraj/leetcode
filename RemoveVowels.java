package leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveVowels {

    public static void main(String[] args) {
        String s = "leetcodeisacommunityforcoders";
        System.out.println(removeVowels(s));
    }

    public static String removeVowels(String S) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (!vowels.contains(S.charAt(i))) {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
