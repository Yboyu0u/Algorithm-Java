package B.DFS;

// NXN 크기의 중간에 물고기 M마리와 아기 상어 1마리가 있다
// 한 칸에는 물고기가 최대 1마리 존재
// 처음 아기 상어의 크기 = 2
// 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동
// 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고,
// 나머지 칸은 모두 지갈 수 있다
// 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다
// 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다

// 아기 상어의 이동
 // 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청
 // 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다
 // 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다
   // 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야 하는 칸의 개수의 최솟값
   // 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면,
   // 가장 왼쪽에 있는 물고기를 먹는다 나
// 아기상어는 이동과 동시에 물고기를 먹고, 그 칸은 빈 칸이 된다
// 아기상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1증가
// 0: 빈 칸, 1~6: 칸에 있는 물고기의 크기, 9: 아기 상어의 위치
// 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static int n;
    static int[][] sea = new int[25][25];
    static Queue<Coord> q = new LinkedList<>();
    static int sharkSz = 2;
    static int fishCnt = 0;
    static int sec;
    static int subSec;
    static boolean eat = true;
    static int[] dy = {-1,0,0,1}; //상좌우하
    static int[] dx = {0,-1,1,0};
    static boolean[][] check = new boolean[25][25];
    static int count = 1;
    static int eatCnt;
    static boolean shut;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(int j=0; j<n; j++){
                sea[i][j] = Integer.parseInt(st.nextToken());
                if(sea[i][j] == 9){
                    check[i][j] = true;
                    sea[i][j] = 0;
                    q.add(new Coord(i,j));
                }else if(sea[i][j] > 0){
                    if(sea[i][j] == 1){
                        shut = true;
                    }
                    fishCnt ++;
                }
            }
        }
        if(fishCnt>0 && shut == true){
            eat();
        }
        System.out.println(sec);
    }

    static void eat(){
        while(!q.isEmpty()){
            eat = false;
            int cnt = 0;
            ArrayList<Coord> closest = new ArrayList<>();
            sec++;
            while(count>0){
                int y = q.peek().y;
                int x = q.peek().x;
                q.remove();
                count--;

                boolean subEat = false;
                for(int i=0; i<4; i++){
                    int qy = y+dy[i];
                    int qx = x+dx[i];
                    if(qy>=0 && qx>=0 && qy<n && qx<n){
                        if(check[qy][qx] == false && (sharkSz >= sea[qy][qx]  || sea[qy][qx] == 0)){
                            // 물고기를 잡아 먹을 수 있는 경우
                            if(sea[qy][qx] != 0 && sharkSz > sea[qy][qx]){
                                // closest에 넣는다
                                closest.add(new Coord(qy,qx));
                                subSec =sec;
                                subEat = true;
                            }else{
                                check[qy][qx] = true;
                                q.add(new Coord(qy,qx));
                                cnt++;
                            }
                        }
                    }
                }
                if(subEat == true){
                    eat = true;
                }else{
                    eat = false;
                }
            }
            int sz = closest.size();
            if(sz>0){
                Coord eFish =closest.get(0);
                for(int i=1; i<sz; i++){
                    if(closest.get(i).y < eFish.y){
                        eFish = closest.get(i);
                    }else if(closest.get(i).y == eFish.y){
                        if(closest.get(i).x < eFish.x){
                            eFish = closest.get(i);
                        }
                    }
                }
                //잡아먹어라
                sea[eFish.y][eFish.x] = 0;
                eatCnt++;
                fishCnt--;
                if(sharkSz == eatCnt){
                    sharkSz++;
                    eatCnt = 0;
                }
                // 1. q 초기화
                // 2. check 초기화
                // 3. count 초기화
                // 4. 먹을 게 있는 지 check
                q.clear();
                boolean momCall = true;
                for(int j=0; j<n; j++){
                    for(int k=0; k<n; k++){
                        if(sea[j][k] != 0 && sharkSz > sea[j][k]){
                            //근데 이것이 먹을 수 있는 것이 어야 한다
                            // 먹을 수 없는 것이면 fishcount에서 뺀다.
                            momCall = false;
                        }
                        check[j][k] = false;
                    }
                }
                if(momCall == true || fishCnt == 0){
                    return;
                }
                check[eFish.y][eFish.x] = true;
                q.add(new Coord(eFish.y,eFish.x));
                count = 1;
            }else{
                count = cnt;
            }
//            if(q.isEmpty()){
//                sec--;
//            }
        }
        if(eat == false){
            sec = subSec;
        }
    }
}
