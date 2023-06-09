package model.membermodel;

import model.Repository;

public class MemberServiceImpl implements MemberService {
    private Repository repository;

    public MemberServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void join(Member member) {
        repository.setMemberStore(member.getId(), member);
    }

    @Override
    public Member findMember(String memberId) {
        return repository.getMemberStore().get(memberId);
    }

    @Override
    public boolean findId(String memberId){
        for(String key :repository.getMemberStore().keySet())
            if(key.equals(memberId))
                return true;
        return false;
    }
}
