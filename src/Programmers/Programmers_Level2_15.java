package Programmers;



// 메뉴를 새로 구성하려고 고민
// 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정
// 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했다
    // 단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성
    // 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조함에 대해서만 코스요리 메뉴 후보에 포함

// orders: 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열
// course: 스카피가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열

// 각 코스 개수에서 가장 많이 주문된 코스 뽑기
// 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    static int targetNum;
    static HashMap<String,Integer> map; // 모든 손님의 주문에 대해서 코스 개수 마다 코스가 주문이 얼마나 됐는지를 위한
    static int max;
    static PriorityQueue<String> priorityQueue = new PriorityQueue<>();
    public String[] solution(String[] orders, int[] course) {

        for(int num: course){
            targetNum = num;
            map = new HashMap<>();
            max = 0;

            // 1. 손님마다 가 주문들을 num으로 쪼개서 hashmap 에 주문 횟수를 넣는다
            for(String order: orders){
                selectMenuByNum(order,0,"");
            }

            // 2. 코스 개수마다 가장 많이 주문된 코스(들)을 queue 에 넣는다
            for(Map.Entry<String, Integer> entry: map.entrySet()){
                if(entry.getValue() == max && max>1){
//                    System.out.print(entry.getKey()+" ");
                    priorityQueue.offer(entry.getKey());
                }
            }
//            System.out.println();
        }

        // 3. queue 의 값들을 answer 에 옮긴다
        String[] answer = new String[priorityQueue.size()];
        int cnt = 0;
        while (!priorityQueue.isEmpty()){
            answer[cnt++] = priorityQueue.poll();
        }
        return answer;
    }

    public void selectMenuByNum(String order, int idx, String menu){
        if(menu.length() == targetNum){
            char[] mn = menu.toCharArray();
            Arrays.sort(mn);
            menu = String.copyValueOf(mn);

//            if(map.containsKey(menu)){
//                int value = map.get(menu);
//                map.put(menu,value+1);
//            }else{
//                map.put(menu,1);
//            }

            map.put(menu,map.getOrDefault(menu,0)+1);
            max = Math.max(max,map.get(menu));
            return;
        }
        for(int i=idx;i<order.length();i++){
            selectMenuByNum(order,i+1,menu+String.valueOf(order.charAt(i)));
        }
    }
}

public class Programmers_Level2_15 {
    public static void main(String[] args){
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};

       String[] result =  new Solution().solution(orders,course);

       for(String res: result){
           System.out.print(res+" ");
       }
    }
}
