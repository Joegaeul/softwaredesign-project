package model.membermodel;

import java.util.*;

public class Member {
    private String id;
    private String password;
    private String name;
    private Usertype userType;
    private int age;
    private String  sportCareer;
    private String sex;
    private Set<Member> myMemberList;
    private Map<String, Map<String, String>> exerciseList;
    private Map<String, Map<String, String>> dietList;

    public Member(String id, String password, String name, Usertype userType, int age, String sportCareer, String sex) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.userType = userType;
        this.age = age;
        this.sportCareer = sportCareer;
        this.sex = sex;

        myMemberList = new HashSet<>();
        exerciseList = new HashMap<>();getE
        dietList = new HashMap<>();
    }

    public String getSex() {
        return sex;
    }

    public Map<String, Map<String, String>> getDietList() {
        return dietList;
    }

    public void setDietList(String mentor, Map<String, String> menteeDiet) {
        dietList.put(mentor, menteeDiet);
    }
    public Map<String, Map<String, String>> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(String mentor, Map<String, String> menteeExercise) {
        exerciseList.put(mentor, menteeExercise);
    }
    public Set<Member> getMyMemberList() {
        return myMemberList;
    }

    public void setMyMemberList(Member member) {
        myMemberList.add(member);
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Usertype getUserType() {
        return userType;
    }

    public int getAge() {
        return age;
    }

    public String getSportCareer() {
        return sportCareer;
    }
}
