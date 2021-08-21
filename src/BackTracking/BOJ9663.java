package BackTracking;

// 크기가 nXn인 체스판 위에 퀸 n개를 서로 공격할 수 없게 놓는 문제
// n이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램
// 오른쪽, 왼쪽, 대각선 위치에 있으면 안된다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
    static int n;
    static int noc;
    static boolean ch;
    static int[][] ans = new int[2][20];

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());

        tracking(0);
        System.out.println(noc);

    }

    static void tracking(int count){
        if(count == n){
            noc++;
        }else{
            for(int i=0; i<n; i++){ //x
               ch = false;
                for(int j=0; j<count; j++){ //확인

                    if(ans[1][j] == i){ //아래
                        ch = true;
                        break;
                    }if(ans[1][j]+ans[0][j]+(2*(count-ans[0][j])) == count+i){ //오른 대각
                        ch = true;
                        break;
                    }if(ans[1][j]+ans[0][j] == count+i){ //왼 대각
                        ch = true;
                        break;
                    }
                }
                if(ch == false){
                    ans[0][count] = count;
                    ans[1][count] = i;
                    tracking(count+1);
                }
            }
        }
    }
}

//class Coord{
//    int x,y;
//    public Coord(int y, int x){
//        this.x = x;
//        this.y = y;
//    }
//}
