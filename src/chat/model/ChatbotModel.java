package chat.model;

import java.util.ArrayList;

/**
 * Version 2.8
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
	
	
	/**
	 * Creates instance of ChatbotModel with userName.
	 */
	public ChatbotModel(String userName)
	{
		this.userName = userName;
		this.content = "Software Topics";
		this.politicalList = new ArrayList<String>();
		this.softwareList = new ArrayList<String>();
		this.politicalContent = "2016 Election";
		
		buildSoftwareList();
		buildPoliticalList();
	}


	private void buildPoliticalList() 
	{
		
		
	}


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
	
}
