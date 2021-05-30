package com.oop;

import javafx.application.Application;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleUI {
    private static PremierLeagueManager premierLeagueManager=null; //create object to the class
    private GUI GUI=null; //create object by GUI class

 //Adding add,dlt, display to the console

    ConsoleUI(){
        this.premierLeagueManager=new PremierLeagueManager();
        File filename = new File("./premierLeague.ser");//create file to save
        if(filename.exists()) {
            try
            {
                // Reading the object from a file
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);

                // Method for deserialization of object
                this.premierLeagueManager = (PremierLeagueManager)in.readObject();

                in.close();
                file.close();

//                System.out.println("Object has been deserialized ");
//                System.out.println("size = " + premierLeagueManager.clubList.size());

            }

            catch(IOException ex)
            {
                System.out.println("IOException is caught");
            }

            catch(ClassNotFoundException ex)
            {
                System.out.println("ClassNotFoundException is caught");
            }


        }else{
            this.premierLeagueManager = new PremierLeagueManager();
        }
    }

    public static void main (String[] args) {
        boolean exit = true;
        ConsoleUI console = new ConsoleUI();
        do {
            Scanner menu = new Scanner(System.in);

            //add scanners to get user inputs

            System.out.println("Enter 1 to add a Football club : ");
            System.out.println("Enter 2 to delete a Football club : ");
            System.out.println("Enter 3 to display the table : ");
            System.out.println("Enter 4 to display a team statistics : ");
            System.out.println("Enter 5 to add a Played Match : ");
            System.out.println("Enter 6 to GUI : ");


            int guess = menu.nextInt();

            switch (guess) {
                case 1:
                    console.addClub(); //add a club,if user input one
                    break;
                case 2:
                    console.dltClub(); //delete a club, if user input two
                    break;
                case 3:
                    console.displayTable();//display club name,points and goal differnece, if user input three
                    break;
                case 4:
                    console.displayClub(); //display the relevant club stats , if user input four
                    break;
                case 5:
                    console.addMatch();//adding a match if user input five
                    break;
                case 6:
                    console.showGUI();//display GUI, if user input six
                    break;


                default:
                    System.out.println("Input is invalid");
            }


        } while (exit != false);

    }
    public void showGUI(){
        GUI.setManager(getPremierLeagueManager());
//        new Thread (() -> Application.launch(GUI.class)).start();
        try {
            Application.launch(GUI.class);
        }catch (Exception e){
            System.out.println("Getting an error, Please re-run the application");

        }
    }

    public PremierLeagueManager getPremierLeagueManager() {
        return this.premierLeagueManager;
    }


    private void addClub(){

        Scanner menu = new Scanner(System.in); //create an object

        boolean name = false;
        String nameOfTheClub = null;
        while(!name) {
            System.out.println("Name of the club : ");//getting name of the club
            nameOfTheClub = menu.next();
            if(premierLeagueManager.checkTeamByName(nameOfTheClub)){
                System.out.println("The Team name is already exist. Please re-enter your team name.");//if it is a
            }else{
                name = true;
            }

        }

        boolean id = false;
        String clubID = null;
        while(!id) {
            System.out.println("ID of the club : ");//getting name of the club id
            clubID = menu.next();
            if(premierLeagueManager.checkTeamById(clubID)){
                System.out.println("The Team ID is already exist. Please re-enter your team ID.");
            }else{
                id = true;
            }

        }

        System.out.println("Location of the club : ");//getting location of the club
        String  locationOfTheClub=menu.next();

        System.out.println("Numbers of members : ");//getting numbers of the members in an each clubs
        String numbersOfMembers=menu.next();


        FootballClub club = new FootballClub(nameOfTheClub,locationOfTheClub,numbersOfMembers,clubID);

        premierLeagueManager.addClub(club);
        System.out.println("Successfully Added the new team "+nameOfTheClub);//adding team

        ConsoleUI.saveFile();

    }

    private void dltClub(){

        if(premierLeagueManager.clubList.size() > 0 ) {
            Scanner menu = new Scanner(System.in);
            System.out.println("Enter name of the football club : ");//getting club name
            String clubID = menu.next();

            boolean result = premierLeagueManager.dltClub(clubID);

            if (result) {
                System.out.println("Removed Successfully");//successfull message
            } else {
                System.out.println("Not Found");
            }
        }else{
            System.out.format("Please enter the teams first");//if team was not entered
        }

        ConsoleUI.saveFile();
    }






    private  void displayTable(){

        if(premierLeagueManager.clubList.size() > 0 ) {
            ArrayList<FootballClub> sorted;
            sorted = (ArrayList<FootballClub>) premierLeagueManager.clubList;
            Collections.sort(sorted); //sort by collection

            String leftAlignFormat = "| %-15s | %-6s | %-6s |%n"; //setting allignment

            System.out.format("+-----------------+------+%n");
            System.out.format("| Team name       | Points | Goals difference |%n"); //setting table
            System.out.format("+-----------------+------+%n");
            for (FootballClub club1 : sorted) {
                System.out.format(leftAlignFormat, club1.getNameOfTheClub() + "", club1.getCurrentlyPoints(), club1.getGoalDiference());
            }
            System.out.format("+-----------------+------+%n");
        }else{
            System.out.println("Please enter the teams first");//if team is not club
        }

    }
