package Programmers;


// 모든 음식의 스코빌 지수를 k 이상으로 만들고 싶다
// 이를 위해서는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만든다
// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수*2)
// 모든 음식의 스코빌 지수가 k 이상이 될 떄까지 반목하여 섞는다
// scovile: 가진 음식의 스코빌 지수를 담은 배열
// k: 스코빌 지수
// 모든 음식의 스코빌 지수를 k 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return


import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int food: scoville){
            minHeap.add(food);
        }

        while(!minHeap.isEmpty() && minHeap.peek()<K){
            if(answer>=scoville.length-1){
                answer = -1;
                break;
            }
            int first = minHeap.poll();
            int second = minHeap.poll();
            minHeap.add(scov(first,second));
            answer++;
        }

        return answer;
    }
    public int scov(int a, int b) {
        return (a>b) ? b+(a*2) : a+(b*2);
    }
}

public class Programmers_Level2_10 {
    public static void main(String[] args){
        int[] scovile = {1,2,3,9,10,12};
        int k = 7;
        System.out.println(new Solution().solution(scovile,k));
    }
}
