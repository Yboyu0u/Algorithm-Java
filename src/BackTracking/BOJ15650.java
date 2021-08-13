package BackTracking;

// 1부터 n까지 중복 없이 m개를 고른 수열
// 고른 수열은 오름차순

import java.util.Scanner;

public class BOJ15650 {
    static int n,m;
    static int[]arr = new int[10];
    static boolean[]check = new boolean[10];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        tracking(0,0);
    }

    static void tracking(int num,int count){
        if(count == m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }else{
            for(int i=num+1; i<=n; i++){
                if(check[i] == false){
                    arr[count] = i;
                    check[i] = true;
                    tracking(i,count+1);
                    check[i] = false;
                }
            }
        }
    }
}
