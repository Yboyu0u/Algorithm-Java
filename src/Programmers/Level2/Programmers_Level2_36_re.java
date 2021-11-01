package Programmers.Level2;


import java.util.*;

// 2X2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임
// 블록이 지워진 휴에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다
// 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작
// m: y, n: x

class Solution{
    private static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return y == pair.y && x == pair.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
    static Set<Pair> set = new HashSet<>();
    static Character[][] sBoard;
    static int yLen;
    static int xLen;
    static boolean check=true;
    static int[] dy = {0,0,1,1};
    static int[] dx = {0,1,0,1};
    static int cnt;
    public int solution(int m, int n, String[] board) {
        sBoard=new Character[m][n];
        yLen=m;
        xLen=n;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                sBoard[i][j]=board[i].charAt(j);
            }
        }

        while(check){
            findBlocks();
        }

        int answer = cnt;
        return answer;
    }
    public void findBlocks(){
        check=false;
        for(int i=0; i<yLen-1; i++){
            for(int j=0; j<xLen-1; j++){
                char c = sBoard[i][j];
                if(c=='.') continue;
                int cntt=0;
                for(int k=1; k<4; k++){
                    if(c==sBoard[i+dy[k]][j+dx[k]]) cntt++;
                }
                if(cntt==3){
                    check=true;
                    for(int l=0; l<4; l++) set.add(new Pair(i+dy[l],j+dx[l]));
                }
            }
        }
        if(check) removeBlocks();
        else return;
    }
    public void removeBlocks(){
        Iterator<Pair> it = set.iterator();
        while(it.hasNext()){
            Pair pair = it.next();
            sBoard[pair.y][pair.x] = '.';
            cnt++;
        }
        set = new HashSet<>();
        moveBlocks();
    }
    public void moveBlocks(){
        for(int j=0; j<xLen; j++){
            for(int i=yLen-1; i>0; i--){
                if(sBoard[i][j]=='.'){
                    boolean ch = true;
                    for(int k=i-1; k>=0; k--){
                        if(sBoard[k][j] != '.'){
                            sBoard[i][j]=sBoard[k][j];
                            sBoard[k][j]='.';
                            if(k==0) ch=false;
                            break;
                        }
                    }
                    if(!ch) break;
                }
            }
        }
    }
}


public class Programmers_Level2_36_re {
    public static void main(String[] args){
        int m=4;
        int n=5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(new Solution().solution(m,n,board));
    }
}
