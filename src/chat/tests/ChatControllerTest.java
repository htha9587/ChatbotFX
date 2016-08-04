package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chat.view.ChatbotViewController;

/**
 * Version 6.2
 * @author htha9587
 * 8-4-16
 */

public class ChatControllerTest 
{
	private ChatbotViewController testController;
	
	@Before
	public void setUp() throws Exception
	{
		testController = new ChatbotViewController();
	}
	
	@After
	public void tearDown() throws Exception
	{
		testController = null;
	}
	
	@Test
	public void testChatController()
	{
		assertNotNull("Data member not initialized", testController.getChatbotModel());
	}
}
