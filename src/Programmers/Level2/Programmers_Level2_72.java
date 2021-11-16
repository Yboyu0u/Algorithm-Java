package Programmers.Level2;


// 일정 피로도를 사용해서 던전을 탐험
    // 최소 필요 피로도: 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
    // 소모 피로도: 던전을 탐험한 후 소모되는 피로드

// K: 유저의 현재 피로도
// dungeons: 각 던전별 "최소 피로도", "소모 피로도"가 담긴 2차원 배열
// 유저가 탐험할수 있는 최대 던전 수를 return


class Solution {
    static boolean check[];
    static int cnt;
    public int solution(int k, int[][] dungeons){
        check = new boolean[dungeons.length];
        // 1. 던전 수 조합
        findDun(k,dungeons,new int[dungeons.length],0);
        return cnt;
    }

    public void findDun(int k, int[][] dungeons, int[] idxArr, int idx){
        if(idx == dungeons.length){
            // 2. 조합된 던전 순서 대로 탐험할 수 있는 던전 수 counting
            countDun(idxArr,dungeons,k);
            return;
        }
        for(int i=0; i<dungeons.length; i++){
            if(!check[i]) {
                check[i]=true;
                idxArr[idx] = i;
                findDun(k,dungeons,idxArr,idx+1);
                check[i]=false;
            }
        }
    }

    public void countDun(int[] idxArr, int[][] dungeons, int k){
        int count=0;
        for(int i=0; i<idxArr.length; i++){
            int[] dungeon = dungeons[idxArr[i]];
            if(dungeon[0]>k) break;
            k-=dungeon[1];
            count++;
        }
        cnt=Math.max(count,cnt);
    }
}




public class Programmers_Level2_72 {
    public static void main(String[] args){
        int [][]arr = {{80,20},{50,40},{30,10}};
        new Solution().solution(80,arr);
    }
}
