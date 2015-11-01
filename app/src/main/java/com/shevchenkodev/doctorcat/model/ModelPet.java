package com.shevchenkodev.doctorcat.model;


public class ModelPet {

    public static final int CAT = 0;
    public static final int DOG = 1;
    String petName;
    private int petType;
    Long bDate;

    public int getPetType() {
        return petType;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetType(int petType) {
        this.petType = petType;
    }

    public void setbDate(Long bDate) {
        this.bDate = bDate;
    }

    public String getPetName() {

        return petName;
    }

    public Long getPetBDay() {

        return bDate;
    }

    public ModelPet() {
    }

    public ModelPet(String petName, Long bDate, int petType) {
        this.petName = petName;
        this.bDate = bDate;
        this.petType = petType;

    }
}
