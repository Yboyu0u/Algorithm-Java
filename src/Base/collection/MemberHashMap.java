package Base.collection;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {

    public static void main(String[] args) {

        MemberHashMap memberHashMap = new MemberHashMap();


        Member memberLee = new Member(1001, "이순신");
        Member memberKim = new Member(1002, "김유신");
        Member memberKang = new Member(1003, "강감찬");
        Member memberHong = new Member(1004, "홍길동");

        memberHashMap.addMember(memberLee);
        memberHashMap.addMember(memberKim);
        memberHashMap.addMember(memberKang);
        memberHashMap.addMember(memberHong);

        memberHashMap.showAllMember();

        memberHashMap.removeMember(1004);
        memberHashMap.showAllMember();
    }



    private HashMap<Integer, Member> hashMap;

    public MemberHashMap(){
        hashMap = new HashMap<Integer,Member>();
    }

    public void addMember(Member memeber){
        hashMap.put(memeber.getMemberId(),memeber);
    }

    public boolean removeMember(int memberId){
        if(hashMap.containsKey((memberId))){
            hashMap.remove(memberId);
            return true;
        }
        System.out.println(memberId + "가 존재하지 않습니다");
        return false;
    }

    public void showAllMember(){
        Iterator<Integer> ir = hashMap.keySet().iterator();
        while(ir.hasNext()){
            int key = ir.next();
            Member member = hashMap.get(key);
            System.out.println(member);
        }
    }
}
