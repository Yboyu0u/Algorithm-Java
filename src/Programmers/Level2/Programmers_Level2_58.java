package Programmers.Level2;

// people: 사람들의 몸무게를 담은 배열
// limit: 구명보트의 무게 제한

// 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없다!!
// 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Programmers_Level2_58 {
    private static class Solution {
        static LinkedList<Integer> list = new LinkedList<>();
        static boolean[] check;
        public int solution(int[] people, int limit){
            int answer = 0;
            for(int p: people) list.add(p);
            check = new boolean[people.length];

            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });

            for(int j=0; j<list.size(); j++){
                if(check[j]==true) continue;
                int weight= list.get(j);

                if(weight<limit){
                    for(int i=list.size()-1; i>=1; i--){
                        if(check[i]==true) continue;
                        weight+=list.get(i);
                        if(weight>limit) break;
                        check[i]=true;
                        if(weight==limit) break;
                    }
                }
                check[j]=true;
                answer++;
            }

            return answer;
        }
    }
    public static void main(String[] args){
        int[] people={70,80,50};
        int limit = 100;
        System.out.println(new Solution().solution(people,limit));
    }
}
