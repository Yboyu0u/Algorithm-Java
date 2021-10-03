package Programmers;



// someone cut the pater diagonally
// this time, Decide to use the two triangle pater pieces

// #1
//class Solution {
//    public long solution(int w, int h) {
//        long min = Math.min(w,h);
//        long max = Math.max(w,h);
//        long remain = 1;
//
//        while(remain>0){
//            remain=max%min;
//            max=min;
//            min = remain;
//        }
//        long answer = (long)w*(long)h-max*(w/max+h/max-1);
//        return answer;
//    }
//}

//#2
//class Solution{
//    public long solution(int w, int h){
//        int gcdnum = gcd(w,h);
//        long result = (long)w * (long)h - ((long)w+ (long)h - gcdnum);
//        return result;
//    }
//    public int gcd(int w, int h){
//        if(h==0){
//            return w;
//        }else{
//            return gcd(h,w%h);
//        }
//    }
//}

public class Programmers_Level2_07_ans {

    public static void main(String[] args){

    }
}
