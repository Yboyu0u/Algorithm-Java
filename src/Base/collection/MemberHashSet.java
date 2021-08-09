package Base.collection;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {

    public static void main(String[] args) {

        MemberHashSet memberHashSet = new MemberHashSet();

        Member memberLee = new Member(1001, "이순신");
        Member memberKim = new Member(1002, "김유신");
        Member memberKang = new Member(1003, "강감찬");


        memberHashSet.addMember(memberLee);
        memberHashSet.addMember(memberKim);
        memberHashSet.addMember(memberKang);
        memberHashSet.showAllMember();

        Member memberHong = new Member(1003, "홍길동");  //1003 아이디 중복
        memberHashSet.addMember(memberHong);
        memberHashSet.showAllMember();
    }


    private HashSet<Member> hashSet;

    public MemberHashSet(){
        hashSet = new HashSet<Member>();
    }
    public void addMember(Member member){
        hashSet.add(member);
    }
    public boolean removeMember(int memberId){

        Iterator<Member> ir = hashSet.iterator();
        while(ir.hasNext()){
            Member member = ir.next();
            int tempId = member.getMemberId();
            if(tempId == memberId){
                hashSet.remove(member);
                return true;
            }
        }
        return false;
    }

    public void showAllMember(){
        for(Member member : hashSet){
            System.out.println(member);
        }
        System.out.println();
    }

}
