package Programmers.Level1;

// array 의 각 원소 중 divisor 로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 return
// 나누어 떨어지는 원소가 하나도 없다면 배열에 -1담아 return

import java.util.ArrayList;
import java.util.Collections;

public class Programmers_Level1_90 {
	private static class Solution {
		public int[] solution(int[] arr, int divisor) {
			int[] answer = {};
			ArrayList<Integer> list = new ArrayList<>();

			for(int i=0; i<arr.length; i++){
				if(arr[i]%divisor==0) list.add(arr[i]);
			}


			int idx = 0;
			if(list.size()==0){
				answer = new int[1];
				answer[idx] = -1;
				return answer;
			}

			Collections.sort(list);
			answer = new int[list.size()];
			for(int i: list){
				answer[idx++] = i;
			}

			return answer;
		}
	}
}
