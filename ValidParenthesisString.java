package leetcode;

import java.util.Stack;

public class ValidParenthesisString {

    public static void main(String[] args){
        String input = "(*))" ;
        System.out.println(checkValidString(input));
    }

    public static boolean checkValidString(String s) {
        Stack<Integer> starStack = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(')
                stack.push(i);
            else if(c=='*')
                starStack.push(i);
            else{
                if(!stack.isEmpty())
                    stack.pop();
                else if(!starStack.isEmpty())
                    starStack.pop();
                else
                    return false;
            }
        }

        while(!starStack.isEmpty() && !stack.isEmpty()){
            if(stack.pop()>starStack.pop()){
                return false;
            }
        }

        return true;
    }
}
