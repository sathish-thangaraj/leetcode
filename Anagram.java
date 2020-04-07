package leetcode;

public class Anagram {

    public static void main(String[] args){
        String s = "anagram", t = "nagaram" ;
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];

        for(int i=0;i<s.length();i++){
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for(int i=0;i<counter.length;i++){
            if(counter[i]!=0)
                return false;
        }
        return true;
    }
}
