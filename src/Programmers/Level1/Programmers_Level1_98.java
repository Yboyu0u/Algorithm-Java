package Programmers.Level1;

// 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력
// 맨 처음 왼손 엄지손가락은 *, 오른손 엄지 손가락은 #에서 시작

// 엄지손가락 사용하는 규칙
	// 엄지손가락은 상하좌우 4가지 방향으로만 이동 가능
	// 키패드 이동 한 칸은 거리로 1에 해당
	// 1,4,7 입력할 때는 왼손 엄지손가락을 사용
	// 3,6,9 입력할 때는 오른손 엄지손가락 사용
	// 2,5,8,0 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락 사용
		// 두 엄지손가락의 거리가 같다면, 손잡이에 따라 손가락 사용

// numbers: 순서대로 누를 번호가 담긴 배열
// hand: 왼손잡이인지 오른손잡이인 지를 나타내는 문자열

// 각 번호를 누른 엄지손가락이 왼손인지 오른손인 지를 나타내는 연속된 문자열 형태로 return

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_Level1_98 {
	private static class Solution {
		private static final String LEFT = "L";
		private static final String RIGHT = "R";
		private static final String LEFT_HAND = "left";
		private static final String RIGHT_HAND = "right";
		private static final int ONE = 1;
		private static final int TWO = 2;
		private static final int THREE = 3;
		private static final int FOUR = 4;
		private static final int FIVE = 5;
		private static final int SIX = 6;
		private static final int SEVEN = 7;
		private static final int EIGHT = 8;
		private static final int NINE = 9;
		private static final int ZERO = 0;
		private static final int STAR = 11;
		private static final int HASH = 12;

		public static List<List<Integer>> keypad;
		public static int currentRightNumber = STAR;
		public static int currentLeftNumber = HASH;
		public static StringBuilder answer = new StringBuilder();

		private class Position {
			int y;
			int x;

			public Position(int y, int x) {
				this.y = y;
				this.x = x;
			}
		}

		public String solution(int[] numbers, String hand) {
			initKeypad();

			for (int i = 0; i < numbers.length; i++) {
				moveTheThumb(hand, numbers[i]);
			}

			return answer.toString();
		}

		private void initKeypad() {
			keypad = new ArrayList<>() {{
				add(Arrays.asList(ONE, TWO, THREE));
				add(Arrays.asList(FOUR, FIVE, SIX));
				add(Arrays.asList(SEVEN, EIGHT, NINE));
				add(Arrays.asList(STAR, ZERO, HASH));
			}};
		}

		private void moveTheThumb(String hand, int number) {
			if (number == ONE || number == FOUR || number == SEVEN) {
				currentLeftNumber = number;
				answer.append(LEFT);
				return;
			}

			if (number == THREE || number == SIX || number == NINE) {
				currentRightNumber = number;
				answer.append(RIGHT);
				return;
			}

			handleMiddleNumber(hand, number);
		}

		private void handleMiddleNumber(String hand, int number) {
			if (!(decideDirection(getPosition(number), getPosition(currentRightNumber), getPosition(currentLeftNumber),
				number))) {
				handleHanded(hand, number);
			}
		}

		private boolean decideDirection(Position currentKeypadPosition, Position rightPosition, Position leftPosition,
			int number) {
			if (calculatePosition(currentKeypadPosition, leftPosition)
				< calculatePosition(currentKeypadPosition, rightPosition)) {
				currentLeftNumber = number;
				answer.append(LEFT);
				return true;
			}

			if (calculatePosition(currentKeypadPosition, leftPosition)
				> calculatePosition(currentKeypadPosition, rightPosition)) {
				currentRightNumber = number;
				answer.append(RIGHT);
				return true;
			}

			return false;
		}

		private Position getPosition(int position) {
			for (int i = 0; i < keypad.size(); i++) {
				for (int j = 0; j < keypad.get(i).size(); j++) {
					if (keypad.get(i).get(j) == position) {
						return new Position(i, j);
					}
				}
			}

			return null;
		}

		private int calculatePosition(Position currentKeypadPosition, Position position) {
			return Math.abs(currentKeypadPosition.y - position.y) +
				Math.abs(currentKeypadPosition.x - position.x);
		}

		private void handleHanded(String hand, int number) {
			if (hand.equals(LEFT_HAND)) {
				currentLeftNumber = number;
				answer.append(LEFT);
				return;
			}

			currentRightNumber = number;
			answer.append(RIGHT);
		}
	}
}
