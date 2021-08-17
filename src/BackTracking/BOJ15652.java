package BackTracking;

// 1부터 n까지 자연수 중에서 m개를 고른 수열
// 같은 수를 여러 번 골라도 됨
// 비내림차순

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int n;
    static int m;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String str;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr = new int[8];
    static boolean[] check = new boolean[8];

    public static void main(String[] args) throws IOException {

        str = bf.readLine();
        st = new StringTokenizer(str);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tracking(0,0,0);
        bw.flush();
        bw.close();
    }

    static void tracking(int idx, int num, int count) throws IOException {
        if(count == m){
            for(int i=0; i<m; i++){
                bw.write(arr[i] + " ");
            }
            bw.newLine();
        }else{
            for(int i=num; i<n; i++){ //i=0부터 시작
                arr[idx] = i+1;
                tracking(idx+1,i,count+1);
            }
        }
    }
}
