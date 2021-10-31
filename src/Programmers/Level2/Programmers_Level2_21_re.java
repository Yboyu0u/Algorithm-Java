package Programmers.Level2;


// 파일명은 영문 대소문자, " ", ., - 만으로 이루어져 있다
// 파일명은 영문자로 시작하며, 숫자를 하나 이상 포함

// HEAD, NUMBER, TAIL 로 구성
    // HEAD: 숫자가 아닌 문자로 이루어져 있다.
    // NUMBER: 한 글자에서 최대 다섯 글자 사이의 연속된 숫자로 이루어져 있다, 앞쪽에 0이 올 수 있다.
    // TAIL: 그 나머지 부분, 숫자가 다시 나타날 수도 있으며, 아무 글자도 없을 수 있다.

// 문자열 비교 시 대소문자 구분하지 않는다


import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Programmers_Level2_21_re {
    private static class File implements Comparable<File>{
        private String head;
        private int number;
        private int idx;

        public File(int idx) {
            this.idx = idx;
        }

        public void setHead(String head) {
            this.head = head;
        }
        public void setNumber(int number) {
            this.number = number;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }
        public int getIdx() {
            return idx;
        }

        @Override
        public int compareTo(File file) {
            if(this.head.compareTo(file.head)==0){
                return this.number-file.number;
            }
            return this.head.compareTo(file.head);
        }
    }

    private static class Solution {
        static ArrayList<File> fileList = new ArrayList<>();
        public String[] solution(String[] files) {
            filesArrange(files);
            Collections.sort(fileList);

            String[] answer = new String[files.length];
            int idxx=0;
            for(File file: fileList){
                answer[idxx++]=files[file.getIdx()];
            }
            return answer;
        }

        public void filesArrange(String[] files){
            for(int j=0; j< files.length; j++){
                String file = files[j];
                File newFile = new File(j);
                StringBuilder sb = new StringBuilder("");
                boolean check=false;
                for(int i=0; i<file.length(); i++){
                    char c= file.charAt(i);
                    if(Character.isDigit(c)){
                        if(!check){
                            newFile.setHead(sb.toString().toLowerCase(Locale.ROOT));
                            sb=new StringBuilder("");
                            check=true;
                        }
                    }else if(!Character.isDigit(c) && check){ //tail 부분으로 들아섰을 때
                        break;
                    }
                    sb.append(c);
                }
                newFile.setNumber(Integer.parseInt(sb.toString()));
                fileList.add(newFile);
            }
        }
    }
}
