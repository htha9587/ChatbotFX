package chat;


import java.io.IOException;
import java.util.Optional;

import chat.view.ChatbotViewController;

/**
 * Version 4.3
 * @author htha9587
 * 7-21-16
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		//Sets up dialog before main application.
		TextInputDialog dialog = new TextInputDialog("Harrison");
		dialog.setTitle("ChatbotFX");
		dialog.setHeaderText("This message brought to you by ChatbotFX.");
		dialog.setContentText("What's your name?");
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:resources/images/HAL.png"));
		dialog.setGraphic(new ImageView("file:resources/images/HAL.png"));
		//Retrieves response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent())
		{
			dialog.setResult("Hello " + result.get());
		}
		
		//Sets main stage and scene.
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
            //Gives Controller reference to main class.
            ChatbotViewController controller = loader.getController();
            controller.setChatbotRunner(this);
            
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
