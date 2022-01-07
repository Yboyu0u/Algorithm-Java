package Programmers.Level1;

public class Programmers_Level1_32_another {
	private static class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] result = new String[n];
			for(int i = 0; i < n; i++) {
				result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
			}

			for(int i=0; i<n; i++) {
				result[i] = String.format("%" + n + "s", result[i]);
				result[i] = result[i].replaceAll("1","#");
				result[i] = result[i].replaceAll("0"," ");
			}

			return result;
		}
	}
}
