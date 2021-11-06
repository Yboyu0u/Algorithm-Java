package Programmers.Wooteco;


// 어플리케이션을 이용하여 공부한 시간을 기록
// 어플리케이션의 기능
    // 1. 시작버튼: 공부를 시작할 때의 시각 기록
    // 2. 중지버튼: 공부를 중지할 때의 시각을 기록

    //* 1. 공부를 시작하고 5분이 지나기 전에 중지했다면 실제로 공부한 시간에 포함시키지 않는다
            //-> 5분부터는 기록
    //* 2. 공부를 시작하고 1시간 45분 = 105분이 넘어서 중지했다면 1시간 45분까지만 공부한 시간으로 인정

//log: 어플리케이션의 기록을 담은 문자열 배열  [시작, 중지, 시작, 중지] 형태

//HH:MM 형태로 return
    //* 이때 시나 분이 한자리라면 왼쪽에 0을 채워 return


public class Wooteco_2 {
    private static class Solution {
        public String solution(String[] log){
            int totalTime=0;

            for(int i=0; i<log.length-1; i++){
                String start = log[i];
                String end = log[i+1];
                int studyTime = calStudyTime((60*Integer.parseInt(end.substring(0,2))+Integer.parseInt(end.substring(3)))-(60*Integer.parseInt(start.substring(0,2))+Integer.parseInt(start.substring(3))));
                totalTime+=studyTime;
                i++;
            }
            String answer = getResult(totalTime);
            return answer;
        }

        public int calStudyTime(int studyTime){
            if(studyTime<5) studyTime=0;
            else if(studyTime>105) studyTime=105;

            return studyTime;
        }

        public String getResult(int totalTime){
            StringBuilder sb = new StringBuilder();
            int hour = totalTime/60;
            int min = totalTime%60;

            if(hour<10) sb.append('0');
            sb.append(String.valueOf(hour)+':');
            if(min<10) sb.append('0');
            sb.append(String.valueOf(min));

            return sb.toString();
        }
    }
    public static void main(String[] args) {
        String[] log = {"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};

        new Solution().solution(log);
    }
}
