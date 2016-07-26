package chat.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * Version 4.8
 * @author htha9587
 * 7-26-16
 */


public class ChatbotMapController implements Initializable
{
	@FXML
	private WebView webView;
	
	private WebEngine engine;
	
	public ChatbotMapController()
	{
		
	}
	/**
	 * Initializes the new FXML file.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		engine = webView.getEngine();
		engine.setJavaScriptEnabled(true);
		engine.load("https://www.google.com/maps");
	}

}
