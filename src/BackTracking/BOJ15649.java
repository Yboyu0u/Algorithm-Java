package BackTracking;

// 1부터 n까지 자연수 중에서 중복 없이 m개를 고른 수열

import java.util.Scanner;

public class BOJ15649 {
    static int n,m;
    static int[] arr = new int[9];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=1; i<=n; i++){
            arr[0]=i;
            tracking(i,0);
        }
    }
    static void tracking(int num, int count){
        if(count == m-1){
            for(int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }else{
            for(int i=1; i<=n; i++){
                boolean ch = false;
                for(int j=0; j<count+1; j++){
                    if(i==arr[j]) {
                        ch = true;
                        break;
                    }
                }
                if(ch==false){
                    arr[count+1]=i;
                    tracking(i,count+1);
                }
            }
        }
    }
}
