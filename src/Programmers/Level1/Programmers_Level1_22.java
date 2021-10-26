package Programmers.Level1;


public class Programmers_Level1_22 {
    private static class Solution {
        public int solution(int[] numbers){
            int answer = 0;
            boolean[] check = new boolean[10];


            for(int i=0; i<numbers.length; i++){
                if(!check[numbers[i]]){
                    check[numbers[i]] = true;
                }
            }

            for(int i=0; i<check.length; i++){
                if(check[i] == false){
                    answer+=i;
                }
            }
            return answer;
        }
    }
    public static void main(String[] args){

    }
}
