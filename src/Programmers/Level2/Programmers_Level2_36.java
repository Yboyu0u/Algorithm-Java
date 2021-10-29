package Programmers.Level2;
import java.util.*;
public class Programmers_Level2_36 {
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

    private static class Solution {
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
    public static void main(String[] args){
        int m=6;
        int n=6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(new Solution().solution(m,n,board));
    }
}
