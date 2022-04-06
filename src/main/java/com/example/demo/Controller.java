package com.example.demo;

import javafx.fxml.FXML;


import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class Controller {
    Random randNum = new Random();
    //Position hold constants for map size
    int x = Position.mapXsize;
    int y = Position.mapYsize;
    
    Button[][] btn = new Button[x][y];
    public static int[][] gameGrid = new int[Position.mapXsize][Position.mapYsize];
    ArrayList<Ant> ants = new ArrayList<>();
    ArrayList<Country2> country2 = new ArrayList<Country2>();
    ArrayList<Country3> country3 = new ArrayList<Country3>();
    ArrayList<Country4> country4 = new ArrayList<Country4>();
    ArrayList<Water> water = new ArrayList<>();
    ArrayList<Forest> forest = new ArrayList<Forest>();
    ArrayList<water2> Water2 = new ArrayList<water2>();
    //GridPane gPane = new GridPane();
//    Image k = new Image("resources/Koala.jpg");
    @FXML
    private AnchorPane aPane;

    @FXML
    private GridPane gPane;


    @FXML
    private void handleStart(ActionEvent event) {

        //after adding the grdipane in scenebuilder, modify the fxml manually to eliminate
        // rows and columns


//        gPane.setMinSize(0,0);
        //gPane.setPadding(new Insets(btn[i][j]));
        //gPane.setHgap(10);
        //gPane.setVgap(10);
        //gPane.setGridLinesVisible(true);
        //gPane.setAlignment(Pos.CENTER);

        for(int i=0; i<btn.length; i++){
            for(int j=0; j<btn[0].length;j++){

                //Initializing 2D buttons with values i,j
                btn[i][j] = new Button();
                btn[i][j].setStyle("-fx-background-color:#808080");

                btn[i][j].setPrefWidth(25);

//                btn[i][j].setPrefSize(25, 5);
                //Paramters:  object, columns, rows
                gPane.add(btn[i][j], j, i);
                gameGrid[i][j]=0;


            }

        }
        for(int i = 0; i<15; i++){
            int xCoord = (int) (Math.random() * 19) +1;
            int yCoord = (int) (Math.random() * 29) +1;
            gameGrid[xCoord][yCoord] = 2;
            water.add(new Water(xCoord, yCoord));
            btn[xCoord][yCoord].setStyle("-fx-background-color:#808080");
//            System.out.println("Set");
        }
        
        for(int i = 0; i<15; i++){
            int xCoord = (int) (Math.random() * 19) +1;
            int yCoord = (int) (Math.random() * 29) +1;
            gameGrid[xCoord][yCoord] = 6;
            forest.add(new Forest(xCoord, yCoord));
            btn[xCoord][yCoord].setStyle("-fx-background-color:#008000");
//            System.out.println("Set");
        }
        for(int i = 19; i>10; i--){
            int xCoord = i;
            int yCoord = 9;
            gameGrid[xCoord][yCoord] = 7;
            Water2.add(new water2(xCoord, yCoord));
            btn[xCoord][yCoord].setStyle("-fx-background-color:#0000ff");
//            System.out.println("Set");
        }
        for(int i = 10; i > -1; i--){
            int xCoord = i;
            int yCoord = 10;
            gameGrid[xCoord][yCoord] = 7;
            Water2.add(new water2(xCoord, yCoord));
            btn[xCoord][yCoord].setStyle("-fx-background-color:#0000ff");
//            System.out.println("Set");
        }
        gPane.setGridLinesVisible(true);

        gPane.setVisible(true);

        EventHandler<MouseEvent> z = new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent t)
            {
                //ObservableList<Node> children = gPane.getChildren();
                //used to get a list of all children in gridpane
//                System.out.println("hello");
//                ((ImageView) t.getSource()).setImage(new Image("resources/Penguins.jpg"));
//
//                System.out.println("Row:    " + GridPane.getRowIndex(((ImageView) t.getSource())));
//                System.out.println("Column: " + GridPane.getColumnIndex(((ImageView) t.getSource())));
            }

        };
        for(int i=0; i<btn.length; i++){
            for(int j=0; j<btn[0].length;j++){
                btn[i][j].setOnMouseClicked(z);

            }
        }
        start();
    }
    @FXML
    public void handleAddAnt()
    {

//        if(gameGrid[7][8]==0){
//        ants.add(new Ant(0,0));
//        gameGrid[ants.get(ants.size()-1).getX()][ants.get(ants.size()-1).getY()]=1;

        country2.add(new Country2(0,19));
        gameGrid[country2.get(country2.size()-1).getX()][country2.get(country2.size()-1).getY()]=3;

        country3.add(new Country3(19,0));
        gameGrid[country3.get(country3.size()-1).getX()][country3.get(country3.size()-1).getY()]=4;

        country4.add(new Country4(19,19));
        gameGrid[country4.get(country4.size()-1).getX()][country4.get(country4.size()-1).getY()]=5;
//            System.out.println("test");
//        }
        updateScreen();
    }


    public void updateScreen(){
        // 0 = empty, 1 = ant child, 2 = ant adult
        for(int i=0; i<btn.length; i++) {
            for (int j = 0; j < btn[0].length; j++) {
                if (gameGrid[i][j]==0){
                    btn[i][j].setStyle("-fx-background-color:#d3d3d3");
                }
                else if (gameGrid[i][j]==1){
                    btn[i][j].setStyle("-fx-background-color:#ffcccb");
                }
                else if (gameGrid[i][j]==2){
                    btn[i][j].setStyle("-fx-background-color:#808080");
                }
                else if (gameGrid[i][j]==3){
                    btn[i][j].setStyle("-fx-background-color:#ff0000");
                }
                else if (gameGrid[i][j]==4){
                    btn[i][j].setStyle("-fx-background-color:#0000ff");
                }
                else if (gameGrid[i][j]==5){
                    btn[i][j].setStyle("-fx-background-color:#00ff00");
                }
                else if (gameGrid[i][j]==6){
                    btn[i][j].setStyle("-fx-background-color:#008000");
                }
                else if (gameGrid[i][j]==7){
                    btn[i][j].setStyle("-fx-background-color:#0000ff");
                }
            }
        }
    }

    
 
    public void start() {

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(ants.size()>0) {
                    for (int i = 0; i < ants.size(); i++) {
                        if (now - ants.get(i).getStartTime() > 1000000000.0) {

                            //code to see if the current ant has a neighbor.
                            //Can be moved depending on how often you want to check.
                            if (ants.get(i).checkNeighbor(ants, gameGrid)) {
                                System.out.println("found neighbor ant");
                            }
                            if (ants.get(i).checkNeighborWater(water, gameGrid)) {
                                System.out.println("found neighbor water");
                            }
                            ants.get(i).changeLoc(gameGrid);
                            ants.get(i).resetStartTime();


                        }
                        if (now - ants.get(i).getReproduceTime() > 5000000000.0) {
                            System.out.println("reproduce");

                            country1reproduce(i);
                        }
                    }
                }
                if(country2.size()>0) {
                        for (int i = 0; i < country2.size(); i++) {
                            if (now - country2.get(i).getStartTime() > 1000000000.0) {

                                //code to see if the current ant has a neighbor.
                                //Can be moved depending on how often you want to check.
                                if (country2.get(i).checkNeighbor(country2, gameGrid)) {
                                    System.out.println("country2 found neighbor ant");
                                }
                                if (country2.get(i).checkNeighborWater(water, gameGrid)) {
                                    System.out.println("country2 found neighbor water");
                                }
                                country2.get(i).changeLoc(gameGrid);
                                country2.get(i).resetStartTime();


                            }
                            if (now - country2.get(i).getReproduceTime() > 5000000000.0 && country2.size() < 6) {
                                

                                country2reproduce(i);
                            }
                        }
                    }
                if(country3.size()>0) {
                    for (int i = 0; i < country3.size(); i++) {
                        if (now - country3.get(i).getStartTime() > 1000000000.0) {

                            //code to see if the current ant has a neighbor.
                            //Can be moved depending on how often you want to check.
                            if (country3.get(i).checkNeighbor(country3, gameGrid)) {
                                System.out.println("country3 found neighbor ant");
                            }
                            if (country3.get(i).checkNeighborWater(water, gameGrid)) {
                                System.out.println("country3 found neighbor water");
                            }
                            country3.get(i).changeLoc(gameGrid);
                            country3.get(i).resetStartTime();


                        }
                        if (now - country3.get(i).getReproduceTime() > 5000000000.0 && country3.size() < 6) {
                            

                            country3reproduce(i);
                        }
                    }
                }
                if(country4.size()>0) {
                    for (int i = 0; i < country4.size(); i++) {
                        if (now - country4.get(i).getStartTime() > 1000000000.0) {

                            //code to see if the current ant has a neighbor.
                            //Can be moved depending on how often you want to check.
                            if (country4.get(i).checkNeighbor(country4, gameGrid)) {
                                System.out.println("country4 found neighbor ant");
                            }
                            if (country4.get(i).checkNeighborWater(water, gameGrid)) {
                                System.out.println("country4 found neighbor water");
                            }
                            country4.get(i).changeLoc(gameGrid);
                            country4.get(i).resetStartTime();


                        }
                        if (now - country4.get(i).getReproduceTime() > 5000000000.0 && country4.size() < 6) {
                            

                            country4reproduce(i);
                        }
                    }
                }




//                    for (Ant a : ants){
//                        if(a.checkNeighbor(ants)){
//                            System.out.println("found neighbor");
//                        }
//
//                    }



                updateScreen();

//                System.out.println("test");
            }
        }.start();
    }
    private ArrayList<Position> tempLocs = new ArrayList<>();
    private ArrayList<Position> tempLocs2 = new ArrayList<>();
    private ArrayList<Position> tempLocs3 = new ArrayList<>();
    private ArrayList<Position> tempLocs4 = new ArrayList<>();
    public void country1reproduce(int antNum){
    	System.out.println("reproduce");
        tempLocs.clear();
        
        Ant current = ants.get(antNum);
        // find empty spot and add to templocs3 array
        Position newAntSpot = new Position(current.getX(), current.getY());
        newAntSpot = newAntSpot.getEmptyAroundMe();
        //tempLocs2.add(newAntSpot);
        
       // check if there is empty spot
        if(newAntSpot != null) {
        	 // reproduce on newAntSpot  //tempLocs3Array not needed?
        	ants.add(new Ant(newAntSpot.getX(), newAntSpot.getY()));
            gameGrid[newAntSpot.getX()][newAntSpot.getY()]=1;
        }
        
		/*
		 * for(int i = ants.get(antNum).getY(); i<ants.get(antNum).getY()+2;i++){
		 * for(int j = ants.get(antNum).getX();j<ants.get(antNum).getX()+2;j++){
		 * if(ants.get(antNum).getY()<gameGrid.length && ants.get(antNum).getX()
		 * <gameGrid[0].length){ if(checkEmptyAroundMe(j,i)){ // System.out.println("j:"
		 * + j); tempLocs.add(new Position(i,j)); } } } } if(tempLocs.size()>0){ int
		 * newLoc = (int)(Math.random()*tempLocs.size()); // System.out.println("y: "
		 * +tempLocs.get(newLoc).getY()); ants.add(new
		 * Ant(tempLocs.get(newLoc).getX(),tempLocs.get(newLoc).getY())); //
		 * System.out.println("y: " +tempLocs.get(newLoc).getY());
		 * gameGrid[ants.get(ants.size()-1).getX()][ants.get(ants.size()-1).getY()]=1;
		 */
            ants.get(antNum).resetReproduceTime();
        //}

    }
    public void country2reproduce(int antNum){
    	System.out.println("country2 reproduce");
        tempLocs2.clear();
        
        Country2 current = country2.get(antNum);
        // find empty spot and add to templocs3 array
        Position newAntSpot = new Position(current.getX(), current.getY());
        newAntSpot = newAntSpot.getEmptyAroundMe();
        //tempLocs2.add(newAntSpot);
        
       // check if there is empty spot
        if(newAntSpot != null) {
        	 // reproduce on newAntSpot  //tempLocs3Array not needed?
        	country2.add(new Country2(newAntSpot.getX(), newAntSpot.getY()));
            gameGrid[newAntSpot.getX()][newAntSpot.getY()]=3;
        }
        
		/*
		 * for(int i = country2.get(antNum).getY();
		 * i<country2.get(antNum).getY()+2;i++){ for(int j =
		 * country2.get(antNum).getX();j<country2.get(antNum).getX()+2;j++){
		 * if(country2.get(antNum).getY()<gameGrid.length && country2.get(antNum).getX()
		 * <gameGrid[0].length){ if(checkEmptyAroundMe(j, i)){ //
		 * System.out.println("j:" + j); tempLocs2.add(new Position(j, i)); } } } }
		 * if(tempLocs2.size()>0){ int newLoc = (int)(Math.random()*tempLocs2.size());
		 * // System.out.println("y: " +tempLocs2.get(newLoc).getY()); country2.add(new
		 * Country2(tempLocs2.get(newLoc).getX(),tempLocs2.get(newLoc).getY())); //
		 * System.out.println("y: " +tempLocs2.get(newLoc).getY());
		 * gameGrid[country2.get(country2.size()-1).getX()][country2.get(country2.size()
		 * -1).getY()]=1;
		 */
            country2.get(antNum).resetReproduceTime();
        //}


    }
    public void country3reproduce(int antNum){
    	System.out.println("country3 reproduce");
        tempLocs3.clear();
        
        Country3 current = country3.get(antNum);
        // find empty spot and add to templocs3 array
        Position newAntSpot = new Position(current.getX(), current.getY());
        newAntSpot = newAntSpot.getEmptyAroundMe();
        //tempLocs3.add(newAntSpot);
        
       // check if there is empty spot
        if(newAntSpot != null) {
        	 // reproduce on newAntSpot  //tempLocs3Array not needed?
        	country3.add(new Country3(newAntSpot.getX(), newAntSpot.getY()));
            gameGrid[newAntSpot.getX()][newAntSpot.getY()] = 4;
        }
        
        
		/*
		 * for(int i = country3.get(antNum).getY();
		 * i<country3.get(antNum).getY()+2;i++){ for(int j =
		 * country3.get(antNum).getX();j<country3.get(antNum).getX()+2;j++){
		 * if(country3.get(antNum).getY()<gameGrid.length && country3.get(antNum).getX()
		 * <gameGrid[0].length){ if(checkEmptyAroundMe(j,i)){ // System.out.println("j:"
		 * + j); tempLocs3.add(new Position(i,j)); } } }
		 */
            //int newLoc = (int)(Math.random()*tempLocs3.size());
//            System.out.println("y: " +tempLocs3.get(newLoc).getY());
            //country3.add(new Country3(tempLocs3.get(newLoc).getX(),tempLocs3.get(newLoc).getY()));
//            System.out.println("y: " +tempLocs3.get(newLoc).getY());
           // gameGrid[country3.get(country3.size()-1).getX()][country3.get(country3.size()-1).getY()]=1;

            country3.get(antNum).resetReproduceTime();
    //}

    }
    public void country4reproduce(int antNum){
    		System.out.println("country4 reproduce");
    		tempLocs4.clear();
            Country4 current = country4.get(antNum);
            
            // find empty spot and add to templocs3 array
            Position newAntSpot = new Position(current.getX(), current.getY());
            newAntSpot = newAntSpot.getEmptyAroundMe();
            //tempLocs3.add(newAntSpot);
            
           // check if there is empty spot
            if(newAntSpot != null) {
            	 // reproduce on newAntSpot  //tempLocs3Array not needed?
            	country4.add(new Country4(newAntSpot.getX(), newAntSpot.getY()));
                gameGrid[newAntSpot.getX()][newAntSpot.getY()]=5;
            }
    		
//        tempLocs4.clear();
//        for(int i = country4.get(antNum).getY(); i<country4.get(antNum).getY()+2;i++){
//            for(int j = country4.get(antNum).getX();j<country4.get(antNum).getX()+2;j++){
//                if(country4.get(antNum).getY()<gameGrid.length && country4.get(antNum).getX() <gameGrid[0].length){
//                    if(checkEmptyAroundMe(i, j)){
////                        System.out.println("j:" + j);
//                        tempLocs4.add(new Position(i,j));
//                    }
//                }
//            }
//        }
//        if(tempLocs4.size()>0){
//            int newLoc = (int)(Math.random()*tempLocs4.size());
////            System.out.println("y: " +tempLocs.get(newLoc).getY());
//            country4.add(new Country4(tempLocs4.get(newLoc).getX(),tempLocs4.get(newLoc).getY()));
////            System.out.println("y: " +tempLocs.get(newLoc).getY());
//            gameGrid[country4.get(country4.size()-1).getX()][country4.get(country4.size()-1).getY()]=1;
//
            country4.get(antNum).resetReproduceTime();
//        }

    }
    
    
	/* *Now in Position class* 
	 * 
	 * public boolean checkEmptyAroundMe(int i, int j){ //old method - //return
	 * gameGrid[i][j] == 0;
	 * 
	 * }
	 */

    public void death(){
        int c1 = random(1, 4);
        int c2 = random(1, 4);
        int c3 = random(1, 4);
        int c4 = random(1, 4);
        for (int i = 0; i < ants.size(); i++){
            if(ants.get(i).getDeathTime() == 10000000000.0){
                ants.remove(i);
                ants.get(i).resetDeathTime();
            }
        }
        for (int i = 0; i < country2.size(); i++){
            if(country2.get(i).getDeathTime() == 10000000000.0){
                country2.remove(i);
                country2.get(i).resetDeathTime();
            }
        }
        for (int i = 0; i < country3.size(); i++){
            if(country3.get(i).getDeathTime() == 10000000000.0){
                country3.remove(i);
                country3.get(i).resetDeathTime();
            }
        }
        for (int i = 0; i < country4.size(); i++){
            if(country4.get(i).getDeathTime() == 10000000000.0){
                country4.remove(i);
                country4.get(i).resetDeathTime();
            }
        }

    }

    protected int random (int lower, int upper){

        return (int) ((Math.random() * (upper - lower) + (1)) + lower);

    }
//9,10
    //8,10
    public void addBridge(){
        for(int i = 0; i < Water2.size(); i++){
            if(Water2.get(i).getX() == 5 && Water2.get(i).getY() == 10){
                Water2.remove(i);
                gameGrid[5][10] = 0;

            }
            if(Water2.get(i).getX() == 6 && Water2.get(i).getY() == 10){
                Water2.remove(i);
                gameGrid[6][10] = 0;

            }
        }
    }
    public void startWar(){

    }
}