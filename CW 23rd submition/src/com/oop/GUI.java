package com.oop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


public class GUI extends Application {
    private static PremierLeagueManager premierLeagueManager;



    public static void main(String[] args) {
        launch(args);
    }

    public static void setManager(PremierLeagueManager premierLeagueManager0) {
        premierLeagueManager = premierLeagueManager0;
    }


//creating table
    @Override
    public void start(Stage primaryStage) {
        TableView tbv = new TableView();
        TableColumn<String, FootballClub> cl1 = new TableColumn<>("Team Name");
        cl1.setCellValueFactory(new PropertyValueFactory<>("nameOfTheClub"));
        TableColumn<String, FootballClub> cl2 = new TableColumn<>("Team ID");
        cl2.setCellValueFactory(new PropertyValueFactory<>("clubID"));
        TableColumn<String, FootballClub> cl3 = new TableColumn<>("Team Location");
        cl3.setCellValueFactory(new PropertyValueFactory<>("locationOfTheClub"));
        TableColumn<String, FootballClub> cl4 = new TableColumn<>("Scored Goals");
        cl4.setCellValueFactory(new PropertyValueFactory<>("numbersOfGoalsScored"));
        TableColumn<String, FootballClub> cl5 = new TableColumn<>("Points");
        cl5.setCellValueFactory(new PropertyValueFactory<>("currentlyPoints"));
        TableColumn<String, FootballClub> cl11 = new TableColumn<>("Goal diff");
        cl11.setCellValueFactory(new PropertyValueFactory<>("goalDiference"));
        TableColumn<String, FootballClub> cl6 = new TableColumn<>("Wins");
        cl6.setCellValueFactory(new PropertyValueFactory<>("howManyWins"));
        TableColumn<String, FootballClub> cl7 = new TableColumn<>("Draws");
        cl7.setCellValueFactory(new PropertyValueFactory<>("howManyDraws"));
        TableColumn<String, FootballClub> cl8 = new TableColumn<>("Defeats");
        cl8.setCellValueFactory(new PropertyValueFactory<>("howManyDefeats"));
        TableColumn<String, FootballClub> cl9 = new TableColumn<>("Received goals");
        cl9.setCellValueFactory(new PropertyValueFactory<>("numbersOfGoalsReceived"));
        TableColumn<String, FootballClub> cl10 = new TableColumn<>("Numbers of matches played");
        cl10.setCellValueFactory(new PropertyValueFactory<>("numbersOfMatchesPlayed"));





        tbv.getColumns().add(cl1);
        tbv.getColumns().add(cl2);
        tbv.getColumns().add(cl3);
        tbv.getColumns().add(cl4);
        tbv.getColumns().add(cl5);
        tbv.getColumns().add(cl11);
        tbv.getColumns().add(cl6);
        tbv.getColumns().add(cl7);
        tbv.getColumns().add(cl8);
        tbv.getColumns().add(cl9);
        tbv.getColumns().add(cl10);



        ArrayList<FootballClub> sorted;
        sorted = (ArrayList<FootballClub>) premierLeagueManager.getClubList();
        Collections.sort(sorted);//sorted by clublist

        for (FootballClub f : sorted){
            tbv.getItems().add(f);
        }





//creating button

        Button btgo = new Button("To Sort by Goals press the column head");
        btgo.setStyle("-fx-background-radius:12;-fx-text-fill: black;-fx-font-family: \"Arial \"; " +
                " -fx-font-weight: bold;-fx-font-size: 15px;-fx-background-color:#a29bfe");
        Button btwin = new Button("To Sort by Wins press the column head");
        btwin.setStyle("-fx-background-radius:12;-fx-text-fill: black;-fx-font-family: \"Arial \";  " +
                "-fx-font-weight: bold;-fx-font-size: 15px;-fx-background-color:#a29bfe");
        Button btplma = new Button("Play Match");
        btplma.setStyle("-fx-background-radius:12;-fx-text-fill: black;-fx-font-family: \"Arial \";  " +
                "-fx-font-weight: bold;-fx-font-size: 15px;-fx-background-color:#a29bfe");
        Button btpmd = new Button("Play Match details");
        btpmd.setStyle("-fx-background-radius:12;-fx-text-fill: black;-fx-font-family: \"Arial \";  " +
                "-fx-font-weight: bold;-fx-font-size: 15px;-fx-background-color:#a29bfe");



//getting actions
        btpmd.setOnAction(e -> {
            Label label = new Label("New Window");
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: #7CAFC2");




//creating table
            TableView tbv1 = new TableView();

            //creating label
            Label l1=new Label("Played Match Details");
            l1.setLayoutX(25);
            l1.setLayoutY(50);
            l1.setStyle("-fx-text-fill: black;-fx-font-family: \"Verdana\";-fx-font-weight: bold;-fx-font-size: 15px;");


            //creating table

            TableColumn<String, Match> clp1 = new TableColumn<>("Team one");
            clp1.setCellValueFactory(new PropertyValueFactory<>("name1"));
            TableColumn<String, Match> clp2 = new TableColumn<>("Team two");
            clp2.setCellValueFactory(new PropertyValueFactory<>("name2"));
            TableColumn<Integer, Match> clp3 = new TableColumn<>("Team One score");
            clp3.setCellValueFactory(new PropertyValueFactory<>("team1Score"));
            TableColumn<Integer, Match> clp4 = new TableColumn<>("Team two score");
            clp4.setCellValueFactory(new PropertyValueFactory<>("team2Score"));
            TableColumn<String, Match> clp5 = new TableColumn<>("Date");
            clp5.setCellValueFactory(new PropertyValueFactory<>("matchDate"));

            Button lal1 = new Button("Search played match by date:");
            lal1.setStyle("-fx-background-radius:12;-fx-text-fill: black;-fx-font-family: \"Arial \";  " +
                    "-fx-font-weight: bold;-fx-font-size: 15px;-fx-background-color:#00cec9");
            TextField txtNa = new TextField(); //creating textfeild
            txtNa.setPromptText("YYYY/MM/DD"); //setting date
            txtNa.setStyle("-fx-text-fill: #333333"); //


            tbv1.getColumns().add(clp1);
            tbv1.getColumns().add(clp2);
            tbv1.getColumns().add(clp3);
            tbv1.getColumns().add(clp4);
            tbv1.getColumns().add(clp5);

            tbv1.setStyle("-fx-background-color:#dfe6e9");
            tbv1.setId("Mytable");

            ArrayList<Match> sorted1;
            sorted1 = (ArrayList<Match>) premierLeagueManager.matchList;
            Collections.sort(sorted1);


            // for loop
            for (Match m : sorted1){
                tbv1.getItems().add(m);//adding iteams to the table view
            }
            lal1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    tbv1.getItems().clear(); //clear existing tabale view
                    Match found = premierLeagueManager.getMatchByDate(txtNa.getText()); //get match date add to the txtna text feild
                    tbv1.getItems().add(found); //adding iteams to the table view

                }
            });


