package com.oop;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PremierLeagueManager implements LeagueManager, Serializable { //implement the interface

    public List<FootballClub> clubList = new ArrayList<FootballClub>(); //create club list
    public List<Match> matchList = new ArrayList<Match>(); //create match list

    // Adding a new team to the Club list
    @Override
    public void addClub(FootballClub club) {

        clubList.add(club);
    }

// Deleting an existing club by its name
    public boolean dltClub(String clubName) {

        for (FootballClub club1 : clubList) {

            if (Objects.equals(club1.getNameOfTheClub(), clubName)) {
                clubList.remove(club1);
                return true;
            }
        }
        return false;
    }




    public FootballClub getTeam(String clubName) { //get the team that user input
        for (FootballClub club1 : clubList) {
            if (Objects.equals(club1.getNameOfTheClub(), clubName)) {
                return club1;
            }
        }
        return null;
    }

    public boolean checkTeamByName(String name) { //check that its equal to an existing club

        for (FootballClub club1 : clubList) {
            if (Objects.equals(club1.getNameOfTheClub(), name)) {
                return true;
            }
        }
        return false;
    }


    public boolean checkTeamById(String id){
        for (FootballClub club1 : clubList) {
            if (Objects.equals(club1.getClubID(), id)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public List<FootballClub> getClubList() {
        return this.clubList;
    }


//Adding a match

    public boolean addMatch(String id1, String score1, String id2, String score2, Date date){

        FootballClub club1 = null,club2 = null;
        for (FootballClub club : clubList) {
            if (Objects.equals(club.getClubID(), id1)) { //check that the user input equals to the existing club in club list
                club1 = club;
            }else if(Objects.equals(club.getClubID(), id2)) {
                club2 = club;
            }
        }

        club1.setNumbersOfMatchesPlayed(); //numbers of matches defaultly set to the clubs
        club2.setNumbersOfMatchesPlayed();
        club1.setGoalDiference(Integer.parseInt(score1) - Integer.parseInt(score2)); //get goal difference
        club2.setGoalDiference(Integer.parseInt(score2) - Integer.parseInt(score1));
        club1.setNumbersOfGoalsScored(Integer.parseInt(score1)); //each scores set to the clubs
        club2.setNumbersOfGoalsScored(Integer.parseInt(score2));
        club1.setNumbersOfGoalsReceived(Integer.parseInt(score2)); //each goals set to the goals of received and it set to the clubs
        club2.setNumbersOfGoalsReceived(Integer.parseInt(score1));

        //getting points,wins,defeats by entered match

        if(Integer.parseInt(score1) > Integer.parseInt(score2)){
            club1.setHowManyWins();
            club1.setCurrentlyPoints(3); //if a club wins,it gets three points
            club2.setHowManyDefeats();
        }else if(Integer.parseInt(score1) < Integer.parseInt(score2)){
            club2.setHowManyWins();
            club2.setCurrentlyPoints(3); //if a club defeats,it gets zero points
            club1.setHowManyDefeats();
        }else{
            club1.setHowManyDraws();
            club2.setHowManyDraws();
            club1.setCurrentlyPoints(1); //if a club draws , each club gets one point
            club2.setCurrentlyPoints(1);
        }

        //Adding scores and clubs to the Match class

        Match match = new Match(club1,score1,club2,score2,date);
        this.matchList.add(match); //match add to the match list


        return false;


    }

//searching the match details by played match date and it convert to below format
    public Match getMatchByDate(String text) {

        for (Match m: matchList) {
            DateFormat dteFormat = new SimpleDateFormat("yyyy/mm/dd"); //date format
            String strDate = dteFormat.format(m.getMatchDate());
            System.out.println("Changed String: " + strDate);
            if(text.equals(strDate)){
                return m;
            }
        }

        return null;
    }
}
