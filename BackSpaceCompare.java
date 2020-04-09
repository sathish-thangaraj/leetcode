package leetcode;

import java.util.Stack;

public class BackSpaceCompare {

    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";
        System.out.println(backspaceCompare(S, T));
        System.out.println(removeBackSpacesUsingStack(S).equals(removeBackSpacesUsingStack(T)));
        System.out.println(removeBackSpacesUsingTwoPointer(S,T));
    }

    public static boolean backspaceCompare(String S, String T) {
        return removeBackSpaces(S).equals(removeBackSpaces(T));
    }

    public static String removeBackSpaces(String s) {
        StringBuilder sb = new StringBuilder();
        int numberOfBackspaces = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                numberOfBackspaces++;
            } else {
                if (numberOfBackspaces > 0) {
                    numberOfBackspaces--;
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // O(N+M) time complexity . N is length of first String , M is length of second string
    // O(M+N) space complexity
    public static String removeBackSpacesUsingStack(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#')
                stack.push(s.charAt(i));
            else if(!stack.isEmpty())
                stack.pop();
        }
        return String.valueOf(stack);
    }


    public static boolean removeBackSpacesUsingTwoPointer(String s , String t){

        int i = s.length()-1;
        int j = t.length()-1;
        int countSpacesInS = 0 ;
        int countSpacesInT = 0 ;
        while(i>=0 || j>=0){

            while(i>=0){
                if(s.charAt(i)=='#'){
                    i--;
                    countSpacesInS++;
                }
                else if(countSpacesInS>0){
                    i--;
                    countSpacesInS--;
                }
                else
                    break;
            }

            while(j>=0){
                if(t.charAt(j)=='#'){
                    j--;
                    countSpacesInT++;
                }
                else if(countSpacesInT>0){
                    j--;
                    countSpacesInT--;
                }
                else
                    break;
            }

            if(i>=0 && j>=0 && s.charAt(i)!=t.charAt(j))
                return false;
            i--;
            j--;
        }
        return true;
    }
}
