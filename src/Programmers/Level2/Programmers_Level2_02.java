package Programmers.Level2;

// 채팅방에 누군가 들어오,나가면 다음 메시지가 출력
 // [닉네임]님이 들어왔습니다.
 // [닉네임]님이 나갔습니다.
// 채팅방에서 닉네임을 변경하는 방법
 // 1. 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다
 // 2. 채팅방에서 닉네임을 변경한다
// 닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경
// record: 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열
// enter, leave, change
// 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록해라

// 아이디와 닉네임
// enter이면

import java.util.ArrayList;
import java.util.StringTokenizer;


public class Programmers_Level2_02 {
    private static class Solution {

        private static class User {
            String uid;
            String nickname;
            String state;
            int uidIdx;


            public User(int uidIdx, String state) {
                this.uidIdx = uidIdx;
                this.state = state;
            }

            public User(String uid, String nickname) {
                this.uid = uid;
                this.nickname = nickname;
            }
        }

        public String[] solution(String[] record) {
            StringTokenizer st;
            String[] answer = {};
            ArrayList<User> users = new ArrayList<>();
            ArrayList<User> usersRecord = new ArrayList<>();
            int ansCnt = 0;

            for(int i=0; i< record.length; i++){
                st = new StringTokenizer(record[i]);
                String state = st.nextToken();
                String uid = st.nextToken();
                boolean check = false;

                //enter이면 동일한 id가 있는지 check
                //true이면 nickname바꿈
                if(state.equals("Enter")){
                    String nickname = st.nextToken();
                    int uidIdx = -1;
                    for(int j=0; j<users.size(); j++){
                        if(uid.equals(users.get(j).uid)){
                            users.get(j).nickname = nickname;
                            uidIdx = j;
                            check = true;
                            break;
                        }
                    }
                    if(!check){
                        users.add(new User(uid,nickname));
                        uidIdx = users.size()-1;
                    }
                    usersRecord.add(new User(uidIdx, state));
                    ansCnt++;
                }else if(state.equals("Change")) {
                    String nickname = st.nextToken();
                    for(int j=0; j<users.size(); j++){
                        if(uid.equals(users.get(j).uid)){
                            users.get(j).nickname = nickname;
                            break;
                        }
                    }
                }else{
                    int uidIdx = -1;
                    for(int j=0; j<users.size(); j++){
                        if(uid.equals(users.get(j).uid)){
                            uidIdx = j;
                            usersRecord.add(new User(uidIdx,state));
                            break;
                        }
                    }
                    ansCnt++;
                }
            }

            answer = new String[ansCnt];
            for(int i=0; i< usersRecord.size(); i++){
                String nickname = users.get(usersRecord.get(i).uidIdx).nickname;
                String state = usersRecord.get(i).state;

                if(state.equals("Enter")){
                    answer[i] = nickname+"님이"+" "+"들어왔습니다.";
                }else{
                    answer[i] = nickname+"님이"+" "+"나갔습니다.";
                }
            }
            return answer;
        }
    }

    public static void main(String[] args){
        String[] record =  {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] ans = new Solution().solution(record);

        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}
