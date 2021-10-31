package Programmers.Level2;

public class Programmers_Level2_42_re {
    private static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int area = brown+yellow;

            for(int i=1; i<=area; i++){
                int row=i; //세로
                if(area%row!=0) continue;
                int col=area/row;//가로

                if(row<col) continue;

                if((row-2)*(col-2)==yellow){
                    answer[0]=row;
                    answer[1]=col;
                    break;
                }
            }
            return answer;
        }
    }
}
