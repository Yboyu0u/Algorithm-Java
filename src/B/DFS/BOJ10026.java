package B.DFS;
// 적록색약은 빨강과 초록의 차이를 거의 느끼지 못한다
// R,G,B
// 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다
// 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr = new int[1000][1000];
    static boolean[][] check = new boolean[1000][1000];
    static boolean[][] checkD = new boolean[1000][1000];
    static int cntN;
    static int cntRG;
    static Queue<Coord> q = new LinkedList<>();
    static Queue<Coord> qD = new LinkedList<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    //R: 0, G: 1, B: 2
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                if(str.charAt(j) == 'R'){
                    arr[i][j] = 0;
                }else if(str.charAt(j) == 'G'){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 2;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(check[i][j] == false){
                    check[i][j] = true;
                    q.add(new Coord(i,j));
                    normal(arr[i][j]);
                }
                if(checkD[i][j] == false){
                    checkD[i][j] = true;
                    qD.add(new Coord(i,j));
                    dis(arr[i][j]);
                }
            }
        }
        System.out.print(cntN+ " "+cntRG);
    }

    static void normal(int color){
        while(!q.isEmpty()){
            int y = q.peek().y;
            int x = q.peek().x;
            q.remove();

            for(int i=0; i<4; i++){
                int qy = y+dy[i];
                int qx = x+dx[i];

                if(qy>=0 && qy<n && qx>=0 && qx<n){
                    if(check[qy][qx] == false && arr[qy][qx] == color){
                        check[qy][qx] = true;
                        q.add(new Coord(qy,qx));
                    }
                }
            }
        }
        cntN++;
    }

    static void dis(int color){
        while(!qD.isEmpty()){
            int y = qD.peek().y;
            int x = qD.peek().x;
            qD.remove();

            for(int i=0; i<4; i++){
                int qy = y+dy[i];
                int qx = x+dx[i];

                if(qy>=0 && qy<n && qx>=0 && qx<n){
                    if(checkD[qy][qx] == false){
                        if(color == 2){
                            if(arr[qy][qx] == color){
                                qD.add(new Coord(qy,qx));
                            }
                        }else{ // 적록색약 적용
                            if(arr[qy][qx] == 0 || arr[qy][qx] == 1){
                                qD.add(new Coord(qy,qx));
                            }
                        }
                    }
                    checkD[qy][qx] = true;
                }
            }
        }
        cntRG++;
    }
}
