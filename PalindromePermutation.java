package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PalindromePermutation {

    public static void main(String[] args){
        String input = "code";
        System.out.println(canPermutePalindrome(input));
        System.out.println(canPermutePalindromeOptimized(input));
    }

    public static boolean canPermutePalindrome(String s) {
        Map<Character,Integer> counter = new HashMap<>();

        for(int i=0;i<s.length();i++){
            counter.put(s.charAt(i),counter.getOrDefault(s.charAt(i),0)+1);
        }

        boolean isOdd = false;
        for(int i:counter.values()){
            if(i%2 !=0){
                if(isOdd)
                    return false;
                isOdd = true;
            }
        }
        return true;
    }

    public static boolean canPermutePalindromeOptimized(String s) {
        Set<Character> set = new HashSet<>();

        for(int i=0;i<s.length();i++){
            if(!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size()<=1;
    }
}
