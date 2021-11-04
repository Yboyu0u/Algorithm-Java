package Programmers.Level2;
import java.util.LinkedList;
import java.util.Queue;



public class Programmers_Level2_14_re {
    private static class Pair{
        int y;
        int x;
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static class Solution{
        static int len=5;
        static boolean[][] check;
        static int dy[] = {-1,1,0,0};
        static int dx[] = {0,0,-1,1};
        public int[] solution(String[][] places){
            int[] answer = new int[len];

            for(int i=0; i< places.length; i++){
                String[] place = places[i];
                if(checkWaitingRoom(place)) answer[i]=1;
                else answer[i]=0;
            }
            return answer;
        }

        public boolean checkWaitingRoom(String[] places){
            check=new boolean[len][len];
            for(int i=0; i<len; i++){
                for(int j=0; j<len; j++){
                    if(places[i].charAt(j)=='P' && check[i][j]==false){
                        if(!bfs(places,i,j)) return false;
                    }
                }
            }
            return true;
        }

        public boolean bfs(String[] places, int y, int x){
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(y,x));
            check[y][x]=true;

            int cnt=1;
            while(cnt<3){
                int count=q.size();
                while(count>0){
                    Pair pair = q.poll();
                    int qy= pair.y;
                    int qx= pair.x;
                    count--;

                    for(int i=0; i<4; i++){
                        int ny=qy+dy[i];
                        int nx=qx+dx[i];
                        if(ny<0 || ny>len-1 || nx<0 || nx>len-1) continue;

                        if(check[ny][nx]==false && places[ny].charAt(nx)=='P'){
                            if(cnt==1) return false;
                            else if(cnt==2 && places[qy].charAt(qx)=='O') return false;
                        }
                        q.add(new Pair(ny,nx));
                    }
                }
                cnt++;
            }
            return true;
        }
    }
    public static void main(String[] args){
        String[][] a = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}};
        new Solution().solution(a);
    }
}
