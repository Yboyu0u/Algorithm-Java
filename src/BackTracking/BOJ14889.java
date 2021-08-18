package BackTracking;

// 총 n명의 짝수인 사람
// n/2명으로 스타트와 링크 팀을 나눠야 한다
// i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij+sji
// 스타팀과 링크 팀의 능력치 차이를 최소로 해야 한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int n;
    static int arr[][] = new int[20][20];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int start[] = new int[20];
    static boolean[]check = new boolean[20];
    static long min;

    public static void main(String[] args) throws IOException {
            n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                String str = br.readLine();
                st = new StringTokenizer(str);
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    min+=arr[i][j];
                }
            }
            tracking(-1,0);
            System.out.println(min);
    }

    static void tracking(int num,int count){
        if(count == n/2){
            int sSum = 0,lSum=0;
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    if(check[i]==true && check[j]==true){
                        sSum+=arr[i][j]+arr[j][i];
                    }else if(check[i]==false && check[j]==false){
                        lSum+=arr[i][j]+arr[j][i];
                    }
                }
            }
            min = Math.min(min,Math.abs(sSum-lSum));
        }else{
            for(int i=num+1; i<n; i++) {
                if(check[i]==false){
                    check[i]=true;
                    start[count] = i;
                    tracking(i,count+1);
                    check[i]=false;
                }
            }
        }
    }
}
