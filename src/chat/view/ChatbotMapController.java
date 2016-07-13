package chat.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * Version 1.7
 * @author htha9587
 * 7-13-16
 */


public class ChatbotMapController implements Initializable
{
	@FXML
	private WebView webView;
	
	private WebEngine engine;
	
	public ChatbotMapController()
	{
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		engine = webView.getEngine();
		engine.setJavaScriptEnabled(true);
		engine.load("https://www.google.com/maps");
	}

}
