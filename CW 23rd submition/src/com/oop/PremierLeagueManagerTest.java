package com.oop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PremierLeagueManagerTest {
    PremierLeagueManager p;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        p = new PremierLeagueManager();
    }

    @org.junit.jupiter.api.Test
    void addClub() {
        FootballClub ft = new FootballClub("xx","xx","12","1");
        p.addClub(ft);

        assertEquals(1,p.getClubList().size());
    }

    @org.junit.jupiter.api.Test
    void addExistingClubcheckByName() {
        FootballClub ft = new FootballClub("xx","xx","12","1");
        p.addClub(ft);
        FootballClub ft2 = new FootballClub("xx","xx","12","1");
        boolean ftclubExist = p.checkTeamByName("xx");

        assertEquals(true, ftclubExist);
    }

    @org.junit.jupiter.api.Test
    void addExistingClubcheckById() {
        FootballClub ft = new FootballClub("xx","xx","12","1");
        p.addClub(ft);
        FootballClub ft2 = new FootballClub("xx","xx","12","1");
        boolean ftclubExist = p.checkTeamById("1");

        assertEquals(true, ftclubExist);
    }

    @org.junit.jupiter.api.Test
    void dltClub() {
        FootballClub ft = new FootballClub("xx","xx","12","1");
        p.addClub(ft);

        p.dltClub(ft.getNameOfTheClub());
        assertEquals(0,p.getClubList().size());
    }

    @org.junit.jupiter.api.Test
    void displayTeam() {
        FootballClub ft = new FootballClub("xx","xx","12","1");
        p.addClub(ft);

        FootballClub team = p.getTeam("xx");

        assertNotNull(team);
    }

    @org.junit.jupiter.api.Test
    void displayTeamnotExist() {
        FootballClub ft = new FootballClub("xx","xx","12","1");
        p.addClub(ft);

        FootballClub team = p.getTeam("ww");

        assertNull(team);
    }


    @org.junit.jupiter.api.Test
    void getClubList() {
        FootballClub ft = new FootballClub("xx","xx","12","1");
        p.addClub(ft);

        List<FootballClub> clubList = p.getClubList();
        assertNotNull(clubList);
    }


    // Here we chechining the add match method
    @org.junit.jupiter.api.Test
    void addMatch() throws ParseException {
        FootballClub ft1 = new FootballClub("xx","xx","12","1");
        FootballClub ft2 = new FootballClub("ww","ww","14","2");
        p.addClub(ft1);
        p.addClub(ft2);

        p.addMatch("1","5","2","3",  new SimpleDateFormat("yyyy/mm/dd").parse("2020/12/21"));

        assertEquals(1,p.matchList.size());
    }
}