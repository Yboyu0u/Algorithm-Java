package B.DFS;


// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성
// 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문,
// 더 이상 방문할 수 있는 점이 없는 경우 종료
// 정점 번호 1~N까지

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    static int n,m,v;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static int[][] arr = new int[1100][1100];
    static boolean[]check = new boolean[1100];
    static int[] ans = new int[1100];
    static Queue<Integer> q = new LinkedList();

    public static void main(String[] args) throws IOException {
        str = bf.readLine();
        st = new StringTokenizer(str);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;
        for(int i=0; i<m; i++){
            str = bf.readLine();
            st = new StringTokenizer(str);
            y= Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            arr[y][x] = 1;
            arr[x][y] = 1;
        }

        dfs(v);
        System.out.println();
        for(int i=1; i<=n; i++){
            check[i] = false;
        }
        bfs();
    }

    static void dfs(int start){
        check[start] = true;
        System.out.print(start+ " ");
        for(int i=1; i<=n; i++){
            if(check[i] == false && arr[start][i] == 1){
                dfs(i);
            }
        }
    }

    static void bfs(){
        check[v] = true;
        int count = 0;
        q.add(v);

        while(!q.isEmpty()){
            int start = q.peek();
            q.remove();
            ans[count] = start;
            count ++;

            for(int i=1; i<=n; i++){
                if(check[i] == false && arr[start][i] == 1){
                    check[i] = true;
                    q.add(i);
                }
            }
        }
        for(int i=0; i<count; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
