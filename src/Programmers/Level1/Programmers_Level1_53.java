package Programmers.Level1;

// 실패율을 구하는 코드를 완성하라.
    // 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수/ 스테이지에 도달한 플레이어 수

// N: 전제 스테이지의 개수
// stages: 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열

    // 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 한다
    // 스테이지에 도달한 유져가 없는 경우 해당 스테이지의 실패율은 0
// 실페율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨 있는 배열을 return
    // -> 실패율이 높은 순으로

import java.util.ArrayList;
import java.util.Collections;

public class Programmers_Level1_53 {
    private static class Stage implements Comparable<Stage>{
        int num;
        long total;
        long fail;

        public Stage(int num, long total, long fail){
            this.num = num;
            this.total = total;
            this.fail = fail;
        }

        @Override
        public int compareTo(Stage o){
            if((this.fail*o.total)-(this.total*o.fail)==0) return this.num-o.num;
            if((this.total*o.fail)-(this.fail*o.total)>0) return 1;
            return -1;
        }
    }

    private static class Solution {
        static ArrayList<Stage> list = new ArrayList<>();
        public int[] solution(int N, int[] stages){
            // 1. 스테이지 1부터 N까지 실패율을 구해서 list 에 넣는다.
            for(int i=1; i<=N; i++){
                int totalPlayers=0;
                int failPlayers=0;
                for(int j=0; j<stages.length; j++){
                    if(stages[j]>=i) {
                        totalPlayers++;
                        if(stages[j]==i) failPlayers++;
                    }
                }
                if(totalPlayers==0) totalPlayers=N;
                list.add(new Stage(i,totalPlayers,failPlayers));
            }
            Collections.sort(list);

            int[] answer = new int[list.size()];
            int idx=0;
            for(Stage s: list){
                answer[idx++]=s.num;
            }
            return answer;
        }
    }
}
