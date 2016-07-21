package chat.model;

import java.util.ArrayList;

/**
 * Version 4.2
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
