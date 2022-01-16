package Programmers.Level2;

// 들어오고 나가는 메세지
	// [닉네임]님이 들어왔습니다.
	// [닉네임]님이 나갔습니다.

// 채팅방에서 닉네임을 변경하는 방법
	// 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다
	// 채팅방에서 닉네임을 변경한다

// 닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경된다

// record: 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열
	// Enter/Leave/Change,  아이디,  닉네임
// 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_Level2_02_re {
	private static class Solution {
		private class User {
			private String message;
			private String id;

			public User(String message, String id) {
				this.message = message;
				this.id = id;
			}
		}

		private static final String CHANGE = "Change";
		private static final String ENTER = "Enter";
		private static final String ENTER_MESSAGE = "님이 들어왔습니다.";
		private static final String LEAVE_MESSAGE = "님이 나갔습니다.";
		private static final int MESSAGE_INDEX = 0;
		private static final int ID_INDEX = 1;
		private static final int NICKNAME_INDEX = 2;

		private static List<User> recordList = new ArrayList<>();
		private static Map<String,String> idNicknameMap = new HashMap<>();
		private static List<String> answer = new ArrayList<>();

		public String[] solution(String[] record) {

			for (int i = 0; i < record.length; i++) {
				addList(record[i].split(" "));
			}

			getResult();

			int idx = 0;
			String[] strAnswer = new String[answer.size()];
			for(String str: answer) {
				strAnswer[idx++] = str;
			}

			return strAnswer;
		}

		private void addList(String[] rec) {
			String message = rec[MESSAGE_INDEX];
			String id = rec[ID_INDEX];

			if (message.equals(CHANGE)) {
				idNicknameMap.put(id,rec[NICKNAME_INDEX]);
				return;
			}

			if(message.equals(ENTER)) {
				idNicknameMap.put(id,rec[NICKNAME_INDEX]);
			}

			recordList.add(new User(rec[MESSAGE_INDEX], rec[ID_INDEX]));
		}

		private void getResult() {
			recordList.forEach(this::makeMessage);
		}

		private void makeMessage(User user) {
			if(user.message.equals(ENTER)) {
				answer.add(idNicknameMap.get(user.id) + ENTER_MESSAGE);
				return;
			}

			answer.add(idNicknameMap.get(user.id) + LEAVE_MESSAGE);
		}
	}
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		new Solution().solution(record);
	}
}
