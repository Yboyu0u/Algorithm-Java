package Programmers.Level2;


// 땅은 총 y:n, x:4
// 모든 칸에는 점수가 쓰여 있다
// 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 한다
    // * 한 행씩 내여올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있다

// 마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return

import java.util.Arrays;

public class Programmers_Level2_59_ans {
    private static class Solution {
        public int solution(int[][] land){
            for(int i=1; i<land.length; i++){
                land[i][0]+=Math.max(Math.max(land[i-1][1], land[i-1][2]),land[i-1][3]);
                land[i][1]+=Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
                land[i][2]+=Math.max(Math.max(land[i-1][0], land[i-1][1]),land[i-1][3]);
                land[i][3]+=Math.max(Math.max(land[i-1][1], land[i-1][0]), land[i-1][2]);
            }
            int[] answer = land[land.length-1];
            Arrays.sort(answer);

            return answer[answer.length-1];
        }
    }
}
