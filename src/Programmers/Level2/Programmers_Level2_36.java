package Programmers.Level2;




// 같은 모양의 카카오프렌즈 블록이 2X2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는다
// R M A F N T J C

// 지원지는 블록은 모두 몇 개인지 판단하는 프로그램
// m:y n:x
// 1. 2X2 형태의 모여있는 블록 check하고 지우기
// 2. y축 아래부터 빈 칸 확인하면서 빈칸 check
// 3. 빈칸인 y축 부터 위로 올라가면서 빈 칸이랑 같은 x인 것 중 가장 빨리 빈칸이 아닌 값을 지우고 빈 칸에 채운다.

import java.util.*;

class Pair{
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

class Solution {
    static int dy[] = {0, 1, 1};
    static int dx[] = {1, 0, 1};
    static Character[][] sBoard;
    static int yLen;
    static int xLen;
    static Set<Pair> set;
    static boolean check = false;
    static int count;

    public int solution(int m, int n, String[] board) {
        sBoard = new Character[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sBoard[i][j] = board[i].charAt(j);
            }
        }

        yLen = m;
        xLen = n;
        while(!check)fourBlock();
        int answer = count;
        return answer;
    }

    public void fourBlock() {
        check = true;
        set = new HashSet<>();
        for (int i = 0; i < yLen - 1; i++) {
            for (int j = 0; j < xLen - 1; j++) {
                ArrayList<Pair> subList = new ArrayList<>();
                int cnt = 0;
                subList.add(new Pair(i, j));
                for (int k = 0; k < 3; k++) {
                    if (sBoard[i][j] == sBoard[i + dy[k]][j + dx[k]] && sBoard[i][j]!='.') {
                        cnt++;
                        subList.add(new Pair(i + dy[k], j + dx[k]));
                    }
                }
                if(cnt == 3){
                    check = false;
                    for (Pair p : subList) set.add(p);
                }
            }
        }
        removeBlock();
    }

    public void removeBlock() {
        Iterator<Pair> it = set.iterator();
        while (it.hasNext()) {
            Pair p = it.next();
            sBoard[p.y][p.x] = '.';
            count++;
        }
        moveBlocks();
    }

    public void moveBlocks() {
        for(int j=xLen-1;j>=0;j--){
            for(int i=yLen-1; i>0;i--){
                if(sBoard[i][j]=='.'){

                    for(int k=i-1;k>=0;k--){
                        if(sBoard[k][j]!='.'){
                            sBoard[i][j]=sBoard[k][j];
                            sBoard[k][j]='.';
                            break;
                        }
                    }

                }
            }
        }
    }
}

public class Programmers_Level2_36 {
    public static void main(String[] args){
        int m=6;
        int n=6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(new Solution().solution(m,n,board));
    }
}
