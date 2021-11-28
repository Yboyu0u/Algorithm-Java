package Programmers.Level2;

public class Programmers_Level2_85 {
	private static class Solution {
		public int solution(int n) {
			int a=0;
			int answer=1;

			for(int i=2; i<=n; i++){
				int sub = a;
				a=answer;
				answer=(answer+sub)%1234567;
			}

			return answer;
		}
	}
}
