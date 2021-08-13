package BruteForce;

// 몸무게 x, 키 y
// x, y가 다른 사람보다 클 때, 덩치가 크다고 한다
// 자신보다 더 큰 덩치의 사람이 k명이면 그 사람의 덩치 등수는 k+1

import java.util.Scanner;

public class BOJ7568 {
    static int n;
    static int[][] people = new int[2][51];
    static int[] grades = new int[51];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=0; i<n; i++){
            people[0][i] = sc.nextInt();
            people[1][i] = sc.nextInt();
        }

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(people[0][i] < people[0][j] && people[1][i] < people[1][j]) grades[i]++;
                if(people[0][i] > people[0][j] && people[1][i] > people[1][j]) grades[j]++;
            }
        }

        for(int i=0; i<n; i++){
            System.out.print(grades[i]+1+" ");
        }
    }

}
