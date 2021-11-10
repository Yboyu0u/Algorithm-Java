package Programmers.Level1;


public class Programmers_Level1_69 {
    private static class Solution {
        public int solution(int[][] sizes) {
            int maxX=0;
            int maxY=0;
            for(int i=0; i<sizes.length; i++){
                int sX = Math.min(sizes[i][0],sizes[i][1]);
                int sY = Math.max(sizes[i][0],sizes[i][1]);

                maxX=Math.max(maxX,sX);
                maxY=Math.max(maxY,sY);
            }

            return maxX*maxY;
        }
    }
}
