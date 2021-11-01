package Programmers.Level2;

// n명이 참가하는 토너먼트 게임
// 1부터 n까지 -> 1부터 n/2까지 ....  최종 한 명이 남을 때까지 진행

// 처음 라운드에서 A번을 가진 참가자는 B번 참가자와 몇 번째 라운드에서 만나는지 return
    // A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정

public class Programmers_Level2_35_re {
    private static class Solution{
        public int solution(int n, int a, int b){
            int answer = 0;
            while(a!=b){
                if(a%2==1) a+=1;
                if(b%2==1) b+=1;
                answer++;
                if(a==b) break;
                a=a/2;
                b=b/2;
            }
            return answer;
        }
    }
}
