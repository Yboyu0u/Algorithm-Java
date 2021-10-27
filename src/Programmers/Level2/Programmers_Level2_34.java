package Programmers.Level2;


// 상대 팀 진영을 먼저 파괴하면 이기는 게임
// 상대 팀 진영에 최대한 빨리 도착해야 한다
// 5X5 크기의 맵 (0,0) 출발 -> (n-1,n-1) 까지 가야한다
// 동서남북으로 이동

// maps: 게임 맵의 상태
// 도착하기 위해 지나가야 하는 칸의 개수의 최솟값을 return
// 도착할 수 없을 때는 return -1
// 0: 벽  1: 길

import java.util.LinkedList;
import java.util.Queue;



public class Programmers_Level2_34 {
    private static class Coord{
        int y;
        int x;
        int cnt;

        public Coord(int y, int x,int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    private static class Solution {
        static int[][] mapps;
        static int[] dy = {-1,1,0,0};
        static int[] dx= {0,0,-1,1};
        static int ans=-1;
        public int solution(int[][] maps) {
            int answer = 0;
            mapps=maps;
            killEnemy();
            answer=ans;
            return answer;
        }
        public void killEnemy(){
            Queue<Coord> q= new LinkedList<>();
            boolean[][] check = new boolean[mapps.length][mapps[0].length];
            q.add(new Coord(0,0,1));
            check[0][0] = true;
            while(!q.isEmpty()){
                Coord coord = q.poll();
                int y = coord.y;
                int x = coord.x;

                for(int i=0; i<4; i++){
                    int ny = y+dy[i];
                    int nx = x+dx[i];

                    if(ny==mapps.length-1 && nx==mapps[0].length-1){
                        ans=coord.cnt+1;
                        return;
                    }
                    if(ny>=0 && ny<mapps.length && nx>=0 && nx<mapps[0].length){
                        if(check[ny][nx]==false && mapps[ny][nx]==1) {
                            check[ny][nx]=true;
                            q.add(new Coord(ny,nx, coord.cnt+1));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        System.out.println(new Solution().solution(maps));
    }
}
