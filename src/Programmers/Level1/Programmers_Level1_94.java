package Programmers.Level1;

// 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하기.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_Level1_94 {
	private static class MindString implements Comparable<MindString>{
		String s;
		int idx;
		String str;

		public MindString(String s, int idx, String str) {
			this.s = s;
			this.idx = idx;
			this.str = str;
		}

		@Override
		public int compareTo(MindString o) {
			if (s.compareTo(o.s) == 0){
				return str.compareTo(o.str);
			}

			return s.compareTo(o.s);
		}
	}

	private static class Solution {
		public String[] solution(String[] strings, int n) {
			String[] answer = new String[strings.length];
			List<MindString> list = new ArrayList<>();

			// n 번째를 인덱스와 함께 list 에 넣는다.
			for(int i=0; i<strings.length; i++){
				list.add(new MindString(String.valueOf(strings[i].charAt(n)),i,strings[i]));
			}

			// n번째 문자에 따라 정렬한다.
			Collections.sort(list);

			int idx = 0;
			// list 의 인덱스와 strings 의 인덱스 비교하면 answer 에 넣어준다.
			for(MindString ms: list){
				answer[idx++] = strings[ms.idx];
			}

			return answer;
		}
	}
}
