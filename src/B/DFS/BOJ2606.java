package B.DFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 컴퓨터 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
// 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 컴퓨터의 수를 출려하는 프로그램
public class BOJ2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static int n; // 컴퓨터 수
    static int m; // 컴퓨터의 쌍의 수
    static int[][] arr = new int[101][101];
    static boolean[] check = new boolean[101];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[y][x] = 1;
            arr[x][y] = 1;
        }
        System.out.print(bfs());
    }

    static int bfs(){
        int count = 0;
        q.add(1);
        check[1] = true;
        while(!q.isEmpty()){
            int start = q.peek();
            q.remove();

            for(int i=1; i<=n; i++){
                if(check[i]==false && arr[start][i] == 1){
                    check[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
        return count;
    }
}




