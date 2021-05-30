package com.oop;

import java.io.Serializable;

abstract class SportsClub implements Serializable {
    private String nameOfTheClub;   //name of the football club
    private String locationOfTheClub;  //location of the football club
    private String numbersOfMembers; //numbers of the members in each club
    private String clubID;  //club ID,it can be either integer or a string

    public SportsClub(String nameOfTheClub, String locationOfTheClub, String numbersOfMembers, String clubID){
        this.nameOfTheClub = nameOfTheClub;
        this.locationOfTheClub=locationOfTheClub;
        this.numbersOfMembers=numbersOfMembers;
        this.clubID=clubID;
    }

//getting getters and setters methods

    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

    public void setNameOfTheClub(String nameOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
    }

    public String getLocationOfTheClub() {
        return locationOfTheClub;
    }

    public void setLocationOfTheClub(String locationOfTheClub) {
        this.locationOfTheClub = locationOfTheClub;
    }

    public String getNumbersOfMembers() {
        return numbersOfMembers;
    }

    public void setNumbersOfMembers(String numbersOfMembers) {
        this.numbersOfMembers = numbersOfMembers;
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }


}
