package Programmers.Level2;

// 각 프렌즈가 원하는 조건을 입력으로 받았을 때 모든 조건을 입력으로 만족할 수 있도록 서는 경우의 수

// n: 조건의 개수
// data: 각 프렌즈가 원하는 조건이 문자열 형태로 구성
// 첫 번째 글자(주) 와 세 번째 글자(객): A C F J M N R T
// 두 번째 글자: ~
// 네 번째 글자: = < >: 같음, 미만, 초과
// 다섯 번째 글자 0이상 6 이하의 정수: 간격을 의미

// 모든 조건을 만족하는 경우의 수를 return

class Solution {
	private static final int SUBJECT_INDEX = 0;
	private static final int OBJECT_INDEX = 2;
	private static final int COMPARE_INDEX = 3;
	private static final int INTERVAL_INDEX = 4;

	private static final char[] friends1 = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	private static final boolean[] check = new boolean[8];
	private static int count;

	public int solution(int n, String[] data) {
		count = 0;
		int answer = 0;
		tracking(new char[friends1.length], 0, data);

		answer = count;
		return answer;
	}

	private void tracking(char[] photoArray, int index, String[] data) {
		if (index == friends1.length) {
			if(checkData(photoArray, data)) {
				count ++;
			}
			return;
		}

		for (int i = 0; i < friends1.length; i++) {
			if (!check[i]) {
				check[i] = true;
				photoArray[index] = friends1[i];
				tracking(photoArray, index + 1, data);
				check[i] = false;
			}
		}
	}

	private boolean checkData(char[] photoArray, String[] data) {
		boolean result;

		for (String condition : data) {
			result = true;
			char subject = condition.charAt(SUBJECT_INDEX);
			char object = condition.charAt(OBJECT_INDEX);

			int interval = -1;
			boolean check = false;
			for (char c : photoArray) {
				if (check) {
					interval++;
				}

				if (c == subject || c == object) {
					check = true;

					if (interval > -1) {
						result = checkCondition(interval, condition.charAt(COMPARE_INDEX),
							condition.charAt(INTERVAL_INDEX));
						break;
					}
				}
			}

			if (!result) {
				return false;
			}
		}

		return true;
	}

	private boolean checkCondition(int interval, char compareOperator, char intervalNumber) {
		if (compareOperator == '=') {
			return interval == intervalNumber - '0';
		}

		if (compareOperator == '>') {
			return interval > intervalNumber - '0';
		}

		if (compareOperator == '<') {
			return interval < intervalNumber - '0';
		}

		return false;
	}
}


public class Programmers_Level2_26_re {
	public static void main(String[] args) {
		String[] data = {"N~F=0", "R~T>2"};
		System.out.println(new Solution().solution(2,data));
	}
}
