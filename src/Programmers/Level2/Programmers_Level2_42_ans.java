package Programmers.Level2;



// brown: Leo가 본 카펫에서 갈색 격자의 수
// yellow: 노란색 격자의 수

// 카펫의 가로 세로 크기를 순서대로 배열에 담아 return

public class Programmers_Level2_42_ans {
    private static class Solution {
        public int[] solution(int brown, int yellow) {
            int a = (brown+4)/2;
            int b = yellow+2*a-4;
            int[] answer = {(int)(a+Math.sqrt(a*a-4*b)), (int)(a-Math.sqrt(a*a-4*b)/2)};
            return answer;
        }
    }
}
