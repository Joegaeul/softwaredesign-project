package model.menteemodel;

import model.membermodel.Member;

public class Mentee extends Member {
    private Double height;
    private Double weight;
    private Double muscleMass;

    public Mentee(Member member, Double height, Double weight, Double muscleMass) {
        super(member.getId(), member.getPassword(), member.getName(), member.getUserType(), member.getAge(), member.getSportCareer(), member.getSex());
        this.height = height;
        this.weight = weight;
        this.muscleMass = muscleMass;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getMuscleMass() {
        return muscleMass;
    }
}

