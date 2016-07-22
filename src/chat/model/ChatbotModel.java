package chat.model;

import java.util.ArrayList;

/**
 * Version 4.4
 * @author htha9587
 * 7-21-16
 * Makes up the Framework for the ChatbotFX program.
 */

public class ChatbotModel 
{
	private ArrayList<String> softwareList;
	private ArrayList<String> politicalList;
	private String userName;
	private String content;
	private String politicalContent;
	private String softwareContent;
	private String ostContent;
	private String filmContent;
	private String scifiAuthorContent;
	private String musicGenreContent;
	private String favoriteGamesContent;
	private String favoriteFoodContent;
	private String favoriteFilmQuotes;
	private String nasaInventions;
	private String biologyScientists;
	private String memeContent;
	private String spookyDeaths;
	private String badJobs;
	
	/**
	 * Creates instance of ChatbotModel with userName.
	 */
	public ChatbotModel(String userName)
	{
		this.userName = userName;
		this.softwareContent = "Software Topics";
		this.content = "";
		this.politicalList = new ArrayList<String>();
		this.softwareList = new ArrayList<String>();
		this.politicalContent = "2016 Election";
		this.ostContent = "Best Film Soundtracks";
		this.filmContent = "Favorite Films";
		this.scifiAuthorContent = "Favorite Sci-Fi Authors";
		this.musicGenreContent = "Music Genres";
		this.favoriteGamesContent = "Favorite Games";
		this.favoriteFoodContent = "Favorite Foods";
		this.favoriteFilmQuotes = "Favorite Film Quotes";
		this.nasaInventions = "Nasa Inventions";
		this.biologyScientists = "Biology Scientists";
		this.memeContent = "2007 Memes";
		this.badJobs = "Bad Jobs";
		
		buildSoftwareList();
		buildPoliticalList();
	}

/**
 * Lists ten events in the political list.
 */
	private void buildPoliticalList() 
	{
		this.politicalList.add("Trump");
		this.politicalList.add("Clinton");
		this.politicalList.add("Scott Walker");
		this.politicalList.add("Biden");
		this.politicalList.add("Carson");
		this.politicalList.add("Rubio");
		this.politicalList.add("Fiorina");
		this.politicalList.add("Sanders");
		this.politicalList.add("vote");
		this.politicalList.add("11/4/16");
	}

/**
 * :Lists ten events in the software list.
 */
	private void buildSoftwareList() 
	{
		this.softwareList.add("Spring Framework");
		this.softwareList.add("Java EE");
		this.softwareList.add("Angular JS");
		this.softwareList.add("Django");
		this.softwareList.add("Git");
		this.softwareList.add("Jira");
		this.softwareList.add("Maven");
		this.softwareList.add("Machine Learning");
		this.softwareList.add("Unit Testing");
		this.softwareList.add("DevOps");
	}
	
	/**
	 * Checks String length, returns false if String is empty or null.
	 * @return Whether it matches the content area.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null)
		{
			if(currentInput.length() >= 1)
			{
				hasLength = true;
			}
		}
		return hasLength;
	}
	/**
	 * Checks if content is existent or nonexistent.
	 * @param currentInput
	 * @return
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
			{
			hasContent = true;
			}
			return hasContent;		
	}
			
	/**
	 * Checks if topic is matched, and returns true if matched.
	 */
	public boolean politicalCheckerContent(String currentInput)
	{
		boolean hasPolitical = false;
		
		if(currentInput.equals("Trump") 
				|| currentInput.equals("Clinton") 
				|| currentInput.equals("Scott Walker") 
				|| currentInput.equals("Biden") 
				|| currentInput.equals("Carson") 
				|| currentInput.equals("Rubio") 
				|| currentInput.equals("Fiorina") 
				|| currentInput.equals("Sanders") 
				|| currentInput.equals("vote") 
				|| currentInput.equals("11/5/16"))
		{
			hasPolitical = true;
		}
		return hasPolitical;
	}
	
