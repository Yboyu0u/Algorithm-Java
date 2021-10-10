package Programmers;


// 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발
// 작업 수행
 // 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼낸다
 // 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면
 //    J를 대기목록의 가장 마지막에 넣는다
 // 3. 그렇지 않으면 J를 인쇄한다

// priorities: 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열
// location: 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는 지를 알려누는 매개변수
// 숫자가 클 수록 중요한 문서
// 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return


import java.util.LinkedList;
class Document{
    int name;
    int priority;

    public Document(int name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<Document> docs = new LinkedList<>();
        int answer = 0;

        // 클래스 List에 넣는다
        for(int i=0; i<priorities.length; i++){
            docs.add(new Document(i,priorities[i]));
        }

        while(docs.size()>0){
            answer++;
            Document maxDoc = docs.get(0);
            int beRevIdx = 0;
            for(int i=1; i<docs.size(); i++){
                Document comDoc = docs.get(i);
                if(maxDoc.priority < comDoc.priority){
                    maxDoc = comDoc;
                    beRevIdx = i;
                }
            }
            int name = docs.get(beRevIdx).name;
            if(location == name){
                break;
            }
            docs.remove(beRevIdx);
            for(int j=0; j<beRevIdx; j++){
                Document temp = docs.get(0);
                docs.remove(0);
                docs.addLast(temp);
            }
        }
        return answer;
    }
}

public class Programmers_Level2_11 {
    public static void main(String[] args){
        int[] p = {2, 3, 3, 2, 9, 3, 3};
        int loc = 3;

        System.out.println(new Solution().solution(p,loc));
    }
}
