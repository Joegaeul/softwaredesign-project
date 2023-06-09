package model.menteemodel;

import model.Repository;
import model.membermodel.Member;
import model.membermodel.Usertype;
import model.mentormodel.Mentor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MenteeServiceImpl implements MenteeService{
    private Repository repository;

    public MenteeServiceImpl(Repository repository) {
        this.repository = repository;
    }

    public ArrayList<Member> findAllMentor(){
        ArrayList<Member> allMentorList = new ArrayList();
        Set<String> keys = repository.getMemberStore().keySet();
        for(String key : keys){
            if(repository.getMemberStore().get(key).getUserType().equals(Usertype.Mentor)){
                allMentorList.add(repository.getMemberStore().get(key));
            }
        }
        return allMentorList;
    }

    public Set<Mentor> findMyMentorInfo(Member member){
        Set<Mentor> myMentorList = new HashSet<>();
        Set<Member> myMemberList = member.getMyMemberList();
        for(Member m : myMemberList){
            if(repository.getMentorStore().containsKey(m.getId())){
                myMentorList.add(repository.getMentorStore().get(m.getId()));
            }
            else{
                Mentor mentor = new Mentor(m, null, null);
                myMentorList.add(mentor);
            }
        }
        return myMentorList;
    }

    public void saveMyMember(String name, Member member){
        Map<String, Member> members = repository.getMemberStore();
        Member myMentor = members.get(name);
        member.setMyMemberList(myMentor);
        myMentor.setMyMemberList(member);
    }

    public String getExercise(Member mentee, String mentor , String date){
        Map<String, Map<String, String>> exerciseList = mentee.getExerciseList();
        Map<String, String> data = exerciseList.get(mentor);
        if(data.containsKey(date)){
            return data.get(date);
        }else{
            return "선택된 날짜에 운동을 발견할 수 없다.";
        }
    }

    public String getDiet(Member mentee, String mentor , String date){
        Map<String, Map<String, String>> dietList = mentee.getDietList();
        Map<String, String> data = dietList.get(mentor);
        if(data.containsKey(date)){
            return data.get(date);
        }else{
            return "선택된 날짜에 식단을 발견할 수 없습니다.";
        }
    }

    @Override
    public void saveMyInfo(Member member, Double height, Double weight, Double muscle) {
        Mentee mentee = new Mentee(member, height, weight, muscle);
        repository.setMenteeStore(member.getId(), mentee);
    }

    public Set<Member> findMyMentor(Member member){
        return member.getMyMemberList();
    }
}
