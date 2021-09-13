package B.DFS;

// 말은 격자판에서 체스의 나이트와 같은 이동방식을 가진다
// 말은 장애물을 뛰어넘을 수 있다
// 원숭이는 능력 부족으로 총 k번만 위와 같이 움질일 수 있고, -> 상하좌우 + 위 아래 대각으로
// 그 외에는 그냥 인접한 칸으로만 움직일 수 있다. -> 상하좌우
// 0: 평지, 1: 장애물
// 원숭이가 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 방법을 알아내는 프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1600 {

    static class Move{
        int y;
        int x;
        int dis;
        int horseCnt;

        public Move(int y, int x, int dis, int horseCnt) {
            this.y = y;
            this.x = x;
            this.dis = dis;
            this.horseCnt = horseCnt;
        }
    }


    static int k,w,h; // w:x, h:y
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        w = Integer.parseInt(str[0]);
        h = Integer.parseInt(str[1]);

        arr = new int[h][w];
        visited = new boolean[h][w];

        for(int i=0; i<h; i++){
            str = br.readLine().split(" ");
            for(int j=0; j<w; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        monkey();

    }

    static void monkey(){
        Queue<Move> q = new LinkedList<>();
        q.add(new Move(0,0,0,0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Move p = q.poll();

            for(int i=0; i<4; i++){
                int qy = p.y+dy[i];
                int qx = p.x+dx[i];

                if(qy>=0 && qy<h && qx>=0 && qx<w){
                    // 원숭이의 움직임
                    if(visited[qy][qx] == false && arr[qy][qx] == 0){
                        visited[qy][qx] = true;

                        if(qy == h-1 && qx == w-1){
                            System.out.println(p.dis+1);
                            return;
                        }

                        q.add(new Move(qy,qx,p.dis+1,p.horseCnt));
                    }
                    //말의 움직임
                    if(p.horseCnt < k){
                        if(i==0 || i==1){ // 상 하
                            int qlx = qx-1;
                            int qrx = qx+1;
                            int qqy = qy-1;
                            if(i==1){
                                qqy = qy+1;
                            }
                            if(qqy>=0 && qqy<h){
                                if(qlx>=0 && qlx<w){
                                    if(visited[qqy][qlx] = false && arr[qqy][qlx] == 0){
                                        visited[qqy][qlx] = true;

                                        if(qqy == h-1 && qlx == w-1){
                                            System.out.println(p.dis+1);
                                            return;
                                        }

                                        q.add(new Move(qqy,qlx,p.dis+1,p.horseCnt+1));
                                    }
                                }
                                if(qrx>=0 && qrx<w){
                                    if(visited[qqy][qrx] == false && arr[qqy][qrx] == 0){
                                        visited[qqy][qrx] = true;

                                        if(qqy == h-1 && qrx == w-1){
                                            System.out.println(p.dis+1);
                                            return;
                                        }

                                        q.add(new Move(qqy,qrx,p.dis+1,p.horseCnt+1));
                                    }
                                }
                            }
                        }else{ // 좌 우
                            int qty = qy-1;
                            int qby = qy+1;
                            int qqx = qx-1;
                            if(i==3){
                                qqx = qx+1;
                            }
                            if(qqx>=0 && qqx<w){
                                if(qty>=0 && qty<h){
                                    if(visited[qty][qqx] = false && arr[qty][qqx] == 0){
                                        visited[qty][qqx] = true;

                                        if(qty == h-1 && qqx == w-1){
                                            System.out.println(p.dis+1);
                                            return;
                                        }

                                        q.add(new Move(qty,qqx,p.dis+1,p.horseCnt+1));
                                    }
                                }
                                if(qby>=0 && qby<h){
                                    if(visited[qby][qqx] = false && arr[qby][qqx] == 0){
                                        visited[qby][qqx] = true;

                                        if(qby == h-1 && qqx == w-1){
                                            System.out.println(p.dis+1);
                                            return;
                                        }

                                        q.add(new Move(qby,qqx,p.dis+1,p.horseCnt+1));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
