package BackTracking;


// n개의 자연수와 자연수 m이 주어졌을 때,
// n개의 자연수 중에서 m개를 고른 수열을 뽑기

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663 {
    static int n,m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String str;
    static StringTokenizer st;
    static int[] arr;
    static int[] ans;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        str = br.readLine();
        st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = new int[m];
        check = new boolean[n];
        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,0,n);

        tracking(0,0);
        bw.flush();
        bw.close();
    }

    static void tracking(int idx, int cnt) throws IOException {
        if(cnt == m){
            for(int i=0; i<m; i++){
                bw.write(ans[i]+" ");
            }
            bw.newLine();
        }else{
            int prev = 0;
            for(int i=0; i<n; i++){ // 중복이 있다면 check를 하지 않는다.
                if(check[i] == false && arr[i] != prev){
                    check[i] = true;
                    ans[cnt] = arr[i];
                    prev = ans[cnt];
                    tracking(idx+1,cnt+1);
                    check[i] = false;
                }
            }
        }
    }
}
