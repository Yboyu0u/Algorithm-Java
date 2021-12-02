package Programmers.Level1;

// 양의 정수 x가 하샤드 수이려면 x의 자릿의 합으로 x가 나누어져야 한다

public class Programmers_Level1_91 {
	private static class Solution {
		public boolean solution(int x) {
			boolean answer = true;
			String arr = String.valueOf(x);

			int sum=0;
			for(char c: arr.toCharArray()){
				sum+=c-'0';
			}

			if(x%sum!=0) {
				answer=false;
			}
			return answer;
		}
	}
}
