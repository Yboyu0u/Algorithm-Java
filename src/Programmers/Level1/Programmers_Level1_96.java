package Programmers.Level1;

public class Programmers_Level1_96 {
	private static class Solution {
		public int solution(int n) {
			int answer = 0;

			char[] str = String.valueOf(n).toCharArray();

			for(char c: str){
				answer+=c-'0';
			}

			return answer;
		}
	}
}
