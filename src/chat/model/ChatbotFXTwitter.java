package chat.model;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chat.view.ChatbotViewController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;//Add core jar to buildpath.
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

/**
 * Version 3.2
 * @author htha9587
 * 7-15-16
 */


public class ChatbotFXTwitter 
{
	private static final String Listener = null;
	private static final String baseFrame = null;
	private Twitter chatbotTwitter;
	private List<Status> statuses;
	private List<String> tweetTexts;
	private List<String> userList;
	private ChatbotViewController baseController;
	
	/**
	 * Constructor.
	 * @param baseController
	 */
	public ChatbotFXTwitter(ChatbotViewController baseController)
	{
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		statuses = new ArrayList<Status>();
		tweetTexts = new ArrayList<String>();
	}
	
	/**
	 * Send tweet message of a String type.
	 */
	public void sendTweet(String tweet)
	{
		try {
			chatbotTwitter.updateStatus("ChatbotFX is now live! "
					+ "#APCSROCKS @CTECNow Thanks @ cscheerleader & @codyhenrichsen!");
		} catch (twitter4j.TwitterException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Searches for tweets of a string type.
	 */
	public void searchTweet(String tweet)
	{
		if (tweet.length() < 1)
			try {
				chatbotTwitter.updateStatus("java twitter4J.examples.search.searchTweets [query]");
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	//Twitter twitter = new TwitterFactory().getInstance();
	try
	{
		Query query = new Query("JavaFX");
		QueryResult result;
		do
		{
			result = chatbotTwitter.search(query);
			List<Status> tweets = result.getTweets();
			for(Status tweet1: tweets)
			{
				//Working search dialog.
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Searching...");
				alert.setHeaderText(null);
				alert.setContentText("@" + tweet1.getUser().getScreenName() + "-" + tweet1.getText());
				alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
				//Gets the stage.
				Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
				stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
				alert.showAndWait();
			}
		}while ((query = result.nextQuery()) != null);
	}  catch(TwitterException te)
	{
		te.printStackTrace();
		//Returned search dialog if a failure occurs.
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Oops!");
		alert.setHeaderText(null);
		alert.setContentText("Failed to search for tweets: " + te.getMessage());
		alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
		//Gets the stage.
		Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
		stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
		alert.showAndWait();
		
	}
	finally
	{
		
	}
}
	
	/**
	 * Updates status.
	 */
	private void updateStatus(String string)
	{
		Twitter twitter = TwitterFactory.getSingleton();
		String latestStatus = null;
		try
		{
			Status status = twitter.updateStatus(latestStatus);
		} catch(TwitterException e)
		{
			e.printStackTrace();
		}
		//Status dialog.
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Updating Status!");
		alert.setHeaderText(null);
		alert.setContentText("Updating Status!");
		alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
		//Gets the stage.
		Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
		stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
		alert.showAndWait();
	}
	
	/**
	 * Gets home timeline.
	 */
	private void getHomeTimeline(String tweet)
	{
		Twitter twitter = new TwitterFactory().getInstance();
		try
		{
			User user = twitter.verifyCredentials();
		} catch(TwitterException e)
		{
			e.printStackTrace();
		}
		try {
			List <Status> statuses = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Status status : statuses)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Getting timeline...");
			alert.setHeaderText(null);
			alert.setContentText("@" + status.getUser().getScreenName() + "-" + status.getText());
			alert.setGraphic(new ImageView("file:resources/images/HAL.png"));
			//Gets the stage.
			Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
			stage1.getIcons().add(new Image("file:resources/images/HAL.png"));
			alert.showAndWait();
		}
	}
	
	/**
	 * Looks for APIStream.
	 */
	private void APIStream(String [] args) throws TwitterException, IOException
	{
		String twitterException = new TwitterException("").getExceptionCode();
	}
	
	public void onException(Exception ex)
	{
		ex.printStackTrace();
	}
	
	/**
	 * Makes Stats about Tweets.
	 */
	public String topResults(List<String> wordList)
	{
		String tweetResults = "";
		return tweetResults;
	}
	/**
	 * Loads ten JavaFX related tweets.
	 */
	public void loadTweets(String twitterHandle) throws TwitterException, FileNotFoundException
	{
		statuses.clear();
		List<Status> wordList = null;
		wordList.clear();
		Paging StatusPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			StatusPage.setPage(page);
			statuses.addAll(chatbotTwitter.getUserTimeline(twitterHandle, StatusPage));
			page++;
		} for(Status currentStatus : statuses)
		{
			String[]  tweetText = currentStatus.getText().split("");
			for(String word: tweetText)
			{
				tweetTexts.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(tweetTexts);
		removeEmptyText();
	}
/**
 * Removes empty tweet text from the list.
 */
	private void removeEmptyText() 
	{
		for(int spot = 0; spot < tweetTexts.size(); spot++)
		{
			if (tweetTexts.get(spot).equals(""));
			{
				tweetTexts.remove(spot);
				spot--;
			}
		}
	}

	
	/**
	 * Removes punctuation marks and symbols from supplied wordList.
	 * @param word
	 * @return
	 */
	private String removePunctuation(String currentString) 
	{
		String punctuation = ".,'?!:;\"(){}^[]<>-";
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	
	/**
	 * Removes all words in commonWord.txt from parameter wordlist.
	 * @param word
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<String> removeCommonEnglishWords(List<String> wordList) throws FileNotFoundException
	{
		String[] boringWords = importWordstoArray();
		
		for(int count = 0; count < wordList.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
				if(wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length; // Exit inner loop.
				}
		}
		//In order to keep usernames in wordlist.
		removeTwitterUsernamesFromList(wordList);
	
		return wordList;
		
	}
	
	/**
	 * Removes usernames from list of String objects.
	 */
	private void removeTwitterUsernamesFromList(List<String> wordList)
	{
		for (int wordCount = 0; wordCount < wordList.size(); wordCount++)
		{
			if (wordList.get(wordCount).length() >= 1 && wordList.get(wordCount).charAt(0) == '@')
					{
					wordList.remove(wordCount);
					wordCount --;
					}
		}
	}

	/**
	 * Reads commonWords.txt and imports supplied words to a String.
	 * array to be excluded from the results.
	 * @return array of strings to ignore from the results.
	 */
	private String[] importWordstoArray() throws FileNotFoundException
	{
		String[] boringWords;
		int wordCount = 0;
		Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		while (wordFile.hasNext())
		{
			wordCount ++;
			wordFile.next();
		}
		wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		boringWords = new String[wordCount];
		int boringWordCount = 0;
		while (wordFile.hasNext())
		{
			boringWords[boringWordCount] = wordFile.next();
			boringWordCount ++;
		}
		wordFile.close();
		return boringWords;
		}
	
	/**
	 * Searches for JavaFX tweet query.
	 * @return
	 */
	public String sampleInvestigaton()
	{
		String results = "";
		
		Query query = new Query("JavaFX");
		query.setCount(10);
		//query.setGeoCode(new GeoLocation(40.587521, -111.869178), 500, Query.MILES);
		query.setSince("2016-1-1");
		try
		{
			QueryResult result = chatbotTwitter.search(query);
			results += "Count : " + result.getTweets().size() + "\n";
			for (Status tweet : result.getTweets())
			{
				results += "@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n";
			}
		}
		
		catch (TwitterException e)
		{
			e.printStackTrace();
		}
		
		return results;
	}
	
	
	
}
