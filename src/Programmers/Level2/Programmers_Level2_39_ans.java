package Programmers.Level2;


// 각 마을에는 1부터 N까지의 번호가 각각 하나씩 부여되어 있다
// 각 마을은 양방향으로 통행할 수 있는 도로로 연결되어 있다

// N: 마을의 개수
// road: 각 마을을 연결하는 도로의 정보
    // a,b: 도로가 연결하는 두 마을의 번호
    // c: 도로를 지나는데 걸리는 시간
// k: 음식 배달이 가능한 시간

// 음식 주문을 받을 수 있는 마을의 개수를 return

// 플로이드-와샬 알고리즘


import java.util.LinkedList;
import java.util.Queue;

class Programmers_Level2_39 {
    private static class Solution {
        public int solution(int N, int[][] road, int K){
            int[][] map = new int[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; i++){
                    if(i==j){
                        map[i][j]=0;
                        continue;
                    }
                    map[i][j]=500001;
                }
            }

            for(int i=0; i< road.length;i++){
                if(map[road[i][0]-1][road[i][1]-1]<road[i][2]) continue;
                map[road[i][0]-1][road[i][1]-1]=road[i][2];
                map[road[i][1]-1][road[i][0]-1]=road[i][2];
            }

            for(int k=0; k<N; k++){ // 거쳐가는 정점
                for(int i=0; i<N; i++){ // 시작 정점
                    for(int j=0; j<N; j++){ // 도착 정점
                        if(i==j) continue;
                        if(map[i][j]> map[i][k]+map[k][j]) map[i][j] = map[i][k]+map[k][j];
                    }
                }
            }
            int count = 0;

            for (int i = 0; i < map[0].length; i++) {
                if (map[0][i] <= K)
                    count++;
            }

            return count;
        }
    }
    public static void main(String[] args){
        int N=6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int k=4;

        System.out.println(new Solution().solution(N,road,k));
    }
}
