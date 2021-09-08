package B.DFS;

// 방향 없는 그래프가 주어졌을 때, 연결 요소의 개수를 구하는 프로그램을 작성하시오


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int n,m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static int[][] arr = new int[1001][1001];
    static boolean[] check = new boolean[1001];
    static Queue<Integer> q = new LinkedList<>();
    static int count;

    public static void main(String[] args) throws IOException {
        str = br.readLine();
        st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[y][x] = 1;
            arr[x][y] = 1;
        }


        for(int i=1; i<=n; i++){
            if(check[i] == false){
                check[i] = true;
                q.add(i);
                bfs();
                count ++;
            }
        }

        System.out.println(count);

    }
    static void bfs(){
        while(!q.isEmpty()){
            int qs = q.peek();
            q.remove();
            for(int i=1; i<=n; i++){
                if(arr[qs][i] == 1 && check[i] == false){
                    check[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
