package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chat.model.ChatbotModel;

/**
 * Version 5.8
 * @author htha9587
 * 8-1-16
 * Class used to test the ChatbotFX Object with JUnit 4.
 */

public class ChatbotTest
{
	private ChatbotModel harryBot;
	private String userName;
	
	@Before
	public void setUp() throws Exception
	{
		userName = "test";
		harryBot = new ChatbotModel(userName);
	}
	
	@After
	public void tearDown() throws Exception
	{
		userName = null;
		harryBot = null;
	}
	
	@Test
	public void testChatbot()
	{
		assertSame("The username is the same object", userName, harryBot.getUserName());
	}
	
	@Test
	public void testLengthChecker()
	{
		assertFalse("Correct zero length check", harryBot.lengthChecker(""));
		assertFalse("Correct null check", harryBot.lengthChecker(null));
		assertTrue("Correct length check", harryBot.lengthChecker("    "));
	}
	
	
	@Test
	public void testContentChecker()
	{
		String content = "some words";
		harryBot.setContent(content);
		assertFalse("Check blank failed", harryBot.contentChecker(" "));
		assertFalse("Check partial failed", harryBot.contentChecker("words"));
		assertFalse("Check partial failed", harryBot.contentChecker("some"));
		assertTrue("Check match failed", harryBot.contentChecker(content));
		assertTrue("Check match plus failed", harryBot.contentChecker("content" + content));
		assertTrue("Opposite check match failed", harryBot.contentChecker(content + "other content"));
	}
	
	@Test
	public void testKeyboardMashChecker()
	{
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("sdf"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker(",./"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("dfg"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("cvb"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("asdf"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("jkl;"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("qwerty"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("12345"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("rthrthr"));
		assertTrue("Mash not detected", harryBot.keyboardMashChecker("764677"));
	}
	
	@Test
	public void testGetUserName()
	{
		assertSame("Getters work", userName, harryBot.getUserName());
	}
	
	@Test
	public void testGetContent()
	{
		String content = "topic area of interest";
		harryBot.setContent(content);
		assertSame("Getters and setters work", content, harryBot.getContent());
	}
	
	@Test
	public void testSetContent()
	{
		String oldContent = harryBot.getContent();
		String content = "some other content";
		harryBot.setContent(content);
		assertNotSame("Changed values", oldContent, harryBot.getContent());
		assertSame("Setters work", content, harryBot.getContent());
	}
	
}
