package B.DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1600Sol {
    static int k,w,h;
    static int[][] map;
    static boolean[][][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] hx = {-2,-2,2,2,1,-1,1,-1};
    static int[] hy = {1,-1,1,-1,2,2,-2,-2};

    static class Pair{
        int x;
        int y;
        int cnt;
        int k;

        public Pair(int x, int y, int cnt, int k) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.k = k;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();

        map = new int[h][w];
        visit = new boolean[h][w][31];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visit[0][0][0] = true;
        solution();

        sc.close();
    }
    private static void solution(){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,0,k));

        while(!q.isEmpty()){
            Pair cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int cnt = cur.cnt;
            int curK = cur.k;

            if(curX == w-1 && curY == h-1){
                System.out.println(cnt);
                return;
            }

            if(curX >= w || curY>= h || curX<0 || curY<0) continue;

            if(map[curY][curX] == 1) continue;

            if(visit[curY][curX][curK]) continue;
            visit[curY][curX][curK] = true;

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                q.add(new Pair(nextX, nextY, cnt+1, curK));
            }
            if(curK == 0) continue;
            for(int i=0; i<8; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                q.add(new Pair(nextX, nextY, cnt+1,curK-1));
            }
        }
        System.out.println(-1);
        return;
    }

}
