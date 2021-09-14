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
import java.util.StringTokenizer;

public class BOJ1600 {

    static class Move {
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


    static int k, w, h; // w:x, h:y
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] ddy = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] ddx = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        str = br.readLine();
        st = new StringTokenizer(str);
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        visited = new boolean[h][w][31];

        for (int i = 0; i < h; i++) {
            String[] string = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(string[j]);
            }
        }

//        visited[0][0][0] = true;
        monkey();
    }

    static void monkey() {
        Queue<Move> q = new LinkedList<>();
        q.add(new Move(0, 0, 0, k));

        while (!q.isEmpty()) {
            Move p = q.poll();
            int y = p.y;
            int x = p.x;
            int dis = p.dis;
            int horseCnt = p.horseCnt;

            if (x < 0 || x >= w || y < 0 || y >= h) continue;
            if(arr[y][x] == 1) continue;

            if (y == h - 1 && x == w - 1) {
                System.out.println(dis);
                return;
            }

            if (visited[y][x][horseCnt]) continue;
            visited[y][x][horseCnt] = true;

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                q.add(new Move(nextY, nextX, dis + 1, horseCnt));
            }

            if (horseCnt == 0) continue;

            for (int i = 0; i < 8; i++) {
                int nextY = y + ddy[i];
                int nextX = x + ddx[i];

                q.add(new Move(nextY, nextX, dis + 1, horseCnt - 1));
            }
        }
        System.out.println(-1);
    }
}
