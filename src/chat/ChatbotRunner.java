package chat;


import java.io.IOException;

/**
 * Version 0.5
 * @author htha9587
 * 7-5-16
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ChatbotRunner extends Application 
{
	private Stage primaryStage;
	private BorderPane rootLayout;
	/**
	 * Sets stage with the scene.
	 */
	@Override
	public void start(Stage primaryStage) 
	{	
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ChatbotFX");
		
		//Sets Application Icon.
		this.primaryStage.getIcons().add(new Image("file:resources/images/HAL.png"));
		
		initRootLayout();
	}
	
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader(ChatbotRunner.class.getResource("view/ChatbotView.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
 /**
  * Returns main stage.
  */
 public Stage getPrimaryStage()
 {
	 return primaryStage;
 }
 
	/**
	 * Runs the program.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}
}
