package model.mentormodel;

import model.membermodel.Member;
import model.menteemodel.Mentee;

import java.util.ArrayList;
import java.util.Set;

public interface MentorService {
    void updateMentorInfo(Mentor mentor);
    ArrayList<Mentee> findMyMenteeInfo(Member member);
    Set<Member> findMyMentee(Member member);
    void saveExercise(Member member, String mentee, String date, String exercise);
    void saveDiet(Member member, String mentee, String date, String exercise);
}
