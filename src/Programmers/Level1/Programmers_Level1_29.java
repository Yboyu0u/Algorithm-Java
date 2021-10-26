package Programmers.Level1;


// 다트게임: 다트판에 다트를 세 사례 던져 그 점수의 합계로 실력을 겨루는 게임
    // 1. 0~10점
    // 2. 보너스: S D T
    // 3. *: 해당 점수와 바로 전에 얻은 점수를 각 2배로  #: 해당 점수는 마이너스
    // 4. *가 첫 번째에 나오면 첫 번째 *만 점수가 2배
    // 5. * * 나오면 중첩된 *점수는 4배
    // 6. * # 나오면 #의 점수는 -2배
// 점수/보너스/옵션

public class Programmers_Level1_29 {
    private static class Solution {
        static String[] dartRes= new String[3];
        static int ans;
        public int solution(String dartResult) {
            int idx=0;
            int dartIdx=0;
            boolean check = false;
            for(int i=0; i<dartResult.length(); i++){
                char c = dartResult.charAt(i);
                if(i==dartResult.length()-1){
                    dartRes[idx] = dartResult.substring(dartIdx,i+1)+" "+" ";
                    break;
                }
                if(check && (String.valueOf(c).matches("^[0-9]$") || c=='*' || c=='#')){
                    if(c=='*' || c=='#'){
                        dartRes[idx++] = dartResult.substring(dartIdx,i+1)+" "+" ";
                        dartIdx=i+1;
                    }
                    else{
                        dartRes[idx++] =dartResult.substring(dartIdx,i)+" "+" ";
                        dartIdx=i;
                    }
                    check=false;
                }else{
                    if(!String.valueOf(dartResult.charAt(i)).matches("^[0-9]$"))check=true;
                }
            }

            calculate(dartRes);
            int answer = ans;
            return answer;
        }

        public void calculate(String[] dartRes){
            for(int i=0; i<dartRes.length; i++) {
                int subAns=0;
                String score = dartRes[i];
                int num = 0;
                char bonus = score.charAt(1);
                char opt = score.charAt(2);
                if (score.charAt(1) == '0') {
                    num = Integer.parseInt(String.valueOf(score.charAt(0)) + String.valueOf(score.charAt(1)));
                    bonus = score.charAt(2);
                    opt = score.charAt(3);
                }else{
                    num = Integer.parseInt(String.valueOf(score.charAt(0)));
                }
                if(bonus =='D') subAns+=Math.pow(num,2);
                else if(bonus == 'T') subAns+=Math.pow(num,3);
                else subAns+=num;
                if(opt == '*') subAns*=2;
                else if(opt == '#') subAns*=(-1);

                if(i!= dartRes.length-1 && (dartRes[i+1].charAt(2) == '*' || dartRes[i+1].charAt(3) == '*')){
                    subAns*=2;
                }
                ans+=subAns;
            }
        }
    }

    public static void main(String[] args){
        System.out.println(new Solution().solution("1S2D*3T"));
    }
}
