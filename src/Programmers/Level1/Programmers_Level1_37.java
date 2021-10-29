package Programmers.Level1;



// 물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 한다
// d: 부서별로 신청한 금액이 들어있는 배열
// budget: 예산

// 최대 몇개의 부서에 물품을 지원할 수 있는지 return


import java.util.Arrays;

public class Programmers_Level1_37 {
    private static class Solution {
        public int solution(int[] d, int budget){
            int answer=0;
            Arrays.sort(d);
            for(int i=0;i<d.length;i++){
                budget-=d[i];
                if(budget>0 && i==d.length-1)answer=i+1;
                if(budget<=0){
                    if(budget==0) answer=i+1;
                    else answer=i;
                    break;
                }
            }
            return answer;
        }
    }
    public static void main(String[] args){
        int[] d= {1,2,3,5,4};
        int budget=9;
        System.out.println(new Solution().solution(d,budget));
    }
}
