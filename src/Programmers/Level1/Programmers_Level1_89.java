package Programmers.Level1;

// 배열 arr 의 각 원소는 숫자 0부터 9까지로 이루어져 있다
// 배열 arr 에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return

import java.util.*;

public class Programmers_Level1_89 {
	private static class Solution {
		public int[] solution(int[] arr) {
			ArrayList<Integer> ans = removeDup(arr);

			int[] answer = new int[ans.size()];
			int idx = 0;
			for (int i : ans) {
				answer[idx++] = i;
			}

			return answer;
		}

		public ArrayList removeDup(int[] arr) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(arr[0]);

			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != arr[i - 1]) {
					list.add(arr[i]);
				}
			}

			return list;
		}
	}
}
