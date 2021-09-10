package B.DFS;

// 지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어지는지를 조사
// 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정
// 지역넘버가 N보다 낮으면 물에 잠긴다
// 어떤 지역의 높이 정보가 주어졌을 때,
// 장마철에 물에 잠기자 않는 안전한 영역의 최대 개수를 계산하는 프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {
    static int n;
    static int[][] arr = new int[101][101];
    static boolean[][] check = new boolean[101][101];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String str;
    static Queue<Coord> q = new LinkedList<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int count;
    static int subCnt;
    static int rainH;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                rainH = Math.max(rainH,arr[i][j]);
            }
        }
        rainH--;

        while(rainH>=0){
            subCnt = 0;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(check[i][j] == false && arr[i][j] > rainH){
                        check[i][j] = true;
                        q.add(new Coord(i,j));
                        bfs();
                    }
                }
            }
            count = Math.max(subCnt,count);

            rainH--;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    check[i][j] = false;
                }
            }
        }
        System.out.println(count);
    }

    static void bfs(){
        while(!q.isEmpty()){
            int y = q.peek().y;
            int x = q.peek().x;
            q.remove();

            for(int i=0; i<4; i++){
                int qy = y+dy[i];
                int qx = x+dx[i];

                if(qy>=0 && qy<n && qx>=0 && qx<n){
                    if(arr[qy][qx] > rainH && check[qy][qx] == false){
                        check[qy][qx] = true;
                        q.add(new Coord(qy,qx));
                    }
                }
            }
        }
        subCnt ++;
    }
}
