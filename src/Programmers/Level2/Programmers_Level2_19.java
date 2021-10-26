package Programmers.Level2;


// 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 찾아라.

import java.util.Arrays;

public class Programmers_Level2_19 {
    private static class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            String[] result = new String[numbers.length];
            for(int i=0; i<numbers.length; i++){
                result[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(result,(a,b) -> (b+a).compareTo(a+b));

            if(result[0].equals("0")){
                answer = "0";
            }else{
                for(String a: result){
                    answer+=a;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args){
        System.out.println(new Solution().solution(new int[]{3, 30, 34, 5, 9}));

    }
}
