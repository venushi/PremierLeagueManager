package com.oop;

public class UniversityFootballClub extends FootballClub { //subclass of the footballclub
    private String nickName; //shortform name or nick name of the club if the have
    private String universityName;//name of the uni

    public UniversityFootballClub(String nickName , String universityName,String howManyWins,String howManyDraws,String howManyDefeats,String numbersOfGoalsReceived,String numbersOfGoalsScored
            ,String currentlyPoints,String numbersOfMatchesPlayed,String nameOfTheClub,String locationOfTheClub,String numbersOfMembers,String clubID) {
        super(nameOfTheClub,locationOfTheClub,numbersOfMembers,clubID);
        this.nickName=nickName;
        this.universityName=universityName;
    }

    //getting getters and setters

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName=nickName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

}
