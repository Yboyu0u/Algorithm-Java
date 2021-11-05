package Programmers.Level2;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
public class Programmers_Level2_58_ans{
    private static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;

            Arrays.sort(people);

            int min=0;

            for(int max=people.length-1; min<=max; max--){
                if(people[min]+people[max]<=limit) min++;
                answer++;
            }
            return answer;
        }

        @Test
        public void test(){
            Assert.assertEquals(1, solution(new int[]{50},50));
        }
    }
}


