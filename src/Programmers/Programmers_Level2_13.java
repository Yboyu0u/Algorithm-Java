package Programmers;



// 사용자들이 편리하게 다양한 뉴스를 찾아볼 수 있도록 문제점을 개선하는 업무를 맡게 됐다
// 자카드 유사도 : 집합 간의 유사도를 검사하는 여러 방법 중의 하나
// 두 집합 A,B 사이의 자카드 유사도 J(A,B)는
// 두 집합의 교집합 크기를 두 집합의 합잡합의 크기로 나눈 값으로 정의된다
// A, B가 모두 공집합일 경우에는 J(A,B) = 1로 정의
// 문자열 사이의 유사도를 계산
// 문자열을 두 글자씩 끊어서 다중집합을 만든다

// 1. 입력으로 들어온 문자열을 두 글자씩 끊어서 다중집합의 원소로 만든다
//     이때, 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
//          다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. AB=Ab=ab
// 유사도 X 65536 하고 소수점 아래를 버리고 정수부만 출력

import java.util.Locale;
import java.util.regex.Pattern;

public class Programmers_Level2_13 {
    static int count = 0;
    private static class Solution {
        public static int solution(String str1, String str2){
            int answer = 0;
            String[] first;
            String[] second;
            int firstCnt = 0;
            int secondCnt = 0;
            boolean[] check;
            double union = 0;
            double intersection = 0;  // 집합 + 집합 - intersection = union

            first = multiSet(str1);
            firstCnt = count;
            second = multiSet(str2);
            secondCnt = count;
            check = new boolean[second.length];

            if(firstCnt==0 && secondCnt ==0){
                return 65536;
            }

            for(int i=0; i<firstCnt; i++){
                for(int j=0; j<secondCnt; j++){
                    if(check[j]==false && first[i].toUpperCase(Locale.ROOT).equals(second[j].toUpperCase(Locale.ROOT))){
                        check[j] = true;
                        intersection++;
                        break;
                    }
                }
            }
            union = firstCnt+secondCnt-intersection;
            answer = (int) ((intersection/union)*65536);
            return answer;
        }

        public static String[] multiSet(String str){
            String[] strs = new String[str.length()];
            count = 0;
            for(int i=0; i<strs.length-1; i++){
                String nStr = String.valueOf(str.charAt(i))+String.valueOf(str.charAt(i+1));
                if(Pattern.matches("^[a-zA-Z]*$",nStr)){
                    strs[count] = nStr;
                    count++;
                }
            }
            return strs;
        }
    }
    public static void main(String[] args){
        System.out.println( new Solution().solution("E=M*C^2", "e=m*c^2"));
    }
}
