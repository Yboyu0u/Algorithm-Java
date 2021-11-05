package Programmers.Level2;


// 자연수 n이 주어졌을 때, n의 다음 큰 숫자를 구하라
    // 1. n의 다음 큰 숫자는 n보다 큰 자연수
    // 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같다
    // 3. n의 다음 큰 숫자는 조건 1,2를 만족하는 수 중 가장 작은 수이다.

public class Programmers_Level2_60 {
    private static class Solution{
        public int solution(int n) {
            int answer = 0;
            int count = countOne(n);
            int idx=1;

            while(idx<=1000000){
                if(countOne(n+idx)==count){
                    answer=n+idx;
                    break;
                }
                idx++;
            }
            return answer;
        }

        public int countOne(int n){
            int cnt=0;
            String num = Integer.toBinaryString(n);
            for(int i=0; i<num.length(); i++){
                if(num.charAt(i)=='1') cnt++;
            }
            return cnt;
        }
    }
    public static void main(String[] args){
        System.out.println(Integer.parseInt("12",3));
    }
}
