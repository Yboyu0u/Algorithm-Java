package Programmers;
import java.util.LinkedList;
import java.util.Queue;

class Alphabet{
    char[] answer;
    boolean[] check;
    int cnt;
    int idx;

    public Alphabet(char[] answer, int cnt, int idx, boolean[] check) {
        this.answer = answer;
        this.cnt = cnt;
        this.idx = idx;
        this.check = check;
    }
}

class Solution {
    static int ans;
    static Queue<Alphabet> q = new LinkedList<>();
    static char[] cName;
    static Character[] alphabets = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public int solution(String name) {
        cName = name.toCharArray();
        findAlpha(name);

        int answer=ans;
        return answer;
    }

    public void findAlpha(String name){
        char[] start = new char[name.length()];
        for(int i=0; i< start.length;i++){
            start[i]='A';
        }
        boolean[] check =  new boolean[cName.length];
        q.add(new Alphabet(start,0,0,check));

        while(!q.isEmpty()){
            Alphabet alpha = q.poll();

            char[] answer = alpha.answer;
            int cnt = alpha.cnt;
            int idx = alpha.idx;
            boolean[] chc = alpha.check;

            for(int i=0; i< alphabets.length; i++){
                if(cName[idx] == alphabets[i]){
                    cnt+=Math.min(i,26-i);
                    answer[idx] = alphabets[i];
                    break;
                }
            }
            if(String.valueOf(answer).equals(String.valueOf(cName))){
                ans = cnt;
                return;
            }
            int nIdx=idx-1;
            int nnIdx=idx+1;
            char[] nextAnswer = new char[answer.length];
            char[] nnextAnswer = new char[answer.length];
            boolean[] ch = new boolean[answer.length];
            boolean[] cch = new boolean[answer.length];
            for(int i=0; i<answer.length; i++){
                nextAnswer[i] = answer[i];
                nnextAnswer[i]=answer[i];
                ch[i] = chc[i];
                cch[i]=cch[i];
            }
            if(nIdx<0) nIdx=answer.length-1;
            if(nnIdx>=answer.length) nnIdx=0;

            if(!ch[nIdx]){
                ch[nIdx]=true;
                q.add(new Alphabet(nextAnswer,cnt+1,nIdx,ch));
            }

            if(!ch[nnIdx]){
                cch[nnIdx]=true;
                q.add(new Alphabet(nnextAnswer,cnt+1,nnIdx,cch));
            }
        }
    }
}

public class Programmers_Level2_27 {
    public static void main(String[] args){
        System.out.println(new Solution().solution("JAN"));
    }
}
