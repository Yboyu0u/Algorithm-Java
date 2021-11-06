package Programmers.Wooteco;


// 해외 여행은 항상 금요일에 출발하여 다음 월요일에 돌아오도록 한다

// 남은 휴가 시간을 고려하지 않은 채 비행기 시간만 고려하여 일정을 세웠다

// time: 올해 남은 휴가 시간
// plans: 여행 일정을 담은 이차원 배열 -> 여행지, 출발 시간, 도착 시간

// 월 1PM 6PM
// 금 9:30AM 6PM

// plans의  금요일 퇴근시간-출발시간 + 도착시간-월요일 출근시간
    //* 음수일때 처리

// 남은 시간 내에 갈 수 있는 여행지 중 준의 올해 마지막 여행지가 어디인지 return

public class Wooteco_6 {
    private static class Solution {
        static int FriLeave=18;
        static int MonGo=13;
        public String solution(double time, String[][] plans) {
            String answer = "";

            // 1. plans 돌면서 걸리는 시간 계산하고 time에서 빼주면서 time을 초과하면 return
            for(int i=0; i< plans.length; i++){
                String[] plan=plans[i];
                int start = FriLeave-getTime(plan[1]);
                int end = getTime(plan[2])-MonGo;

                if(start<0) start=0;
                if(end<0) end=0;

                double total = start+end;
                time-=total;

                if(time>=0) answer=plan[i];
                if(time<=0) break;
            }

            return answer;
        }

        public int getTime(String time){
            StringBuilder sb = new StringBuilder();
            int hour=0;
            for(int i=0; i<time.length(); i++){
                char c = time.charAt(i);
                if(c=='P') {
                    hour=Integer.parseInt(sb.toString())+12;
                    break;
                }
                else if(c=='A'){
                    hour = Integer.parseInt(sb.toString());
                    break;
                }
                sb.append(c);
            }
            return hour;
        }
    }
    public static void main(String[] args){

    }
}
