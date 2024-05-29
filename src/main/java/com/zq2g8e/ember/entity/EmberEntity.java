package com.zq2g8e.ember.entity;


import com.zq2g8e.ember.Sex;
import jakarta.persistence.*;

@Entity
@Table(name = "ember")
public class EmberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emberId;
    private String name;
    private Integer yearOfBirth;
    @Enumerated(EnumType.STRING)
    private Sex sex;

    public EmberEntity() {
    }

    public EmberEntity(String name, Integer yearOfBirth, String sex) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.sex = Sex.valueOf(sex.toUpperCase());
    }

    public long getEmberId() {
        return emberId;
    }

    public String getName() {
        return name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    private int getCurrentAge(){
        return 2024 - yearOfBirth;
    }

    public String introduction() {
        return "A nevem " + getName() + " es " + getYearOfBirth() + "-ban szulettem, azaz " + getCurrentAge() +  " eves vagyok.";
    }
}
