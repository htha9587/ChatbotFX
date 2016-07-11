package chat.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import chat.ChatbotRunner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Version 1.3
 * @author htha9587
 * 7-11-16
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
	}
	
	
	public void setChatbotRunner(ChatbotRunner chatbotRunner)
	{
		this.chatbotRunner = chatbotRunner;
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
		engine.load("https://www.google.com/maps");
		}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
}
}