package model;

import model.membermodel.Member;
import model.menteemodel.Mentee;
import model.mentormodel.Mentor;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    Map<String, Member> memberStore = new HashMap<>();
    Map<String, Mentor> mentorStore = new HashMap<>();
    Map<String, Mentee> menteeStore = new HashMap<>();

    public Map<String, Member> getMemberStore() {
        return memberStore;
    }

    public void setMemberStore(String id, Member member) {
        memberStore.put(id, member);
    }

    public Map<String, Mentor> getMentorStore() {
        return mentorStore;
    }

    public void setMentorStore(String mentorId, Mentor mentor) {
        mentorStore.put(mentorId, mentor);
    }

    public Map<String, Mentee> getMenteeStore() {
        return menteeStore;
    }

    public void setMenteeStore(String memberId, Mentee mentee) {
        menteeStore.put(memberId, mentee);
    }
}
