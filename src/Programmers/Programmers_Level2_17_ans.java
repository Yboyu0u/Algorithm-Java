package Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution{


    // Set
    // 1. 객체를 중복해서 저장할 수 없다
    // 2. 저장 순서가 유지되지 않는다

    // Map
    // 1. 객체를 중복해서 저장할 수 없다
    // 2. 저장 순서가 유지되지 않는다
    // 3. key, value 키와 쌍으로 객체를 받는다.

    //trim
    // : 문자열의 제일 왼쪽 공백, 오른쪽 공백만 제거


    public int[] solution(String s){

        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]"," ").replaceAll("[}]"," ").trim().split(" , ");
        Arrays.sort(arr,(a,b)->{return a.length()-b.length();});

        int[] answer = new int[arr.length];
        int idx=0;

        for(String s1: arr){
            for(String s2: s1.split(",")){
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String s ="{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] ans = new Solution().solution(s);
        for(int a: ans){
            System.out.print(a+" ");
        }
    }
}


public class Programmers_Level2_17_ans {

}
