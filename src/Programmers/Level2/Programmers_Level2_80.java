package Programmers.Level2;

// 0과 1로 이루어진 2^n X 2^n 크기의 2차원 정수 배열 arr
// arr 을 쿼드압축
    // 1. 압축하고자 하는 특정 영역을 s라고 정의
    // 2. 만약 s 내부에 있는 모든 수가 값은 값이라면, s를 해당 수 하나로 압축
    // 3. 그렇지 않다면, s를 정확히 4개의 균일한 정사각형 영역으로 쪼갠다.
        // 각 정사각형 영역에 대해 같은 방식의 압축을 시도

// 압축했을 때, 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return


public class Programmers_Level2_80 {
    private static class Solution {
        static int[][] mArr;
        static int zeroCnt;
        static int oneCnt;
        public int[] solution(int[][] arr) {
            int[] answer = new int[2];
            mArr=arr;


            // 1. 확인하고 압축이 안되면 계속 사분할
            zip(0,0,arr.length, arr.length,arr.length);

            answer[0]=zeroCnt;
            answer[1]=oneCnt;
            return answer;
        }

        public void zip(int startY, int startX, int endY, int endX, int len){

            int cri = mArr[startY][startX];
            boolean check = false;
            for(int i=startY; i<endY; i++){
                for(int j=startX; j<endX; j++){
                    if(cri!=mArr[i][j]){
                        check=true;
                        break;
                    }
                }
                if(check) break;
            }
            if(!check){
                if(cri==1) oneCnt++;
                else zeroCnt++;
                return;
            }

            len/=2;
            // 0,1,2,3
            zip(startY,startX,startY+len,startX+len,len);
            zip(startY,startX+len,startY+len,endX,len);
            zip(startY+len,startX,endY,startX+len,len);
            zip(startY+len,startX+len,endY,endX,len);
        }
    }

    public static void main(String[] args){
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};

        new Solution().solution(arr);
    }
}
