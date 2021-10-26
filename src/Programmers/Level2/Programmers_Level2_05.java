package Programmers.Level2;


// 기능 개선 작업을 수행 중
// 기능의 개발속도는 모두 다르다
// 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수도 있고,
// 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포된다
// Progresses: 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
// speeds: 각 작업의 개발 속도가 적힌 정수 배열
// 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능
public class Programmers_Level2_05 {
    private static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] subAns = new int[100];
            int[] answer = {};

            for(int i=0; i<progresses.length; i++){
                int day = 0;
                int plusD = 0;
                progresses[i] = 100-progresses[i];
                while(progresses[i]>0){
                    plusD = progresses[i]/speeds[i];
                    progresses[i] = progresses[i]%speeds[i];
                    if(plusD==0){
                        plusD = 1;
                        progresses[i] = 0;
                    }
                    day+=plusD;
                }
                progresses[i] = day;
            }

            int dis = progresses[0];
            int idx = 1;
            int ansIdx = 0;
            int total = 0;
            while(idx<progresses.length){
                int cnt = 1;
                for(int i=idx; i<progresses.length; i++){
                    if(dis<progresses[i]){
                        break;
                    }
                    idx++;
                    cnt++;
                }

                subAns[ansIdx++] = cnt;
                total+=cnt;

                // idx가 끝에까지 갔을 때, 끝났으면 break, 하나 남았으면 ans에 넣어주고 break
                if(idx == progresses.length || idx == progresses.length-1){
                    if(total<progresses.length){
                        subAns[ansIdx++] = 1;
                    }
                    break;
                }
                dis = progresses[idx++];
            }
            answer = new int[ansIdx];
            for(int i=0; i<ansIdx; i++){
                answer[i] = subAns[i];
            }
            return answer;
        }
    }
    public static void main(String[] args){
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] ans = new Solution().solution(progresses,speeds);
        for(int a:ans){
            System.out.print(a+" ");
        }
    }
}
