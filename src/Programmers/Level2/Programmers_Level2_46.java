package Programmers.Level2;


// numbers 에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하라



public class Programmers_Level2_46 {
    private static class Solution {
        public String solution(String number, int k){
            StringBuilder sb = new StringBuilder();
            int index = 0;
            int max = 0;
            for(int i=0; i<number.length()-k; i++){
                max=0;
                for(int j=index; j<=k+i; j++){
                    if(max < number.charAt(j)-'0'){
                        max = number.charAt(j)-'0';
                        index=j+1;
                    }
                }
                sb.append(max);
            }
            return sb.toString();
        }
    }
    public static void main(String[] args){
        new Solution().solution("1924",2);
    }
}
