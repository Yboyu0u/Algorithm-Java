package Programmers.Level2;

// 최소 공배수: 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자
 //: n개의 수의 최소공배수는 n개의 수들의 배수 중 공통이 되는 가장 작은 숫자

// arr: n개의 숫자를 담은 배열, 이 수들의 최소공배수를 return

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_Level2_86 {
	private static class Solution {
		public int solution(int[] arr) {
			int answer = arr[0];
			for (int i = 1; i < arr.length; i++) {
				answer = lcm(answer, arr[i]);
			}
			return answer;
		}

		// 최소 공배수
		public int lcm(int a, int b) {
			return a*b/gcd(a,b);
		}

		// 최대 공약수
		public int gcd(int a, int b){
			if(a<b){
				int temp = a;
				a=b;
				b=temp;
			}
			if(b==0) return a;
			else return gcd(b,a%b);
		}
	}
	public static void main(String[] args){
		int[] arr = {18,21};
		new Solution().solution(arr);
	}
}
