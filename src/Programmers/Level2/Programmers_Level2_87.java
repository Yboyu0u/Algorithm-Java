package Programmers.Level2;

// f(x) = x 보다 크고 x 와 비트가 1~2개 다른 수들 중에서 제일 작은 수

// class Solution {
// 	public long[] solution(long[] numbers) {
// 		long[] answer = new long[numbers.length];
// 		int idx = 0;
//
// 		// 1. 각 number 의 f(x)값 구하기
// 		for (int i = 0; i < numbers.length; i++) {
// 			long num = numbers[i];
// 			// 2. f(x) 값 구해서 answer 에 넣기
// 			answer[idx++] = findFx(num);
// 		}
//
// 		return answer;
// 	}
//
// 	public long findFx(long num) {
// 		StringBuilder biNum = new StringBuilder(Long.toBinaryString(num));
//
// 		if(num%2 == 0){
// 			return num+1;
// 		}
//
// 		else{
// 			long fNum = num;
//
// 			boolean check = false;
// 			while (!check) {
// 				fNum++;
// 				String fBiNum = Long.toBinaryString(fNum);
//
// 				if (fBiNum.length() != biNum.length()) {
// 					biNum.insert(0,'0');
// 				}
//
// 				int cnt = 0;
// 				for (int i = fBiNum.length() - 1; i >= 0; i--) {
// 					if (biNum.charAt(i) != fBiNum.charAt(i)) {
// 						cnt++;
// 					}
//
// 					if (cnt > 2 ) {
// 						break;
// 					}
//
// 				}
//
// 				if (cnt == 2 || cnt == 1) {
// 					check = true;
// 				}
// 			}
//
// 			return fNum;
// 		}
// 	}
// }

public class Programmers_Level2_87 {
	public static void main(String[] args) {
		long[] numbers = {7};

		new Solution().solution(numbers);
	}
}
