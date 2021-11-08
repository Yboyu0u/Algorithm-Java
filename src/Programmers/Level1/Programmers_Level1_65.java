package Programmers.Level1;


// 2016년 1월 1일은 금요일 -> 2016년 a월 b일은 무슨 요일일까?
// 2월 29일 까지 있다.

// 1월 -> 31일  2월 -> 29일  3월 -> 31일  4월 -> 30일 5월 -> 31일  6월 -> 30일
// 7월 -> 31일  8월 -> 31일  9월 -> 30일  10월 -> 31일  11월 -> 30일  12월 -> 31일


public class Programmers_Level1_65{
    private static class Solution {
        public String solution(int a, int b) {
            String answer = "";
            int dOF = 4;
            for(int i=1; i<=a; i++){
                for(int j=1; j<=31; j++){
                    dOF++;
                    if(dOF>7) dOF=1;
                    if(i==a && j==b) break;
                    if(i==2 && j==29) break;
                    if((i==4 || i==6 || i==9 || i==11) && j==30) break;
                }
            }

            switch(dOF){
                case 1: answer="MON";
                    break;
                case 2: answer="TUE";
                    break;
                case 3: answer="WED";
                    break;
                case 4: answer="THU";
                    break;
                case 5: answer="FRI";
                    break;
                case 6: answer="SAT";
                    break;
                case 7: answer="SUN";
                    break;
            }

            return answer;
        }
    }
}
