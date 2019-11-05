package com.westga.cs3211.prescription_app;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

/**
 * The main class of the application
 * @author Jeremy Trimble
 * @version 10/29/2019
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("./view/Dashboard.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The main method that is the entry point for the application
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
