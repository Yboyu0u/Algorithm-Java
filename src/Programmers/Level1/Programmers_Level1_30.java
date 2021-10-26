package Programmers.Level1;



// 1~45까지의 숫자 중 6개를 찍어서 맞히는 복권
// 5등: 2개 번호 일치

// 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶다
// 알아볼 수 없는 번호: 0
// 순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정

// lottos: 민우가 구매한 로또 번호
// win_nums: 당첨 번호를 담은 배열
// 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아 return

class Solution {
    static int count; // 맞은 개수
    static int zeorCnt; // 0 개수
    public int[] solution(int[] lottos, int[] win_nums){
        // 최고: 0개수 + 맞은 번호 개수
        // 최저: 맞은 번호 개수
        for(int lotto: lottos){
            lotCheck(lotto, win_nums);
        }

        int[] answer = new int[2];
        answer[0] = 6-(zeorCnt+count)+1;
        if(zeorCnt==0 && count==0) answer[0]=6;
        answer[1] = 6-count+1;
        if(count==0) answer[1]=6;
        return answer;
    }
    public void lotCheck(int num, int[] win_nums){
        if(num==0){
            zeorCnt++;
            return;
        }
        for(int i=0; i<win_nums.length; i++){
            if(num==win_nums[i]){
                count++;
                return;
            }
        }
    }
}

public class Programmers_Level1_30 {
    public static void main(String[] args){

    }
}
