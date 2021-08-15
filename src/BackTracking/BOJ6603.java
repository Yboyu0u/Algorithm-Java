package BackTracking;

// 1~49에서 6개를 고른다
// 49가지 수 중 k개의 수를 골르 집합 s를 만든 다음 그 수만 가지고 번호를 선택
// 집합 s와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램

import java.io.*;
import java.util.StringTokenizer;

public class BOJ6603 {
    static int k;
    static int[] s = new int[13];
    static int[] ans = new int[6];
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            st=new StringTokenizer(str);
            k = Integer.parseInt(st.nextToken());

            if(k==0){
                break;
            }

            for(int i=0; i<k; i++){
                s[i] = Integer.parseInt(st.nextToken());
            }

            tracking(-1,0);

            bw.newLine();
            bw.flush();
        }
    }

    static void tracking(int idx, int count) throws IOException {
        if(count == 6){
            for(int i=0; i<6; i++){
                bw.write(ans[i] + " ");
            }
            bw.newLine();
        }else{
            for(int i=idx+1; i<k; i++){
                ans[count] = s[i];
                tracking(i,count+1);
            }
        }
    }
}
