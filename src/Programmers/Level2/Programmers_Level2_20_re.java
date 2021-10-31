package Programmers.Level2;


// 빛이 "S"가 써진 칸에 도달한 경우, 직진
// 빛이 "L"이 써진 칸에 도달한 경우, 좌회전
// 빛이 "R"이 써진 칸에 도달한 경우, 우회전
// 빛이 격자의 끝을 넘어갈 경우, 반대쪽 끝으로 다시 돌아온다.

// 격자 내에서 빛이 이동할 수 있는 경로 사이클이 몇개이고 사이클의 길어가 얼마인지 찾아라
// 사이클의 모든 길이들을 배열에 담아 오름차순으로 정렬하여 return

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_Level2_20_re {
    private static class Solution {
        static ArrayList<Integer> ans = new ArrayList<>();
        static boolean[][][] check;
        static int yLen;
        static int xLen;
        static String[] newGrid;

        public int[] solution(String[] grid){
            newGrid=grid;
            yLen =grid.length;
            xLen =grid[0].length();
            check = new boolean[yLen][xLen][4];

            for(int i=0; i<yLen; i++){
                for(int j=0; j<xLen; j++){
                    for(int k=0; k<4; k++){
                        if(!check[i][j][k]){
                            findCycle(i,j,k,0);
                        }
                    }
                }
            }
            int[] answer = new int[ans.size()];
            int idx=0;
            for(int i: ans) answer[idx++]=i;
            Arrays.sort(answer);
            return answer;
        }

        public void findCycle(int y, int x, int dir, int cnt){
            check[y][x][dir]=true;
            int newY=y;
            int newX=x;
            int newDir=dir;
            int newCnt =cnt+1;
            if(newGrid[y].charAt(x)=='S'){
                if(dir==0) newY=y+1;
                else if(dir==1) newY=y-1;
                else if(dir==2) newX=x+1;
                else newX=x-1;

            }else if(newGrid[y].charAt(x)=='L'){
                if(dir==0){
                    newX=x+1;
                    newDir=2;
                }else if(dir==1){
                    newX=x-1;
                    newDir=3;
                }else if(dir==2){
                    newY=y-1;
                    newDir=1;
                }else{
                    newY=y+1;
                    newDir=0;
                }
            }else{// R      // dir: 0,1,2,3 상화좌우
                if(dir==0){
                    newX=x-1;
                    newDir=3;
                }else if(dir==1){
                    newX=x+1;
                    newDir=2;
                }else if(dir==2){
                    newY=y+1;
                    newDir=0;
                }else{
                    newY=y-1;
                    newDir=1;
                }
            }

            if(newY<0) newY=yLen-1;
            else if(newY>yLen-1) newY=0;
            else if(newX<0) newX=xLen-1;
            else if(newX>xLen-1) newX=0;

            if(check[newY][newX][newDir]){
                ans.add(newCnt);
            }else findCycle(newY,newX,newDir,newCnt);
        }
    }

}
