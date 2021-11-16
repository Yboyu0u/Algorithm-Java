package Programmers.Level3;


// 야근 피로도: 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값

// N시간 동안 야근 피로도를 최소화하도록 일할 예정

// N: 퇴근까지 남은 시간
// works: 각 일에 대한 작업량
    // 1시간 동안 작업량 1만큼을 처리할 수 있다

// 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works 에 대해 야근 피로도를 최소화한 값을 return
//
//class Solution {
//    static int[] sWorks;
//    static long ans = Long.MAX_VALUE;
//    public long solution(int n, int[] works) {
//        sWorks = works;
//        // works 에서 n 시간 만큼 뺀 조합 중 최소
//        findMinus(n,new int[works.length], 0, 0);
//
//        if(ans==Long.MAX_VALUE) ans=0;
//        return ans;
//    }
//
//    public void findMinus(int n, int[] minus, int cnt, int sum){
//        if(cnt==minus.length){
//            // minus 값들을 sWorks 의 값에서 뺀다
//            if(sum==n){
//                findMin(minus);
//            }
//            return;
//        }
//        for(int i=0; i<=n; i++){
//            if(i+sum<=n){
//                minus[cnt] = i;
//                findMinus(n, minus, cnt+1, sum+i);
//            }
//        }
//    }
//
//    public void findMin(int[] minus){
//        int tired = 0;
//        for(int i=0; i<minus.length; i++){
//            if(sWorks[i]-minus[i]<0) return;
//            tired+=Math.pow(sWorks[i]-minus[i],2);
//        }
//        ans = Math.min(tired,ans);
//    }
//}
//
//public class Programmers_Level3_74 {
//    public static void main(String[] args){
//        new Solution().solution(1, new int[]{2, 1, 2});
//    }
//}
