package Programmers.Level2;


// 압축 전의 정보를 완벽하게 복원 가능한 무손실 압출 알고리즘을 구현
// LZW 압축 과정
    // 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다
    // 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다
    // 3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거
    // 4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+C에 해당하는 단어를 사전에 등록
    // 5. 단계 2로 돌아간다


// msg: 영문 대문자로만 이뤄진 문자열
// 주어진 문자열을 압축한 후의 사전 색인 번호를 배열로 출력하라

import java.util.ArrayList;
import java.util.HashMap;


public class Programmers_Level2_68 {
    private static class Solution {
        static HashMap<String,Integer> map = new HashMap<>();
        static int num=1;
        static ArrayList<Integer> list = new ArrayList<>();
        public int[] solution(String msg) {
            // 1. A~Z 사전 초기화
            initDic();

            // 2. msg 를 돌면서 사전에 안나오는 거 있으면 그 전 것까지 처리하고 현재꺼 포함 사전에 등록
            makeLZW(msg);

            int[] answer = new int[list.size()];
            int idx=0;
            for(int i: list) answer[idx++]=i;

            return answer;
        }

        public void initDic(){
            for(int i=65; i<91; i++) map.put(String.valueOf((char) i),num++);
        }

        public void makeLZW(String msg){
            int idx=0;

            while(idx<msg.length()){
                StringBuilder sb = new StringBuilder();
                int subIdx=-1;
                for(int i=idx; i<msg.length(); i++){
                    sb.append(msg.charAt(i));
                    if(!map.containsKey(sb.toString())){
                        map.put(sb.toString(),num++);
                        sb.deleteCharAt(sb.length()-1);
                        subIdx=i;
                        break;
                    }
                }
                list.add(map.get(sb.toString()));
                if(subIdx==-1) return;
                idx=subIdx;
            }
        }
    }
    public static void main(String[] args){
        new Solution().solution("KAKAO");
    }
}
