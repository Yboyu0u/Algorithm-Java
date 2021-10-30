package Programmers.Level2;


// 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장한다
// clothes: 스파이가 가진 의상들이 담긴 2차원 배열
// 같은 종류의 의상은 하나만
// 서로 다른 옷의 조합의 수를 return


import java.util.ArrayList;
import java.util.HashMap;

public class Programmers_Level2_40 {
    private static class Solution {
        static HashMap<String,Integer> map = new HashMap<>();
        static ArrayList<Integer> list = new ArrayList<>();
        static int cnt;
        public int solution(String[][] clothes) {

            for(int i=0; i< clothes.length; i++){
                String type = clothes[i][1];

                if(map.containsKey(type)){
                    map.put(type,map.get(type)+1);
                    continue;
                }
                map.put(type,1);
            }
            for(String s: map.keySet()){
                list.add(map.get(s));
            }
            sum(1,0);
            int answer =cnt-1;
            return answer;
        }
        public void sum(int summ, int idx){
            cnt+=summ;
            for(int i=idx;i<list.size();i++){
                sum(summ*list.get(i),i+1);
            }
        }
    }
    public static void main(String[] args){
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(new Solution().solution(clothes));
    }
}
