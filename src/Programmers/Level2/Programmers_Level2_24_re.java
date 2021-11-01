package Programmers.Level2;


// 후보키: 유일성과 최소성을 만족하는 키
// 인적사항이 주어졌을 때, 후보 키의 최대 개수를 구하라

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Programmers_Level2_24_re {
    private static class Solution {
        static String[][] rel;
        static int keysSz;
        static int ans;
        static ArrayList<String> checkCad = new ArrayList<>();
        public int solution(String[][] relation){
            rel = relation;
            keysSz = relation[0].length;
            //1. 후보키 조합하기
            //2. 조합된 후보키를 set에 넣어서 확인
            findCandidate(0,"");
            int answer = ans;
            return answer;
        }
        public void findCandidate(int idx,String s){
            if(s.length()>0){
                if(checkKey(s)){

                    for(int k=0; k<checkCad.size(); k++){
                        String sc=checkCad.get(k);
                        int count = 0;
                        for(int j=0; j<s.length(); j++){
                            for(int i=0; i<sc.length(); i++){
                                if(s.charAt(j) == sc.charAt(i)){
                                    count++;
                                    break;
                                }
                            }
                        }
                        if(count==s.length()){
                            checkCad.remove(sc);
                            k--;
                            ans--;
                        }
                    }

                    checkCad.add(s);
                    ans++;
                    return;
                }
            }
            for(int i=idx; i<keysSz; i++){
                findCandidate(i+1,s+String.valueOf(i));
            }
        }
        public boolean checkKey(String s){
            Set<String> set = new HashSet<>();
            char[] chars = s.toCharArray();

            for(int i=0; i<rel.length; i++){
                StringBuilder sb = new StringBuilder("");
                for(int j=0; j<chars.length; j++){
                    sb.append(rel[i][Integer.parseInt(String.valueOf(chars[j]))]+".");
                }
                if(set.contains(sb.toString())) return false;
                set.add(sb.toString());
            }
            return true;
        }
    }

    public static void main(String[] args){
        String[][] relations = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(new Solution().solution(relations));
    }
}
