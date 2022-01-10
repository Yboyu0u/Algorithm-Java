package Programmers.Level1;

// 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

// N: 전체 스테이지의 개수
// stages: 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열

// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return
	// 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록
	// 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0

import java.util.ArrayList;
import java.util.Collections;

public class Programmers_Level1_53_re {
	private static class Fail implements Comparable<Fail> {
		public double failure;
		public int name;

		public Fail(int name) {
			this.failure = 0;
			this.name = name;
		}

		@Override
		public int compareTo(Fail o) {
			if (this.failure < o.failure) {
				return 1;
			}

			if (this.failure > o.failure) {
				return -1;
			}

			return 0;
		}
	}

	private static class Solution {
		public static ArrayList<Fail> list = new ArrayList<>();

		public int[] solution(int N, int[] stages) {
			initList(N);

			for (int i = 1; i < N + 1; i++) {
				calculateFailure(i, stages);
			}

			Collections.sort(list);

			int[] answer = new int[N];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				answer[idx++] = list.get(i).name;
			}

			return answer;
		}

		public void initList(int N) {
			for (int i = 0; i < N; i++) {
				list.add(new Fail(i + 1));
			}
		}

		public void calculateFailure(int stage, int[] stages) {
			double denominator = 0;
			double numerator = 0;

			for (int j = 0; j < stages.length; j++) {
				if (stage <= stages[j]) { // 분모
					denominator++;

					if (stage == stages[j]) { // 분자
						numerator++;
					}
				}
			}

			list.get(stage - 1).failure = numerator / denominator;
		}
	}
	public static void main(String[] args) {
		int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
		new Solution().solution(5,arr);
	}
}
