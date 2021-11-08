package Programmers.Level2;


// Ax + By + C = 0 으로 표현할 수 있는 n개 의 직선
// 이 직선의 교점 중 정수 좌표에 별을 그리려 한다

import java.util.HashSet;
import java.util.Objects;

public class Programmers_Level2_64 {
    private static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return y == pair.y && x == pair.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    private static class Solution {
        static int posYMax = Integer.MIN_VALUE;
        static int nevYMax = Integer.MAX_VALUE;
        static int posXMax = Integer.MIN_VALUE;
        static int nevXMax = Integer.MAX_VALUE;
        public String[] solution(int[][] line){
            HashSet<Pair> set = new HashSet<>();

            // 1. line 의 선들을 하나 씩 매칭해 map 에 넣는다
            for(int i=0; i<line.length-1; i++){
                int[] line1 = line[i];
                for(int j=i+1; j<line.length; j++){
                    int[] line2 = line[j];

                    long bot = ((long)(line1[0])*(long)(line2[1])-(long)(line1[1])*(long)(line2[0]));
                    if(bot==0) continue;
                    long xTop = ((long)(line1[1])*(long)(line2[2])-(long)(line1[2])*(long)(line2[1]));
                    long yTop = ((long)(line1[2])*(long)(line2[0])-(long)(line1[0])*(long)(line2[2]));


                    // 1-1. 넣을 때 x,y 중 하나라도 정수가 아니면 거른다
                    if(!intCheck(bot,yTop,xTop)) continue;

                    // 1-2. 절대값 최대 x값과 최대 y값을 알아낸다
                    checkMax((int)(yTop/bot),(int)(xTop/bot));

                    set.add(new Pair((int)(yTop/bot),(int)(xTop/bot)));
                }
            }

            // 2. 격자판을 만들고 교점에 *, 교점 아니면 . 으로 표현
            String[] answer = new String[(int) (posYMax-nevYMax+1)];
            int idx=0;
            for(int i=posYMax; i>=nevYMax; i--){
                StringBuilder sb = new StringBuilder();
                for(int j=nevXMax; j<=posXMax; j++){
                    if(set.contains(new Pair(i,j)))sb.append('*');
                    else sb.append('.');
                }
                answer[idx++]=sb.toString();
            }
            return answer;
        }

        public boolean intCheck(long bot, long yTop, long xTop){
            if(yTop%bot!=0 || xTop%bot!=0) return false;
            return true;
        }

        public void checkMax(int y, int x){
            posYMax = Math.max(y,posYMax);
            nevYMax = Math.min(y,nevYMax);
            posXMax = Math.max(x,posXMax);
            nevXMax = Math.min(x,nevXMax);
        }
    }
}
