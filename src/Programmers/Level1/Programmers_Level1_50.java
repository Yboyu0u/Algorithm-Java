package Programmers.Level1;


// answers: 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열
// 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return
    // 가장 높은 점수를 받은 사람이 여럿일 경우, return 하는 값 오름차순으로

import java.util.ArrayList;

public class Programmers_Level1_50 {
    private static class Solution {
        static int[] one={1,2,3,4,5};
        static int[] two={2,1,2,3,2,4,2,5};
        static int[] three={3,3,1,1,2,2,4,4,5,5};
        static ArrayList<Integer> ans = new ArrayList<>();

        public int[] solution(int[] answers){
            checkLosers(answers);
            int[] answer = new int[ans.size()];
            int idx=0;
            for(int i: ans){
                answer[idx++]=i;
            }
            return answer;
        }

        public void checkLosers(int[] answers){
            int max=-1;
            for(int i=0; i<3; i++){
                int idx = 0;
                int loser=0;
                for(int j=0; j<answers.length; j++){
                    if(i==0){
                        if(one[idx++]==answers[j]) loser++;
                        if(idx>=one.length) idx=0;
                    }else if(i==1){
                        if(two[idx++]==answers[j]) loser++;
                        if(idx>=two.length) idx=0;
                    }else{
                        if(three[idx++]==answers[j]) loser++;
                        if(idx>=three.length) idx=0;
                    }
                }
                if(max<=loser){
                    if(max<loser){
                        max=loser;
                        ans.clear();
                    }
                    ans.add(i+1);
                }
            }
        }
    }
}
