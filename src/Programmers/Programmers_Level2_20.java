package Programmers;

// S, L, R
// 각 칸마다 S,L 또는 R가 써져 있는 격자가 있다
// 격자에 빛을 쏜다
// 빛의 입장에서 생각.
// 격자의 각 칸에는 특이한 성질이 있다
 // 1. 빛이 "s"가 써진 칸에 도달한 경우, 직진
 // 2. 빛이 "L"이 써진 칸에 도달한 경우, 좌회전
 // 3. 빛이 "R"이 써진 칸에 도달한 경우, 우회전
 // 4. 빛이 격자의 끝에 넘어갈 영우, 반대쪽 끝으로 다시 돌아온다

// 이 격자 내에서 빛이 이동할 수 있는 경로 사이클이 몇 개 있고,
// 각 사이클의 길이가 얼마인지 알고 싶다
// 경로 싸이클: 빛이 이동하는 순환 경로
// grid: 격자의 정보를 나타내는 1차원 문자열 배열


import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static boolean[][][] check;
    static Character[][] arr;
    static ArrayList<Integer> ans = new ArrayList<>();
    public int[] solution(String[] grid){
        // 상하좌우
        check = new boolean[grid.length][grid[0].length()][4];
        arr = new Character[grid.length][grid[0].length()];
        for(int i=0; i<grid.length; i++){
            String str = grid[i];
            for(int j=0; j<str.length(); j++){
                arr[i][j] = str.charAt(j);
            }
        }

        //dir: 상하좌우, 0,1,2,3
        for(int k=0; k< grid.length; k++){
            for(int j=0; j<grid[k].length(); j++){
                for(int i=0; i<4; i++){
                    cycleCheck(k,j,i,0, grid.length, grid[0].length());
                }
            }
        }

        int[] answer = new int[ans.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = ans.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }
    // 1. cycle check
    public void cycleCheck(int y, int x, int dir, int cnt,int yLen, int xLen){

        if(check[y][x][dir] == true){
            if(cnt>0){
                ans.add(cnt);
            }
            return;
        }

        check[y][x][dir] = true;
        char slr = arr[y][x];
        int ny=y;
        int nx=x;
        int nDir=dir;
        if(slr == 'S'){
            if(dir==0){ // y+1 0
                ny = y+1;
            }else if(dir==1){  //y-1 1
                ny = y-1;
            }else if(dir==2){ // x+1 2
                nx=x+1;
            }else{ // x-1 3
                nx=x-1;
            }
        }else if(slr == 'L'){
            if(dir==0){ // x+1 2
                nx=x+1;
                nDir=2;
            }else if(dir==1){ //x-1 4
                nx=x-1;
                nDir=3;
            }else if(dir==2){ // y-1 1
                ny=y-1;
                nDir=1;
            }else{ // y+1 0
                ny=y+1;
                nDir=0;
            }

        }else{ // R
            if(dir==0){ // x-1 3
                nx=x-1;
                nDir=3;
            }else if(dir==1){ // x+1 2
                nx=x+1;
                nDir=2;
            }else if(dir==2){ // y+1 0
                ny=y+1;
                nDir=0;
            }else{ // y-1 1
                ny=y-1;
                nDir=1;
            }
        }

        if(ny<0 || nx<0 || ny>=yLen || nx>=xLen){
            if(ny<0){
                ny=yLen-1;
            }else if(nx<0){
                nx=xLen-1;
            }else if(ny>=yLen){
                ny=0;
            }else{
                nx=0;
            }
        }
        cycleCheck(ny,nx,nDir,cnt+1,yLen,xLen);
    }
}

public class Programmers_Level2_20 {

    public static void main(String[] args){
        String[] grid = {"R","R"};

        int[] answer = new Solution().solution(grid);

        for(int a: answer){
            System.out.print(a+" ");
        }
    }

}
