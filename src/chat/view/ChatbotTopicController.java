package chat.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import chat.ChatbotRunner;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Version 4.9
 * @author htha9587
 * 7-26-16
 */


public class ChatbotTopicController implements Initializable
{
	@FXML
	private TableView tableView;
	
	private ObservableList data;
	private Text ActionStatus;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		
		
	}
	
	@FXML
	private void handleAbout(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setHeaderText("ChatbotFX: About");
		alert.setContentText("ChatbotFX is a JavaFX application that performs the same tasks"
				+ " as Chatbot (Swing), but with better GUI and more features."
				+ " ChatbotFX returns and talks about information input by the user, has file loading and saving"
				+ " capabilities, and utilizes the Twitter4J API.");
		
		//Sets window so it shares application icon.
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:resources/images/HAL.png"));
		alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
		
		alert.showAndWait();
		
	}
		
	@FXML
	private void handleHelpButton(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help");
		alert.setHeaderText("ChatbotFX: Help");
		alert.setContentText("ChatbotFX is a JavaFX application that performs the same tasks");
		
		//Sets window so it shares application icon.
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:resources/images/HAL.png"));
		alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
		
		alert.showAndWait();
	}
	
	
	}
	


