package Programmers.Wooteco;

// 처음 격자 칸 안에는 숫자 0이 있다
// 격자에 숫자들을 채우는 과정
    // 1. 현재 위치를 1행 1열로 정하고, 그 위치에 숫자 1을 쓴다
    // 2. r을 현재 위치의 행, c를 현재 위치의 열로 정의
    // 3. 격자 내에 0이 쓰인 칸이 없거나, 더 이상 0이 쓰여 있는 칸에 다른 숫자를 쓸 수 없게 된다면 과정을 즉시 종료

    // 4. 만약 가장 최근에 쓴 숫자가 짝수라면, r행 c열에서 r+1행 c열로 이동
        // r=rows라면 1행으로 이동
    // 5. 만약 가장 최근에 쓴 숫자가 홀수라면, r행 c열에서 r행 c+1열로 이동
        //c=columns라면, 1열로 이동
    // 6. 도착한 칸에 원래 쓰여 있던 수를 지우고 (가장 최근에 쓴 숫자 +1을 쓴다)
    // 7. 2변 과정으로 돌아간다


// 해당 격자를 2차원 정수 배열로 return

public class Wooteco_5 {
    private static class Solution {
        static boolean[][] checkAns;
        static int[][] answer;
        public int[][] solution(int rows, int columns){
            answer = new int[rows][columns];
            checkAns = new boolean[rows][columns];

            int y=0;
            int x=0;
            int num=1;
            int cnt=0;
            while(check(y,x,num)){
                checkAns[y][x]=true;
                answer[y][x]=num;

                if(num%2==1) x=x+1;
                else y=y+1;

                if(x==columns) x=0;
                if(y==rows) y=0;
                num+=1;

                cnt++;
                if(cnt>=rows*columns) if(!fullCheck()) break;
            }
            return answer;
        }

        public boolean check(int y,int x,int num){
            if(checkAns[y][x]) if(answer[y][x]%2 == num%2) return false;
            return true;
        }

        public boolean fullCheck(){
            for(int i=0; i< answer.length; i++){
                for(int j=0; j<answer[i].length; j++){
                    if(answer[i][j]==0) return true;
                }
            }
            return false;
        }
    }
    public static void main(String[] args){

    }
}
