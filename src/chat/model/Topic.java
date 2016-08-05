package chat.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Version 6.3
 * @author htha9587
 * 8-4-16
 */


public class Topic 
{
	private final SimpleStringProperty topic;
	private final SimpleStringProperty item;
	
	/**
	 * Constructor.
	 * @param topic
	 * @param item
	 */
	public Topic(String topic, String item)
	{
		super();
		this.topic = new SimpleStringProperty(topic);
		this.item = new SimpleStringProperty(item);
	}
	
	/**
	 * Returns topic.
	 * @return
	 */
	public String getTopic()
	{
		return topic.get();
	}
	
	/**
	 * Returns item.
	 * @return
	 */
	public String getItem()
	{
		return item.get();
	}
	
}
