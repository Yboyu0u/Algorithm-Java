package BackTracking;

// 1부터 n까지 자연수 중에서 m개를 고른 수열
// 같은 수를 여러 번 골라도 된다
import java.io.*;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int n;
    static int m;
    static int[]arr = new int[8];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer sb = new StringTokenizer(s);
        n=Integer.parseInt(sb.nextToken());
        m=Integer.parseInt(sb.nextToken());
        tracking(0);
        bw.flush();
        bw.close();
    }

    static void tracking(int count) throws IOException {
        if(count == m){
            for(int i=0; i<m; i++){
                bw.write(arr[i]+" ");
            }
            bw.newLine();
        }else{
            for(int i=1; i<=n; i++){
                arr[count] = i;
                tracking(count+1);
            }
        }
    }
}
