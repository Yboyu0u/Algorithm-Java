package Programmers.Level1;



// 자연수 n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return

public class Programmers_Level1_54{
    private static class Solution {
        public int solution(int n){
            int answer = threeToTen(tenToReverseThree(n));
            return answer;
        }

        public String tenToReverseThree(long n){
            StringBuilder sb = new StringBuilder();
            while(n>2){
                sb.append(n%3);
                n=n/3;
            }
            sb.append(n);
            return sb.toString();
        }

        public int threeToTen(String n){
            int m=0;
            double num=0;
            for(int i=n.length()-1; i>=0; i--){
                num+=(n.charAt(i)-'0')*Math.pow(3,m++);
            }
            return (int)num;
        }
    }
    public static void main(String[] args){
        int a = 100000000;
        System.out.println(a);
        new Solution().solution(45);
    }
}
