package Programmers.Level2;

// 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었다

public class Programmers_Level2_81 {
    private  static class Solution {
        private static int cnt;
        public int solution(int n) {

            for(int i=1; i<=n; i++){
                count(i,i,n);
            }

            return cnt;
        }

        public void count(int idx, int sum, int n) {
            if(sum>=n){
                if(sum==n) cnt++;
                return;
            }
            count(idx+1,sum+(idx+1),n);
        }
    }

}
