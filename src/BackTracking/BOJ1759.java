package BackTracking;

// 암호 만들기
// 암호는 서로다른 L개의 알파벳 소문자들로 구성
// 최소 한 개의 모음(a,e,i,o,u)과 최소 두 개의 자음으로 구성
// 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열, 사전식으로
// c개의 문자들이 주어졌을 때, 가능성이 있는 암호들을 모두 구하는 프로그램

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    static int l,c;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] arr;
    static String[] ans;

    public static void main(String[] args) throws IOException{
        str = br.readLine();
        st = new StringTokenizer(str);
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(str);
        arr = new String[c];
        ans = new String[l];
        for(int i=0; i<c; i++){
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);

        code(0,0,0,0);
        bw.flush();
        bw.close();
    }

    static void code(int idx, int count, int vCnt, int conCnt) throws IOException{
        if(count == l){
            if(vCnt>0 && conCnt>1){
                for(int i=0; i<l; i++){
                    bw.write(ans[i]);
                }
                bw.newLine();
            }
        }else{ //최소 한 개의 모음과 최소 두 개의 자음으로 구성되어야 함
            for(int i=idx; i<c; i++){
                ans[count] = arr[i];
                if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
                    code(i+1, count+1, vCnt+1, conCnt);
                }else{
                    code(i+1, count+1, vCnt, conCnt+1);
                }
            }
        }
    }
}
