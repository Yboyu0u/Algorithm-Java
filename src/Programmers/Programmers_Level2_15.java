package Programmers;



// 메뉴를 새로 구성하려고 고민
// 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정
// 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했다
    // 단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성
    // 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조함에 대해서만 코스요리 메뉴 후보에 포함

// orders: 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열
// course: 스카피가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열

// 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeMap;
//
//class Solution {
//    static HashMap<String, Integer> subAns = new HashMap<>();
//
//    static TreeMap<String, Integer> ans = new TreeMap<>();
//    static int count;
//
//    public String[] solution(String[] orders, int[] course) {
//        String[] answer = {};
//
//        for (int k = 0; k < orders.length; k++) {
//            // 2메뉴로 쪼갠다.
//            String order = orders[k];
//            HashMap<String, Integer> orderr = new HashMap<>();
//            for (int i = 0; i < order.length() - 1; i++) {
//                for (int j = i + 1; j < orders[k].length(); j++) {
//                    String twoCourse = String.valueOf(order.charAt(i)) + String.valueOf(order.charAt(j));
//                    orderr.put(twoCourse, j);
//                    if (subAns.containsKey(twoCourse)) {
//                        ans.put(twoCourse, j);
//                    }
//                    subAns.put(twoCourse, j);
//                }
//            }
//
//            for (Map.Entry<String, Integer> entry : orderr.entrySet()){
//                System.out.print(entry.getKey()+" ");
//            }
//            System.out.println();
//
//            for (int num : course) {
//                if (num == 2 || order.length()<num) continue;
//                orderr = slice(orderr, order, num);
//                System.out.println();
//            }
//
//            for (Map.Entry<String, Integer> entry : ans.entrySet()){
//                System.out.print(entry.getKey()+" ");
//            }
//
//        }
//        return answer;
//    }
//
//    // 한 손님의 오더들을 두개 씩 자른 오더들을 3,4 ... 만큼 쪼개서 subAns에 넣고 같은 키 값이 있으면 ans에 넣는다
//    public HashMap<String, Integer> slice(HashMap<String, Integer> orderr, String order, int num) {
//        HashMap<String, Integer> result = null;
//        boolean conti = false;
//        // orderr에 있는 key 값에 value 부터 order.length 만큼 돌면서 문자를 붙여준다.
//        // 붙은 새로운 문자를 subAns에 넣고 subAns에 같은 값이 있으면 ans에 넣어준다.
//        while(!conti){
//            result = new HashMap<>();
//            for (Map.Entry<String, Integer> entry : orderr.entrySet()){
//                String or = entry.getKey();
//                int idx = entry.getValue() + 1;
//                if(or.length()+1 == num || idx>=or.length()) conti = true;
//
//                for (int i = idx; i < order.length(); i++) {
//                    String orr = or + String.valueOf(order.charAt(idx)); // orr= AB -> or = ABC
//                    result.put(orr, i);
//                    if(conti){
//                        if (subAns.containsKey(orr)) {
//                            ans.put(orr, i);
//                        }
//                        subAns.put(orr, i);
//                    }
//                    idx++;
//                }
//            }
////            System.out.println();
//
//            orderr = result;
//        }
//        for (Map.Entry<String, Integer> entry : result.entrySet()){
//            System.out.print(entry.getKey()+" ");
//        }
//        return result;
//    }
//}

//public class Programmers_Level2_15 {
//    public static void main(String[] args){
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2,3,4};
//
//       String[] result =  new Solution().solution(orders,course);
//
//       for(String res: result){
//           System.out.print(res+" ");
//       }
//    }
//}
