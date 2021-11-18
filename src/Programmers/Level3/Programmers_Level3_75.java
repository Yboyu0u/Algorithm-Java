package Programmers.Level3;

// 자연수 n개로 이루어진 중복 집합 중에 다음 두 조건을 만족하는 집합을 최고의 집합이라고 한다
    // 1. 각 원소의 합이 S가 되는 수의 집합
    // 2. 위 조건을 만족하면서 각 원소의 곱이 최대가 되는 집합
// * 오름차순으로 정렬
// 최고의 집합이 존재하지 않는 경우에 크기가 1인 1차원 배열에 -1을 채워서 return

public class Programmers_Level3_75 {
    private static class Solution {
        public int[] solution(int n, int s){
            int[] answer = {};

            // s/n이 첫 번째 칸, 다음 은 s-(s/n) / (n-1)  ..... n
            if(n>s) answer = new int[]{-1};
            else{
                answer = new int[n];
                int idx=0;
                while(n>0){
                    answer[idx++] = s/n;
                    s-=s/n;
                    n--;
                }
            }
            return answer;
        }
    }
}
