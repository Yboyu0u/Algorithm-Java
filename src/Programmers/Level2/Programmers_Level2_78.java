package Programmers.Level2;

// JadenCase: 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열


import java.util.Locale;


public class Programmers_Level2_78 {
    private static class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();

            boolean check=false;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)!=' '){
                    if(!check){
                        check=true;
                        sb.append(String.valueOf(s.charAt(i)).toUpperCase(Locale.ROOT));
                    }else sb.append(String.valueOf(s.charAt(i)).toLowerCase(Locale.ROOT));
                    continue;
                }

                if(s.charAt(i)==' ' && check) check=false;
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }
}
