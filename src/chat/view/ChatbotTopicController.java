package chat.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import chat.ChatbotRunner;
import chat.model.Topic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Version 5.1
 * @author htha9587
 * 7-27-16
 */


public class ChatbotTopicController implements Initializable
{
	@FXML
	private TableView<Topic> tableView;
	
	@FXML
	private TableColumn<Topic, String> topic;
	
	@FXML
	private TableColumn<Topic, String> item;
	
	private ObservableList data;
	private Text ActionStatus;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		//TableView and data properties.
		topic.setCellValueFactory(new PropertyValueFactory<Topic, String>("topic"));
		item.setCellValueFactory(new PropertyValueFactory<Topic, String>("item"));
		tableView.setItems(list);
		tableView.setEditable(false);
	}
	
	// Loads table with topics and their respective items.
	private ObservableList<Topic> list = FXCollections.observableArrayList(
			new Topic("2016 Election", "Trump"),
			new Topic("2016 Election", "Clinton"),
			new Topic("2016 Election", "Scott Walker"),
			new Topic("2016 Election", "Biden"),
			new Topic("2016 Election", "Carson"),
			new Topic("2016 Election", "Rubio"),
			new Topic("2016 Election", "Fiorina"),
			new Topic("2016 Election", "Sanders"),
			new Topic("2016 Election", "vote"),
			new Topic("2016 Election", "11/4/16"),
			new Topic("Software Topics", "Spring Framework"),
			new Topic("Software Topics", "Java EE"),
			new Topic("Software Topics", "Angular JS"),
			new Topic("Software Topics", "Django"),
			new Topic("Software Topics", "Git"),
			new Topic("Software Topics", "Jira"),
			new Topic("Software Topics", "Maven"),
			new Topic("Software Topics", "Machine Learning"),
			new Topic("Software Topics", "Unit Testing"),
			new Topic("Software Topics", "DevOps"),
			new Topic("Keyboard Mash", "sdf"),
			new Topic("Keyboard Mash", ",./"),
			new Topic("Keyboard Mash", "dfg"),
			new Topic("Keyboard Mash", "cvb"),
			new Topic("Keyboard Mash", "asdf"),
			new Topic("Keyboard Mash", "jkl;"),
			new Topic("Keyboard Mash", "qwerty"),
			new Topic("Keyboard Mash", "12345"),
			new Topic("Keyboard Mash", "rthrthr"),
			new Topic("Keyboard Mash", "764677"),
			new Topic("Best Film Soundtracks", "Blade Runner Soundtrack"),
			new Topic("Best Film Soundtracks", "Interstellar Soundtrack"),
			new Topic("Best Film Soundtracks", "The Social Network Soundtrack"),
			new Topic("Best Film Soundtracks", "Oblivion Soundtrack"),
			new Topic("Best Film Soundtracks", "Tron Legacy Soundtrack"),
			new Topic("Best Film Soundtracks", "Cloud Atlas Soundtrack"),
			new Topic("Best Film Soundtracks", "Gravity Soundtrack"),
			new Topic("Best Film Soundtracks", "Inception Soundtrack"),
			new Topic("Best Film Soundtracks", "2001: A Space Odyssey Soundtrack"),
			new Topic("Best Film Soundtracks", "Pulp Fiction Soundtrack"),
			new Topic("Favorite Films", "Blade Runner"),
			new Topic("Favorite Films", "Interstellar"),
			new Topic("Favorite Films", "The Social Network"),
			new Topic("Favorite Films", "Terminator 2: Judgement Day"),
			new Topic("Favorite Films", "Solaris"),
			new Topic("Favorite Films", "Cloud Atlas"),
			new Topic("Favorite Films", "The Martian"),
			new Topic("Favorite Films", "Apocalypse Now"),
			new Topic("Favorite Films", "2001: A Space Odyssey"),
			new Topic("Favorite Films", "Citizen Kane"),
			new Topic("Favorite Sci-Fi Authors", "Robert Heinlein"),
			new Topic("Favorite Sci-Fi Authors", "Isaac Asimov"),
			new Topic("Favorite Sci-Fi Authors", "Arthur C. Clarke"),
			new Topic("Favorite Sci-Fi Authors", "Orson Scott Card"),
			new Topic("Favorite Sci-Fi Authors", "Phillip K. Dick"),
			new Topic("Favorite Sci-Fi Authors", "Ray Bradbury"),
			new Topic("Favorite Sci-Fi Authors", "Jules Verne"),
			new Topic("Favorite Sci-Fi Authors", "H.G Wells"),
			new Topic("Favorite Sci-Fi Authors", "Frank Herbert"),
			new Topic("Favorite Sci-Fi Authors", "William Gibson"),
			new Topic("Music Genres", "Rock"),
			new Topic("Music Genres", "Ambient"),
			new Topic("Music Genres", "Industrial"),
			new Topic("Music Genres", "Electronic"),
			new Topic("Music Genres", "Love"),
			new Topic("Music Genres", "Acoustic"),
			new Topic("Music Genres", "Blues"),
			new Topic("Music Genres", "Folk"),
			new Topic("Music Genres", "Indie"),
			new Topic("Music Genres", "Classical"),
			new Topic("Favorite Game Series", "Deus Ex Series"),
			new Topic("Favorite Game Series", "Mass Effect Series"),
			new Topic("Favorite Game Series", "Mario Series"),
			new Topic("Favorite Game Series", "Tomb Raider Series"),
			new Topic("Favorite Game Series", "Uncharted Series"),
			new Topic("Favorite Game Series", "Doom Series"),
			new Topic("Favorite Game Series", "Quake Series"),
			new Topic("Favorite Game Series", "Crysis Series"),
			new Topic("Favorite Game Series", "Metal Gear Series"),
			new Topic("Favorite Game Series", "The Witcher Series"),
			new Topic("Favorite Foods", "Pasta"),
			new Topic("Favorite Foods", "Eggs"),
			new Topic("Favorite Foods", "Bread"),
			new Topic("Favorite Foods", "Cinnamon Rolls"),
			new Topic("Favorite Foods", "Grapes"),
			new Topic("Favorite Foods", "Rolls"),
			new Topic("Favorite Foods", "Biscuits"),
			new Topic("Favorite Foods", "Lasagna"),
			new Topic("Favorite Foods", "Salad"),
			new Topic("Favorite Foods", "Steak"),
			new Topic("Favorite Film Quotes", "I drink your milkshake!"),
			new Topic("Favorite Film Quotes", "This is the worst thing ever made."),
			new Topic("Favorite Film Quotes", "They call me Mister Tibbs!"),
			new Topic("Favorite Film Quotes", "Elementary, my dear Watson."),
			new Topic("Favorite Film Quotes", "Gentlemen, you can't fight in here!"),
			new Topic("Favorite Film Quotes", "That'll do, pig. That'll do."),
			new Topic("Favorite Film Quotes", "Good morning, Vietnam!"),
			new Topic("Favorite Film Quotes", "Go ahead, make my day."),
			new Topic("Favorite Film Quotes", "Pay no attention behind the curtain!"),
			new Topic("Favorite Film Quotes", "Failure to Communicate!")
		);
	
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