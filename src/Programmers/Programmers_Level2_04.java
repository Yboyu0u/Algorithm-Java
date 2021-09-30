package Programmers;


// n개의 음이 아닌 정수
// 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 한다
// 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return

public class Programmers_Level2_04 {
    static int cnt;
    private static class Solution {
        public int solution(int[] numbers, int target) {
            int answer = 0;

            for(int i=0; i<numbers.length; i++){
                tracking(numbers,target,i+1,numbers[i],1);
                tracking(numbers,target,i+1,-numbers[i],1);
            }
            answer=cnt;
            return answer;
        }
        public void tracking(int[] numbers, int target,int idx, int sum, int count){
            if(count == numbers.length){
                if(sum == target){
                    cnt++;
                    return;
                }
            }else{
                for(int i=idx;i<numbers.length; i++){
                    tracking(numbers,target,i+1,sum+numbers[i],count+1);
                    tracking(numbers,target,i+1,sum-numbers[i],count+1);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(new Solution().solution(numbers,target));
    }
}
