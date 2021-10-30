package Programmers.Level1;


// 일부 자릿수를 영단어로 바꾼 카드를 건네주면 원래 숫자를 찾는 게임

public class Programmers_Level1_38 {
    private static class Solution {
        static String[] num={"zero","one","two","three","four","five","six","seven","eight","nine"};
        static StringBuilder ans=new StringBuilder("");
        public int solution(String s) {
            StringBuilder sb = new StringBuilder("");
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(!Character.isDigit(c)){
                    sb.append(c);
                    int num = checkNum(sb.toString());
                    if(num>-1){
                        ans.append(String.valueOf(num));
                        sb=new StringBuilder("");
                    }
                }else ans.append(c);
            }
            int answer=Integer.parseInt(ans.toString());
            return answer;
        }

        public int checkNum(String ss){
            for(int i=0; i<num.length; i++){
                if(num[i].equals(ss)) return i;
            }
            return -1;
        }
    }
    public static void main(String[] args){
        System.out.println(new Solution().solution("one4seveneight"));
    }
}
