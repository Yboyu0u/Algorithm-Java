package B.DFS;

// NXM의 행렬
// 0: 이동할 수 있는 곳
// 1: 이동할 수 없는 벽
// (1,1)에서 (N,M)의 위치까지 최단 경로로 이동
// 최단경로: 맵에서 가장 적은 개수의 칸을 지나는 경로, 시작하는 칸과 끝나는 칸도 포함해서 센다
// 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧다진다면,
// 벽을 한 개 까지 부수고 이동하는 것도 가능

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    static int n,m;
    static int[][] arr = new int[1001][1001];
    static boolean[][] check = new boolean[1001][1001];
    static int[][] walls = new int[2][10000001];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static Queue<Coord> q = new LinkedList<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int path = -1;
    static int subPath=1;
    static boolean wallCheck;
    static int wallCnt;

    public static void main(String[] args) throws IOException {
        str = br.readLine();
        st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            str = br.readLine();
            for(int j=0; j<m; j++){
                int num = str.charAt(j);
                if(num == '0'){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1;
                    walls[0][wallCnt] = i;
                    walls[1][wallCnt] = j;
                    wallCnt++;
                }
            }
        }

        check[0][0] = true;
        q.add(new Coord(0,0));
        shortPath();

//        System.out.println(wallCnt);

        for(int i=0; i<wallCnt; i++){
            subPath = 1;
            initCheck();

            int wallY = walls[0][i];
            int wallX = walls[1][i];

            arr[wallY][wallX] = 0;

            check[0][0] = true;
            q.add(new Coord(0,0));
            shortPath();

            path = Math.max(path,subPath);

            arr[wallY][wallX] = 1;
        }

        System.out.println(path);
    }

    static void shortPath(){
        int count = 1;
        boolean ch = false;
        while(!q.isEmpty()){
            if(ch == true){
                break;
            }
            int cnt = 0;
            while(count>0){
                int y = q.peek().y;
                int x = q.peek().x;
                q.remove();
                count--;

                for(int i=0; i<4; i++){
                    int qy = y+dy[i];
                    int qx = x+dx[i];

                    if(qy == n-1 && qx == m-1){
                        ch = true;
                        break;
                    }

                    if(qy>=0 && qy<n && qx>=0 && qx<m){
                        if(check[qy][qx] == false && arr[qy][qx] == 0){
                            check[qy][qx] = true;
                            q.add(new Coord(qy,qx));
                            cnt++;
                        }
                    }
                }
            }
            count = cnt;
            subPath++;
        }
        if(ch == false){
            subPath = -1;
        }
    }
    static void initCheck(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                check[i][j] = false;
            }
        }
    }
}
