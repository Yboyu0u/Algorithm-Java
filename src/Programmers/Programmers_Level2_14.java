package Programmers;



// 대기실에 거리두기
// 1. 대기실은 5개이며, 각 대기실은 5X5 크기이다.
// 2. 거리두기를 위하여 응시자들 끼리는 맨해튼 거리가 2이하로 앉지 말아야 한다.
// 3. 단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용한다.
// p: 응시자가 앉아있는 자리
// O: 빈 테이블
// X: 파티션

// places: 자리에 않아있는 응시자들의 정보와 대기실 구조를 대기실별로 담은 2차원 배열
// 각 대기실별로 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 배열에 담아 return

// 맨해튼 거리: (r1, c1), (r2, c2) -> |r1-r2|+|c1-c2|
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_Level2_14 {
    static int rows = 5;
    static int columns = 5;
    static Queue<Coord> q;
    static Character[][] plaze;
    static boolean[][] check;
    static int[] dy={-1,1,0,0}; //상하좌우
    static int[] dx={0,0,-1,1};

    private static class Coord{
        int y;
        int x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static class Solution {
        public int[] solution(String[][] places) {

            int[] answer = {};
            answer = new int[places.length];
            int ansCnt = 0;

            for(String[] place: places){
                plaze = new Character[rows][columns];
                check = new boolean[rows][columns];

                // 1.2차원 배열로 옮긴다
                for(int i=0; i<place.length; i++){
                    for(int j=0; j<place[i].length(); j++){
                        plaze[i][j] = place[i].charAt(j);
                    }
                }

                // 2.for 문 돌리면서 p를 찾고 거리두기 확인
                int distance = 1;
                for(int i=0; i<rows; i++){
                    for(int j=0; j<columns; j++){
                        if(plaze[i][j] == 'P'){
                            q = new LinkedList<>();
                            check[i][j]=true;
                            q.add(new Coord(i,j));
                            if(!bfs()){
                                distance = 0;
                                break;
                            }
                        }
                    }
                    if(distance == 0){
                        break;
                    }
                }
                answer[ansCnt++] = distance;
            }
            return answer;
        }

        public boolean bfs(){
            int sy = q.peek().y;
            int sx = q.peek().x;

            while(!q.isEmpty()){
                Coord qPeek = q.poll();
                int y = qPeek.y;
                int x = qPeek.x;

                for(int i=0; i<4; i++){
                    int qy = y+dy[i];
                    int qx = x+dx[i];
                    int manDis = Math.abs(sy-qy)+Math.abs(sx-qx);

                    if(qy>=0 && qy<rows && qx>=0 && qx<columns && manDis<=2 && check[qy][qx]==false){
                        if(manDis == 2){ // 거리가 2일 때 사이에 빈 테이블이 하나라도 있다면
                            if(plaze[qy][qx] == 'P' && plaze[y][x] == 'O'){
                                return false;
                            }
                        }else{ // 거리가 1일 때 사람이 있으면 바로 false return
                            if(plaze[qy][qx] == 'P'){
                                return false;
                            }
                            q.add(new Coord(qy,qx));
                        }
                    }
                }
            }
            return true;
        }
    }
    public static void main(String[] args){
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] result = new Solution().solution(places);

        for(int a: result){
            System.out.print(a+" ");
        }
    }
}
