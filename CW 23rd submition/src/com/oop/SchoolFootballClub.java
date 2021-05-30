package com.oop;

public class SchoolFootballClub extends FootballClub { //subclass of the football club

    private String nameOfThePrinciple; //name of school's principle
    private String schoolName; //name of school

    public SchoolFootballClub(String nameOfThePrinciple, String schoolName,String howManyWins,String howManyDraws,String howManyDefeats, String numbersOfGoalsReceived,String numbersOfGoalsScored
            ,String currentlyPoints,String numbersOfMatchesPlayed,String nameOfTheClub,String locationOfTheClub,String numbersOfMembers,String clubID) {
        super(nameOfTheClub,locationOfTheClub,numbersOfMembers,clubID);
        this.nameOfThePrinciple = nameOfThePrinciple;
        this.schoolName=schoolName;
    }

    //getting getters and setters

    public String getNameOfThePrinciple() {
        return nameOfThePrinciple;
    }

    public void setNameOfThePrinciple(String nameOfThePrinciple) {
        this.nameOfThePrinciple = nameOfThePrinciple;
    }

    public String getSchoolName()
    {
        return schoolName;
    }

    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }


}
