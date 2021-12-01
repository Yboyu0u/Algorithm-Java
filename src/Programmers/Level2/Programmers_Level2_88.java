package Programmers.Level2;


// 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U' 만을 사용하여 만들 수 있는,
// 길이 5 이하의 모든 단어가 수록되어 있다

// word 가 주어졌을 때, 이 단어가 사전에서 몇 번째 단어인지 return


public class Programmers_Level2_88 {
	private static class Solution {
		static int answer;
		static boolean check;
		static String dir = "AEIOU";
		public int solution(String word) {

			findOrder(word,"");
			System.out.println(answer);
			return answer;
		}

		public void findOrder(String word, String com){
			if(com.equals(word)){
				check=true;
				return;
			}

			if(com.length()>=5){
				return;
			}

			for(int i=0; i<dir.length(); i++){
				if(!check){
					answer++;
					findOrder(word,com+(dir.charAt(i)));
				}
			}
		}
	}

	public static void main(String[] args){
		new Solution().solution("I");
	}

}
