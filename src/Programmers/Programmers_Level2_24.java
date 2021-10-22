package Programmers;

// 학생들의 인적사항을 정리
// 후보 키
 // 유일성: 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다
 // 최소성: 유일성을 가진 키를 구성하는 속성 중 하나라도 제외하는 경우 유일성이 깨지는 것을 의미
            // 즉, 릴레이션의 모든 튜플을 유일하게 식별하는 데 꼭 필요한 속성들로만 구성되어야 한다

// 학생들의 인적사항이 주어졌을 때, 후보 키의 최대 개수를 구하라.
// relation: 릴레이션을 나타내는 문자열 배열

import java.util.HashSet;
import java.util.LinkedList;

class Solution {
    static int x;
    static int y;
    static boolean[] check;
    static String[][] rels;
    static int ans;
    static LinkedList<String> ansList = new LinkedList<>();
    public int solution(String[][] relation) {
        rels=relation;
        check = new boolean[relation[0].length];
        y = relation.length;
        x = relation[0].length;

        selectIdx(0,0, "");

        int answer = ans;
        return answer;
    }

    public void selectIdx(int idx, int idxCnt, String str){
        //findCan
        if(str!=""){
            if(findCan(str)){
                for(int i=0; i<ansList.size(); i++){
                    int c = 0;
                    for(int j=0; j<str.length(); j++){
                        if(ansList.get(i).contains(String.valueOf(str.charAt(j)))){
                            c++;
                        }
                    }
                    if(c==str.length()){
                        ansList.remove(i);
                        i--;
                        ans--;
                    }
                }
                ans++;
                ansList.add(str);
                return;
            }
        }
        for(int i=idx; i<x; i++){
            selectIdx(i+1,idxCnt+1,str+String.valueOf(i));
        }
    }

    public boolean findCan(String strs){
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<y; i++){
            String str = "";
            for(int k=0; k<strs.length(); k++){
                str=str+rels[i][Integer.parseInt(String.valueOf(strs.charAt(k)))]+".";
            }
            if(set.contains(str)){
                return false;
            }
            set.add(str);
        }
        return true;
    }
}

public class Programmers_Level2_24 {
    public static void main(String[] args){
        String[][] relations = {{"a", "aa"}, {"aa", "a"}, {"a", "a"}};
        System.out.println(new Solution().solution(relations));
    }
}
