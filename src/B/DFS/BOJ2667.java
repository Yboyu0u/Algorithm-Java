package B.DFS;


// 1은 집이 있는 곳, 0은 집이 없는 곳
// 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙여야 한다
// 연결: 집이 좌우, 상하로 다른 집이 있는 경우
// 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램
//

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667 {
    static int n;
    static int[][] house = new int[2][10000];
    static int[][] field = new int[30][30];
    static boolean[][] check = new boolean[30][30];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Coord> q = new LinkedList<>();
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static int count;
    static int[] ans = new int[1000];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        int c =0;
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                if(str.charAt(j) == '0'){
                    field[i][j] = 0;
                }else{
                    field[i][j] = 1;
                    house[0][c] = i;
                    house[1][c] = j;
                    c++;
                }
            }
        }

        for(int j=0; j<c; j++){
            if(check[house[0][j]][house[1][j]] == false){
                check[house[0][j]][house[1][j]] = true;
                q.add(new Coord(house[0][j],house[1][j]));
                housing();
                count++;
            }
        }

        System.out.println(count);
        Arrays.sort(ans,0,count);
        for(int i=0; i<count; i++){
            System.out.println(ans[i]);
        }
    }

    static void housing() throws IOException {
        int cnt=0;
        while(!q.isEmpty()){
            int y = q.peek().y;
            int x = q.peek().x;
            q.remove();
            cnt++;

            for(int i=0; i<4; i++){
                int qy = y+dy[i];
                int qx = x+dx[i];

                if(qy>=0 && qx>=0 && qy<n && qx<n){
                    if(check[qy][qx] == false && field[qy][qx] == 1){
                        q.add(new Coord(qy,qx));
                        check[qy][qx] = true;
                    }
                }
            }
        }
        ans[count] = cnt;
    }
}
