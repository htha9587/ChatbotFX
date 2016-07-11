package chat.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import chat.ChatbotRunner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Version 1.2
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
		Stage webView = new Stage();
		
	   Parent root = FXMLLoader.load(getClass().getResource("view/ChatbotMap.fxml"));
	   
	   Scene scene = new Scene(root);
	   webView.setScene(scene);
	   
		engine.load("https://www.google.com/maps");
		}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
}
}