package Programmers.Level2;

// 본래 닉네임이 아닌 가상의 닉네임 사용

    // 1. [닉네임]님이 들어왔습니다.
    // 2. [닉네임]님이 나갔습니다.

// 닉네임 변경하는 방법
    // 1. 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다
    // 2. 채팅방에서 닉네임을 변경한다
// 닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경
// 나간후 다시 돌어올 때, 다른 닉네임으로 들어올 경우 기존에 채팅방에 있던 메시지도 바뀐다

// record: 닉네임을 변경한 기록이 담긴 문자열 배열
    // (Enter, Change, Leave)   (아이디)   (닉네임)

// 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메세지를 문자열 배열 형태로 return


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class User{
    String msg;
    String id;

    public User(String msg, String id) {
        this.msg = msg;
        this.id = id;
    }
}


class Solution {
    public String[] solution(String[] record) {
        Map<String,String> map = new HashMap<>();
        ArrayList<User> list = new ArrayList<>();

        // 1. record 를 분해해서 map(아이디와 닉네임) 과 list(msg 와 아이디) 에 넣는다.
            // 1-1. change 라면 map의 닉네임 값 바꾼다. Leave면 map에는 넣지 않는다.
        for(String s: record){
            String[] rec = s.split(" ");
            String msg = rec[0];
            String id = rec[1];
            if(msg.equals("Enter") || msg.equals("Change")){
                String nickname = rec[2];
                map.put(id,nickname);
            }
            if(msg.equals("Enter") || msg.equals("Leave")){
                list.add(new User(msg,id));
            }
        }

        String[] answer = new String[list.size()];
        int idx=0;
        for(User user: list){
            String msg = user.msg;
            String nickname = map.get(user.id);
            StringBuilder sb = new StringBuilder();
            sb.append(nickname+"님이 ");
            if(msg.equals("Enter")){
                sb.append("들어왔습니다.");
            }else{
                sb.append("나갔습니다.");
            }

            answer[idx++] = sb.toString();
        }

        return answer;
    }
}


public class Programmers_Level2_73 {

}