            pane.getChildren().addAll(tbv1,l1,lal1, txtNa); //adding buttons and labales to the pane
            tbv1.setMinWidth(525);
            txtNa.setLayoutX(250);//set textfeild location


            Stage stage1 = new Stage();//create a stage
            stage1.setScene(new Scene(pane,650, 650));// set pane size
            tbv1.setLayoutX(25);
            tbv1.setLayoutY(150); //set table view location

            stage1.showAndWait();







        });


















        HBox hb1 = new HBox();
        hb1.getChildren().addAll();
        hb1.setSpacing(10);
        hb1.setAlignment(Pos.CENTER);
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(btplma, btgo, btwin,btpmd);
        hb2.setSpacing(10);
        hb2.setAlignment(Pos.CENTER);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(hb1, hb2, tbv);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        btplma.setOnAction(event -> {


            //borderPane.setCenter(pane5);
            //borderPane.setRight(null);

                FootballClub rndTOne, rndTTwo;
                int rndSOne, rndSTwo;
                LocalDate rndLocalDate;
                int iOne = 0, iTwo = 0;


                if ((premierLeagueManager.getClubList().size() >= 2)) {

                    Random rnd = new Random();
//                do{
                    iOne = new Random().nextInt(premierLeagueManager.getClubList().size());
                    boolean two = true;
                    while (two) {
                        iTwo = new Random().nextInt(premierLeagueManager.getClubList().size());
                        if (iOne == iTwo) {
                            two = true;
                        } else {
                            two = false;
                        }
                    }


                    rndTOne = (premierLeagueManager.getClubList().get(iOne));
                    rndTTwo = (premierLeagueManager.getClubList().get(iTwo));

                    rndSOne = rnd.nextInt(20);
                    rndSTwo = rnd.nextInt(20);


                    System.out.println("Team one" + rndTOne.getNameOfTheClub());
                    System.out.println("Team two" + rndTTwo.getNameOfTheClub());
                    System.out.println("Team one Score" + rndSOne);
                    System.out.println("Team two Score" + rndSTwo);

                    long sD = new Date("01/01/2020").getTime();
                    long eD = new Date("01/01/2021").getTime();

//generate a random long with this start and end date
                    Random r = new Random();
                    long random = eD + (long) (r.nextDouble() * (sD - eD));

                    Date resultdate = new Date(random);
                    System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(resultdate));

                    premierLeagueManager.addMatch(rndTOne.getClubID(), String.valueOf(rndSOne),
                            rndTTwo.getClubID(), String.valueOf(rndSTwo), resultdate);
                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.CONFIRMATION);
                    a.setContentText("random match generated successfully !!!\n"+
                            "Teat One   :"+ rndTOne.getNameOfTheClub()+"\n"+
                            "Team Two   :"+ rndTTwo.getNameOfTheClub()+"\n"+
                            "Team One Score   :"+ rndSOne +"\n"+
                            "Team Two Score   :"+ rndSTwo +"\n"+
                            "Teat One   :"+resultdate);










                        // show the dialog
                    a.show();
                    saveFile();

                }










//                }while (rndTOne.getNameOfTheClub().equals(rndTOne.getNameOfTheClub()));









        });



        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void setPremierLeagueManager(LeagueManager premierLeagueManager) {
    }

    private static void saveFile(){
        File filename = new File("./premierLeague.ser");

        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(premierLeagueManager);
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

