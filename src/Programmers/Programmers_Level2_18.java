package Programmers;


// 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인
// phone_book: 전화번호부에 적힌 전화번호를 담은 배열

// 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false 그렇지 않으면 true를 return

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Programmers_Level2_18 {
    private static class Solution {
        public boolean solution(String[] phone_book) {
            Set<String> set = new HashSet<>();
            boolean answer = true;

            Arrays.sort(phone_book,(a,b)->{return a.length()-b.length();});
            set.add(phone_book[0]);

            for(int i=1; i<phone_book.length; i++){
                String com = "";
                for(int j=0; j<phone_book[i].length(); j++){
                    com+=String.valueOf(phone_book[i].charAt(j));
                    if(set.contains(com)){
                        answer = false;
                        break;
                    }
                }
                if(!answer){
                    break;
                }
                set.add(phone_book[i]);
            }

            return answer;
        }
    }
    public static void main(String[] args){
        String[] pB = {"119", "97674223", "1195524421"};

        System.out.println(new Solution().solution(pB));
    }
}
