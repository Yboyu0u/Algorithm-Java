package Programmers.Wooteco;


// 음식점에서 하루 동안 판매 수익을 계산

// 재료  -> 이름, 가격

// 메뉴  -> 이름, 필요한 재료, 판매가
    // 재료에 포함된 알파벳의 개수는 해당 메뉴를 만들 때 필요한 재료의 수
    // 수익 = 판매가-재료비

// 판매 실적  -> 판매 수량
    // 실적= 수익*수량.
        // 손실이 발생할 수 도 있다


// ings: 재료 정보를 담은 문자열 배열
// menu: 메뉴정보를 담은 문자열 배열
// sell: 하루 동안의 판매 실적을 담은 문자열 배열

// 하루 동안의 총수익을 return
    // 음수가 날 수도 있다

import java.util.HashMap;

public class Wooteco_3 {
    private static class Solution {
        static HashMap<String,Integer> ingsMap = new HashMap<>();
        static HashMap<String,Integer> menuMap = new HashMap<>();
        public int solution(String[] ings, String[] menu, String[] sell){
            // 1. 재료를 map<이름, 가격>에 넣는다.
            putIngs(ings);

            // 2. 메뉴돌릴 때 필요한 재료를 map 에 넣어서 있으면 재료비 계속 계산
            // 3. 재료비 계산 끝났으면 판매가랑 재료비랑 빼서 수익을 Map<메뉴이름, 재료비>에 담는다.
            putMenu(menu);

            // 4. 실적 돌리면서 이름 map에 있으면 value*개수 해서 결과 값 계산
            int answer = getResult(sell);

            return answer;
        }

        public void putIngs(String[] ings){
            for(int i=0; i<ings.length; i++){
                String[] ing = ings[i].split(" ");
                ingsMap.put(ing[0],Integer.parseInt(ing[1]));
            }
        }

        public void putMenu(String[] menu){
            for(int i=0; i< menu.length; i++){
                String[] mn = menu[i].split(" ");
                String name = mn[0];
                String ingss = mn[1];
                String sellPrice = mn[2];

                int ingsPrice=0;
                for(int j=0; j<ingss.length(); j++){
                    if(ingsMap.containsKey(String.valueOf(ingss.charAt(j)))) ingsPrice+=ingsMap.get(String.valueOf(ingss.charAt(j)));
                }
                menuMap.put(name, Integer.parseInt(sellPrice)-ingsPrice);
            }
        }

        public int getResult(String[] sell){
            int result=0;
            for(int i=0; i< sell.length; i++){
                String[] s = sell[i].split(" ");
                if(menuMap.containsKey(s[0])) result+=Integer.parseInt(s[1])* menuMap.get(s[0]);
            }
            return result;
        }
    }
    public static void main(String[] args){
        String[] ings = {"r 10", "a 23", "t 124", "k 9"};
        String[] menu = {"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"};
        String[] sell = {"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};

        new Solution().solution(ings,menu,sell);
    }
}
