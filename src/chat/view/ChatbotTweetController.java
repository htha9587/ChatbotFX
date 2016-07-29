package chat.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * Version 5.5
 * @author htha9587
 * 7-29-16
 *
 */
public class ChatbotTweetController implements Initializable
{
	@FXML
	private WebView webView;
	
	private WebEngine engine;
	
	/**
	 * Initializes new FXML file which allows user to see the tweet they posted on Twitter.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		engine = webView.getEngine();
		engine.setJavaScriptEnabled(true);
		engine.load("https://twitter.com/ChatbotCTEC");
	}

	public ChatbotTweetController()
	{
		
	}
	
	
}