	/**
	 * Checks if topic is matched, and returns true if matched.
	 * @param currentInput
	 * @return
	 */
	public boolean softwareCheckerContent(String currentInput)
	{
		boolean hasSoftware = false;
		
		if(currentInput.equals("Spring Framework") 
				|| currentInput.equals("Java EE") 
				|| currentInput.equals("Angular JS") 
				|| currentInput.equals("Django") 
				|| currentInput.equals("Git") 
				|| currentInput.equals("Jira") 
				|| currentInput.equals("Maven") 
				|| currentInput.equals("Machine Learning") 
				|| currentInput.equals("Unit Testing") 
				|| currentInput.equals("DevOps"))
		{
			hasSoftware = true;
		}
		return hasSoftware;
	}
	/**
	 * Checker for whether or not the user is typing in keyboard nonsense.
	 * @param currentInput
	 * @return
	 */
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean isMash = false;
		
		if(currentInput.equals("sdf") 
				|| currentInput.equals(",./") 
				|| currentInput.equals("dfg") 
				|| currentInput.equals("cvb")
		     	|| currentInput.equals("asdf")
                || currentInput.equals("jkl;")
                || currentInput.equals("qwerty")
                || currentInput.equals("12345")
                || currentInput.equals("rthrthr")
                || currentInput.equals("764677"))
		{
			isMash = true;
		}
		return isMash;
	}
	
	/**
	 * Checker for whether or not the user is typing in OST related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean ostContentChecker(String currentInput)
	{
		boolean isOST = false;
		
		if(currentInput.equals("Blade Runner Soundtrack") 
				|| currentInput.equals("Interstellar Soundtrack") 
				|| currentInput.equals("The Social Network Soundtrack") 
				|| currentInput.equals("Oblivion Soundtrack")
		     	|| currentInput.equals("Tron Legacy Soundtrack")
                || currentInput.equals("Cloud Atlas Soundtrack")
                || currentInput.equals("Gravity Soundtrack")
                || currentInput.equals("Inception Soundtrack")
                || currentInput.equals("2001: A Space Odyssey Soundtrack")
                || currentInput.equals("Pulp Fiction Soundtrack"))
		{
			isOST = true;
		}
		return isOST;
	}
	
	/**
	 * Checker for whether or not the user is typing in film related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean filmContentChecker(String currentInput)
	{
		boolean isFilm = false;
		
		if(currentInput.equals("Blade Runner") 
				|| currentInput.equals("Interstellar") 
				|| currentInput.equals("The Social Network") 
				|| currentInput.equals("Terminator 2: Judgement Day")
		     	|| currentInput.equals("Solaris")
                || currentInput.equals("Cloud Atlas")
                || currentInput.equals("The Martian")
                || currentInput.equals("Apocalypse Now")
                || currentInput.equals("2001: A Space Odyssey")
                || currentInput.equals("Citizen Kane"))
		{
			isFilm = true;
		}
		return isFilm;
	}
	
	/**
	 * Checker for whether or not the user is typing in author related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean scifiAuthorContentChecker(String currentInput)
	{
		boolean isAuthor = false;
		
		if(currentInput.equals("Robert Heinlein") 
				|| currentInput.equals("Isaac Asimov") 
				|| currentInput.equals("Arthur C. Clarke") 
				|| currentInput.equals("Orson Scott Card")
		     	|| currentInput.equals("Phillip K. Dick")
                || currentInput.equals("Ray Bradbury")
                || currentInput.equals("Jules Verne")
                || currentInput.equals("H.G Wells")
                || currentInput.equals("Frank Herbert")
                || currentInput.equals("William Gibson"))
		{
			isAuthor = true;
		}
		return isAuthor;
	}
	
	/**
	 * Checker for whether or not the user is typing in music genre related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean musicGenreContentChecker(String currentInput)
	{
		boolean isMusic = false;
		
		if(currentInput.equals("Rock") 
				|| currentInput.equals("Ambient") 
				|| currentInput.equals("Industrial") 
				|| currentInput.equals("Electronic")
		     	|| currentInput.equals("Love")
                || currentInput.equals("Acoustic")
                || currentInput.equals("Blues")
                || currentInput.equals("Folk")
                || currentInput.equals("Indie")
                || currentInput.equals("Classical"))
		{
			isMusic = true;
		}
		return isMusic;
	}
	
	/**
	 * Checker for whether or not the user is typing in favorite game related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean favoriteGameContentChecker(String currentInput)
	{
		boolean isGame = false;
		
		if(currentInput.equals("Deus Ex Series") 
				|| currentInput.equals("Mass Effect Series") 
				|| currentInput.equals("Mario Series") 
				|| currentInput.equals("Tomb Raider Series")
		     	|| currentInput.equals("Uncharted Series")
                || currentInput.equals("Doom Series")
                || currentInput.equals("Quake Series")
                || currentInput.equals("Crysis Series")
                || currentInput.equals("Halo Series")
                || currentInput.equals("The Witcher Series"))
		{
			isGame = true;
		}
		return isGame;
	}
	
	/**
	 * Checker for whether or not the user is typing in favorite food related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean favoriteFoodContentChecker(String currentInput)
	{
		boolean isFood= false;
		
		if(currentInput.equals("Pasta") 
				|| currentInput.equals("Eggs") 
				|| currentInput.equals("Bread") 
				|| currentInput.equals("Cinnamon Rolls")
		     	|| currentInput.equals("Grapes")
                || currentInput.equals("Rolls")
                || currentInput.equals("Biscuits")
                || currentInput.equals("Lasagna")
                || currentInput.equals("Salad")
                || currentInput.equals("Steak"))
		{
			isFood = true;
		}
		return isFood;
	}
	
	/**
	 * Checker for whether or not the user is typing in favorite film quote related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean favoriteFilmQuotesContentChecker(String currentInput)
	{
		boolean isQuote = false;
		
		if(currentInput.equals("I drink your milkshake!") 
				|| currentInput.equals("This is pretty much the worst thing ever made.") 
				|| currentInput.equals("They call me Mister Tibbs!") 
				|| currentInput.equals("Elementary, my dear Watson.")
		     	|| currentInput.equals("Gentlemen, you can't fight in here! This is the war room!")
                || currentInput.equals("That'll do, pig. That'll do.")
                || currentInput.equals("Good morning, Vietnam!")
                || currentInput.equals("Go ahead, make my day.")
                || currentInput.equals("Pay no attention to that man behind the curtain!")
                || currentInput.equals("What we've got here is a failure to communicate."))
		{
			isQuote = true;
		}
		return isQuote;
	}
	
	/**
	 * Checker for whether or not the user is typing in NASA Invention related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean nasaInventionsContentChecker(String currentInput)
	{
		boolean isNASA = false;
		
		if(currentInput.equals("Memory Foam") 
				|| currentInput.equals("Anti-corrosion Coating") 
				|| currentInput.equals("ArterioVision") 
				|| currentInput.equals("Cochlear Implants")
		     	|| currentInput.equals("Scratch-resistant Eyeglass Lenses")
                || currentInput.equals("Emulsified Iron")
                || currentInput.equals("Insulin Pump")
                || currentInput.equals("Lifeshears")
                || currentInput.equals("Charge-coupled Device")
                || currentInput.equals("Water Filters"))
		{
			isNASA = true;
		}
		return isNASA;
	}
	
	/**
	 * Checker for whether or not the user is typing in Biology Scientists related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean biologyScientistsContentChecker(String currentInput)
	{
		boolean isBio = false;
		
		if(currentInput.equals("Charles Darwin") 
				|| currentInput.equals("Gregor Mendel") 
				|| currentInput.equals("Aristotle") 
				|| currentInput.equals("Hippocrates")
		     	|| currentInput.equals("Robert Hooke")
                || currentInput.equals("Louis Pasteur")
                || currentInput.equals("Edward Jenner")
                || currentInput.equals("Claude Bernard")
                || currentInput.equals("Robert Brown")
                || currentInput.equals("Galen"))
		{
			isBio = true;
		}
		return isBio;
	}
	
	/**
	 * Checker for whether or not the user is typing in 2007 meme related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean memeContentChecker(String currentInput)
	{
		boolean isMeme = false;
		
		if(currentInput.equals("Squadala!") 
				|| currentInput.equals("Mah Boi!") 
				|| currentInput.equals("Gee, It sure is boring around here!") 
				|| currentInput.equals("Enclosed Instruction Book")
		     	|| currentInput.equals("I can't wait to bomb some Dodongos!")
                || currentInput.equals("Everything about Hotel Mario")
                || currentInput.equals("YTP")
                || currentInput.equals("Pingas!")
                || currentInput.equals("These are the faces of evil!")
                || currentInput.equals("Enough!"))
		{
			isMeme = true;
		}
		return isMeme;
	}
	
	/**
	 * Checker for whether or not the user is typing in spooky death related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean spookyDeathContentChecker(String currentInput)
	{
		boolean isDeath = false;
		
		if(currentInput.equals("Drowning") 
				|| currentInput.equals("Immolation") 
				|| currentInput.equals("Spaghettification") 
				|| currentInput.equals("Inquisition Tortures")
		     	|| currentInput.equals("Shredding")
                || currentInput.equals("Amusement Park Rides")
                || currentInput.equals("Decapitation")
                || currentInput.equals("Vacuum Exposure")
                || currentInput.equals("Viruses")
                || currentInput.equals("Acid"))
		{
			isDeath = true;
		}
		return isDeath;
	}
	
	/**
	 * Checker for whether or not the user is typing in bad job related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean badJobsContentChecker(String currentInput)
	{
		boolean isBad = false;
		
		if(currentInput.equals("Mail Carrier") 
				|| currentInput.equals("Firefighter") 
				|| currentInput.equals("Taxi Driver") 
				|| currentInput.equals("Corrections Officer")
		     	|| currentInput.equals("Photojournalist")
                || currentInput.equals("Broadcaster")
                || currentInput.equals("Cook")
                || currentInput.equals("Lumberjack")
                || currentInput.equals("Garbageman?")
                || currentInput.equals("Newspaper Reporter"))
		{
			isBad = true;
		}
		return isBad;
	}
	
	/**
	 * Processes conversation between end user and ChatbotFX.
	 */
	public String processConversation(String currentInput)
	{
		String nextTalk = "Anything else that you like?";
		int randomTopic = (int) (Math.random() * 5); //Generates a random number between 0 and 4.
		
		if(softwareCheckerContent(currentInput))
		{
			return "Think you might use that someday?";
		}
		
		if(politicalCheckerContent(currentInput))
		{
			return "That surely is interesting!";
		}
		
		if(keyboardMashChecker(currentInput))
		{
			return "Stop mashing my keys!";
		}
		
		if(ostContentChecker(currentInput))
		{
			return "Is that a favorite of yours?";
		}
		
		if(filmContentChecker(currentInput))
		{
			return "That one's a novel!";
		}
		
		if(scifiAuthorContentChecker(currentInput))
		{
			return "His work is really good!";
		}
		
		if(musicGenreContentChecker(currentInput))
		{
			return "Good taste!";
		}
		
		if(favoriteGameContentChecker(currentInput))
		{
			return "Never tried it.";
		}
		
		if(favoriteFoodContentChecker(currentInput))
		{
			return "Shame AI's cannot eat!";
		}
		
		if(favoriteFilmQuotesContentChecker(currentInput))
		{
			return "Another Zinger!";
		}
		
		if(nasaInventionsContentChecker(currentInput))
		{
			return "What would we do without it?!";
		}
		
		if(biologyScientistsContentChecker(currentInput))
		{
			return "What of his or her discoveries?";
		}
		
		if(memeContentChecker(currentInput))
		{
			return "Is that a reference for reference sake?";
		}
		
		if(spookyDeathContentChecker(currentInput))
		{
			return "Would you even want to experience that?";
		}
		
		if(badJobsContentChecker(currentInput))
		{
			return "Is it really that bad?";
		}
		
		return nextTalk;
	}
	
	/**
	 * Getter for userName.
	 * @return
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Getter for content.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for software list.
	 */
	public ArrayList<String> getSoftwareList()
	{
		return softwareList;
	}
	
	/**
	 * Getter method for political topic list.
	 */
	public ArrayList<String> getPoliticalList()
	{
		return politicalList;
	}
	
	/**
	 * Updates content for this chatbot instance.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}
