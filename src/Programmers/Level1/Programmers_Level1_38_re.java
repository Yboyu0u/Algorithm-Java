package Programmers.Level1;

// 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임

// s: 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀢 않고 그대로인 문자열

import java.util.HashMap;
import java.util.Map;

public class Programmers_Level1_38_re {
	private static class Solution {
		public static Map<String, String> map = new HashMap<>();

		public int solution(String s) {
			StringBuilder answer = new StringBuilder();
			initMap();

			StringBuilder word = new StringBuilder();
			for (char c : s.toCharArray()) {
				if (map.containsKey(word.toString())) {
					answer.append(map.get(word.toString()));
					word = new StringBuilder();
				}

				if (Character.isDigit(c)) {
					answer.append(Integer.parseInt(String.valueOf(c - '0')));
					word = new StringBuilder();
					continue;
				}

				word.append(c);
			}

			if (map.containsKey(word.toString())) {
				answer.append(map.get(word.toString()));
			}

			return Integer.parseInt(answer.toString());
		}

		public void initMap() {
			map.put("zero", "0");
			map.put("one", "1");
			map.put("two", "2");
			map.put("three", "3");
			map.put("four", "4");
			map.put("five", "5");
			map.put("six", "6");
			map.put("seven", "7");
			map.put("eight", "8");
			map.put("nine", "9");
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution("one4seveneight"));
	}
}
