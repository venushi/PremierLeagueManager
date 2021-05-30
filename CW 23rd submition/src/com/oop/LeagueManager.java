package com.oop;

import java.util.List;

public interface LeagueManager {

    void addClub(FootballClub club);
    boolean dltClub(String clubID);
    boolean checkTeamByName(String name);
    boolean checkTeamById(String id);
    List<FootballClub> getClubList();



}
