package Stack;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String S) {

        Stack<Character> st = new Stack<>();

        for(char c : S.toCharArray())
        {
            if(c == '(' || c == '[' || c == '{')
                st.push(c);

            else if(c == ')' || c == ']' || c == '}')
            {
                if(st.isEmpty())
                    return false;

                if(c == ')' && st.peek() != '(')
                    return false;

                if(c == ']' && st.peek() != '[')
                    return false;

                if(c == '}' && st.peek() != '{')
                    return false;

                st.pop();
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {

        String S = "{[()]}";

        if(isValid(S))
            System.out.println("Valid Parenthesis");
        else
            System.out.println("Invalid Parenthesis");
    }
}