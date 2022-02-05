package Programmers.Level1;

// 유저들의 아이디를 생성하는 업무
// 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때,
// 입력된 아이디와 유샤하면서 규칙에 맞는 아이디를 추천해주는 프로그램 개발
// 아이디 규칙
	// 1. 아이디의 길이는 3자 이상 15자 이하
	// 2. 아이디는 알파벳 소문자, 숫자, -, _, ., 문자만 사용 가능
	// 3. .는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용 할 수 없음

// 아이디 추천 과정
	// 1. 아이디의 모든 대문자를 대응되는 소문자로 치환
	// 2. 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거
	// 3. 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
	// 4. 마침표가 처음이나 끝에 위치한다면 제거
	// 5. 아이디가 빈 문자열이라면, 아이디에 "a"를 대입
	// 6. 아이디의 길이가 16자 이상이면, 아이디의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
			// 제거 후, .가 아이디의 끝에 위치한다면 끝에 위치한 마침표를 제거
	// 7. 아이디의 길이가 2자 이하면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙인다.

import java.util.Locale;

class Solution {
	public String solution(String new_id) {

		return checkLength(checkBlank(
			removeStartAndEndPeriod(
				removeChar(new_id.toLowerCase(Locale.ROOT)))));
	}

	private String removeChar(String new_id) {
		StringBuilder new_new_id = new StringBuilder();
		char endChar = ' ';

		for (char c : new_id.toCharArray()) {
			boolean check = false;

			if (checkChar(c)) {
				check = true;
			}

			if (checkStraightPeriod(check, endChar, c)) {
				new_new_id.append(c);
				endChar = c;
			}
		}

		return new_new_id.toString();
	}

	private boolean checkChar(char c) {
		if (c >= 97 && c <= 122) {
			return true;
		}

		if (Character.isDigit(c)) {
			return true;
		}

		return c == '-' || c == '_' || c == '.';
	}

	private boolean checkStraightPeriod(boolean check, char a, char b) {
		return check && !(a == '.' && b == '.');
	}

	private String removeStartAndEndPeriod(String new_id) {
		return checkEndPeriod(checkStartPeriod(new_id));
	}

	private String checkStartPeriod(String new_id) {
		if (new_id.length() > 0 && new_id.charAt(0) == '.') {
			return new_id.substring(1);
		}

		return new_id;
	}

	private String checkEndPeriod(String new_id) {
		if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
			return new_id.substring(0, new_id.length() - 1);
		}

		return new_id;
	}

	private String checkBlank(String new_id) {
		if (new_id.length() == 0) {
			return "a";
		}

		return new_id;
	}

	private String checkLength(String new_id) {
		return checkShortFall(checkOver(new_id));
	}

	private String checkOver(String new_id) {
		if (new_id.length() > 15) {
			return checkEndPeriod(new_id.substring(0, 15));
		}

		return new_id;
	}

	private String checkShortFall(String new_id) {
		if (new_id.length() < 3) {
			return makeNewIdLenThree(new_id);
		}

		return new_id;
	}

	private String makeNewIdLenThree(String new_id) {
		StringBuilder stringBuilder = new StringBuilder(new_id);
		char endChar = new_id.charAt(new_id.length() - 1);

		while (stringBuilder.length() < 3) {
			stringBuilder.append(endChar);
		}

		return stringBuilder.toString();
	}

}

public class Programmers_Level1_99 {
}
