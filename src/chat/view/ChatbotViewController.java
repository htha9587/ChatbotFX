package chat.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.calendarfx.view.CalendarView;
import chat.ChatbotRunner;
import chat.model.ChatbotFXTwitter;
import chat.model.ChatbotModel;
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
 * Version 3.2
 * @author htha9587
 * 7-15-16
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
	private ChatbotModel user;
	private ChatbotModel harryBot;
	private ChatbotFXTwitter myTwitter;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private String fileName;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String path;
	private String file;
	
	//Reference to main application.
	private ChatbotRunner chatbotRunner;
	
	/**
	 * Constructor called before initialize method.
	 */
	public ChatbotViewController()
	{
		myTwitter = new ChatbotFXTwitter(this);
		String user = null;
		harryBot = new ChatbotModel(user);
	}
	
	public void initialize(URL location, ResourceBundle resources)
	{
	engine = webView.getEngine();
	engine.setJavaScriptEnabled(true);
	engine.load("https://www.google.com/maps");
	}
	
	/**
	 * Getter for the model class.
	 * 
	 */
	public ChatbotModel getChatbotModel()
	{
		return harryBot;
	}
	
	public void setChatbotRunner(ChatbotRunner chatbotRunner)
	{
		this.chatbotRunner = chatbotRunner;
	}
	
	
	/**
	 *  Starts chat method.
	 * @param event
	 */
	public String fromUserToChatbot(String textFromUser)
	{
		String botResponse = "What do you like?";
		botResponse = harryBot.processConversation(textFromUser);
		return botResponse;
	}
	
	/**
	 * Sends tweet to Twitter.
	 * @param input
	 * @return
	 */
	public String fromChatbottoTwitter(String input)
	{
		String result = "";
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Sending!");
		alert.setHeaderText(null);
		alert.setContentText("Sending your Tweet!");
		alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
		//Gets the stage.
		Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
		stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
		alert.showAndWait();
		myTwitter.sendTweet("");
		
		return result;
	}
	
	/**
	 * Searches for tweets and returns results.
	 * @param input
	 * @return
	 */
	public String chatbotTwitterSearch(String input)
	{
		String result = "";
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Searching...");
		alert.setHeaderText(null);
		alert.setContentText("Give me a second...");
		alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
		//Gets the stage.
		Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
		stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
		alert.showAndWait();
		result = myTwitter.sampleInvestigaton();
		
		return result;
	}
	
	/**
	 * Writes text to a file and reads from said file.
	 * @param event
	 */
	public void bufferedWriter(String input)
	{
		String fileName = "ChatbotFXFile.txt"; //Filename
		
		try
		{
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Want me to save something of our conversation?");
			bufferedWriter.write(input);
			bufferedWriter.newLine();
			bufferedWriter.write("Watch as I save to a file!");
			
			//Closes file.
			bufferedWriter.close();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success!");
			alert.setHeaderText(null);
			alert.setContentText("Saved! Check ChatbotFXFile.txt!");
			alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
			//Gets the stage.
			Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
			stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
			alert.showAndWait();
			
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public String bufferedReader()
	{
		BufferedReader bufferedReader = null;
		
		String fileContents = "";
		
		try
		{
			File file = new File("ChatbotFXFile.txt");
			bufferedReader = new BufferedReader(new FileReader(file));
			
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Opened!");
			alert.setHeaderText(null);
			alert.setContentText("Opening your file!");
			alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
			//Gets the stage.
			Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
			stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
			alert.showAndWait();
			String currentLine = "";
			while ((currentLine = bufferedReader.readLine()) != null)
			{
				fileContents += currentLine + "\n";
			}

			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert.setTitle("Read!");
			alert.setHeaderText(null);
			alert.setContentText("Reading your file!");
			alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
			//Gets the stage.
			Stage stage2 = (Stage) alert.getDialogPane().getScene().getWindow();
			stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
			alert.showAndWait();
		}
		
		catch (IOException ex)
		
		{
			ex.printStackTrace();
		}
		
		finally
		{
			try 
			{
				bufferedReader.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		
		return fileContents;
		
	}
	
	public void openFile()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Hold Up!");
		alert.setHeaderText(null);
		alert.setContentText("Opening our conversation!");
		alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
		//Gets the stage.
		Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
		stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
		alert.showAndWait();
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