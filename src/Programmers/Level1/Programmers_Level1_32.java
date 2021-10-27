package Programmers.Level1;

// 지도 암호 해독
// 1. 지도는 한 변의 길이가 n인 정사각형 배열 형태, 각 칸은 " "(공백) 또는 #(벽)
// 2. 지도1과 지도2
// 3. 지도는 정수 배열로 암호화
// 4. 암호화된 배열은 지도의 각 가로줄에서 벽부분을 1, 공백부분을 0으로 부보화했을 때 얻어지는 이진수에 해당하는 값의 배열

// 1-># 0->" "

import java.util.ArrayList;

public class Programmers_Level1_32 {
    private static class Solution {
        static ArrayList<String> decodedMap = new ArrayList<>();
        public String[] solution(int n, int[] arr1, int[] arr2) {
            int len = arr1.length;
            // 1. 지도의 숫자를 이진수로 바꿔서
            for(int i=0; i<len; i++){
                String arr1Num = Integer.toBinaryString(arr1[i]);
                String arr2Num = Integer.toBinaryString(arr2[i]);
                decode(arr1Num,arr2Num,n);
            }
            String[] answer = new String[decodedMap.size()];
            int idx=0;
            for(String str: decodedMap){
                answer[idx++]=str;
            }
            return answer;
        }

        public void decode(String num1, String num2, int n){
            while(num1.length()<n) num1 = "0"+num1;
            while(num2.length()<n) num2 = "0"+num2;
            String result = "";
            for(int i=0;i<n;i++){
                if(num1.charAt(i)=='1'||num2.charAt(i)=='1'){
                    result+="#";
                }else{
                    result+=" ";
                }
            }
            decodedMap.add(result);
        }
    }

    public static void main(String[] args){
        int[] arr1= {9, 20, 28, 18, 11};
        int [] arr2 = {30, 1, 21, 17, 28};
        String[] ans = new Solution().solution(5,arr1,arr2);

        for(String a: ans){
            System.out.print(a+"      ");
        }
        System.out.println();
    }
}
