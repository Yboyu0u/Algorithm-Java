package Programmers.Level2;



// 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해순 순으로 건너려 한다
// 다리에는 트럭이 최대 bridge_length대 까지 올라 갈 수 있다
// 다리는 weight 이하까지의 무게를 견딜 수 있다

// 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 한다
// 마지막에 +1

//class Solution {
//    public int solution(int bridge_length, int weight, int[] truck_weights) {
//        int time=0;
//        int idx=0;
//        int wg = 0;
//        int truckCnt=1;
//        while(idx<truck_weights.length){
//            int truck = truck_weights[idx];
//            wg+=truck;
//            if(wg<weight && idx!=truck_weights.length-1){
//                idx++;
//                truckCnt++;
//                continue;
//            }
//            else if(wg>weight) {
//                truckCnt--;
//                idx--;
//            }
//
//            if(idx==truck_weights.length-1) {
//                time+=bridge_length+truckCnt;
//                idx++;
//            }
//            else {
//                time+=bridge_length+truckCnt-1;
//            }
//            idx++;
//            wg=0;
//            truckCnt=1;
//        }
//
//        int answer = time;
//        return answer;
//    }
//}
//
//public class Programmers_Level2_31 {
//    public static void main(String[] args){
//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
//
//        System.out.println(new Solution().solution(bridge_length,weight,truck_weights));
//    }
//}
