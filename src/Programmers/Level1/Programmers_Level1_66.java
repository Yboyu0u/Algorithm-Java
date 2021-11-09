package Programmers.Level1;


// 시저 암호: 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식
// 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수

public class Programmers_Level1_66 {
    private static class Solution {
        public String solution(String s, int n){
            String answer="";
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c>=65 && c<=122){
                    for(int j=0; j<n; j++){
                        c+=1;
                        if(c==91) c='A';
                        else if(c==123) c='a';
                    }
                }
                sb.append(c);
            }
            answer = sb.toString();
            return answer;
        }
    }
    public static void main(String[] args){
        String s= "a B z";
        new Solution().solution(s,1);
    }
}
