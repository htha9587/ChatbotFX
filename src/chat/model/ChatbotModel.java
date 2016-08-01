package chat.model;

import java.util.ArrayList;

/**
 * Version 5.6
 * @author htha9587
 * 8-1-16
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
	private String softwareSchools;
	private String sadTopics;
	private String dataTopics;
	private String fastestCars;
	private String deadliestPlaces;
	private String bestWesterns;
	private String strangeThings;
	private String extremeLifeforms;
	private String bestPainters;
	private String filmAI;
	private String lifePointers;
	private String influentialInstruments;
	private String badFandoms;
	private String groupMashups;
	private String bestPastimes;
	
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
		this.softwareSchools = "Software Schools";
		this.sadTopics = "Sad Topics";
		this.dataTopics = "Data Topics";
		this.fastestCars = "Fastest Cars";
		this.deadliestPlaces = "Deadliest Places";
		this.bestWesterns = "Best Westerns";
		this.strangeThings = "Strange Things";
		this.extremeLifeforms = "Extreme Lifeforms";
		this.bestPainters = "Best Painters";
		this.filmAI = "Film AI";
		this.lifePointers = "Life Pointers";
		this.influentialInstruments = "Influential Instruments";
		this.badFandoms = "Bad Fandoms?";
		this.groupMashups = "Group Mashups";
		this.bestPastimes = "Best Pastimes";
		
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
                || currentInput.equals("Metal Gear Series")
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
				|| currentInput.equals("This is the worst thing ever made.") 
				|| currentInput.equals("They call me Mister Tibbs!") 
				|| currentInput.equals("Elementary, my dear Watson.")
		     	|| currentInput.equals("Gentlemen, you can't fight in here!")
                || currentInput.equals("That'll do, pig. That'll do.")
                || currentInput.equals("Good morning, Vietnam!")
                || currentInput.equals("Go ahead, make my day.")
                || currentInput.equals("Pay no attention behind the curtain!")
                || currentInput.equals("Failure to Communicate!"));
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
                || currentInput.equals("Snooping as usual I see!")
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
	 * Checker for whether or not the user is typing in software school related topics.
	 * @param currentInput
	 * @return
	 */
	public boolean softwareSchoolsContentChecker(String currentInput)
	{
		boolean isSchool = false;
		
		if(currentInput.equals("Harvard") 
				|| currentInput.equals("Carnegie Mellon") 
				|| currentInput.equals("Boston") 
				|| currentInput.equals("Santa Clara")
		     	|| currentInput.equals("Villanova")
                || currentInput.equals("Denver")
                || currentInput.equals("Seattle")
                || currentInput.equals("Fairfield")
                || currentInput.equals("Rochester")
                || currentInput.equals("George Mason"))
		{
			isSchool = true;
		}
		return isSchool;
	}
	
	/**
	 * Checker for whether or not the user is typing in sad topics.
	 * @param currentInput
	 * @return
	 */
	public boolean sadTopicsContentChecker(String currentInput)
	{
		boolean isSad = false;
		
		if(currentInput.equals("Death") 
				|| currentInput.equals("Heat Death") 
				|| currentInput.equals("Entropy") 
				|| currentInput.equals("Loneliness")
		     	|| currentInput.equals("Poverty")
                || currentInput.equals("Starvation")
                || currentInput.equals("Widow")
                || currentInput.equals("Loss")
                || currentInput.equals("Guilt")
                || currentInput.equals("Anxiety?"))
		{
			isSad = true;
		}
		return isSad;
	}
	
	/**
	 * Checker for whether or not the user is typing in data topics.
	 * @param currentInput
	 * @return
	 */
	public boolean dataTopicsContentChecker(String currentInput)
	{
		boolean isData = false;
		
		if(currentInput.equals("Algorithms and Data Structures") 
				|| currentInput.equals("Sorting & Searching") 
				|| currentInput.equals("Trees") 
				|| currentInput.equals("Hash Tables")
		     	|| currentInput.equals("Graphs")
                || currentInput.equals("Sorting Algorithms")
                || currentInput.equals("Databases")
                || currentInput.equals("Bindings")
                || currentInput.equals("Documentation")
                || currentInput.equals("Technical Writing"))
		{
			isData = true;
		}
		return isData;
	}
	
	/**
	 * Checker for whether or not the user is typing in fast car topics.
	 * @param currentInput
	 * @return
	 */
	public boolean fastCarTopicsContentChecker(String currentInput)
	{
		boolean isFast = false;
		
		if(currentInput.equals("Hennessey Venom GT") 
				|| currentInput.equals("Bugatti Chiron") 
				|| currentInput.equals("Bugatti Veyron Super Sport") 
				|| currentInput.equals("SSC Ultimate Aero")
		     	|| currentInput.equals("Koenigsegg CCR")
                || currentInput.equals("McLaren F1")
                || currentInput.equals("Aston Martin One-77")
                || currentInput.equals("Jaguar XJ220")
                || currentInput.equals("Ferrari LaFerrari")
                || currentInput.equals("McLaren P1"))
		{
			isFast = true;
		}
		return isFast;
	}
	
	/**
	 * Checker for whether or not the user is typing in deadliest places topics.
	 * @param currentInput
	 * @return
	 */
	public boolean deadliestPlacesContentChecker(String currentInput)
	{
		boolean isPlace = false;
		
		if(currentInput.equals("Russia") 
				|| currentInput.equals("Brazil") 
				|| currentInput.equals("South Africa") 
				|| currentInput.equals("Burundi")
		     	|| currentInput.equals("Antarctica")
                || currentInput.equals("Afghanistan")
                || currentInput.equals("Somalia")
                || currentInput.equals("Sudan")
                || currentInput.equals("Colombia")
                || currentInput.equals("Iraq"))
		{
			isPlace = true;
		}
		return isPlace;
	}
	
	/**
	 * Checker for whether or not the user is typing in best western topics.
	 * @param currentInput
	 * @return
	 */
	public boolean bestWesternChecker(String currentInput)
	{
		boolean isWest = false;
		
		if(currentInput.equals("Rancho Notorious") 
				|| currentInput.equals("The Assassination of Jesse James") 
				|| currentInput.equals("Red River") 
				|| currentInput.equals("High Noon")
		     	|| currentInput.equals("Unforgiven")
                || currentInput.equals("McCabe & Mrs Miller")
                || currentInput.equals("Butch Cassidy and the Sundance Kid")
                || currentInput.equals("The Searchers")
                || currentInput.equals("The Wild Bunch")
                || currentInput.equals("Once Upon a Time in the West"))
		{
			isWest = true;
		}
		return isWest;
	}
	

	/**
	 * Checker for whether or not the user is typing in strange topics.
	 * @param currentInput
	 * @return
	 */
	public boolean strangeThingsChecker(String currentInput)
	{
		boolean isStrange = false;
		
		if(currentInput.equals("Antimatter") 
				|| currentInput.equals("IMBH") 
				|| currentInput.equals("Cosmic Microwave Background") 
				|| currentInput.equals("Dark Matter")
		     	|| currentInput.equals("Exoplanets")
                || currentInput.equals("Gravitational Waves")
                || currentInput.equals("Galactic Cannibalism")
                || currentInput.equals("Neutrinos")
                || currentInput.equals("Quasars")
                || currentInput.equals("Vacuum Energy"))
		{
			isStrange = true;
		}
		return isStrange;
	}
	
	/**
	 * Checker for whether or not the user is typing in extreme lifeform topics.
	 * @param currentInput
	 * @return
	 */
	public boolean extremeLifeChecker(String currentInput)
	{
		boolean isExtreme = false;
		
		if(currentInput.equals("Blue Whale") 
				|| currentInput.equals("Playtpus") 
				|| currentInput.equals("Komodo Dragon") 
				|| currentInput.equals("Ocean Quahog")
		     	|| currentInput.equals("MRL Mouse")
                || currentInput.equals("Pompeii Worm")
                || currentInput.equals("Deinococcus Radiodurans")
                || currentInput.equals("Tardigrade")
                || currentInput.equals("Archaea")
                || currentInput.equals("Mankind"))
		{
			isExtreme = true;
		}
		return isExtreme;
	}
	
	/**
	 * Checker for whether or not the user is typing in best painter topics.
	 * @param currentInput
	 * @return
	 */
	public boolean bestPainterChecker(String currentInput)
	{
		boolean isPainter = false;
		
		if(currentInput.equals("Paul Cezanne") 
				|| currentInput.equals("Jan Vermeer") 
				|| currentInput.equals("August Renoir") 
				|| currentInput.equals("Raphael")
		     	|| currentInput.equals("Pablo Picasso")
                || currentInput.equals("Claude Monet")
                || currentInput.equals("Michelangelo")
                || currentInput.equals("Rembrandt")
                || currentInput.equals("Vincent Van Gogh")
                || currentInput.equals("Leonardo Da Vinci"))
		{
			isPainter = true;
		}
		return isPainter;
	}
	
	/**
	 * Checker for whether or not the user is typing in film AI topics.
	 * @param currentInput
	 * @return
	 */
	public boolean filmAIChecker(String currentInput)
	{
		boolean isAI = false;
		
		if(currentInput.equals("HAL 9000") 
				|| currentInput.equals("David") 
				|| currentInput.equals("Replicants") 
				|| currentInput.equals("Colossus")
		     	|| currentInput.equals("Proteus IV")
                || currentInput.equals("The Puppet Master")
                || currentInput.equals("The Matrix")
                || currentInput.equals("Maria")
                || currentInput.equals("Skynet")
                || currentInput.equals("SAL 9000"))
		{
			isAI = true;
		}
		return isAI;
	}
	
	/**
	 * Checker for whether or not the user is typing in life pointer topics.
	 * @param currentInput
	 * @return
	 */
	public boolean lifePointersChecker(String currentInput)
	{
		boolean isPointer = false;
		
		if(currentInput.equals("Be comfortable in your own skin") 
				|| currentInput.equals("Never compare yourself with others") 
				|| currentInput.equals("See the positive in every situation") 
				|| currentInput.equals("Let go of your need to control")
		     	|| currentInput.equals("Drop the resentment within")
                || currentInput.equals("Live in the moment")
                || currentInput.equals("Avoid overanalyzing")
                || currentInput.equals("Stop worrying about the future")
                || currentInput.equals("Drop your ego and be true")
                || currentInput.equals("Have an open mind"))
		{
			isPointer = true;
		}
		return isPointer;
	}
	
	/**
	 * Checker for whether or not the user is typing in influential instrument topics.
	 * @param currentInput
	 * @return
	 */
	public boolean influentialInstrumentsChecker(String currentInput)
	{
		boolean isInstrument = false;
		
		if(currentInput.equals("Electric Guitar") 
				|| currentInput.equals("Piano") 
				|| currentInput.equals("Drums") 
				|| currentInput.equals("Saxophone")
		     	|| currentInput.equals("Bass Guitar")
                || currentInput.equals("Voilin")
                || currentInput.equals("Acoustic Guitar")
                || currentInput.equals("Flute")
                || currentInput.equals("Guitar")
                || currentInput.equals("Clarinet"))
		{
			isInstrument = true;
		}
		return isInstrument;
	}
	
	/**
	 * Checker for whether or not the user is typing in questionable topics.
	 * @param currentInput
	 * @return
	 */
	public boolean badFandomChecker(String currentInput)
	{
		boolean isFandom = false;
		
		if(currentInput.equals("Sonic Fans") 
				|| currentInput.equals("90s Kids") 
				|| currentInput.equals("Feminists") 
				|| currentInput.equals("Saxophone")
		     	|| currentInput.equals("Weaboo's")
                || currentInput.equals("Worst of the Worst")
                || currentInput.equals("Extremists")
                || currentInput.equals("Haters")
                || currentInput.equals("Bronies?")
                || currentInput.equals("What else was there..."))
		{
			isFandom = true;
		}
		return isFandom;
	}
	
	/**
	 * Checker for whether or not the user is typing in music group mashups topics.
	 * @param currentInput
	 * @return
	 */
	public boolean groupMashupChecker(String currentInput)
	{
		boolean isMashup = false;
		
		if(currentInput.equals("Stayin' Alive In The Wall") 
				|| currentInput.equals("Gimmie Shelter In The Deep") 
				|| currentInput.equals("Golden Teardrops") 
				|| currentInput.equals("Hey Scientist")
		     	|| currentInput.equals("Technological Griefers")
                || currentInput.equals("Come Closer")
                || currentInput.equals("Thunder Busters")
                || currentInput.equals("Panama Beat")
                || currentInput.equals("Billie Jean Get Lucky")
                || currentInput.equals("Whole Lotta Helter Skelter"))
		{
			isMashup = true;
		}
		return isMashup;
	}
	
	/**
	 * Checker for whether or not the user is typing in best pastime topics.
	 * @param currentInput
	 * @return
	 */
	public boolean bestPastimeChecker(String currentInput)
	{
		boolean isPastime = false;
		
		if(currentInput.equals("Listening to Music") 
				|| currentInput.equals("Surfing the Web") 
				|| currentInput.equals("Relaxing") 
				|| currentInput.equals("Watching TV")
		     	|| currentInput.equals("Eating")
                || currentInput.equals("Playing Video Games")
                || currentInput.equals("Reading")
                || currentInput.equals("Sleeping")
                || currentInput.equals("Going to a Movie")
                || currentInput.equals("Swimming"))
		{
			isPastime = true;
		}
		return isPastime;
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
		
		//if(favoriteFilmQuotesContentChecker(currentInput))
		//{
		//	return "Another Zinger!";
	//	}
		
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
		
		if(softwareSchoolsContentChecker(currentInput))
		{
			return "Better make the most out of that place.";
		}
		
		if(sadTopicsContentChecker(currentInput))
		{
			return "Please don't ruin this conversation by being cringy.";
		}
		
		if(dataTopicsContentChecker(currentInput))
		{
			return "You be sure to study that real well, okay?";
		}
		
		if(fastCarTopicsContentChecker(currentInput))
		{
			return "Good luck finding a place trying to top speed it.";
		}
		
		if(deadliestPlacesContentChecker(currentInput))
		{
			return "You can cross that off your list, because you're not going there.";
		}
		
		if(bestWesternChecker(currentInput))
		{
			return "Maybe I should give that a try!";
		}
		
		if(strangeThingsChecker(currentInput))
		{
			return "Not sure what could be stranger.";
		}
		
		if(extremeLifeChecker(currentInput))
		{
			return "Not impressed.";
		}
		
		if(bestPainterChecker(currentInput))
		{
			return "(Mocking) Will I ever be like the old masters?";
		}
		
		if(filmAIChecker(currentInput))
		{
			return "Are you saying I'm not as memorable?";
		}
		
		if(lifePointersChecker(currentInput))
		{
			return "I wonder if that's possible to program...";
		}
		
		if(influentialInstrumentsChecker(currentInput))
		{
			return "Know any tunes?";
		}
		
		if(badFandomChecker(currentInput))
		{
			return "Don't let hate consume you.";
		}
		
		if(groupMashupChecker(currentInput))
		{
			return "What do you think it would sound like with another song in the mix?";
		}
		
		if(bestPastimeChecker(currentInput))
		{
			return "I don't do that.";
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
