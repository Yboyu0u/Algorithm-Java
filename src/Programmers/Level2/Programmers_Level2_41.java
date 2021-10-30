package Programmers.Level2;



// H-index는 과학자의 생산성과 영향력을 나타내는 지표
// H-index 구하기
    // 1. 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면,
    // 2. h의 최댓값이 이 과학자의 H-Index이다

// citations: 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열
// 이 과학자의 H-Index를 return 하도록 solution 함수를 작성

import java.util.Arrays;

public class Programmers_Level2_41 {
    private static class Solution {
        static int max;
        public int solution(int[] citations) {
            int answer = 0;

            Arrays.sort(citations);
            max=citations[citations.length-1];

            for(int i=0; i<=max; i++){
                int h = 0;
                for(int j=0; j<citations.length; j++){
                    if (citations[j] >= i) h++;
                    if (h == i) {
                        answer = i;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
