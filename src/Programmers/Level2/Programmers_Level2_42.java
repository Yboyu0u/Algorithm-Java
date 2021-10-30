package Programmers.Level2;



// brown: Leo가 본 카펫에서 갈색 격자의 수
// yellow: 노란색 격자의 수

// 카펫의 가로 세로 크기를 순서대로 배열에 담아 return

public class Programmers_Level2_42 {
    private static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            for(int i=1; i<=brown+yellow; i++){
                int row = i; // 세로
                int col = (brown+yellow)/row; //가로

                if(row>col) continue;

                if((row-2) * (col-2) == yellow){
                    answer[0]=col;
                    answer[1]=row;
                    return answer;
                }
            }
            return answer;
        }
    }
    public static void main(String[] args){

    }
}
