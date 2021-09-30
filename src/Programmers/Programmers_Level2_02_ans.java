package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;


public class Programmers_Level2_02_ans {
    private static class Solution{
        public static String[] solution(String[] record){
            StringTokenizer st;
            HashMap<String,String> codeMap = new HashMap<>();
            codeMap.put("enter","들어왔습니다.");
            codeMap.put("leave","나갔습니다.");

            HashMap<String,String> uidMap = new HashMap<>(); //uid와 닉네임
            List<String> list = new ArrayList<>();

            for(String str:record){
                String[] split = str.split("\\s+");
                String code = split[0];
                String uid = split[1];
                if(split.length>2){ //Enter, Change일 경우
                    String name = split[2];
                    uidMap.put(uid,name); // HashMap이 키 값에 따른 값을 커버해주므로
                }
                if(!"Change".equalsIgnoreCase(code)){ // Change가 아닐 경우
                    list.add(code+" "+uid); //상태와 uid
                }
            }
            String[] answer = new String[list.size()];
            for(int i=0; i< answer.length; i++){
                String[] split = list.get(i).split("\\s+");
                String name = uidMap.get(split[1]);
                answer[i] = name+"님이 "+ codeMap.get(split[0].toLowerCase());
            }
            return answer;
        }
    }
}
