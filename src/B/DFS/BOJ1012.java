package B.DFS;

// 인접해 있다는 것은 상하좌우가 인접해 있는 것
// 0: 배추가 심어져 있지 않은 땅
// 1: 배추가 심어져 있는 땅

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coord{
    int y,x;

    public Coord(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ1012 {
    static int t;
    static int m,n,k;
    static String str;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] field;
    static boolean[][] check;
    static Queue<Coord> q = new LinkedList<>();
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static int count;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            field = new int[m][n];
            check = new boolean[m][n];
            count = 0;

            for(int j=0; j<k; j++){
                str = br.readLine();
                st= new StringTokenizer(str);
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                field[y][x] = 1;
            }

            for(int p=0; p<m; p++){
                for(int l=0; l<n; l++){
                    if(check[p][l] == false && field[p][l] == 1){
                        q.add(new Coord(p,l));
                        bfs();
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            int y = q.peek().y;
            int x = q.peek().x;
            check[y][x] = true;
            q.remove();

            for(int i=0; i<4; i++){
                int qy = y+dy[i];
                int qx = x+dx[i];

                if(qy>=0 && qy<m && qx>=0 && qx<n){
                    if(check[qy][qx] == false && field[qy][qx] == 1){
                        check[qy][qx] = true;
                        q.add(new Coord(qy,qx));
                    }
                }
            }
        }
        count++;
    }
}
