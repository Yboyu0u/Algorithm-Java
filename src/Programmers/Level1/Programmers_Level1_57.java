package Programmers.Level1;

// 문자열 s는 한 개 이상의 단어로 구성되어 있다.
// 각 단어는 하나 이상의 공백문자로 구분되어 있다.
// 각 단어의 짝수번쩨 알파벳은 대문자로,
// 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴


public class Programmers_Level1_57{
    private static class Solution {
        public String solution(String s){
            char[] ss = s.toCharArray();
            int idx=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<ss.length; i++){
                if(ss[i]==' '){
                    idx=0;
                    sb.append(' ');
                    continue;
                }
                if(idx%2==0) sb.append(String.valueOf(ss[i]).toUpperCase());
                else sb.append(String.valueOf(ss[i]).toLowerCase());
                idx++;
            }

            return sb.toString();
        }
    }
}
