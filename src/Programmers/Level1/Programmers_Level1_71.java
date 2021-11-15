package Programmers.Level1;

// n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return

public class Programmers_Level1_71 {
    private static class Solution {
        public int solution(int n) {
            int answer = 1;

            while(n%answer != 1) answer++;

            return answer;
        }
    }
}
