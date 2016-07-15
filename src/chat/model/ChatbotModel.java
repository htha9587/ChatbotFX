package chat.model;

import java.util.ArrayList;

/**
 * Version 3.0
 * @author htha9587
 * 7-15-16
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
		
		if(currentInput.toLowerCase().contains(politicalContent.toLowerCase()))
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
		
		if(currentInput.toLowerCase().contains(softwareContent.toLowerCase()))
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
		
		if(currentInput.equals("sdf") || currentInput.equals(",./") || currentInput.equals("dfg") || currentInput.equals("cvb"))
		{
			isMash = true;
		}
		return isMash;
	}
	
	
	
	
}
