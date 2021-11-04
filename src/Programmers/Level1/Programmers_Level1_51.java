package Programmers.Level1;

public class Programmers_Level1_51 {
    private static class Solution {
        public int solution(int[] a, int[] b) {
            int answer = 0;
            int len = a.length;
            for(int i=0; i<len; i++) answer+=a[i]*b[i];
            return answer;
        }
    }
}
