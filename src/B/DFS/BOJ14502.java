package B.DFS;


// NXM 직사각형
// 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다
// 새로 세울 수 있는 벽의 개수는 3개, 꼭 3개를 세워야 한다
// 0: 빈 칸, 1: 벽, 2: 바이러스
// 연구소의 지도가 주어졌을 때
// 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int n,m;
    static int[][] arr =  new int[10][10];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static int zone;
    static int[][] blanks = new int[2][100];
    static Queue<Coord> q = new LinkedList<>();
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static int qSz;

    public static void main(String[] args) throws IOException {
        str = br.readLine();
        st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int c = 0;
        for(int i=0; i<n; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0){
                    blanks[0][c] = i;
                    blanks[1][c] = j;
                    c++;
                }else if(arr[i][j] == 2){
                    q.add(new Coord(i,j));
                    qSz++;
                }
            }
        }

        // idx가 0인 곳에 벽을 3개 세운다.
        // 그리고 돌려서 안전영역이 최대인 곳을 찾는다.
        for(int i=0; i<c-2; i++){
            arr[blanks[0][i]][blanks[1][i]] = 1;
            for(int j=i+1; j<c-1; j++){
                arr[blanks[0][j]][blanks[1][j]] = 1;
                for(int k=j+1; k<c; k++){
                    arr[blanks[0][k]][blanks[1][k]] = 1;

                    int[][] tArr = new int[10][10];
                    for(int g=0; g<n; g++){
                        for(int h=0; h<m; h++){
                            tArr[g][h] = arr[g][h];
                        }
                    }

                    Queue<Coord> qq = new LinkedList<>();
                    int qSzz = qSz;
                    while(qSz>0){
                        Coord qPeek = q.peek();
                        qq.add(qPeek);
                        q.remove();
                        q.add(qPeek);
                        qSz--;
                    }
                    qSz = qSzz;

                    virus();

                    int subZone = 0;
                    for(int o=0; o<n; o++){
                        for(int p=0; p<m; p++){
                            if(arr[o][p] == 0){
                                subZone++;
                            }
                        }
                    }
                    zone = Math.max(subZone,zone);

                    arr = tArr;
                    q = qq;

                    arr[blanks[0][k]][blanks[1][k]] = 0;
                }
                arr[blanks[0][j]][blanks[1][j]] = 0;
            }
            arr[blanks[0][i]][blanks[1][i]] = 0;
        }

        System.out.println(zone);
    }
    static void virus(){
        while(!q.isEmpty()){
            int y = q.peek().y;
            int x = q.peek().x;
            q.remove();

            for(int i=0; i<4; i++){
                int qy = y+dy[i];
                int qx = x+dx[i];

                if(qy>=0 && qy<n && qx>=0 && qx<m){
                    if(arr[qy][qx] == 0){
                        arr[qy][qx] = 2;
                        q.add(new Coord(qy,qx));
                    }
                }
            }
        }
    }
}
