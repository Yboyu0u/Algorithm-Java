package Programmers.Level1;

// 놀이기구의 원래 이용료는 price 인데, 용
// 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였다.

// 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return

public class Programmers_Level1_56{
    private static class Solution {
        public long solution(int price, int money, int count) {
            long total=0;
            while(count>0){
                total+=price*count;
                count--;
            }
            long answer = -1;
            if(total-money<0) answer = 0;
            else answer = total-money;
            return answer;
        }
    }
}
