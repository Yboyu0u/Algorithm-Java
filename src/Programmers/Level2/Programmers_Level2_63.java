package Programmers.Level2;

// 재생시작 시간, 재생 끝난 시간, 음악 제목,  악보
// C, C#, D, D#, E, F, F#, G, G#, A, A#, B
// C#, D#, F#, G#, A# -> 3, 4, 6, 7, 1

// 음악은 반드시 처음부터 재생된다
// 재생된 시간이 길 때는 음악이 끊김없이 처음부터 반복해서 재생된다
// 음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다
    // 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환
    // 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환
    // 조건이 일치하는 음악이 없을 때에는 None을 반환

// m: 입력으로 네오가 기억한 멜로디를 담은 문자열
// musicinfos: 방송된 곡의 정보를 담고 있는 배열


import java.util.ArrayList;
import java.util.Collections;

public class Programmers_Level2_63 {
    private static class Music implements Comparable<Music>{
        String name;
        int len;

        public Music(String name, int len) {
            this.name = name;
            this.len = len;
        }

        @Override
        public int compareTo(Music o){
            return o.len-this.len;
        }
    }

    private static class Solution {
        static ArrayList<Music> list= new ArrayList<>();
        public String solution(String m, String[] musicinfos){
            String answer = "(None)";
            m = changeMelody(m);
            for(int i=0; i< musicinfos.length; i++){
                String[] music = musicinfos[i].split(",");
                int end = 60*Integer.parseInt(music[1].substring(0,2))+Integer.parseInt(music[1].substring(3));
                int start= 60*Integer.parseInt(music[0].substring(0,2))+Integer.parseInt(music[0].substring(3));
                String melodyBylen = makeMusicByTime(changeMelody(music[3]),end-start);
                if(melodyBylen.contains(m)) list.add(new Music(music[2],end-start));
            }
            if(!list.isEmpty()){
                Collections.sort(list);
                answer = list.get(0).name;
            }
            return answer;
        }

        public String changeMelody(String melody){
            melody=melody.replaceAll("C#","3");
            melody=melody.replaceAll("D#","4");
            melody=melody.replaceAll("F#","6");
            melody=melody.replaceAll("G#","7");
            melody=melody.replaceAll("A#","1");

            return melody;
        }

        public String makeMusicByTime(String melody, int len){
            int idx=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<len; i++){
                sb.append(melody.charAt(idx++));
                if(idx==melody.length()) idx=0;
            }
            return sb.toString();
        }
    }
    public static void main(String[] args){
        String m="ABC";
        String[] music = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        new Solution().solution(m,music);
    }
}
