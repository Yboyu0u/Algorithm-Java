package Programmers.Level2;



// 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성
// 최소 2가지 이상의 단품메뉴로 구성,
// 또한 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함

// orders: 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열
// course: 스카피가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열

// 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return
    // 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Programmers_Level2_15_re {
    private static class Solution {
        static HashMap<String,Integer> map = new HashMap<>();
        static int max;
        static PriorityQueue<String> q = new PriorityQueue<>();
        public String[] solution(String[] orders, int[] course){
            for(int num: course){
                map = new HashMap<>();
                max=0;
                // 1. 만들 코스요리 개수 만큼 orders에서 조합하기
                for(String order: orders){
                    findCourseBynum(num,order,"",0);
                }
                // 2. 조합된 코스요리 중 주문횟수 2번이상이면서 최대인 것을 뽑아낸다
                // map에 담긴 거 priorityQueue에 넣는다.
                for(Map.Entry<String,Integer> entry: map.entrySet()){
                    if(entry.getValue()>=2 && entry.getValue()==max) q.add(entry.getKey());
                }
            }

            String[] answer = new String[q.size()];
            int idx=0;
            while(!q.isEmpty()){
                String s = q.poll();
                answer[idx++]=s;
            }
            return answer;
        }
        public void findCourseBynum(int n, String order, String mix, int idx){
            if(mix.length()==n){
                System.out.println(mix);
                char[] charMix = mix.toCharArray();
                Arrays.sort(charMix);
                mix = new String(charMix);
                if(map.containsKey(mix)) map.put(mix,map.get(mix)+1);
                else map.put(mix,1);
                max = Math.max(map.get(mix),max);
            }
            for(int i=idx; i<order.length(); i++){
                findCourseBynum(n,order,mix+String.valueOf(order.charAt(i)),i+1);
            }
        }
    }

}
