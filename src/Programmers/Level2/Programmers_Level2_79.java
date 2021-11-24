package Programmers.Level2;

// 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환

    // 1. x의 모든 0을 제거
    // 2. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꾼다

// s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때,
// 이진 변환의 횟수와 변환 과정에서 제거된 0의 개수를 각각 배열에 담아 return



public class Programmers_Level2_79 {
    private static class Solution {
        static int zeroCnt;
        static StringBuilder mSb = new StringBuilder();

        public int[] solution(String s) {
            int[] answer = new int[2];
            int cnt = 0;

            while (s.length() > 1) {
                // 1. x의 모든 0을 제거 -> 길이 이진 변환
                s = Integer.toBinaryString(removeZero(s).length());
                cnt++;
            }

            answer[0] = cnt;
            answer[1] = zeroCnt;
            return answer;
        }


        public String removeZero(String s) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    sb.append(s.charAt(i));
                    continue;
                }
                zeroCnt++;
            }
            return sb.toString();
        }
    }
    public static void main(String[] args){
        new Solution().solution("01110");
    }
}