//displaying the table
    private void displayClub(){

        if(premierLeagueManager.clubList.size() > 0 ) {


            Scanner menu = new Scanner(System.in);
            System.out.println("Enter name of the football club : ");//enter id first
            String clubID = menu.next();

            FootballClub selectedTeam = premierLeagueManager.getTeam(clubID);//premierleageue manager's clubId add to the selected team


            if(selectedTeam != null){
                System.out.println("Team Name :"+selectedTeam.getNameOfTheClub());//get team name
                System.out.println("Scored Goals :"+selectedTeam.getNumbersOfGoalsScored());// get scored goals
                System.out.println("Points :"+selectedTeam.getCurrentlyPoints());//get points
                System.out.println("Wins :"+selectedTeam.getHowManyWins());//get wins
                System.out.println("Defeats :"+selectedTeam.getHowManyDefeats());//get defeat
                System.out.println("Draws :"+selectedTeam.getHowManyDraws());//get draws
            }else{
                System.out.println("Team is not found. Please re-check your team ID.");
            }

        }else{
            System.out.println("Please enter the teams first");
        }

    }
    //adding match to the

    private void addMatch(){
        Scanner scan = new Scanner(System.in);
        if(premierLeagueManager.clubList.size() > 1 ) {
            String id1 = null;
            while(!premierLeagueManager.checkTeamById(id1)) {
                System.out.println("Enter the team 1 ID: "); //getting he team1 id
                id1 = scan.next();
                if(!premierLeagueManager.checkTeamById(id1))
                    System.out.println("Team ID is invalid");// if it is invalid
            }

            System.out.println("Enter the score of the team 1: ");//getting the score of team1
            String score1 = scan.next();

            String id2 = null;
            while(!premierLeagueManager.checkTeamById(id2)) {
                System.out.println("Enter the team 2 ID: ");//get team2 id
                id2 = scan.next();
                if(!premierLeagueManager.checkTeamById(id2))
                    System.out.println("Team ID is invalid");
            }

            System.out.println("Enter the score of the team 2: ");//getting team 2 scores
            String score2 = scan.next();


            System.out.println("Enter the date of the match(yyyy/mm/dd) : ");//getting the date

            String date1 = scan.next();
            Date date= null;
            try {
                date = new SimpleDateFormat("yyyy/mm/dd").parse(date1);// getting the date
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(date);
            // get date

            premierLeagueManager.addMatch(id1,score1,id2,score2,date);
            System.out.println("The Match details added successfully");
            ConsoleUI.saveFile();
        }else{
            System.out.println("Please enter at least two teams first");
        }
    }

//saving file
    private static void saveFile(){
        File filename = new File("./premierLeague.ser");

        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);// create a new file
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(premierLeagueManager);//write file
            out.close();
            file.close();
            System.out.println("Object has been serialized");

        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }
















}
