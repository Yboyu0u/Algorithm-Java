package B.DFS;

// 수빈이는 점 N, 동생은 점 K에 있다
// 수빈이는 걷거나 순간이동 가능
// 수빈이의 위치가 X일때 걷는다면 1초 후 x-1, x+1로 이동
// 순간이동 한다면 1초 후 2*X로 이동
// 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    static int n,k;
    static boolean[] check = new boolean[100001];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static long sec;
    static int count = 1;
    static Queue<Integer> q = new LinkedList<>();
    static int[] move = {1,-1,2};

    public static void main(String[] args) throws IOException {
        str = br.readLine();
        st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        q.add(n);
        has();
        System.out.println(sec);
    }

    static void has(){
        if(n==k){
            return;
        }
        boolean ch = false;
        while(!q.isEmpty()){
            if(ch == true){
                break;
            }
            int cnt = 0;
            while(count>0){
                if(ch == true){
                    break;
                }
                int s = q.peek();
                q.remove();

                for(int i=0; i<3; i++){
                    int ns;
                    if(i == 2){
                        ns = 2*s;
                    }else{
                        ns = s+move[i];
                    }
                    if(ns>=0 && ns<=100000 && check[ns] == false){
                        check[ns] = true;

                        if(ns == k){
                            ch=true;
                            break;
                        }
                        q.add(ns);
                        cnt++;
                    }
                }
                count --;
            }
            sec++;
            count = cnt;
        }
    }
}
