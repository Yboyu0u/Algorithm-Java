package Programmers.Level2;


// 그림의 난이도를 영역의 수로 정의
	// 영역: 상하좌우로 연결된 같은 색상의 공간
// 그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램

// m: y, n: x
// picture: mXn 크기의 2차원 배열, 0은 색칠하지 않는 영역

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_Level2_09_re {
	private static class Solution {
		private static final int[] dy = {-1, 1, 0, 0};
		private static final int[] dx = {0, 0, -1, 1};
		private static int[][] sPicture;
		private static boolean[][] check;
		private static final Queue<Pair> queue = new LinkedList<>();
		private static int yLen;
		private static int xLen;

		private static class Pair {
			int y;
			int x;

			public Pair(int y, int x) {
				this.y = y;
				this.x = x;
			}
		}

		public int[] solution(int m, int n, int[][] picture) {
			sPicture = picture;
			check = new boolean[m][n];
			yLen = m;
			xLen = n;

			int numberOfArea = 0;
			int maxSizeOfOneArea = 0;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (sPicture[i][j] > 0 && !check[i][j]) {
						numberOfArea++;
						queue.add(new Pair(i, j));
						check[i][j] = true;
						maxSizeOfOneArea = Math.max(bfs(), maxSizeOfOneArea);
					}
				}
			}

			int[] answer = new int[2];
			answer[0] = numberOfArea;
			answer[1] = maxSizeOfOneArea;

			return answer;
		}

		private int bfs() {
			int count = 0;

			while (!queue.isEmpty()) {
				count++;
				Pair pair = queue.poll();
				addNextPair(pair.y, pair.x);
			}

			return count;
		}

		private void addNextPair(int y, int x) {
			for (int i = 0; i < 4; i++) {
				int nextY = y + dy[i];
				int nextX = x + dx[i];

				if (isPossiblePair(nextY, nextX, y, x)) {
					check[nextY][nextX] = true;
					queue.add(new Pair(nextY, nextX));
				}
			}
		}

		private boolean isPossiblePair(int nextY, int nextX, int y, int x) {
			if (nextY >= 0 && nextY < yLen && nextX >= 0 && nextX < xLen) {
				return sPicture[nextY][nextX] == sPicture[y][x] && !check[nextY][nextX];
			}

			return false;
		}
	}

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

		new Solution().solution(m,n,picture);
	}
}
