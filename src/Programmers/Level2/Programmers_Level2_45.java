package Programmers.Level2;



// 1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기
    // 1. 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말한다
    // 2. 마지막 사람이 단어를 말한 후에는 다시 1번부터 시작
    // 3. 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 한다
    // 4. 이전에 등장했던 단어는 사용할 수 없다
    // 5. 한 글자인 단어는 인정되지 않는다

// n: 사람의 수
// words: 사람들이 순서대로 말한 단어
// 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구하라

import java.util.HashSet;
import java.util.Set;

public class Programmers_Level2_45 {
    private static class Solution {
        static Set<String> set = new HashSet<>();
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];
            int person=1;
            int cnt=1;
            char prev=words[0].charAt(words[0].length()-1);
            boolean check = false;
            for(int i=0; i< words.length; i++){
                String now = words[i];
                if(i>0) prev=words[i-1].charAt(words[i-1].length()-1);;

                if(i!=0 && (set.contains(now) || now.charAt(0) != prev)){
                    answer[0] = person;
                    answer[1] = cnt;
                    check=true;
                    break;
                }
                set.add(now);
                if(person==n){
                    person=1;
                    cnt++;
                }else person++;
            }
            if(!check){
                answer[0] = 0;
                answer[1] = 0;
            }
            return answer;
        }
    }
}
