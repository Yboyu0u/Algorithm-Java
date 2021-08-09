package Base.collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class MyCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return (o1.compareTo(o2)) * (-1);
    }
}

public class MemberTreeSet {

    public static void main(String[] args) {

        MemberTreeSet memberTreeSet = new MemberTreeSet();

        Member memberKim = new Member(1003, "김유신");
        Member memberLee = new Member(1001, "이순신");
        Member memberKang = new Member(1002, "강감찬");

        memberTreeSet.addMember(memberKim);
        memberTreeSet.addMember(memberLee);
        memberTreeSet.addMember(memberKang);
        memberTreeSet.showAllMember();

    }

    private TreeSet<Member> treeSet;

    public MemberTreeSet(){
        treeSet = new TreeSet<Member>();
    }

    public void addMember(Member member){
        treeSet.add(member);
    }

    public boolean removeMember(int memberId){

        Iterator<Member> ir = treeSet.iterator();

        while( ir.hasNext()){
            Member member = ir.next();
            int tempId = member.getMemberId();
            if( tempId == memberId){
                treeSet.remove(member);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다");
        return false;
    }

    public void showAllMember(){
        for(Member member : treeSet){
            System.out.println(member);
        }
        System.out.println();
    }
}
