package Programmers;



// 그림을 난이도 순으로 컬러링북에 넣어야 한다
// 난이도를 영역의 수로 정의
// 영역: 상하좌우로 연결된 같은 색상의 공간

// 그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성
// m: y, n: x
// 0은 색칠하지 않은 영역


import java.util.LinkedList;
import java.util.Queue;

class Coord{
    int y;
    int x;

    public Coord(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    static Queue<Coord> q = new LinkedList<>();
    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};
    static boolean[][] check;

    public int[] solution(int m, int n, int[][] picture){
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        check = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] > 0 && check[i][j] == false){
                    q.add(new Coord(i,j));
                    check[i][j] = true;
                    maxSizeOfOneArea = Math.max(bfs(m,n,picture),maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int bfs(int m, int n, int[][] picture){
        int count = 0;

        while(!q.isEmpty()){
            int y = q.peek().y;
            int x = q.peek().x;
            q.remove();
            count++;

            for(int i=0; i<4; i++){
                int nextY = y+dy[i];
                int nextX = x+dx[i];

                if(nextX>=0 && nextX<n && nextY>=0 && nextY<m){
                    if(check[nextY][nextX] == false && picture[nextY][nextX] == picture[y][x]){
                        q.add(new Coord(nextY,nextX));
                        check[nextY][nextX] = true;
                    }
                }
            }
        }
        return count;
    }
}

public class Programmers_Level2_09{
    public static void main(String[] args){
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] ans = new Solution().solution(6,4,picture);

        System.out.println(ans[0]+ " "+ans[1]);
    }
}

