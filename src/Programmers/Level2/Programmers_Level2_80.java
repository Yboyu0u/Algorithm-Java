package Programmers.Level2;

// 0과 1로 이루어진 2^n X 2^n 크기의 2차원 정수 배열 arr
// arr 을 쿼드압축
    // 1. 압축하고자 하는 특정 영역을 s라고 정의
    // 2. 만약 s 내부에 있는 모든 수가 값은 값이라면, s를 해당 수 하나로 압축
    // 3. 그렇지 않다면, s를 정확히 4개의 균일한 정사각형 영역으로 쪼갠다.
        // 각 정사각형 영역에 대해 같은 방식의 압축을 시도

// 압축했을 때, 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return


class Solution {
    static int zeroCnt;
    static int oneCnt;
    static int[][] mArr;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        mArr = arr;

        zip(0,0,arr.length,arr.length, 4);

        answer[0]=zeroCnt;
        answer[1]=oneCnt;
        return answer;
    }

    public void zip(int initY, int initX, int endY, int endX, int dir){
        boolean check=false;
        if(initY==endY){
            if(dir==2 || dir==3){
                initY++;
                endY++;
            }
            endY++;
        }
        if(initX==endX){
            if(dir==2 || dir==3){
                initX++;
                endX++;
            }
            endX++;
        }

        System.out.println(initY+" "+initX+" "+endY+" "+endX);
        int num = mArr[initY][initX];
        for(int i=initY; i<endY; i++){
            for(int j=initX; j<endX; j++){
                if(mArr[i][j]!=num){
                    check=true;
                    break;
                }
            }
            if(check) break;
        }
        if(!check){
            if(mArr[initY][initX] == 1) oneCnt++;
            else zeroCnt++;
//
//            System.out.println(zeroCnt+" "+oneCnt);

            return;
        }else{
            // 재귀 0,1,2,3
            zip(initY,initX,endY/2,endX/2,0);
            zip(initY,endX/2,endY/2,endX,1);
            zip(endY/2,initX,endY,endX/2,2);
            zip(endY/2,endX/2,endY,endX,3);
        }
    }
}

public class Programmers_Level2_80 {

    public static void main(String[] args){
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};

        new Solution().solution(arr);
    }
}
