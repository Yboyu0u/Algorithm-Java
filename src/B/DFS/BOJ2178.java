package B.DFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로에서 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
// (1,1)에서 출발하여 (N,M)의 위치로 이동할 때
// 지나야 하는 최소의 칸 수를 구하는 프로그램
// 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
public class BOJ2178 {
    static int n,m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static int[][] arr = new int[110][110];
    static boolean[][] check = new boolean[110][110];
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static Queue<Coord> q = new LinkedList<>();
    static int space = 1;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        str = br.readLine();
        st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++){
            str = br.readLine();
            for(int j=1; j<=m; j++){
                if(str.charAt(j-1) == '0'){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1;
                }
            }
        }

        q.add(new Coord(1,1));
        check[1][1] = true;
        maze();
        System.out.println(space);

    }
    static void maze(){
        boolean ch = false;
        while(!q.isEmpty()){
            if(ch == true){
                break;
            }
            int cnt = 0;
            while(count>0){
                if(ch == true){
                    break;
                }
                int y = q.peek().y;
                int x = q.peek().x;
                q.remove();
                count--;

                for(int i=0; i<4; i++){
                    int qy = y+dy[i];
                    int qx = x+dx[i];

                    if(qx>0 && qy>0 && qx<=m && qy<=n &&check[qy][qx] == false && arr[qy][qx] == 1){
                        if(qy == n && qx == m){
                            ch=true;
                            break;
                        }
                        check[qy][qx] = true;
                        q.add(new Coord(qy,qx));
                        cnt++;
                    }
                }
            }
            space++;
            count=cnt;
        }
    }
}
