package Programmers;

//문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 여
// 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부
// 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return

class Solution {
    public static int solution(String s) {
        int answer = 0;
        answer = s.length();
        int unit = 1;
        while(s.length()-unit>=unit){
            int idx = 0;
            String subAns="";
            for(int i=idx; i<s.length(); i++){
                if(idx>=s.length() || idx+unit>s.length()){
                    if(idx<s.length()){
                        subAns+=s.substring(idx,s.length());
                    }
                    break;
                }
                String str = s.substring(idx,idx+unit);

                int comIdx = idx+unit;
                int conCnt = 1;
                for(int j=comIdx; j<s.length(); j++){
                    if(comIdx>=s.length() || comIdx+unit > s.length()){
                        break;
                    }
                    if(str.equals(s.substring(comIdx,comIdx+unit))){
                        conCnt++;
                    }else{

                        break;
                    }
                    comIdx = comIdx+unit;
                }
                if(conCnt>1){
                    subAns+=Integer.toString(conCnt)+str;
                }else{
                    subAns+=str;
                }
                idx=idx+unit*conCnt;
            }
            answer = Math.min(answer,subAns.length());
            unit++;
        }

        return answer;
    }
}

public class Programmers_Level2_01 {
    public static void main(String[] args){
        System.out.println(Solution.solution("xababcdcdababcdcd"));
    }
}
