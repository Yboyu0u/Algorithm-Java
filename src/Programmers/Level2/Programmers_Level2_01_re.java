package Programmers.Level2;


// 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현
// 문자를 n개 단위로 짤라서 압축

// 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return

public class Programmers_Level2_01_re {
	private static class Solution {
		public int solution(String s) {
			int answer = Integer.MAX_VALUE;

			if(s.length() == 1) {
				return 1;
			}

			for(int i = 1; i <= s.length()/2; i++) {
				answer = Math.min(zipByNumber(i, s).length(), answer);
			}

			return answer;
		}

		public String zipByNumber(int number, String s) {
			int zipNum = 1;
			int start = 0;
			int end = number;
			StringBuilder zipS = new StringBuilder();
			String standardS = s.substring(start,end);

			while(end < s.length()) {
				int[] beginEndArr = addIndex(start, end, number, s.length());
				start = beginEndArr[0];
				end = beginEndArr[1];

				if(standardS.equals(s.substring(start,end))) {
					zipNum ++;
					continue;
				}

				zipS = append(zipNum, zipS, standardS);

				standardS = s.substring(start,end);
				zipNum = 1;
			}

			zipS = append(zipNum, zipS, s.substring(start));

			return zipS.toString();
		}

		private int[] addIndex(int start, int end, int number, int sLen) {
			start = end;
			end += number;

			if(end > sLen) {
				end = sLen;
			}

			int[] arr = {start, end};

			return arr;
		}

		private StringBuilder append(int zipNum, StringBuilder zipS, String standardS) {
			if(zipNum > 1) {
				zipS.append(zipNum);
			}
			zipS.append(standardS);

			return zipS;
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution("a"));
	}
}
