package Programmers.Level2;




// 파일 저장소 서버 관리
// 버전 번호와 숫자가 포함된 파일 목록은 여러 면에서 관리가 불편
// 단순한 문자 코드 순이 아닌,
// 파일명에 포함된 숫자를 반영한 정렬 기능을 저장소 관리 프로그램에 구현
// 파일명은 크게 HEAD, NUMBER, TAIL 의 세 부분

// HEAD: 숫자가 아닌 문자로 이루어져 있으며, 최소한 한 글자 이상
// NUMBER: 한 글자에서 최대 다섯 글자 사이의 연속된 숫자로 이루어져 있다. 앞쪽에 0이 올수 있다
// TAIL: 그 나머지 부분, 숫자가 다시 나타날 수도 있으며, 아무 글자도 없을 수 있다

// 1. HEAD 부분을 기준으로 사전 순으로 정렬
// 2. NUMBER의 숫자 순으로 정렬: 숫자 앞의 0은 무시 -> 정렬 시에 같은 값으로 처리
// 3. 두 파일의 HEAD부붙과 NUMBER 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지

// 파일 정렬 프로그램을 구현하라.

// files: 1000개 이하의 파일명을 포함하는 문자열 배열
        // 100글자 이하, 영문 대소문자, 숫자, 공백" ", ., - 만으로 이루어져 있다

// 중복된 파일명은 없지만, 대소문자나 숫자 앞부분의 0 차이가 있는 경우는 함께 주어질 수 있다

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;



public class Programmers_Level2_21 {
    private static class File implements Comparable<File>{
        String head;
        Integer number;
        int idx;

        public void setIdx(int idx) {
            this.idx = idx;
        }
        public File(int idx) {
            this.idx = idx;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public int compareTo(File file) {
            if(this.head.compareTo(file.head)==0){
                return this.number.compareTo(file.number);
            }
            return this.head.compareTo(file.head);
        }
    }

    private static class Solution {
        public String[] solution(String[] files) {
            ArrayList<File> tFiles = new ArrayList<>();

            for(int i=0; i<files.length; i++){
                File filee = new File(i);
                boolean check = false;
                boolean  numCheck = false;
                String file = files[i];
                int numFirstIdx = 0;
                String head = "";
                String number = "";

                for(int j=0; j<file.length(); j++){
                    if(String.valueOf(file.charAt(j)).matches("^[0-9]$") && check==false){
                        head = file.substring(0,j);
                        filee.setHead(head.toLowerCase(Locale.ROOT));
                        numFirstIdx = j;
                        check = true;
                    }

                    if(check == true && !(String.valueOf(file.charAt(j)).matches("^[0-9]$"))){
                        number = file.substring(numFirstIdx,j);
                        filee.setNumber((Integer.parseInt(number)));
                        numCheck = true;
                        break;
                    }
                }

                if(!numCheck){
                    number = file.substring(numFirstIdx,file.length());
                    filee.setNumber((Integer.parseInt(number)));
                }

                tFiles.add(filee);
            }

            Collections.sort(tFiles);

            String[] answer = new String[files.length];
            int cnt = 0;
            for(File f: tFiles){
                answer[cnt++] = files[f.idx];
            }
            return answer;
        }
    }


    public static void main(String[] args){
        String[] files = {"F-14", "B-08 Superfortress", "A-10 Thunderbolt II", "F-5 Tomcat","B-50 Superfortress"};
        String[] ans = new Solution().solution(files);

        for(String a: ans){
            System.out.print(a+" ");
        }
    }
}
