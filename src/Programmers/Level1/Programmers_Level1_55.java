package Programmers.Level1;

// numbers: 정수 배열

// numbers 에서 서로 다른 인덱스에 있는 두개의 수를 뽑아 더해서
// 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Programmers_Level1_55 {
    private static class Solution {
        public int[] solution(int[] numbers){
            HashSet<Integer> set = new HashSet<>();

            for(int i=0; i<numbers.length-1; i++){
                for(int j=i+1; j<numbers.length; j++){
                    set.add(numbers[i]+numbers[j]);
                }
            }

            int[] answer = new int[set.size()];
            int idx=0;
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                answer[idx++] = it.next();
            }
            Arrays.sort(answer);
            return answer;
        }
    }
}
