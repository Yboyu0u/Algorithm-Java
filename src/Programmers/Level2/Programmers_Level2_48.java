package Programmers.Level2;

// 게임 캐릭터 이동
    // U:y+1  D:y-1  R:x+1  L:x-1

// 좌표평면의 경계를 넘어가는 명령어는 무시
// 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return

public class Programmers_Level2_48 {
    private static class Solution {
        static int[][][] map = new int[11][11][4];
        static int ans;
        public int solution(String dirs){
            newRoadCount(dirs);
            int answer = ans;
            return answer;
        }

        public void newRoadCount(String dirs){
            int y=5;
            int x=5;
            int dir=-1;

            for(int i=0; i<dirs.length(); i++){
                int ny=y;
                int nx=x;
                int nDir=dir;
                char c = dirs.charAt(i);

                if(c=='U'){
                    ny+=1;
                    nDir=1;
                    dir=0;
                }
                else if(c=='D'){
                    ny-=1;
                    nDir=0;
                    dir=1;
                }
                else if(c=='R'){
                    nx+=1;
                    nDir=2;
                    dir=3;
                }
                else{
                    nx-=1;
                    nDir=3;
                    dir=2;
                }

                if(ny<0 || ny>10 || nx<0 || nx>10) continue;
                if(map[y][x][dir]==0 && map[ny][nx][nDir]==0) ans++;
                map[y][x][dir]=1;
                map[ny][nx][nDir]=1;
                y=ny;
                x=nx;
            }
        }
    }
}
