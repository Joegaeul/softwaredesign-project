package model.membermodel;

public interface MemberService {

    void join(Member member);
    Member findMember(String memberId);
    boolean findId(String memberId);

}
