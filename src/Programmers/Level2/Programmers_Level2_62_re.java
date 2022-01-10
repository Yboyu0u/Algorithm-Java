package Programmers.Level2;

// 캐시 크기에 따른 실행시간 측정 프로그램을 작성

// cacheSize: 캐시크기
// cities: 도시이름

// 입력된 도시이름 배열을 순서대로 처리할 때, 총 실행시간을 출력

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Programmers_Level2_62_re {
	private static class Solution {
		public static List<String> cache = new ArrayList<>();
		public static int answer;

		public int solution(int cacheSize, String[] cities) {
			Arrays.stream(cities).forEach(city -> checkCache(city.toUpperCase(Locale.ROOT), cacheSize));

			return answer;
		}

		public void checkCache(String city, int cacheSize) {
			int option = -1;
			if (cache.contains(city)) {
				option = 0;
				answer++;
			}

			if (!cache.contains(city)) {
				option = 1;
				answer += 5;
			}

			if (cacheSize > 0) {
				removeCache(cacheSize, option, city);
				cache.add(city);
			}
		}

		public void removeCache(int cacheSize, int option, String city) {
			if (option == 0) {
				cache.remove(city);
			}

			if (option == 1) {
				if (cache.size() == cacheSize) {
					cache.remove(0);
				}
			}
		}
	}
}
