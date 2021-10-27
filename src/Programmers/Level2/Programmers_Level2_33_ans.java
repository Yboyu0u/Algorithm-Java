package Programmers.Level2;


import java.util.Stack;

public class Programmers_Level2_33_ans {
    private static class Solution {
        public int solution(String s){
            Stack<Character> stk = new Stack<>();
            int answer = 0;

            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(stk.isEmpty()) stk.push(c);
                else{
                    if(stk.peek() == c)stk.pop();
                    else stk.push(c);
                }
            }
            if(stk.isEmpty()) answer=1;
            return answer;
        }
    }
    public static void main(String[] args){
        System.out.println(new Solution().solution("baabaa"));
    }
}
