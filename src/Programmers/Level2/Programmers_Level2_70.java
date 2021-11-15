package Programmers.Level2;


// 여러 사람이 둥글게 앉아서 숫자를 하나씩 차례대로 말하는 게임
// 규칙
    // 1. 숫자를 0부터 시작해서 차례대로 말한다. 첫 번째 사람은 0, 두 번째 사람은 1 ... 열 번째는 9
    // 2. 10 이상의 숫자부터는 한 자리 씩 끊어서 말한다.

// 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p

public class Programmers_Level2_70 {
    private static class Solution {
        public String solution(int n, int t, int m, int p) {
            StringBuilder sb = new StringBuilder();
            int num=0;
            int idx=0;

            while(t>0){
                //2. n 진법 게임 진행, 순서와 인원 수 대로 한 번 진행
                String str = game(num,n);

                for(int i=0; i<str.length(); i++){
                    if(idx==p-1){
                        sb.append(str.charAt(i));
                        t--;
                        if(t==0) break;
                    }
                    idx++;
                    if(idx>m-1) idx=0;
                }
                if(t==0) break;
                num++;
            }
            return sb.toString();
        }

        public String game(int num, int n){
            StringBuilder sb = new StringBuilder();

            while(num>n-1){
                sb.append(check(num%n));
                num=num/n;
            }
            sb.append(check(num));
            return sb.reverse().toString();
        }

        public String check(int num){
            String str = "";
            if(num==10) str="A";
            else if(num==11) str="B";
            else if(num==12) str="C";
            else if (num==13) str="D";
            else if(num==14) str="E";
            else if(num==15) str="F";
            else str=String.valueOf(num);
            return str;
        }
    }
    public static void main(String[] args){
        new Solution().solution(16,16,2,1);
    }
}
