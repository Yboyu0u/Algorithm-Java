package Programmers.Level2;


// 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하라


public class Programmers_Level2_46_re {
    private static class Solution {
        public String solution(String number, int k) {
            StringBuilder sb = new StringBuilder();
            int idx=0;
            int max=Integer.MIN_VALUE;
            for(int i=0; i<number.length()-k; i++){
                max=Integer.MIN_VALUE;
                for(int j=idx; j<k+i; j++){
                    if(number.charAt(j)-'0'>max){
                        max=number.charAt(j)-'0';
                        idx=j+1;
                    }
                }
                sb.append(max);
            }
            return sb.toString();
        }
    }
    public static void main(String[] args){
        new Solution().solution("1231234",3);
    }
}
