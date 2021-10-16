package Programmers;


// tuple: 셀수있는 수량의 순서를 순서있는 열거 또는 어떤 순서를 따른 요소들의 모음
// n-tuple: n개의 요소를 가진 튜플
// 튜플의 성질
    // 1. 중복된 원소가 있을 수 있다
    // 2. 원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플
    // 3. 튜플의 원소 개수는 유한하다

// 특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때,
// s가 표현하는 튜플을 배열에 담아 return

import java.util.ArrayList;
import java.util.HashMap;

public class Programmers_Level2_17 {
    private static class Solution {
        public int[] solution(String s) {
            HashMap<String,Integer> map = new HashMap<>();
            int[] subAns = new int[s.length()];
            String ch = "";
            int cnt = 1;
            boolean escape = false;
            while(!escape) {
                ch="";
                ArrayList<String> numbers = new ArrayList<>();
                boolean eescape = false;
                for (int i=1; i<s.length() - 1; i++) {
                    if (s.charAt(i) == '}') {
                        // ch의 len 이 cnt 와 같으면 subAns 에 없는 값을 ch 에서 찾아서 넣어준다
                        // 아니면 ch 초기화
                        numbers.add(ch);
                        if(numbers.size() == cnt){
                            // ch와 subAns 를 비교 -> ch 값들 중에 subAns 에 없는 것을 넣어야 한다
                            for(int j=0; j<numbers.size(); j++){
                                if(!map.containsKey(numbers.get(j))){
                                    subAns[cnt-1] = Integer.parseInt(numbers.get(j));
                                    map.put(numbers.get(j),cnt);
                                    break;
                                }
                                map.put(numbers.get(j),cnt);
                            }
                            cnt++;
                            eescape = true;
                            break;
                        }
                        numbers = new ArrayList<>();
                        ch = "";
                        i++;

                    }else{// '{', ',' , number
                        if(s.charAt(i) != ',' && s.charAt(i) != '{'){
                            ch+=String.valueOf(s.charAt(i));
                            continue;
                        }
                        if(s.charAt(i) == ','){
                            numbers.add(ch);
                            ch = "";
                        }
                    }
                }
                if(!eescape){
                    escape = true;
                }
            }

            int[] answer = new int[cnt-1];
            for(int i=0; i<cnt-1; i++){
                answer[i] = subAns[i];
            }
            return answer;
        }
    }
    public static void main(String[] args){
        String s ="{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] ans = new Solution().solution(s);
        for(int a: ans){
            System.out.print(a+" ");
        }
    }
}
