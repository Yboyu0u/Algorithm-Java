package Programmers.Level1;


// participant: 마라톤에 참여한 선수들의 이름이 담긴 배열
// completion: 완주한 선수들의 이름이 담긴 배열
    // 참가자 중에는 동명이인이 있을 수 있다
    // 단 한명만 완주하지 못했다
// 완주하지 못한 선수의 이름을 return

import java.util.HashMap;
import java.util.Iterator;

public class Programmers_Level1_49{
    private static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String,Integer> map = new HashMap<>();
            for(String p: participant) map.put(p,map.getOrDefault(p,1)+1);

            for(String c: completion){
                if(map.containsKey(c)){
                    if(map.get(c) == 1) {
                        map.remove(c);
                        continue;
                    }
                    map.put(c,map.get(c)-1);
                }
            }

            Iterator<String>it = map.keySet().iterator();
            if(it.hasNext()) answer = it.next();
            return answer;
        }
    }
}
