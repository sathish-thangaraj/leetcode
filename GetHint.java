package leetcode;

import java.util.HashMap;

public class GetHint {

    public static void main(String[] args){
        String secret = "1123" ;
        String guess =  "0111" ;
        System.out.println(getHint(secret,guess));

    }

    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secretChars.length; i++) {
            if(secretChars[i] == guessChars[i])
                bulls++;
            else
                map.put(secretChars[i], map.getOrDefault(secretChars[i], 0) + 1);
        }

        for (int i = 0; i < guessChars.length; i++) {
            if (guessChars[i] != secretChars[i]) {
                if (map.containsKey(guessChars[i])) {
                    int j = map.get(guessChars[i]);
                    if (j > 0) {
                        cows++;
                        map.put(guessChars[i], j - 1);
                    }

                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}
