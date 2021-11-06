package Programmers.Wooteco;


// 처음과 끝이 이어져 있는 문자열
// 해당 문자열 내의 "같은 글자가 연속해 있는" 구간들을 추출하고자 한다

// 같은 글자가 연속해 있는 구간의 길이를 각각 배열에 담아 오름차순으로 정렬하여 return

// 마지막일 때만 check?


import java.util.Arrays;
import java.util.LinkedList;

public class Wooteco_4 {
    private static class Pair{
        char let;
        int count;

        public Pair(char let, int count) {
            this.let = let;
            this.count = count;
        }
    }

    private static class Solution {
        static LinkedList<Pair> list = new LinkedList();
        public int[] solution(String s){
            checkString(s);

            int[] answer = new int[list.size()];
            int idx=0;
            for(Pair p: list){
                answer[idx++] = p.count;
            }
            Arrays.sort(answer);
            return answer;
        }

        public void checkString(String s){
            int idx=0;
            int cnt=1;
            while(idx<s.length()-1){
                if(s.charAt(idx)==s.charAt(idx+1))cnt++;
                else{
                    list.add(new Pair(s.charAt(idx),cnt));
                    cnt=1;
                }
                idx++;

                if(idx==s.length()-1){
                    if(!list.isEmpty() && (list.get(0).let==s.charAt(idx))){
                        int prevCnt = list.get(0).count;
                        list.remove(0);
                        cnt+=prevCnt;
                    }
                    list.add(new Pair(s.charAt(idx),cnt));
                }
            }
        }
    }
    public static void main(String[] args){
        int[] ans = new Solution().solution("aaaaaa");
        for(int i: ans) System.out.print(i+" ");
    }
}
