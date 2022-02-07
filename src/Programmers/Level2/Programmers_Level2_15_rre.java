package Programmers.Level2;

// 메뉴를 새로 구성
// 단품 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공
// 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성
	// 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성,
	// 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서 코스요리 메뉴 후보에 포함

// orders: 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열
// course: 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열

// 새로 추가하게 될 코스요리의 메뉴 구성을 오름차순으로 문자열 형태로 배열에 담아 return

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Programmers_Level2_15_rre {
	private static class Solution {

		private static final PriorityQueue<String> priorityQueue = new PriorityQueue();
		private static HashMap<String, Integer> map;

		public String[] solution(String[] orders, int[] course) {

			for (int number : course) {
				checkOrders(orders, number);
				putMaxInMapToQueue();
			}

			return addMenuToAnswer();
		}

		private void checkOrders(String[] orders, int number) {
			map = new HashMap<>();
			Arrays.stream(orders).forEach(order ->
				splitToNumber(order, number, new StringBuilder(), 0));
		}

		private void splitToNumber(String order, int number, StringBuilder menu, int index) {
			if (menu.length() == number) {
				String newMenu = sortMenu(menu);
				map.put(newMenu, map.getOrDefault(newMenu, 0) + 1);
				return;
			}

			for (int i = index; i < order.length(); i++) {
				menu.append(order.charAt(i));
				splitToNumber(order, number, menu, i + 1);
				menu.deleteCharAt(menu.length() - 1);
			}
		}

		private String sortMenu(StringBuilder menu) {
			char[] menuToChar = menu.toString().toCharArray();
			Arrays.sort(menuToChar);
			return new String(menuToChar);
		}

		private void putMaxInMapToQueue() {
			if (map.isEmpty()) {
				return;
			}

			int maxValue = Collections.max(map.values());
			if (maxValue > 1) {
				map.entrySet().forEach(entry -> SelectMaxInMap(maxValue, entry));
			}
		}

		private void SelectMaxInMap(int maxValue, Map.Entry<String, Integer> entry) {
			if (entry.getValue() == maxValue) {
				priorityQueue.add(entry.getKey());
			}
		}

		private String[] addMenuToAnswer() {
			String[] answer = new String[priorityQueue.size()];
			int index = 0;

			while (!priorityQueue.isEmpty()) {
				answer[index++] = priorityQueue.poll();
			}

			return answer;
		}
	}
	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		new Solution().solution(orders, course);
	}
}
