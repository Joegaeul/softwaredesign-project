package model.mentormodel;

import model.membermodel.Member;

public class Mentor extends Member {
    private String phoneNumber;
    private String email;

    public Mentor(Member member ,String phoneNumber, String email) {
        super(member.getId(), member.getPassword(), member.getName(), member.getUserType(), member.getAge(), member.getSportCareer(), member.getSex());
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
