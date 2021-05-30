package com.oop;

import java.util.Date;

public class FootballClub extends SportsClub implements Comparable<FootballClub>{ //this is a sub class of sports club
    private int howManyWins; //the wins,football club have
    private int howManyDraws; //the draws, football club have
    private int howManyDefeats; //the defeats football club have
    private int numbersOfGoalsReceived; //the received goals football club have
    private int numbersOfGoalsScored; //the scored goals football club have
    private int currentlyPoints; //the points, the football club have
    private int numbersOfMatchesPlayed; //the played matches ,football club have

    private int goalDiference;//goals received-goals scored
    private Date date;// played matches date

    private String id1; // id of the football club
    private String id2;
    private String score1;//scores of they have
    private String score2;

    public FootballClub(String nameOfTheClub, String locationOfTheClub, String numbersOfMembers,String clubID) {
        super(nameOfTheClub,locationOfTheClub,numbersOfMembers,clubID);

    }
    //getting getters and setters

    public int getHowManyWins() {
        return howManyWins;
    }

    public void setHowManyWins() {
        this.howManyWins = this.howManyWins + 1;
    }

    public int getHowManyDraws() {
        return howManyDraws;
    }

    public void setHowManyDraws() {
        this.howManyDraws = this.howManyDraws + 1;
    }

    public int getHowManyDefeats() {
        return howManyDefeats;
    }

    public void setHowManyDefeats() {
        this.howManyDefeats = this.howManyDefeats + 1;
    }

    public int getNumbersOfGoalsReceived() {
        return numbersOfGoalsReceived;
    }

    public void setNumbersOfGoalsReceived(int numbersOfGoalsReceived) {
        this.numbersOfGoalsReceived = this.numbersOfGoalsReceived + numbersOfGoalsReceived;
    }

    public int getNumbersOfGoalsScored() {
        return numbersOfGoalsScored;
    }

    public void setNumbersOfGoalsScored(int numbersOfGoalsScored) {
        this.numbersOfGoalsScored = this.numbersOfGoalsScored + numbersOfGoalsScored;
    }

    public int getCurrentlyPoints() {
        return currentlyPoints;
    }

    public void setCurrentlyPoints(int currentlyPoints) {

        this.currentlyPoints = this.currentlyPoints + currentlyPoints;
    }

    public int getNumbersOfMatchesPlayed() {
        return numbersOfMatchesPlayed;
    }

    public void setGoalDiference(int diff) {
        this.goalDiference = this.goalDiference + diff;
    }

    public int getGoalDiference() {
        return goalDiference;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNumbersOfMatchesPlayed() {
        this.numbersOfMatchesPlayed = this.numbersOfMatchesPlayed + 1;
    }
//sort by currently points and goal diifference
    public int compareTo(FootballClub ft){

        if( this.currentlyPoints == ft.getCurrentlyPoints()) {
            if (this.goalDiference == ft.getGoalDiference())
                return 0;
            else if(this.goalDiference < ft.getGoalDiference())//if points equal,sort by goal differnce
                return 1;
            else
                return -1;
        }else if(this.currentlyPoints < ft.getCurrentlyPoints()) { //sort by points
            return 1;
        }else {
            return -1;
        }

    }

}
