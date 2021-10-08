package Programmers;



// 괄호가 개수는 맞지만 짝이 맞지 않은 형태로 작성되어 있다
// 소스 코드에 작성된 모든 괄호를 뽑아서 올바른 순서대로 배치된 괄호 문자열을 알려주는 프로그램을 개발
// '('와 ')'로만 이루어진 문자열이 있을 경우 '('의 개수와 ')'의 개수가 같다면
// 이를 균형잡힌 괄호 문자열이라고 한다
// 여기에 '('와 ')'의 괄호의 짝도 모두 맞을 경우에
// 이를 올바른 괄호 문자열이라고 하다

// 균형잡힌 괄호 문자열 p가 매개변수로 주어질 때, 변
// 주어진 알고리즘을 수행해 "올바른 괄호 문자열"로 변환한 결과를 return 하도록 solution 함수를 완성해라

// 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환
// 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리
//    단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있다
// 3. 문자열 u가 "올바른 괄호 문자열"이라면 문자열 v에 대해 1단계부터 다시 수행
//   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환
// 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행
//   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙인다
//   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙인다
//   4-3. ')'를 다시 붙인다.
//   4-4 u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙인다
//   4-5. 생성된 문자열을 반환

// p가 이미 "올바른 괄호 문자열"이라면 그대로 return


// p는 v라고 생각.
// 한마디로 v가 빈 문자열이나 올바른 문자열일 때까지 작업을 수행해야 한다
// 나온 u 저장하면서 answer에다가 조건에 맞게 계속 붙여준다.

public class Programmers_Level2_08 {
    static String ans="";
    private static class Solution {
        public String solution(String p){
            String answer = "";
            vCheck(p);

            answer = ans;
            return answer;
        }

        // v가 빈 문자열이나 올바른 문자열인지를 check하는 함수
        public void vCheck(String p){
            int correct = 0;
            int leftCnt = 0,rightCnt = 0;
            boolean uCheck = false;
            String u="";
            String v="";

            if (p.length() == 0){
                return;
            }

            for (int i = 0; i < p.length(); i++){
                char ch = p.charAt(i);
                if (ch == '(') {
                    correct++;
                    leftCnt++;
                }else {
                    if (correct!=0) {
                        correct--;
                    }
                    rightCnt++;
                }
                if(!uCheck){
                    u+=ch;
                }else{
                    v+=ch;
                }
                if(!uCheck && leftCnt!=0 && (leftCnt == rightCnt)){
                    uCheck = true;
                }
            }
            // 올바른 문자열이다.
            if(correct==0){
                ans+=p;
                return;
            }
            // u가 올바른 문자열인지 아닌지 check
            if(uCheck(u)){
                ans+=u;
                vCheck(v);
            }else{
                String tAns = ans;
                String reversedU="";
                if(u.length()>2){
                    for(int i=1; i<u.length()-1; i++){
                        if(u.charAt(i)=='('){
                            reversedU+=')';
                        }else{
                            reversedU+='(';
                        }
                    }
                }
                ans = "";
                vCheck(v);
                ans= tAns+'('+ans+')'+reversedU;
            }
            return;
        }

        public boolean uCheck(String u){
            int correct = 0;
            for (int i = 0; i < u.length(); i++){
                char ch = u.charAt(i);
                if (ch == '(') {
                    correct++;
                }else {
                    if (correct!=0) {
                        correct--;
                    }
                }
            }
            if(correct==0){
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args){
        String p = "))()((";
        System.out.println(new Solution().solution(p));
    }
}
