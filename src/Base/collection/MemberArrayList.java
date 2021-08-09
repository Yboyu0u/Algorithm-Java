package Base.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberArrayList {

    private ArrayList<Member> arrayList;  // ArrayList 선언

    public MemberArrayList(){
        arrayList = new ArrayList<Member>();  //멤버로 선언한 ArrayList 생성
    }

    public void addMember(Member member){  //ArrayList 에 멤버 추가
        arrayList.add(member);
    }

    public boolean removeMember(int memberId){  // 멤버 아이디를 매개변수로, 삭제 여부를 반환

        Iterator<Member> ir = arrayList.iterator();
        while(ir.hasNext()){
            Member member = ir.next();
            int tempId = member.getMemberId();
            if(tempId == memberId){
                arrayList.remove(member);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다");  //for 가 끝날때 까지 return 이 안된경우
        return false;
    }

    public void showAllMember(){
        for(Member member : arrayList){
            System.out.println(member);
        }
        System.out.println();
    }
}

