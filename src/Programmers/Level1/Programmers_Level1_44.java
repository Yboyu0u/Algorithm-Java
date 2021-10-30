package Programmers.Level1;


// 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우릐 개수를 구하라

public class Programmers_Level1_44 {
    private static class Solution {
        public int solution(int[] nums) {
            int answer = findPrime(nums);
            return answer;
        }

        public int findPrime(int[] nums){
            int ans=0;
            for(int i=0; i<nums.length-2; i++){
                for(int j=i+1; j<nums.length-1; j++){
                    for(int k=j+1; k<nums.length; k++){
                        if(checkPrime(nums[i]+nums[j]+nums[k])) ans++;
                    }
                }
            }
            return ans;
        }

        public boolean checkPrime(int num){
            for(int i=2; i<num; i++){
                if(num%i==0) return false;
            }
            return true;
        }
    }
}
