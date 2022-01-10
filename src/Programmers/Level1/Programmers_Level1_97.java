package Programmers.Level1;

// NXN 크기의 정사각 격자, 위쪽에는 크레인 오른쪽에는 바구니
// 인형이 격자의 가장 아래 칸부터 차곡차고 쌓여있다
// 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있다
// 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라진다

// board: 게임 화면의 격자의 상태가 담긴 2차원 배열
// moves: 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열
	// 0은 빈 칸. 1~100의 각 숫자는 각기 다른 인형의 모양을 의미

// 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return

import java.util.Stack;

public class Programmers_Level1_97 {
	private static class Solution {
		public static int[][] sBoard;
		public static Stack<Integer> basket = new Stack<>();
		public static int answer;

		public int solution(int[][] board, int[] moves) {
			sBoard = board;

			for (int i = 0; i < moves.length; i++) {
				catchADoll(moves[i]);
			}

			return answer;
		}

		public void catchADoll(int move) {
			for (int i = 0; i < sBoard.length; i++) {
				int doll = sBoard[i][move - 1];

				if (doll > 0) {
					addADollInBasket(doll);
					sBoard[i][move - 1] = 0;
					break;
				}
			}
		}

		public void addADollInBasket(int doll) {
			boolean check = false;

			if (!basket.isEmpty()) {
				check = killDolls(doll);
			}

			if (!check) {
				basket.push(doll);
			}
		}

		public boolean killDolls(int doll) {
			if (basket.peek() == doll) {
				basket.pop();
				answer += 2;
				return true;
			}

			return false;
		}
	}
	public static void main(String[] args) {
		int[][] dolls = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(new Solution().solution(dolls,moves));
	}
}
