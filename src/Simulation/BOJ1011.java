package Simulation;

// 이동 장치
// 이전 작동시기에 k광년 이동했으면 k-1, k, k+1 광년 다시 이동가능
// 처음 이동할땐 1광년만 이동가능
// x에서 y까지 최소한의 작동 횟수로 이동해야 한다
// y지점에 도착하기 바로 직전의 이동거리는 반드시 1광년으로 해야함
// x지점부터 y지점으로 이동하는데 필요한 장치 이동 횟수의 최소값을 구해라

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1011 {
    static int t,x,y;
    static String s;
    static StringTokenizer st;
    static Queue<Alpha> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            s = br.readLine();
            st = new StringTokenizer(s);
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            queue.clear();
            Alpha a = new Alpha(x,0,0);
            queue.add(a);
            move();
        }
    }

    static void move() {
        while(!queue.isEmpty()){
            int p = queue.peek().point;
            int s = queue.peek().step;
            int c = queue.peek().count;
            queue.remove();

            if(p == y && s == 1){
                System.out.println(c);
                return;
            }else{
                if(c==0){
                    queue.add(new Alpha(p+1,1,1));
                }else{
                    queue.add(new Alpha(p+s-1,s-1,c+1)); //k-1
                    queue.add(new Alpha(p+s,s,c+1)); //k
                    queue.add(new Alpha(p+s+1,s+1,c+1)); //k+1
                }
            }
        }
    }
}

class Alpha{
    int step;
    int point;
    int count;

    public Alpha(int point, int step, int count) {
        this.point = point;
        this.step = step;
        this.count = count;
    }
}
