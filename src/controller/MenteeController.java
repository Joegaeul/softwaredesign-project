package controller;

import model.Repository;
import model.membermodel.Member;
import model.menteemodel.MenteeService;
import model.menteemodel.MenteeServiceImpl;
import model.mentormodel.Mentor;
import view.memberview.LoginFrame;
import view.menteeview.*;

import java.util.ArrayList;
import java.util.Set;

public class MenteeController {
    private Repository repository;
    private MenteeService menteeService;
    private Member member;
    private MemberController memberController;

    public MenteeController(Repository repository, MemberController memberController, Member member) {
        this.repository = repository;
        this.memberController = memberController;
        this.member = member;
        menteeService = new MenteeServiceImpl(repository);
    }

    public ArrayList<Member> readAllMentor(){
        ArrayList<Member> allMentorList = menteeService.findAllMentor();
        return allMentorList;
    }

    public Set<Mentor> readMyMentorInfo(){
        return menteeService.findMyMentorInfo(member);
    }
    public Set<Member> readMyMentor(){
        Set<Member> myMentorList = menteeService.findMyMentor(member);
        return myMentorList;
    }

    public String readExercise(String mentor, String date){
       return menteeService.getExercise(member, mentor, date);
    }

    public String readDiet(String mentor, String date){
        return menteeService.getDiet(member, mentor, date);
    }

    public void updateMyPage(double height, double weight, double muscle){
        menteeService.saveMyInfo(member, height, weight, muscle);
    }

    public void selectMentor(String name){
        menteeService.saveMyMember(name, member);
    }

    public void goAllMentorListFrame(){
        AllMentorListFrame allMentorListFrame = new AllMentorListFrame(this);
    }

    public void goMenteeMypageFrmae(){
        MenteeMyPageFrame menteeMyPageFrame = new MenteeMyPageFrame(this);
    }
    public void goLoginFrame(){
        LoginFrame loginFrame = new LoginFrame(memberController);
    }

    public void goMyMentorListFrame(){
        MyMentorListFrame myMentorListFrame = new MyMentorListFrame(this);
    }

    public void goReadExerciseProgramFrame(){
        ReadExerciseProgramFrame readExerciseProgramFrame = new ReadExerciseProgramFrame(this);
    }

    public void goReadDietProgramFrame(){
        ReadDietProgramFrame readDietProgramFrame = new ReadDietProgramFrame(this);
    }

    public void goMenteeView(){
        MenteeView menteeView = new MenteeView(this);
    }
}
