package controller;

import model.Repository;
import model.membermodel.Member;

import model.menteemodel.Mentee;
import model.mentormodel.Mentor;
import model.mentormodel.MentorService;

import model.mentormodel.MentorServiceImpl;
import view.memberview.LoginFrame;
import view.mentorview.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;

public class MentorController {
    private Repository repository;
    private MentorService mentorService;
    private Member member;
    private MemberController memberController;

    public MentorController(Repository repository, MemberController memberController, Member member) {
        this.repository = repository;
        this.memberController = memberController;
        this.member = member;

        mentorService = new MentorServiceImpl(repository);
    }

    public void MypageUpdateMentor(String phoneNumber, String intro){
        Mentor mentor = new Mentor(member,phoneNumber, intro);
        mentorService.updateMentorInfo(mentor);
        JOptionPane.showMessageDialog(null, "저장되었습니다.");
    }

    public Set<Member> readMyMentee(){
        Set <Member> myMentee = mentorService.findMyMentee(member);
        return myMentee;
    }

    public ArrayList<Mentee> readMyMenteeInfo(){
        ArrayList<Mentee> myMenteeInfo = mentorService.findMyMenteeInfo(member);
        return myMenteeInfo;
    }

    public void postExercise(String mentee, String date, String exercise){
        mentorService.saveExercise(member, mentee, date, exercise);
    }

    public void postDiet(String mentee, String date, String diet){
        mentorService.saveDiet(member, mentee,date,diet);
    }

    public void goMentorMyPageFrame(){
        MentorMyPageFrame mentorMyPageFrame = new MentorMyPageFrame(this);
    }

    public void goPostDietProgramFrame(){
        PostDietProgramFrame postDietProgramFrame = new PostDietProgramFrame(this);
    }
    public void goLoginFrame(){
        LoginFrame loginFrame = new LoginFrame(memberController);
    }

    public void goMenteeListFrame(){
        MenteeListFrame menteeListFrame = new MenteeListFrame(this);
    }

    public void goPostExerciseProgramFrame(){
        PostExerciseProgramFrame postExerciseProgramFrame = new PostExerciseProgramFrame(this);
    }

    public void goMentorView(){
        MentorView mentorView = new MentorView(this);
    }
}
