package Programmers;


import java.util.HashSet;

// 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지


public class Programmers_Level2_23 {
    private static class Solution {
        static char[] numberss;
        static boolean[] check;
        static int ans;
        static HashSet<Integer> set = new HashSet<>();
        public int solution(String numbers) {
            numberss = numbers.toCharArray();
            check = new boolean[numberss.length];

            findPrime("");

            int answer = ans;
            return answer;
        }

        public void findPrime(String str){
            if(str != ""){
                int num = Integer.parseInt(str);
                if(!set.contains(num)){
                    if(checkPrime(num)){
                        ans++;
                    }
                    set.add(num);
                }
            }
            for(int i=0; i<numberss.length; i++){
                if(check[i] == false){
                    check[i] = true;
                    findPrime(str+String.valueOf(numberss[i]));
                    check[i] = false;
                }
            }
        }

        public boolean checkPrime(int num){
            if(num == 1 || num == 0){
                return false;
            }
            int n=2;
            while(n<num){
                if(num%n == 0){
                    return false;
                }
                n++;
            }
            return true;
        }
    }
    public static void main(String[] args){
        String numbers = "011";
        System.out.println(new Solution().solution(numbers));
    }
}
