package BruteForce;

import java.util.ArrayList;
import java.util.Scanner;

// 백준이의 퇴사
// 오늘부터 n+1일째 되는 날 퇴사를 하기 위해서,
// 완료 시간과 금액
// 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램

class Consult{
    int time;
    int pay;

    public Consult(int time, int pay) {
        this.time = time;
        this.pay = pay;
    }
}

public class BOJ14501 {
    static ArrayList<Consult> schedule = new ArrayList<>();
    static int sum;
    static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=0; i<n; i++){
            Consult c = new Consult(sc.nextInt(),sc.nextInt());
            schedule.add(c);
        }
        getMax(1,0);
        System.out.println(sum);
    }

    static void getMax(int day,int subSum){

    }
}
