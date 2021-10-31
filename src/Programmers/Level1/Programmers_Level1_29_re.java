package Programmers.Level1;


// 총 세번의 기회
// 점수: 0점에서 10점
// 보너스: S, D, T 영역이 존재
// 옵션: *, #
    // * 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다
    // # 당첨 시 해당 점수는 마이너스 된다
    // *, #은 점수마다 둘 중 하나만 존재할 수 있고 존재하지 않을 수도 있다

import java.util.Stack;

public class Programmers_Level1_29_re {
    private static class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            Stack<Integer> stk = new Stack<>();
            for(int i=0; i<dartResult.length(); i++){
                char c = dartResult.charAt(i);

                if(Character.isDigit(c)){
                    if(i>0 && (dartResult.charAt(i)=='0' && Character.isDigit(dartResult.charAt(i-1)))){
                        stk.pop();
                        stk.push(10);
                    }else stk.push(Integer.parseInt(String.valueOf(c)));
                    continue;
                }

                if(c=='D' || c=='T'){
                    int n = stk.pop();
                    if(c=='D') n*=n;
                    else n=n*n*n;
                    stk.push(n);
                    continue;
                }

                if(c=='*' || c=='#'){
                    int n=stk.pop();
                    if(c=='*'){
                        n*=2;
                        if(!stk.isEmpty()){
                            int prevN = stk.pop();
                            prevN*=2;
                            stk.push(prevN);
                        }
                    }else n*=-1;
                    stk.push(n);
                }
            }
            return answer;
        }
    }
}
