package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.java.utility.ResourceLocator;


public class MainApp extends Application {
    // App entry
    public static void main(String[] args) {
        Application.launch(MainApp.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
    	// Redirect to https
    	System.setProperty("yahoofinance.baseurl.histquotes", "https://ichart.yahoo.com/table.csv");
    	// Initialize current stage
    	// User login is the first page appears when user runs the app
    	FXMLLoader loader = new FXMLLoader(getClass().getResource(ResourceLocator.LOGIN_VIEW));
    	Parent root = (Parent)loader.load();
        stage.setTitle("Stock Tracker");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.getIcons().add(new Image(ResourceLocator.MSU_ICON));
        stage.show();
    }
}