package Programmers.Level1;

// 바로 앞번호와 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있다.

// n: 전체 학생의 수
// lost: 체육복을 도난당한 학생들의 번호가 담긴 배여
// reserve: 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열


// 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있다
// 체육수업을 들을 수 있는 학생의 최댓값을 return


import java.util.Arrays;
public class Programmers_Level1_52 {
    private static class Solution {
        public int solution(int n, int[] lost, int[] reserve){
            boolean[] checkReverse = new boolean[reserve.length];
            Arrays.sort(lost);
            Arrays.sort(reserve);
            int save=0;


            for(int i=0; i<lost.length; i++){
                int lStd = lost[i];
                int borrowS=-1;
                for(int j=0; j<reserve.length; j++){
                    if(checkReverse[j]==true){
                        if(lStd==reserve[j]) break;
                        continue;
                    }
                    if(lStd==reserve[j]){
                        borrowS=j;
                        break;
                    }
                    if(borrowS==-1 && (lStd+1==reserve[j] || lStd-1==reserve[j])){
                        borrowS=j;
                        if(lStd+1==reserve[j]) break;
                    }
                }
                if(borrowS>-1) {
                    checkReverse[borrowS]=true;
                    save++;
                }
            }
            int answer = n-(lost.length-save);
            return answer;
        }
    }
}
