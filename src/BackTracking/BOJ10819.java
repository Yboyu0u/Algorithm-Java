package BackTracking;

// n개의 정수로 이루어진 배열A
// 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static boolean[] check = new boolean[10];
    static int[]arr = new int[10];
    static int[]ans = new int[10];
    static int max;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        tracking(0);
        System.out.println(max);

    }
    static void tracking(int count){
        if(count == n){
            int sum = 0;
            for(int i=0; i<n-1; i++){
                sum+=Math.abs(ans[i]-ans[i+1]);
            }
            max = Math.max(max,sum);
        }else{
            for(int i=0; i<n; i++){
                if(check[i] == false){
                    check[i] = true;
                    ans[count] = arr[i];
                    tracking(count+1);
                    check[i] = false;
                }
            }
        }
    }
}
