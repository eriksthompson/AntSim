package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class fxApp extends Application {
	
    @Override
    public void start(Stage stage) throws IOException {
		/*
		 * FXMLLoader fxmlLoader = new
		 * FXMLLoader(fxApp.class.getResource("hello-view.fxml")); 
		 * Scene scene = new Scene(fxmlLoader.load(), 600, 600); 
		 * stage.setScene(scene);
		 * stage.setTitle("Ant Simulator!");
		 * 
		 * stage.show();
		 */
    	
    	 //JavaFx load the GUI from FXML file ... super 
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Ant Simulator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        
        

        // add music change bip.mp3 to music 
//        String bip = "bip.mp3";
//        Media hit = new Media(bip);
//        MediaPlayer mediaPlayer = new MediaPlayer(hit);
//        //set player property to autoplay
//        mediaPlayer.setAutoPlay(true);
//
//        // Create the view and add it to the Scene.
//        MediaView mediaView = new MediaView(mediaPlayer);
//        ((Group) scene.getRoot()).getChildren().add(mediaView);
        
    }

    public static void main(String[] args) {
        launch();
    }
}