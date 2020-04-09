package leetcode;

import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {

    public static void main(String[] args){

        String order = "hlabcdefgijkmnopqrstuvwxyz" ;
        String[] words = {"hello","leetcode"};

        System.out.println(isAlienSorted(words,order));
    }

        public static boolean isAlienSorted(String[] words, String order) {
            Map<Character,Integer> map = new HashMap<>();

            for(int i=0;i<order.length();i++){
                map.put(order.charAt(i),i);
            }

            for(int i=1;i<words.length;i++){
                if(!isLexicographicalOrder(words[i-1],words[i],map)){
                    return false;
                }
            }
            return true;
        }

        public static boolean isLexicographicalOrder(String first, String second, Map<Character,Integer> map){

            int length = Math.min(first.length(),second.length());
            for(int i=0;i<length;i++){
                if(map.get(first.charAt(i))>map.get(second.charAt(i)))
                    return false;
                else if(map.get(first.charAt(i))<map.get(second.charAt(i)))
                    return true;
            }

            if(length != first.length())
                return false;
            return true;
        }
    }
