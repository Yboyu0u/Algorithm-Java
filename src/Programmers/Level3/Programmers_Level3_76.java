package Programmers.Level3;


// 한번에 1칸, 또는 2칸을 뛸 수 있다

// n: 멀리뛰기에 사용될 칸의 수
// 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 return




public class Programmers_Level3_76 {
    private static class Solution {
        public long solution(int n) {

            if(n==1) return 1;
            if(n==2) return 2;

            int num=3;
            long a=1;
            long answer=2;

            while(num<=n){
                long subA=a;
                a=answer;
                answer=(answer+subA)%1234567;
                num++;
            }
            return answer;
        }
    }
    public static void main(String[] args){
        new Solution().solution(3);
    }
}
