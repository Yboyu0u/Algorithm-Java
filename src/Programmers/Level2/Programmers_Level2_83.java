package Programmers.Level2;


// 길이가 같은 배열 A,B. 각 배열은 자연수로 이루어져 있다
// 1. 배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱한다
// 2. 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더한다
// 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표


import java.util.Arrays;

public class Programmers_Level2_83 {
    private static class Solution {
        public int solution(int []A, int []B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            int bIdx = B.length-1;
            for(int i=0; i<A.length; i++){
                answer+=A[i]*B[bIdx];
                bIdx--;
            }

            return answer;
        }
    }

}
