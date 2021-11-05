package Programmers.Level2;



// DB 캐시를 적용할 때 키시 크기에 실행시간 측정 프로그램을 작성

// cacheSize: 캐시 크기
// cities: 도시이름으로 이뤄진 문자열 배열

// 입력된 도시이를 배열을 순서대로 처리할 때, "총 실행시간"을 출력하라

import java.util.ArrayList;
import java.util.Locale;

public class Programmers_Level2_62{
    private static class Solution {
        static ArrayList<String> cache = new ArrayList<>();
        static int cacheSz;
        public int solution(int cacheSize, String[] cities){
            int answer = 0;
            cacheSz=cacheSize;

            for(String city: cities){
                if(checkCache(city.toLowerCase(Locale.ROOT))) answer+=1;
                else{
                    answer+=5;
                    AddCache(city.toLowerCase(Locale.ROOT));
                }

            }
            return answer;
        }

        public boolean checkCache(String city){
            for(int i=0; i<cache.size(); i++){
                if(cache.get(i).equals(city)){
                    cache.remove(i);
                    cache.add(0,city);
                    return true;
                }
            }
            return false;
        }

        public void AddCache(String city){
            if(cacheSz==0) return;
            if(cache.isEmpty()){
                cache.add(city);
                return;
            }
            if(cache.size()==cacheSz) cache.remove(cacheSz-1);
            cache.add(0,city);
        }
    }
}
