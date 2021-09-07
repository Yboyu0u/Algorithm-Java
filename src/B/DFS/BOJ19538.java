package B.DFS;

// 루머는 최초의 유포자로부터 시작
// 최초의 유포자는 여러 명일 수 있고,
// 최초 유포자를 제외하고 스스로 루머를 만들어 믿는 사람은 없다
// 매분 루머를 믿는 사람은 모든 주변인에게 루머를 동시에 퍼뜨린다
// 군중 속 사람은 주변인의 절반 이상이 루머릴 믿을 때 본인도 루머를 믿는다
// 한번 믿은 루머는 계속 믿는다
// 사람들이 루머를 처음 믿기 시작하는 시간을 알아내자


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ19538 {
    static int n; // 전체 사람 수
    static int m; // 최초 유포자의 수
    static ArrayList<ArrayList<Integer>> people = new ArrayList<ArrayList<Integer>>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static Queue<Integer> q = new LinkedList<>();
    static int count;
    static int sec;
    static int[] ans;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        check = new boolean[n+1];
        people.add(new ArrayList<Integer>());
        for(int i=1; i<=n; i++){
            str = br.readLine();
            st= new StringTokenizer(str);
            int rel = Integer.parseInt(st.nextToken());
            ArrayList<Integer> sPeople = new ArrayList<>();
            while(rel!=0){
                sPeople.add(rel);
                rel = Integer.parseInt(st.nextToken());
            }
            people.add(sPeople);
        }

        m = Integer.parseInt(br.readLine());
        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<m; i++){
            int sr = Integer.parseInt(st.nextToken());
            q.add(sr);
            check[sr] = true;
            ans[sr] = 0;
            count++;
        }

        rumor();

        for(int i=1; i<=n; i++){
            if(check[i] == false){
                ans[i] = -1;
            }
        }

        for(int i=1; i<=n; i++){
            System.out.print(ans[i] + " ");
        }

    }
    static void rumor(){
        while(!q.isEmpty()){
            int cnt=0;
            sec++;
            Queue<Integer> checkQ = new LinkedList<>();

            while(count>0){
                int qs = q.peek();
                q.remove();
                count--;
                for(int i=0; i<people.get(qs).size(); i++){
                    // 루머를 믿은 사람은 루머를 동시에 퍼뜨린다
                    // 주변인의 절반 이상이 루머를 믿을 때 본인도 루머를 믿는다
                    // 루머를 믿게 되는 시점을 알아야 한다
                    if(check[people.get(qs).get(i)] == false){
                        int rCnt = 0;
                        int tCnt = 0;
                        for(int j=0; j<people.get(people.get(qs).get(i)).size(); j++){
                                tCnt++;
                                if(check[people.get(people.get(qs).get(i)).get(j)] == true){
                                    rCnt++;
                                }
                        }
                        if(tCnt%2 == 1){
                            if(rCnt>tCnt/2){
                                checkQ.add(people.get(qs).get(i));
                                q.add(people.get(qs).get(i));
                                ans[people.get(qs).get(i)]=sec;
                                cnt++;
                            }
                        }else{
                            if(rCnt>=tCnt/2){
                                checkQ.add(people.get(qs).get(i));
                                q.add(people.get(qs).get(i));
                                ans[people.get(qs).get(i)]=sec;
                                cnt++;
                            }
                        }
                    }
                }
            }
            // checking 한 번에 해줘야 함
            while(!checkQ.isEmpty()){
                check[checkQ.peek()] = true;
                checkQ.remove();
            }
            count = cnt;
        }
    }
}
