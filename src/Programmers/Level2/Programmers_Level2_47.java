package Programmers.Level2;


// skill: 선행 스킬 순서
// skill_trees: 유저들이 만든 스킬트리

// 가능한 스킬트리 개수를 return

import java.util.Stack;

public class Programmers_Level2_47 {
    private static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            for(String str: skill_trees){
                if(checkRight(str,skill)) answer++;
            }
            return answer;
        }

        public boolean checkRight(String str,String skill){
            int idx=0;
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(!skill.contains(String.valueOf(c))) continue;

                if(c==skill.charAt(idx)){
                    if(idx<skill.length()-1)idx++;
                }else return false;
            }
            return true;
        }
    }
}
