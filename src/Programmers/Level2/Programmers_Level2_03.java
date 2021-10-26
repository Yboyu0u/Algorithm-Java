package Programmers.Level2;


// 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현
    // 1. 124 나라에서는 자연수만 존재
    // 2. 124 나라에는 모든 수를 표현할 때 1,2,4만 사용
// 자연수 n이 매개변수로 주어졌을 때, n을 124나라에서 사용하는 숫자로 바꾼 값을 return

public class Programmers_Level2_03 {
    private static class Solution {
        public String solution(int n) {
            String answer = "";
            while(n>0){
                int p = n%3;
                n = n/3;
                if(p==0) { //0이면
                    p = 4;
                    n--;
                }
                answer= p + answer;
            }
            return answer;
        }
    }

    public static void main(String[] args){
        int n = 10;
        System.out.println(new Solution().solution(10));
    }
}
