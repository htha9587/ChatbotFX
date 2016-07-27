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
 * Version 5.0
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
			new Topic("2016 Election", "11/4/16")
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