package BackTracking;

// n개의 수로 이뤄진 수열
// 수와 수 사이에 끼워넣을 수 있는 n-1개의 연산자가 주어진다
// + - x %
// n개의 수와 n-1개의 연산자가 주여졌을 떄, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14888 {
    static StringTokenizer st;
    static String str;
    static int n;
    static int p;
    static int[] nums = new int[11];
    static ArrayList<Character>opeators = new ArrayList<>();
    static boolean[] check = new boolean[11];
    static long min = 1000000000;
    static long max = -1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        str = bf.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        str = bf.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<4; i++) {
            if (i == 0) { //+
                p = Integer.parseInt(st.nextToken());
                for (int j = 0; j < p; j++) {
                    opeators.add('+');
                }
            } else if (i == 1) { //-
                p = Integer.parseInt(st.nextToken());
                for (int j = 0; j < p; j++) {
                    opeators.add('-');
                }

            } else if (i == 2) { //x
                p = Integer.parseInt(st.nextToken());
                for (int j = 0; j < p; j++) {
                    opeators.add('*');
                }
            } else {
                p = Integer.parseInt(st.nextToken());
                for (int j = 0; j < p; j++) {
                    opeators.add('/');
                }
            }
        }
        tracking(0,nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void tracking(int count,int sum){
        if(count==n-1){
            max = Math.max(sum,max);
            min = Math.min(sum,min);
        }else{
            for(int i=0;i<n-1;i++){
                if(check[i] == false){
                    check[i]=true;
                    if(opeators.get(i).equals('+')){
                        tracking(count+1,sum+nums[count+1]);
                    }else if (opeators.get(i).equals('-')){
                        tracking(count+1,sum-nums[count+1]);
                    }else if (opeators.get(i).equals('*')){
                        tracking(count+1,sum*nums[count+1]);
                    }else{
                        tracking(count+1,sum/nums[count+1]);
                    }
                    check[i]=false;
                }
            }
        }
    }
}
