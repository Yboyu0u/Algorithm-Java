package BruteForce;

// 일곱 난쟁이의 키의 합이 100
// 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2309 {
    static ArrayList<Integer> dwarfs = new ArrayList<>();
    static int sum;
    static int dwarf;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<9; i++){
            dwarf = sc.nextInt();
            dwarfs.add(dwarf);
            sum+=dwarf;
        }

        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(sum-(dwarfs.get(i)+dwarfs.get(j)) == 100){
                    dwarfs.remove(i);
                    dwarfs.remove(j-1);
                    dwarfs.stream().sorted().forEach(s-> System.out.println(s));
                    return;
                }
            }
        }
    }
}
