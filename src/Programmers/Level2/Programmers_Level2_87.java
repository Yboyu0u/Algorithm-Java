package Programmers.Level2;

// f(x) = x 보다 크고 x 와 비트가 1~2개 다른 수들 중에서 제일 작은 수

public class Programmers_Level2_87 {
	private static class Solution {
		public long[] solution(long[] numbers) {
			long[] answer = new long[numbers.length];
			int idx = 0;

			// 1. 각 number 의 f(x)값 구하기
			for (int i = 0; i < numbers.length; i++) {
				long num = numbers[i];
				// 2. f(x) 값 구해서 answer 에 넣기
				answer[idx++] = findFx(num);
			}

			return answer;
		}

		public long findFx(long num) {
			String biNum = Long.toBinaryString(num);

			if (num % 2 == 0) {
				return num + 1;
			}

			if(num % 2 == 1) {
				if (biNum.contains("0")) {
					for (int i = biNum.length() - 1; i >= 0; i--) {
						if (biNum.charAt(i) == '0') {
							biNum = biNum.substring(0, i) + "10" + biNum.substring(i + 2);
							break;
						}
					}
				}
				else {
					biNum = biNum.substring(0, 1) + "0" + biNum.substring(1);
				}
			}
			return Long.parseLong(biNum, 2);
		}
	}
	public static void main(String[] args) {
		long[] numbers = {7};

		new Solution().solution(numbers);
	}
}
