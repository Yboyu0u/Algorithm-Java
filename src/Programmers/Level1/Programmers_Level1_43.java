package Programmers.Level1;


// absolutes: 정수들의 절딧값을 차례대로 담은 정수 배열
// signs: 정수들의 부호를 차례대로 담은 불리언 배열

// signs[i]가 참이면 absolutes[i]의 실제 정수가 양수이고 그렇지 않으면 음
// 실제 정수들의 합을 구하여 return

public class Programmers_Level1_43 {
    private static class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;

            for(int i=0; i<absolutes.length; i++){
                int num = absolutes[i];
                if(!signs[i]) num*=-1;
                answer+=num;
            }
            return answer;
        }
    }
    public static void main(String[] args){

    }
}
