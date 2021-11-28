package Programmers.Level2;

// 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 return

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length] ;

        for(int i=0; i<arr1.length; i++){
            int idx=0;

            for(int j=0; j<arr1[i].length; j++){

                for(int k=0; k<arr2[0].length; k++){
                    answer[i][k]+=arr1[i][j]*arr2[idx][k];
                }
                idx++;
            }
        }

        return answer;
    }
}

public class Programmers_Level2_84 {
}
