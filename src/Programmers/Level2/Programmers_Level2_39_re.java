package Programmers.Level2;


// 1부터 N까지의 번호가 각각 하나씩 부여된 마을들
// 1번 마을에 있는 음식점에서 각 마을로 음식 배달을 하려고 한다.
// N개의 마을 중에서 k 시간 이하로 배달이 가능한 마을에서만 주무을 받으려 한다

// N: 마을의 개수
// road: 도로의 정보
// K: 음식 배달이 가능한 시간

// 음식 주문을 받을 수 있는 마을의 개수를 return

public class Programmers_Level2_39_re{
    private static class Solution {
        static int[][] town;
        static int len;
        static int k;
        public int solution(int N, int[][] road, int K) {
            town = new int[N][N];
            len=N;
            k=K;

            for(int i=0; i< road.length; i++){
                int a = road[i][0];
                int b = road[i][1];
                int c = road[i][2];

                if(town[a-1][b-1]>0 && town[a-1][b-1]<c)  continue;
                town[a-1][b-1] = c;
                town[b-1][a-1] = c;
            }

            for(int i=0; i<len; i++){
                for(int j=0; j<len; j++){
                    if(i!=j && town[i][j]==0) town[i][j]=500001;
                }
            }

            checkDel();
            int answer = 1;
            for(int i=1; i<len; i++){
                System.out.println(i+1+" "+town[0][i]);
                if(town[0][i]>0 && town[0][i]<=k){
                    answer++;
                }
            }
            return answer;
        }
        public void checkDel(){
            for(int k=0; k<len; k++){
                for(int i=0; i<len; i++){
                    for(int j=0; j<len; j++){
                        if(i==j) continue;
                        if(town[i][j]>town[i][k]+town[k][j]) town[i][j]=town[i][k]+town[k][j];
                    }
                }
            }

        }
    }
}
