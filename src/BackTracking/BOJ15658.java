package BackTracking;
// n개의 수로 이루어진 수열
// 연산자 +, -, X, %
// 연산자의 개수는 n-1보다 많을 수도 있다
// 모든 수의 사이에는 연산자를 한 개 끼워넣어야 하며, 고
// 주어진 연산자를 모두 사용하지 않고 모든 수의 사이에 연산자를 끼워넣을 수도 있
// n개의 수와 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15658 {
    static int n;
    static int[] arr = new int[12];
    static String[] op = new String[50];
    static boolean[] check = new boolean[50];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static long max = -1000000000;
    static long min = 1000000000;
    static int count;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        str = br.readLine();
        st = new StringTokenizer(str);
        count = 0;
        for(int i=0; i<4; i++){
            int a = Integer.parseInt(st.nextToken());
            if(i==0){
                for(int j=0; j<a; j++){
                    op[count] = "+";
                    count ++;
                }
            }else if(i==1){
                for(int j=0; j<a; j++){
                    op[count] = "-";
                    count ++;
                }
            }else if(i==2){
                for(int j=0; j<a; j++){
                    op[count] = "*";
                    count ++;
                }
            }else{
                for(int j=0; j<a; j++){
                    op[count] = "/";
                    count ++;
                }
            }
        }

        tracking(0,arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void tracking(int cnt, long sum){
        if(cnt == n-1){
            max = Math.max(sum,max);
            min = Math.min(sum,min);
        }else{
            for(int i=0; i<count; i++){
                String prev = "a";
                if(i!=0){
                    prev = op[i-1];
                }
                System.out.print(prev + " ");
                if(check[i] == false && !prev.equals(op[i])){
                    check[i] = true;
                    if(op[i].equals("+")){
                        tracking(cnt+1, sum+arr[cnt+1]);
                    }else if(op[i].equals("-")){
                        tracking(cnt+1, sum-arr[cnt+1]);
                    }else if(op[i].equals("*")){
                        tracking(cnt+1, sum*arr[cnt+1]);
                    }else{
                        tracking(cnt+1, sum/arr[cnt+1]);
                    }
                    check[i] = false;
                }
            }
        }
    }
}
