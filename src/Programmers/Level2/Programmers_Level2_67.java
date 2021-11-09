package Programmers.Level2;

// 괄호가 바르게 짝지어졌다는 것은 '('문자로 열렸으면 ')'문자로 닫혀야 한다는 뜻
import java.util.Stack;

public class Programmers_Level2_67 {
    private static class Solution{
        boolean solution(String s){
            boolean answer = true;
            Stack<Character> stk = new Stack<>();

            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);

                if(c=='(') stk.push(c);
                else if(c==')'){
                    if(stk.isEmpty()) return false;
                    if(!stk.isEmpty()) stk.pop();
                }
            }
            if(!stk.isEmpty()) answer=false;
            return answer;
        }
    }
}
