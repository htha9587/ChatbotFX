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
 * Version 5.2
 * @author htha9587
 * 7-28-16
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
			new Topic("Favorite Film Quotes", "Failure to Communicate!"),
			new Topic("NASA Inventions", "Memory Foam"),
			new Topic("NASA Inventions", "Anti-corrosion Coating"),
			new Topic("NASA Inventions", "ArterioVision"),
			new Topic("NASA Inventions", "Cochlear Implants"),
			new Topic("NASA Inventions", "Scratch-resistant Eyeglass Lenses"),
			new Topic("NASA Inventions", "Emulsified Iron"),
			new Topic("NASA Inventions", "Insulin Pump"),
			new Topic("NASA Inventions", "Lifeshears"),
			new Topic("NASA Inventions", "Charge-coupled Device"),
			new Topic("NASA Inventions", "Water Filters"),
			new Topic("Biology Scientists", "Charles Darwin"),
			new Topic("Biology Scientists", "Gregor Mendel"),
			new Topic("Biology Scientists", "Aristotle"),
			new Topic("Biology Scientists", "Hippocrates"),
			new Topic("Biology Scientists", "Robert Hooke"),
			new Topic("Biology Scientists", "Louis Pasteur"),
			new Topic("Biology Scientists", "Edward Jenner"),
			new Topic("Biology Scientists", "Claude Bernard"),
			new Topic("Biology Scientists", "Robert Brown"),
			new Topic("Biology Scientists", "Galen"),
			new Topic("2007 Memes", "Squadala!"),
			new Topic("2007 Memes", "Mah Boi!"),
			new Topic("2007 Memes", "Gee, It sure is boring around here!"),
			new Topic("2007 Memes", "Enclosed Instruction Book"),
			new Topic("2007 Memes", "I can't wait to bomb some Dodongos!"),
			new Topic("2007 Memes", "Everything about Hotel Mario"),
			new Topic("2007 Memes", "YTP"),
			new Topic("2007 Memes", "Snooping as usual I see!"),
			new Topic("2007 Memes", "These are the faces of evil!"),
			new Topic("2007 Memes", "Enough!"),
			new Topic("Spooky Death", "Drowning"),
			new Topic("Spooky Death", "Immolation"),
			new Topic("Spooky Death", "Spaghettification"),
			new Topic("Spooky Death", "Inquisition Tortures"),
			new Topic("Spooky Death", "Shredding"),
			new Topic("Spooky Death", "Amusement Park Rides"),
			new Topic("Spooky Death", "Decapitation"),
			new Topic("Spooky Death", "Vacuum Exposure"),
			new Topic("Spooky Death", "Viruses"),
			new Topic("Spooky Death", "Acid"),
			new Topic("Bad Jobs", "Mail Carrier"),
			new Topic("Bad Jobs", "Firefighter"),
			new Topic("Bad Jobs", "Taxi Driver"),
			new Topic("Bad Jobs", "Corrections Officer"),
			new Topic("Bad Jobs", "Photojournalist"),
			new Topic("Bad Jobs", "Broadcaster"),
			new Topic("Bad Jobs", "Cook"),
			new Topic("Bad Jobs", "Lumberjack"),
			new Topic("Bad Jobs", "Garbageman?"),
			new Topic("Bad Jobs", "Newspaper Reporter"),
			new Topic("Software Schools", "Harvard"),
			new Topic("Software Schools", "Carnegie Mellon"),
			new Topic("Software Schools", "Boston"),
			new Topic("Software Schools", "Santa Clara"),
			new Topic("Software Schools", "Villanova"),
			new Topic("Software Schools", "Denver"),
			new Topic("Software Schools", "Seattle"),
			new Topic("Software Schools", "Fairfield"),
			new Topic("Software Schools", "Rochester"),
			new Topic("Software Schools", "George Mason"),
			new Topic("Sad Topics", "Death"),
			new Topic("Sad Topics", "Heat Death"),
			new Topic("Sad Topics", "Entropy"),
			new Topic("Sad Topics", "Loneliness"),
			new Topic("Sad Topics", "Poverty"),
			new Topic("Sad Topics", "Starvation"),
			new Topic("Sad Topics", "Widow"),
			new Topic("Sad Topics", "Loss"),
			new Topic("Sad Topics", "Guilt"),
			new Topic("Sad Topics", "Anxiety?"),
			new Topic("Technical Interviews", "Algorithms and Data Structures"),
			new Topic("Technical Interviews", "Sorting & Searching"),
			new Topic("Technical Interviews", "Trees"),
			new Topic("Technical Interviews", "Hash Tables"),
			new Topic("Technical Interviews", "Graphs"),
			new Topic("Technical Interviews", "Sorting Algorithms"),
			new Topic("Technical Interviews", "Databases"),
			new Topic("Technical Interviews", "Bindings"),
			new Topic("Technical Interviews", "Documentation"),
			new Topic("Technical Interviews", "Technical Writing"),
			new Topic("Fast Cars", "Hennessey Venom GT"),
			new Topic("Fast Cars", "Bugatti Chiron"),
			new Topic("Fast Cars", "Bugatti Veyron Super Sport"),
			new Topic("Fast Cars", "SSC Ultimate Aero"),
			new Topic("Fast Cars", "Koenigsegg CCR"),
			new Topic("Fast Cars", "McLaren F1"),
			new Topic("Fast Cars", "Aston Martin One-77"),
			new Topic("Fast Cars", "Jaguar XJ220"),
			new Topic("Fast Cars", "Ferrari LaFerrari"),
			new Topic("Fast Cars", "McLaren P1"),
			new Topic("Deadliest Places", "Russia"),
			new Topic("Deadliest Places", "Brazil"),
			new Topic("Deadliest Places", "South Africa"),
			new Topic("Deadliest Places", "Burundi"),
			new Topic("Deadliest Places", "Antarctica"),
			new Topic("Deadliest Places", "Afghanistan"),
			new Topic("Deadliest Places", "Somalia"),
			new Topic("Deadliest Places", "Sudan"),
			new Topic("Deadliest Places", "Colombia"),
			new Topic("Deadliest Places", "Iraq")
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