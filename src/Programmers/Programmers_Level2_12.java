package Programmers;


// rows X columns 크기인 행렬
// 행렬에는 1부터 rows X columns 까지의 숫자가 한 줄씩 순서대로 적혀있다
// 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 한다
// 각 회전은 (x1, y1, x2, y2) 전수 4개로 표현
// x1행 y1열 부터 x2행 y2열까지의 영역에 해당하는 직사각형 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전
// rows: 행 개수 y
// columns: 열 개수 x
// queries: 회전들의 목록
// 각 회전들을 배열에 적용한 뒤,
// 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return

public class Programmers_Level2_12 {

    private static class Solution {
        public static int[] solution(int rows, int columns, int[][] queries){
            int[] answer = {};
            int[][] matrix = new int[rows+1][columns+1];
            int num = 1;
            answer = new int[queries.length];

            for(int i=1; i<=rows; i++){
                for(int j=1; j<=columns; j++){
                    matrix[i][j] = num++;
                }
            }

            for(int i=0; i<queries.length; i++){
                int[] query = queries[i];
                int topY = query[0];
                int topX = query[1];
                int botY = query[2];
                int botX = query[3];
                int temp = matrix[topY][topX];
                int ttemp = matrix[topY][topX];
                int min = matrix[topY][topX];

                System.out.println(matrix[topY+1][topX]);

                //1. 상 //y=topY
                for(int j=topX; j<=botX; j++){
                    if(j==topX){
                        matrix[topY][j]=matrix[topY+1][topX];
                    }else{
                        ttemp = matrix[topY][j];
                        matrix[topY][j]=temp;
                        temp = ttemp;
                    }
                    min = Math.min(min,temp);
                }

                //2. 우  //x=botX
                for(int j=topY+1; j<=botY; j++){
                    ttemp = matrix[j][botX];
                    matrix[j][botX]=temp;
                    temp = ttemp;
                    min = Math.min(min,temp);
                }

                //3. 하 //y=botY
                for(int j=botX-1; j>=topX; j--){
                    ttemp = matrix[botY][j];
                    matrix[botY][j]=temp;
                    temp = ttemp;
                    min = Math.min(min,temp);
                }

                //4. 좌 //x=topX
                for(int j=botY-1; j>=topY; j--){
                    ttemp = matrix[j][topX];
                    matrix[j][topX]=temp;
                    temp = ttemp;
                    min = Math.min(min,temp);
                }
                answer[i]=min;
            }
            return answer;
        }
    }


    public static void main(String[] args){
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int[] result = new Solution().solution(6,6,queries);
        for(int a: result){
            System.out.println(a);
        }
    }
}
