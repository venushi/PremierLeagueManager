package com.oop;

import java.io.Serializable;
import java.util.Date;


public class Match implements Comparable<Match>,Serializable {
    private FootballClub team1; //team1 as user first  input
    private FootballClub team2; //team2 as user second input

    private int team1Score; //score of teamone
    private int team2Score; //score of teamtwo

    private String name1; //name of theteam
    private String name2; //nameof the ream

    private Date matchDate;//played match darte

    public Match(FootballClub team1, String team1Score, FootballClub team2, String team2Score, Date matchDate) {
        this.team1 = team1;
        this.team1Score=Integer.parseInt(team1Score);// pass it as integer
        this.team2=team2;
        this.team2Score=Integer.parseInt(team2Score);// pass it as integer
        this.matchDate=matchDate;
        this.name1 = team1.getNameOfTheClub(); //name of the club add to the team one and it add as name1
        this.name2 = team2.getNameOfTheClub();
    }
    public int compareTo(Match mt){

//        if( this.matchDate== mt.getMatchDate()) {
//            return 0;
//
//        }else if(this.matchDate < mt.getMatchDate()) {
//            return 1;
//        }else {
//            return -1;
//        }
        return this.matchDate.compareTo(mt.getMatchDate());

    }



// geeting getters and setters

    public FootballClub getTeam1() {
        return team1;
    }

    public void setTeam1(FootballClub team1) {
        this.team1 = team1;
    }

    public FootballClub getTeam2() {
        return team2;
    }

    public void setTeam2(FootballClub team2) {
        this.team2 = team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }
}
