package B.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2206Sol {

    static class Place{
        int y;
        int x;
        int dis; // 이동거리
        int drill; // 공사횟수

        public Place(int y, int x, int dis, int drill) {
            this.y = y;
            this.x = x;
            this.dis = dis;
            this.drill = drill;
        }
    }

    static int n,m,ans;
    static int[][] map, visit;

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new int[n][m];
        visit = new int[n][m];

        for(int i=0; i<n; i++){
            str = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str[j]);
                visit[i][j] = Integer.MAX_VALUE; //무한대로 초기화
            }
        }

        ans = Integer.MAX_VALUE;


        bfs();

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
    static void bfs(){
        Queue<Place> q = new LinkedList<>();

        q.add(new Place(0,0,1,0));
        visit[0][0] = 0;

        while(!q.isEmpty()){
            Place p = q.poll();

            if(p.y == n-1 && p.x == m-1){
                ans = p.dis;
                break;
            }
            for(int i=0; i<4; i++){
                int qy = p.y + dy[i];
                int qx = p.x + dx[i];

                if(qy<0 || qx<0 || qy>=n || qx>=m) continue;

                if(visit[qy][qx] <= p.drill) continue;;

                if(map[qy][qx] == 0){
                    visit[qy][qx] = p.drill;
                    q.add(new Place(qy,qx,p.dis+1,p.drill));
                }else{ // 벽일 때
                    if(p.drill == 0){
                        visit[qy][qx] = p.drill+1;
                        q.add(new Place(qy,qx,p.dis+1,p.drill+1));
                    }
                }
            }
        }
    }
}
