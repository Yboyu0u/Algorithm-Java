package Programmers;

// 각 프렌즈가 원하는 조건을 입력으로 받았을 때 모든 조건을 만족할 수 있도록 서는 경우의 수를 계산하는 프로그램

// data: 길이가 n. 한 원소는 각 프렌즈가 원하는 조건이 N~F=0과 같은 형태의 문자열로 구성

    // 1. data의 원소는 다섯 글자로 구성된 문자열
    // 2. 첫 번쩨, 세 번째 글자는 A,C,F,J,M,N,R,T 중 하나 주체와 객체
    // 3. 두 번째 글자는 항상 ~
    // 4. 네 번째 글자는 =,<,> 같음 미만 초과
    // 5. 다섯 번째 글자는 0 이상 6 이하의 정수의 문자형 -> 간격을 의미
// 모든 조건을 만족하는 경우의 수를 리턴

public class Programmers_Level2_26 {
    private static class Solution {
        static Character[] friends = {'A','C','F','J','M','N','R','T'};
        static boolean[] check = new boolean[friends.length];
        static int ans;
        public int solution(int n, String[] data){
            ans=0;
            find(new Character[friends.length],0,data);
            int answer = ans;
            return answer;
        }

        public void find(Character[] chars, int cnt, String[] data){
            if(cnt==friends.length){
                if(conCheck(data,chars))ans++;
                return;
            }
            for(int i=0; i< friends.length; i++){
                if(!check[i]){
                    check[i]=true;
                    chars[cnt]=friends[i];
                    find(chars,cnt+1,data);
                    check[i]=false;
                }
            }
        }

        public boolean conCheck(String[] data, Character[] chars){
            for(int i=0; i<data.length; i++){
                char sub = data[i].charAt(0);
                char obj = data[i].charAt(2);
                char oper = data[i].charAt(3);
                int inter = Integer.parseInt(String.valueOf(data[i].charAt(4)));

                int disCnt = -1;
                boolean ch = false;
                for(int j=0; j<friends.length; j++){
                    char frd = chars[j];
                    if(frd==sub || frd==obj){
                        if(!ch) ch=true;
                        else break;
                    }
                    if(ch)disCnt++;
                }
                if(oper=='='){
                    if(disCnt!=inter)return false;
                }else if(oper=='>'){
                    if(disCnt<=inter)return false;
                }else{
                    if(disCnt>=inter)return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args){
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(new Solution().solution(2,data));
    }
}
