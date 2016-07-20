package chat.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.calendarfx.view.CalendarView;
import chat.ChatbotRunner;
import chat.model.CTECTwitter;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

/**
 * Version 3.9
 * @author htha9587
 * 7-20-16
 * @param <T>
 */

public class ChatbotViewController<T> 
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
	private CTECTwitter myTwitter;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private String fileName;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String path;
	private String file;
	private T data;
	private Twitter chatbotTwitter;
	//private ChatbotViewController baseController;
	protected static final User List = null;
	Twitter twitter;
	
	//Reference to main application.
	private ChatbotRunner chatbotRunner;
	
	/**
	 * Constructor called before initialize method.
	 */
	public ChatbotViewController()
	{
		myTwitter = new CTECTwitter(this);
		String user = null;
		harryBot = new ChatbotModel(user);
		chatbotTwitter = TwitterFactory.getSingleton();
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
		String result = chatField.getText();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Sending!");
		alert.setHeaderText(null);
		alert.setContentText("Sending your Tweet!");
		alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
		//Gets the stage.
		Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
		stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
		alert.showAndWait();
		
		// Sends tweet by having user type in the text field and clicking the send button.
		try {
			chatbotTwitter.updateStatus("ChatbotFX: " + chatField.getText()
					+ "#APCSROCKS @CTECNow Thanks @ cscheerleader & @codyhenrichsen!");
		} catch (twitter4j.TwitterException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Searches for tweets and returns results.
	 * @param input
	 * @return
	 */
	public String chatbotTwitterSearch(String input)
	{
		String result = chatField.getText();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Searching...");
		alert.setHeaderText(null);
		alert.setContentText("Give me a second...");
		alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
		//Gets the stage.
		Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
		stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
		alert.showAndWait();
		
		//Searches for tweets by having the user type in the text field and hitting the search button.
		Query query = new Query(chatField.getText());
		query.setCount(10);
		//query.setGeoCode(new GeoLocation(40.587521, -111.869178), 500, Query.MILES);
		query.setSince("2016-1-1");
		try
		{
			QueryResult qResult = chatbotTwitter.search(query);
			result += "Count : " + qResult.getTweets().size() + "\n";
			for (Status tweet : qResult.getTweets())
			{
				result += "@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n";
			}
		}
		
		catch (TwitterException e)
		{
			e.printStackTrace();
		}
		
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
	private void handleChatButton(ActionEvent event)
	{
		String userText = chatField.getText(); //Grabs user Text.
		String response = fromUserToChatbot(userText); //Displays user text.
		chatArea.appendText("\nUser: " + userText); //Gives text to Model for processing.
		chatArea.appendText("\nChatbotFX: " + response); //Gets and displays answer.
		chatField.setText(""); //Clears user field.
	}
	
	@FXML
	private void handleTweetButton(ActionEvent event)
	{
		String userText = chatField.getText(); //Grabs user text.
		String response = fromChatbottoTwitter(userText); //Displays user text.
		chatArea.appendText("\nUser: " + userText); //Gives text to model for processing.
		chatArea.appendText("\nUser: " + response); //Gets and displays answer.
		chatField.setText(""); //Clears user field.
	}
	
	@FXML
	private void handleSearchButton(ActionEvent event)
	{
		String userText = chatField.getText(); //Grabs user text.
		String response = chatbotTwitterSearch(userText); //Displays user text.
		chatArea.appendText("\nUser: " + userText); //Gives text to model for processing.
		chatArea.appendText("\nUser: " + response); //Gets and displays answer.
		chatField.setText(""); //Clears user field.
	}
	
	@FXML
	private void handleSaveButton(ActionEvent event)
	{
		String userText = chatArea.getText(); //Grabs conversation text.
		bufferedWriter(userText); //Displays user text.
		chatArea.appendText("\nUser: " + userText); //Gets and displays answer.
		chatField.setText(""); //Clears user field.
	}
	
	@FXML
	private void handleLoadButton(ActionEvent event)
	{
		//Loads text file into TextArea.
		FileChooser fileChooser = new FileChooser();
		StringBuilder sb = null;
		fileChooser.setTitle("Find the conversation file!");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		 //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
		//Show save file dialog.
        File file = fileChooser.showOpenDialog(null);
        sb = readFile(file);
        chatArea.setText(sb.toString());
	}
	
	public StringBuilder readFile(File selectedFile){
		         StringBuilder sb = new StringBuilder(1024);
		         String curLine = "";
		         try{
		              FileReader fr = new FileReader(selectedFile);
		              BufferedReader br = new BufferedReader(fr);
		          
		             while(curLine != null){
		                 curLine = br.readLine();
		                 sb.append(curLine).append("\n");
		             }
		         } catch (Exception e){
		             e.getMessage();
		         }
		        return sb;
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
	
	
	//Getter for the text field.
	public TextField getTextField()
	{
		return chatField;
	}
	
	public T getData()
	{
		return data;
	}
	
}