package Programmers;


// n개의 음이 아닌 정수
// 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 한다
// 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return

class Solution {
    static int len;
    static int targetN;
    static int cnt;
    static int[] arr;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        len = numbers.length;
        targetN = target;
        arr = numbers;

        for(int i=0; i<numbers.length; i++){
            tracking(i+1,numbers[i],1);
            tracking(i+1,-numbers[i],1);
        }
        answer=cnt;
        return answer;
    }
    public void tracking(int idx, int sum, int count){
        if(count == len){
            if(sum == targetN){
                cnt++;
                return;
            }
        }else{
            for(int i=idx;i<arr.length; i++){
                tracking(i+1,sum+arr[i],count+1);
                tracking(i+1,sum-arr[i],count+1);
            }
        }
    }
}

public class Programmers_Level2_04 {

    public static void main(String[] args){
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(new Solution().solution(numbers,target));
    }
}
