package Programmers.Level2;

// 1차원 배열 만들기
    // 1. n행 n열 크기의 비어잇는 2차원 배열을 만든다
    // 2. 1행 1열부터 i행 i열 까지의 영역 내의 모든 빈 칸을 숫자 i로 채운다
    // 3. 1행부터 n행 까지 잘라내어 모두 이어붙인 1차원 배열을 만든다
    // 4. idx: left ~ right+1까지 잘라낸 배열 return

public class Programmers_Level2_61{
    private static class Solution{
        static long[] answer;
        public long[] solution(int n, long left, long right){
            answer = new long[(int) (right-left+1)];
            makeArr(n,left,right);
            return answer;
        }

        public void makeArr(int n, long left, long right){
            int idx=0;
            for(long i=left; i<right+1; i++){
                long x=i/n;
                long y=i%n;
                answer[idx++]=Math.max(x,y)+1;
            }
        }
    }
    public static void main(String[] args){
        new Solution().solution(3,2,5);
    }
}
