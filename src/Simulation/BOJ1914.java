package Simulation;

import java.io.*;
import java.math.BigInteger;

public class BOJ1914 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BigInteger count = new BigInteger("1");

    public static void main(String args[]) throws IOException {
        N = Integer.parseInt(br.readLine());

        ssum();
        System.out.println(count);

        if(N<=20){
            hanoi(N,1,2,3);
            bw.flush();
            bw.close();
        }
    }

    static void hanoi(int n, int start, int temp, int end) throws IOException {
        if(n==1){
            bw.write(start+" "+end);
            bw.write("\n");
        }else{
            hanoi(n-1,start,end,temp); // temp로 옮긴다
            hanoi(1,start,temp,end); // 마지막 제일 큰 것을 end로 옮긴다
            hanoi(n-1,temp,start,end); // temp에서 end로 옮긴다
        }
    }

    static void ssum(){
        BigInteger sum = new BigInteger("1");
        BigInteger n = new BigInteger("1");
        for(int i=1; i<N; i++){
            n = n.multiply(new BigInteger("2"));
            sum = sum.add(n);
        }
        count = sum;
    }
}
