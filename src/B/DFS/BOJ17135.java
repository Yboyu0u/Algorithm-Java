package B.DFS;

// 성을 향해 몰려오는 적을 잡는 턴 방식의 게임
// 각 칸에 포함된 적의 수는 최대 하나
// 격자판의 N번행의 바로 아래의 모든 칸에는 성이 있다
// 성을 지키기 위해 궁수 3명을 배치
// 궁수는 성이 있는 칸에 배치 가능
// 하나의 칸에는 최대 1명의 궁수
// 각각의 턴마다 궁수는 적 하나를 공격할 수 있다. 모든 궁수는 동시에 공격
// 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적
// 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격
// 같은 적이 여러 궁수에게 공격당할 수 있다
// 공격받은 적은 게임에서 제외
// 궁수의 공격이 끝나면, 적이 이동
// 적은 아래로 한 칸 이동, 성이 있는 칸으로 이동한 경우에는 게임에서 제외
// 모든 적이 격자판에서 제외되면 게임이 끝

// 격자판 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산
// 궁수의 공격으로 제거할 수 있는 적의 최대 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17135 {
    static int n, m, d;
    static int[][] field;
    static boolean[][][] visited;
    static int kill;
    static int subkill;
    static int enemies;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Coord implements Comparable<Coord> {
        int y;
        int x;
        int dis;
        int id;

        public Coord(int y, int x, int dis, int id) {
            this.y = y;
            this.x = x;
            this.dis = dis;
            this.id = id;
        }

        @Override
        public int compareTo(Coord c) {
            if(c.x < x){
                return 1;
            }else{
                return 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        field = new int[n + 1][m];
        visited = new boolean[n + 1][m][3];

        for (int i = 0; i < n; i++) {
            String[] string = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(string[j]);
                if (field[i][j] == 1) {
                    enemies++;
                }
            }
        }

        // n+1에 궁수 3명 배치 궁수=2
        for (int i = 0; i < m - 2; i++) {
            field[n][i] = 2;
            for (int j = i + 1; j < m - 1; j++) {
                field[n][j] = 2;
                for (int k = i + 2; k < m; k++) {
                    field[n][k] = 2;

                    game(i, j, k);

                    field[n][k] = 0;
                }
                field[n][j] = 0;
            }
            field[n][i] = 0;
        }

    }

    static void game(int a1, int a2, int a3) {
        Queue<Coord> q = new LinkedList<>();
        int my = n;
        q.add(new Coord(my, a1, 0, 0));
        q.add(new Coord(my, a2, 0, 1));
        q.add(new Coord(my, a3, 0, 2));


        int count = 3;
        while (!q.isEmpty()) {
            int cnt = 0;

            while (count > 0) {
                Coord c = q.poll();
                int y = c.y;
                int x = c.x;
                int dis = c.dis;
                int id = c.id;
                count--;

                if (dis == d) continue;

                ArrayList<Coord> whoKill = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    int nextY = y + dy[i];
                    int nextX = x + dx[i];

                    if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m) {
                        if (visited[nextY][nextX][id] == false) {
                            visited[nextY][nextX][id] = true;
                            if (field[nextY][nextX] == 1) {
                                //같은 거리에 있는 것이 많다면 다 모아서 가장 왼쪽에 있는 적을 죽이기 위해
                                whoKill.add(new Coord(nextY, nextX, dis + 1, id));
                            } else {
                                q.add(new Coord(nextY, nextX, dis + 1, id));
                                cnt++;
                            }
                        }
                    }
                }

                int candiSize = whoKill.size();
                if (candiSize > 0) {
                    Collections.sort(whoKill);
                    if(field[whoKill.get(0).y][whoKill.get(0).x] == 1){
                        subkill++;
                        field[whoKill.get(0).y][whoKill.get(0).x] = 0;
                    }
                }
            }
            count = cnt;

            if(q.isEmpty()){
                if(my>0){
                    q.add(new Coord(my-1, a1, 0, 0));
                    q.add(new Coord(my-1, a2, 0, 1));
                    q.add(new Coord(my-1, a3, 0, 2));
                }
            }
        }

    }
}
