package Programmers;



// 언어 cpp,java,python -
// 직군 backend frontend -
// 경력 junior senior -
// 푸드 chicken pizza -
// 점수

// -: 해당 조건을 고려하지 않겠다는 의미

// 지원자들의 지원 조건을 선택하면 해당 조건에 맞는 지원자가 몇 명인지 알고 싶다
// 각각을 and 로 구분
// info: 지원자의 4가지 정보와 획득한 코딩테스트 점수를 하나의 문자열로 구성한 배열
// query: 문의 조건으로 된 문자열

// 각 문의조건에 해당하는 사람들의 숫자를 순서대로 배열에 담아 return
import java.util.ArrayList;
import java.util.StringTokenizer;

//class Solution {
//    static ArrayList<Integer> ans = new ArrayList<>();
//    static String[][] developers;
//
//    public int[] solution(String[] info, String[] query) {
//        developers = new String[info.length][5];
//        // 1. ArrayList에 info 정보 class형태로 받기
//        int idx=0;
//        for(String person: info){
//            StringTokenizer st = new StringTokenizer(person);
//            for(int i=0; i<5; i++){
//                   developers[idx][i] = st.nextToken();
//            }
//            idx++;
//        }
//
//        for(String q: query){
//            int idxx=0;
//            String[] customQ = new String[5];
//            StringTokenizer st = new StringTokenizer(q);
//            while(st.hasMoreTokens()){
//                String str = st.nextToken();
//                if(str.equals("and")) continue;
//                customQ[idxx++]=str;
//            }
//            findDeveloper(customQ);
//        }
//        int[] answer = new int[ans.size()];
//        int idxxx=0;
//        for(int num: ans){
//            answer[idxxx++]=num;
//        }
//        return answer;
//    }
//
//    public void findDeveloper(String[] query){
//        int count=0;
//        for(int i=0; i<developers.length; i++){
//            String[] developer = developers[i];
//
//            if((developer[0].equals(query[0]) || query[0].equals("-")) && (developer[1].equals(query[1]) || query[1].equals("-")) &&
//                    (developer[2].equals(query[2]) || query[2].equals("-")) && (developer[3].equals(query[3]) || query[3].equals("-")) &&
//                    (Integer.parseInt(developer[4])>=Integer.parseInt(query[4]) || query[4].equals("-"))) count++;
//        }
//        ans.add(count);
//    }
//}


//public class Programmers_Level2_28 {
//
//    public static void main(String[] args){
//        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
//        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
//
//        int[] answer = new Solution().solution(info,query);
//
//        for(int a: answer){
//            System.out.print(a+" ");
//        }
//
//    }
//}
