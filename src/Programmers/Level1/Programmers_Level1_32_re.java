package Programmers.Level1;


// 지도 암호를 해독할 방법
	// 지도는 한 변의 길이가 n인 정사각형 배열 형태
		// " "(공백), #(벽) 두 종류
	// 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
		// 지도 1과 지도 2 중 어느 하나라도 벽, 공백인 부분은 전체 지도에서도 벽
	// 지도는 각각 정수 배열로 암호화되어 있다
	// 암호화된 배열은 자도의 각 가로줄에서
		// 벽: 1, 공백:0 d으로 부호화했을 때 얻어지는 이진후에 해당하는 값의 배열

public class Programmers_Level1_32_re {
	private static class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];

			for (int i = 0; i < n; i++) {
				answer[i] = convertNumberToCode(Integer.toBinaryString(arr1[i]),
					Integer.toBinaryString(arr2[i]), n);
			}
			return answer;
		}

		public String convertNumberToCode(String a, String b, int n) {
			StringBuilder sb = new StringBuilder();
			a = checkStringLength(a, n);
			b = checkStringLength(b, n);

			for (int i = 0; i < n; i++) {
				if (a.charAt(i) == '1' || b.charAt(i) == '1') {
					sb.append('#');
					continue;
				}

				if (a.charAt(i) == '0' || b.charAt(i) == '0') {
					sb.append(' ');
				}
			}
			return sb.toString();
		}

		public String checkStringLength(String str, int n) {
			while (str.length() < n) {
				str = "0" + str;
			}

			return str;
		}
	}
	public static void main(String[] args) {
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		new Solution().solution(5,arr1,arr2);
	}
}
