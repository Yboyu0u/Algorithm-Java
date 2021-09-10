package B.DFS;

// L: 육지 0, W: 바다 1
// 육지로만 상하좌우 이동가능
// 한 칸 이동하는데 한 시간 걸린다
// 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀 있다
// 같은 곳을 두 번이상 지나가거나, 멀리 돌아가서는 안 된다
// 보물 지도가 주어졌을 때, 보물이 묻혀 있는 두 곳 간의 최단 거리로 이동하는 시간을 구하는 프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {
    static int n,m;
    static int[][] map = new int[100][100];
    static boolean[][] check = new boolean[100][100];
    static int[][] land = new int[2][10000];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String str;
    static int cnt;
    static int dis;
    static int maxDis;
    static Queue<Coord> q = new LinkedList<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        str = br.readLine();
        st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            str = br.readLine();
            for(int j=0; j<m; j++){
                if(str.charAt(j) == 'W'){
                    map[i][j] = 1;
                }else{
                    map[i][j] = 0;
                    land[0][cnt] = i;
                    land[1][cnt] = j;
                    cnt++;
                }
            }
        }

        for(int i=0; i<cnt; i++){
            dis = 0;
            int y = land[0][i];
            int x = land[1][i];
            if(check[y][x] == false){
                check[y][x] = true;
                q.add(new Coord(y,x));
                treasure();
            }
            maxDis = Math.max(maxDis,dis);
            initCheck();
//            check[y][x] = true;
        }

        System.out.println(maxDis);
    }

    static void treasure(){
        int count = q.size();

        while(!q.isEmpty()){
            int cnt = 0;
            boolean lch = false;
            while(count>0){
                int y = q.peek().y;
                int x = q.peek().x;
                q.remove();
                count --;

                for(int i=0; i<4; i++){
                    int qy = y+dy[i];
                    int qx = x+dx[i];

                    if(qy>=0 && qy<n && qx>=0 && qx<m){
                        if(check[qy][qx] == false && map[qy][qx] == 0){
                            lch = true;
                            cnt++;
                            check[qy][qx] = true;
                            q.add(new Coord(qy,qx));
                        }
                    }

                }
            }
            if(lch == true){
                dis++;
            }
            count = cnt;
        }
    }

    static void initCheck(){
        for(int i=0; i<cnt; i++){
            int y = land[0][i];
            int x = land[1][i];
            check[y][x] = false;
        }
    }
}
