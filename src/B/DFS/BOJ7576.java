package B.DFS;

// 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는
// 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게된다.
// 인접한 곳은 왼, 오, 앞, 뒤 네방향에 있는 토마토를 의미
// 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다
// 며칠이 자나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라
//1: 익은 토먀토, 0: 익지 않은 토마토, -1: 토마토가 들어있지 않은 칸
// 저장될 때터 모든 토마토가 익부어있는 상태이면 0을 출력, 모두 익지 못하는 상황이면 -1출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//class Coord{
//    int y,x;
//
//    public Coord(int y, int x) {
//        this.y = y;
//        this.x = x;
//    }
//}

public class BOJ7576 {
    static int n,m; // m: x, n: y
    static int[][] field = new int[1001][1001];
    static boolean[][] check = new boolean[1001][1001];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static Queue<Coord> q = new LinkedList<>();
    static int[]dy = {1,-1,0,0};
    static int[]dx = {0,0,-1,1};
    static int date;
    static int count;

    public static void main(String[] args) throws IOException {
        str = br.readLine();
        st = new StringTokenizer(str);
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(int j=0; j<m; j++){
                int t =  Integer.parseInt(st.nextToken());
                field[i][j] =t;
                if(t == 1){
                    q.add(new Coord(i,j));
                    count++;
                }
            }
        }

        bfs();

        boolean check = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               if(field[i][j] == 0){
                   check = true;
                   break;
               }
            }
        }

        if(check == true){
            System.out.println(-1);
        }else{
            System.out.println(date-1);
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            int cnt = 0;
            while(count>0){
                int y = q.peek().y;
                int x = q.peek().x;
                q.remove();
                count--;

                boolean ch = false;
                for(int i=0; i<4; i++){
                    int qy = y+dy[i];
                    int qx = x+dx[i];

                    if(qy>=0 && qy<n && qx>=0 && qx<m){
                        if(field[qy][qx] == 0 && check[qy][qx] == false){
                            ch = true;
                            check[qy][qx] = true;
                            field[qy][qx] = 1;
                            q.add(new Coord(qy,qx));
                            cnt++;
                        }
                    }
                }
            }
            date++;
            count = cnt;
        }
    }
}
