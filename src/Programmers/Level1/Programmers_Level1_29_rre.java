package Programmers.Level1;

// 다트판에 다트를 세 차례 던져 점수의 합계로 실력을 겨루는 게임
// 점수 계산 로직
	// 1. 총 3번의 기회
	// 2. 각 기회마다 얻을 수 있는 점수는 0~10
	// 3. S, D, T 영역이 점수마다 존재하고 1제곱, 2제곱, 3제곱
	// 4. 옵션: *, #: 점수마다 둘 중 하나만 존재하고 존재하지 않을 수도 있다
		// *: 해당 점수와 바로 전에 얻은 점수를 각 2배로
		// #: 해당 점수는 마이너스
	// 5. *는 첫 번째 기회에서도 나올 수 있다: 첫 번째 *의 점수만 2배가 된다
	// 6. *의 효과는 다른 스타상의 효과와 중첩될 수 있다.
	// 7. *의 효과는 #의 효과와 중첩될 수 있다.

// 0~10의 정수와 문자 S,D,T,*,#로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성
// dartResult: 점수|보너스|옵션으로 이루어진 문자열 3세트

import java.util.ArrayList;
import java.util.List;

public class Programmers_Level1_29_rre {
	private static class Solution {
		static List<Integer> scoreList = new ArrayList<>();

		public int solution(String dartResult) {
			splitResult(dartResult);

			return scoreList.stream().mapToInt(i -> i).sum();
		}

		public void splitResult(String dartResult) {
			StringBuilder score = new StringBuilder();

			for (int i = 0; i < dartResult.length(); i++) {
				if (score.length() > 1 && Character.isDigit(dartResult.charAt(i))) {
					calculateScore(score.toString());
					score = new StringBuilder();
				}

				score.append(dartResult.charAt(i));

				if (i == dartResult.length() - 1) {
					calculateScore(score.toString());
				}
			}
		}

		public void calculateScore(String score) {
			int intScore = 0;
			for (int i = 0; i < score.length(); i++) {
				char scoreC = score.charAt(i);

				if (Character.isDigit(scoreC)) {
					intScore = getNumber(intScore, score, i);
					continue;
				}

				intScore = getBonusAndOption(intScore, scoreC);
			}

			scoreList.add(intScore);
		}

		public int getNumber(int intScore, String score, int idx) {
			if (intScore == 10) {
				return 10;
			}

			if (Character.isDigit(score.charAt(idx + 1))) {
				return 10;
			}

			return score.charAt(idx) - '0';
		}

		public int getBonusAndOption(int intScore, char scoreC) {
			if (scoreC == 'S') {
				return intScore;
			}

			if (scoreC == 'D') {
				return intScore * intScore;
			}

			if (scoreC == 'T') {
				return intScore * intScore * intScore;
			}
			return getOption(intScore, scoreC);
		}

		public int getOption(int intScore, char scoreC) {
			if (scoreC == '*') {
				handleStar();
				intScore *= 2;
			}

			if (scoreC == '#') {
				intScore = -intScore;
			}

			return intScore;
		}

		public void handleStar() {
			if (scoreList.size() > 0) {
				int prevScore = scoreList.get(scoreList.size() - 1);
				scoreList.remove(scoreList.size() - 1);
				scoreList.add(prevScore * 2);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution("1D2S3T*"));
	}
}
