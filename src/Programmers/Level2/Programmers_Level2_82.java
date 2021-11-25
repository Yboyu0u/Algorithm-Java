package Programmers.Level2;


// str 에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 (최소값)(최대값) 형태의 문자열로 return

public class Programmers_Level2_82 {
    private static class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            String[] strings = s.split(" ");
            for(String str: strings){
                max=Integer.max(Integer.parseInt(str),max);
                min=Integer.min(Integer.parseInt(str),min);
            }

            sb.append(min +" "+max);
            return sb.toString();
        }
    }
}
