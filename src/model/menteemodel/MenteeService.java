package model.menteemodel;

import model.membermodel.Member;
import model.mentormodel.Mentor;

import java.util.ArrayList;
import java.util.Set;

public interface MenteeService {
    ArrayList<Member> findAllMentor();
    void saveMyMember(String name, Member member);
    Set<Member> findMyMentor(Member member);
    String getExercise(Member member, String mentor, String date);
    String getDiet(Member member, String mentor, String date);
    void saveMyInfo(Member member, Double height, Double weight, Double muscle);
    Set<Mentor> findMyMentorInfo(Member member);
}
