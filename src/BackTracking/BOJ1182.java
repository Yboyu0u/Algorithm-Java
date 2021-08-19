package BackTracking;

// n개의 정수로 이루어진 수열이 있을 때,
// 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 s가 되는 경우의 수를 구하는 프로그램을 작성해라

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
    static int n;
    static long s;
    static int[] arr = new int[21];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String str;
    static int[] ans = new int[21];
    static int noc;
    public static void main(String[] args) throws IOException {
        str = br.readLine();
        st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        s = Long.parseLong(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tracking(0,0,0);
        System.out.println(noc);
    }
    static void tracking(int num, int count, int sum) {
        if (count>0 && sum == s) {
            noc++;
        }
        for(int i=num; i<n; i++){
            ans[count] = arr[i];
            tracking(i+1,count+1,sum+arr[i]);
        }
    }
}
