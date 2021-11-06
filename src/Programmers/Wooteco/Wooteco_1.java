package Programmers.Wooteco;


// arr: 정수 1,2,3을 담고 있는 배열
// 이 배열에 원소를 추가해서 배열 안의 1,2,3의 개수가 모두 같아지도록 한려 한다.
    // * 추가하는 원소의 개소는 최소가 되어야 한다

// 추가해야 하는 각 원소의 개수를 1,2,3 순서대로 배열에 담에 return

import java.util.Arrays;



public class Wooteco_1 {
    private static class Solution {
        public int[] solution(int[] arr){
            int[] numCount = new int[3];
            int[] answer = new int[3];
            for(int i=0; i<arr.length; i++){
                if(arr[i]==1) {
                    answer[0]++;
                    numCount[0]++;
                }
                else if(arr[i]==2){
                    answer[1]++;
                    numCount[1]++;
                }
                else{
                    answer[2]++;
                    numCount[2]++;
                }
            }
            Arrays.sort(numCount);

            for(int i=0; i<answer.length; i++){
                answer[i] = numCount[numCount.length-1]-answer[i];
            }
            return answer;
        }
    }
    public static void main(String[] args){

    }
}
