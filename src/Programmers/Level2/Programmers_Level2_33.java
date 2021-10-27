package Programmers.Level2;


// 알파벳 소문자로 이루어진 문자열
// 1.같은 알파벳이 2개 붙어 있는 짝을 찾는다
// 2. 그 둘을 제거
// 3. 앞뒤로 문자열을 이어 붙인다
// 4. 이 과정을 반복해서 문자열을 모두 제거

// 문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성

public class Programmers_Level2_33 {
    private static class Solution {
        static String ss;
        public int solution(String s) {
            ss=s;
            int answer = 0;
            boolean check=false;
            while(ss.length()>0){
                if(!removeStr()){
                    check=true;
                    break;
                }
            }
            if(!check) answer=1;
            return answer;
        }

        public boolean removeStr(){
            for(int i=0; i<ss.length()-1; i++){
                if(ss.charAt(i) == ss.charAt(i+1)){
                    if(i==ss.length()-1 && i==0) ss="";
                    else if(i==ss.length()-1) ss=ss.substring(0,i);
                    else if(i==0) ss=ss.substring(i+2,ss.length());
                    else ss=ss.substring(0,i)+ss.substring(i+2,ss.length());
                    return true;
                }
            }
            return false;
        }
    }
    public static void main(String[] args){
        System.out.println(new Solution().solution("baabaa"));
    }
}
