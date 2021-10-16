package Programmers;


// 참가자들에게 숫자들과 3가지 연산문자 (+,-,*)만으로 이루어진 연산 수식이 전달
// 참가자의 미션은 전달받은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의하여
    // 만들 수 있는 가장 큰 숫자를 제출하는 것
// 1. 같은 순위의 연산자는 없어야 한다
// 2. 계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환하여 제출
// 3. 같은 연산자끼리는 앞에 있는 것의 우선순위가 더 높다

// expression: +,-,*으로만 이루어진 연산식

// 연산식이 주어졌을 때, 우승 시 받을 수 있는 가장 큰 상금 금액을 return

import java.util.HashMap;
import java.util.LinkedList;

public class Programmers_Level2_16 {
    private static class Solution {
        static boolean[] check;
        static HashMap<String,Integer> map = new HashMap<>();
        static long max;
        static LinkedList<String> orgExp = new LinkedList<>();

        public long solution(String expression) {
            String opers = "";
            String num = "";

            // 1. ArrayList 에 숫자와 연산자 분류해서 넣어준다. 연산자는 map에 쓰인 횟수와 별도 저장
            for(int i=0; i<expression.length(); i++){
                char c = expression.charAt(i);
                if(c == '+' || c == '-' || c=='*'){ // 정규식으로 고쳐도 됨

                    if(!map.containsKey(String.valueOf(c))){
                        opers += String.valueOf(c);
                    }

                    map.put(String.valueOf(c),0);
                    orgExp.add(num);
                    orgExp.add(String.valueOf(c));
                    num="";
                }else{
                    num+=String.valueOf(c);
                }
            }
            orgExp.add(num);

            // 2. opers 에 들어간 연산자들을 backtracking 을 통해 우선순위를 부여.
            check = new boolean[opers.length()];
            priority(opers,"");

            long answer = max;
            return answer;
        }
        public void priority(String opers, String priorOper){
            if(priorOper.length() == opers.length()){
                // 3. 우선순위에 따라 ArrayList 를 돌면서 계산한다.
                calculByPrior(priorOper);
                return;
            }
            for(int i=0; i<opers.length(); i++){
                if(check[i]==false){
                    check[i] = true;
                    priority(opers,priorOper+String.valueOf(opers.charAt(i)));
                    check[i] = false;
                }
            }
        }
        public void calculByPrior(String priorOper){
            LinkedList<String> exp = new LinkedList<>();

            for(String str: orgExp){
                exp.add(str);
            }

            long num = 0;
            for(int i=0; i<priorOper.length(); i++){
                String oper = String.valueOf(priorOper.charAt(i));
                int idx = 0;
                while(idx<exp.size()){
                    if(exp.get(idx).equals(oper)){
                        if(oper.equals("+")){
                            num = Long.parseLong(exp.get(idx-1)) + Long.parseLong(exp.get(idx+1));
                        }else if(oper.equals("-")){
                            num = Long.parseLong(exp.get(idx-1)) - Long.parseLong(exp.get(idx+1));
                        }else{ // *
                            num = Long.parseLong(exp.get(idx-1)) * Long.parseLong(exp.get(idx+1));
                        }
                        exp.add(idx,String.valueOf(num));
                        exp.remove(idx+1);
                        exp.remove(idx+1);
                        exp.remove(idx-1);
                    }else{
                        idx++;
                    }
                }
            }
            max = Math.max(Math.abs(num),max);
        }
    }

    public static void main(String[] args){
        System.out.println(new Solution().solution("200-300-500-600*40+500+500"));
    }
}
