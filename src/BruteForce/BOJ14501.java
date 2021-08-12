package BruteForce;

// 백준이의 퇴사
// 오늘부터 n+1일째 되는 날 퇴사를 하기 위해서,
// 완료 시간과 금액
// 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static ArrayList<Consult> schedule = new ArrayList<>();
    static int sum;
    static int n;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=0; i<n; i++){
            Consult c = new Consult(sc.nextInt(),sc.nextInt());
            schedule.add(c);
        }
        getMax(0,0);
        System.out.println(sum);
    }

    static void getMax(int day,int subSum){
        if(day>=n){
            sum = Math.max(sum,subSum);
            return;
        }
        if(day+schedule.get(day).time<=n){
            getMax(day+schedule.get(day).time,subSum+schedule.get(day).pay);
        }
       //되는 거면 getMax()호출해야 함으로 !
       getMax(day+1,subSum);
    }
}
class Consult{
    int time;
    int pay;

    public Consult(int time, int pay) {
        this.time = time;
        this.pay = pay;
    }
}
