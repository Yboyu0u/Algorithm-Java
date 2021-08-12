package BruteForce;
//n장의 카드 중에서 3장의 카드를 choose
//player가 고른 카드의 합은 m을 넘지 않으면서 m과 최대한 가깝게 만들어야 한다

import java.util.Scanner;

public class BOJ2798 {
    static int n;
    static int m;
    static int sum;
    static int[]arr = new int[101];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(arr[i]+arr[j]+arr[k] <= m)
                        sum = Math.max(arr[i]+arr[j]+arr[k],sum);
                }
            }
        }
        System.out.println(sum);
    }
}
