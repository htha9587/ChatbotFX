package chat.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Version 5.0
 * @author htha9587
 * 7-27-16
 */


public class Topic 
{
	private final SimpleStringProperty topic;
	private final SimpleStringProperty item;
	
	public Topic(String topic, String item)
	{
		super();
		this.topic = new SimpleStringProperty(topic);
		this.item = new SimpleStringProperty(item);
	}
	
	public String getTopic()
	{
		return topic.get();
	}
	
	public String getItem()
	{
		return item.get();
	}
	
}
