package Programmers.Level1;

// 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 return
// 소수: 1과 자기 자신으로만 나누어지는 수를 의미

public class Programmers_Level1_93 {
	private static class Solution {
		public int solution(int n) {
			int answer = 0;

			while (n > 1) {
				if (checkPrime(n))
					answer++;
				n--;
			}

			return answer;
		}

		private boolean checkPrime(int n) {
			for (int i = 2; i * i <= n; i++) {
				if (n % i == 0)
					return false;
			}

			return true;
		}
	}
}
