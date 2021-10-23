package Programmers;

// 1. 조합을 만든다
// 2. 단품메뉴조합을 길이별로 분류하고, 해당 단품메뉴가 몇번 선택되었는지 체크
//    2-1. 그리고 단품메뉴를 List에 담는다
// 3. List를 돌면서 가장 많이 선택된 메뉴를 answer에 담는다
// 4. 오름차순으로 정렬해주고 answer를 return

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Programmers_Level2_15_another {
    static HashMap<String,Integer> map;
    static int m;
    private static class Solution{

        public String[] solution(String[] orders, int[] course) {
            PriorityQueue<String>pq = new PriorityQueue<>();
            for(int i=0; i<course.length; i++){
                map = new HashMap<>();
                m=0;
                for(int j=0; j<orders.length; j++){
                    find(0,"",course[i],0,orders[j]);
                }
                for(String s: map.keySet()){
                    if(map.get(s)==m && m>1){
                        pq.offer(s);
                    }
                }
            }
            String answer[] = new String[pq.size()];
            int k=0;
            while(!pq.isEmpty()){
                answer[k++]=pq.poll();
            }
            return answer;
        }
        static void find(int cnt,String str,int targetNum,int idx,String word){
            if(cnt == targetNum){
                char[] c = str.toCharArray();
                Arrays.sort(c);
                String temps ="";
                for(int i=0; i<c.length; i++){
                    temps+=c[i];
                }
                map.put(temps,map.getOrDefault(temps,0)+1);
                m = Math.max(m,map.get(temps));
                return;
            }
            for(int i=idx;i<word.length();i++){
                char now = word.charAt(i);
                find(cnt+1,str+now,targetNum,i+1,word);
            }
        }
    }


}
