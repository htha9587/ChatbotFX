package chat.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.calendarfx.view.CalendarView;

import chat.ChatbotRunner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Version 2.6
 * @author htha9587
 * 7-14-16
 */

public class ChatbotViewController 
{
	@FXML
	private WebView webView;
	@FXML
	private TextField chatField;
	@FXML
	private TextArea chatArea;
	@FXML
	private Button chatButton;
	@FXML
	private Button mapButton;
	@FXML
	private Button calendarButton;
	@FXML
	private Button topicListButton;
	@FXML
	private Button quitButton;
	@FXML
	private Button loadButton;
	@FXML
	private Button saveButton;
	@FXML
	private Button sendButton;
	@FXML
	private Button searchButton;
	
	private WebEngine engine;
	private AnchorPane rootLayout;
	private BorderPane rootLayout2;
	
	//Reference to main application.
	private ChatbotRunner chatbotRunner;
	
	/**
	 * Constructor called before initialize method.
	 */
	public ChatbotViewController()
	{
		
	}
	
	public void initialize(URL location, ResourceBundle resources)
	{
	engine = webView.getEngine();
	engine.setJavaScriptEnabled(true);
	engine.load("https://www.google.com/maps");
	}
	
	
	public void setChatbotRunner(ChatbotRunner chatbotRunner)
	{
		this.chatbotRunner = chatbotRunner;
	}
	
	@FXML
	private void handleQuitButton(ActionEvent event)
	{
		//Sets up quit dialog.
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Goodbye!");
		alert.setHeaderText(null);
		alert.setContentText("It has been a pleasure talking with you!");
		alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
		//Gets the stage.
		Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
		stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
		alert.showAndWait();
		System.exit(0); //Closes the application.
	}
	
	@FXML
	private void handleCalendarButton(ActionEvent event)
	{
		try
		{
			//Loads FXML file.
		FXMLLoader loader = new FXMLLoader(ChatbotRunner.class.getResource("view/ChatbotCalendar.fxml"));
		rootLayout2 = (BorderPane) loader.load();
		Scene scene = new Scene(rootLayout2);
		Stage calendarView = new Stage();
		calendarView.setScene(scene);
		calendarView.setTitle("Have anything planned?"); //Sets title.
		calendarView.getIcons().add(new Image("file:resources/images/HAL.png")); //Sets Icon on the top of the window.
	    calendarView.show();
		}
	catch(IOException e)
	{
		e.printStackTrace();
	}
		
}

	@FXML
	private void handleMapButton(ActionEvent event)
	{
		try
		{
			//Loads FXML file.
		FXMLLoader loader = new FXMLLoader(ChatbotRunner.class.getResource("view/ChatbotMap.fxml"));
		rootLayout = (AnchorPane) loader.load();
		Scene scene = new Scene(rootLayout);
		Stage webView = new Stage();
		webView.setScene(scene);
		webView.setTitle("Can you find yourself here?"); //Sets title.
		webView.getIcons().add(new Image("file:resources/images/HAL.png")); //Sets Icon on the top of the window.
	    webView.show();
		}
	catch(IOException e)
	{
		e.printStackTrace();
	}
		
}
}