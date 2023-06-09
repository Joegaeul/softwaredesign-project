package model.mentormodel;

import model.Repository;
import model.membermodel.Member;
import model.menteemodel.Mentee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MentorServiceImpl implements MentorService {
    private Repository repository;

    public MentorServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void updateMentorInfo(Mentor mentor) {
        repository.setMentorStore(mentor.getId(), mentor);
    }

    @Override
    public ArrayList<Mentee> findMyMenteeInfo(Member member) {
        ArrayList<Mentee> myMenteeList = new ArrayList<>();
        Set<Member> myMemberList = member.getMyMemberList();
        for(Member m : myMemberList){
            if(repository.getMenteeStore().containsKey(m.getId())){
                myMenteeList.add(repository.getMenteeStore().get(m.getId()));
            }
            else{
                Mentee mentee = new Mentee(m, null, null, null);
                myMenteeList.add(mentee);
            }
        }
        return myMenteeList;
    }

    @Override
    public Set<Member> findMyMentee(Member member) {
        return member.getMyMemberList();
    }

    @Override
    public void saveExercise(Member mentor, String mentee, String date, String exercise) {
        Set<Member> myMemberList = mentor.getMyMemberList();
        for (Member select : myMemberList) {
            if (select.getName().equals(mentee)) {
                Map<String, Map<String, String>> exerciseList = select.getExerciseList();
                if(exerciseList.containsKey(mentor.getName())){
                    exerciseList.get(mentor.getName()).put(date, exercise);
                }
                else{
                    HashMap<String, String> map = new HashMap<>();
                    map.put(date, exercise);
                    select.setExerciseList(mentor.getName(), map);
                }
            }
        }
    }

    public void saveDiet(Member mentor, String mentee, String date, String diet){
        Set<Member> myMemberList = mentor.getMyMemberList();
        for (Member select : myMemberList) {
            if (select.getName().equals(mentee)) {
                Map<String, Map<String, String>> dietList= select.getDietList();
                if(dietList.containsKey(mentor.getName())){
                    dietList.get(mentor.getName()).put(date, diet);
                }
                else{
                    HashMap<String, String> map = new HashMap<>();
                    map.put(date, diet);
                    select.setDietList(mentor.getName(), map);
                }
            }
        }
    }
}
