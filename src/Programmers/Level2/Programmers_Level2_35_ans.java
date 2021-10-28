package Programmers.Level2;


// N명이 참가 n-1<->n번의 참가자끼리 대결
// 게임은 최종 한 명이 남을 때까지 진행
// A번을 가진 참가는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지

// n: 게임 참가자 수
// a: 참가자 번호
// b: 경쟁자 번호
// 항상 이긴다고 가정


import java.util.LinkedList;


public class Programmers_Level2_35_ans{
    private static class Solution{
        public int solution(int n, int a, int b){
            int answer = 1;
            int left = 0;
            int right = 0;

            if(a>b){
                left=b;
                right=a;
            }else{
                left=a;
                right=b;
            }
            while(true){
                if(left%2!=0 && right-left==1){
                    break;
                }
                left = (left+1)/2;
                right = (right+1)/2;
                answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args){
        int n=8;
        int a=4;
        int b=7;
        System.out.println(new Solution().solution(n,a,b));

    }
}
