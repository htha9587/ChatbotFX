package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chat.model.ChatbotModel;

/**
 * Version 6.2
 * @author htha9587
 * 8-4-16
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
	public void testPoliticalCheckerContent()
	{
		assertTrue("Content not detected", harryBot.politicalCheckerContent("Trump"));
		assertTrue("Content not detected", harryBot.politicalCheckerContent("Clinton"));
		assertTrue("Content not detected", harryBot.politicalCheckerContent("Scott Walker"));
		assertTrue("Content not detected", harryBot.politicalCheckerContent("Biden"));
		assertTrue("Content not detected", harryBot.politicalCheckerContent("Carson"));
		assertTrue("Content not detected", harryBot.politicalCheckerContent("Rubio"));
		assertTrue("Content not detected", harryBot.politicalCheckerContent("Fiorina"));
		assertTrue("Content not detected", harryBot.politicalCheckerContent("Sanders"));
		assertTrue("Content not detected", harryBot.politicalCheckerContent("vote"));
		assertTrue("Content not detected", harryBot.politicalCheckerContent("11/5/16"));
	}
	
	@Test
	public void testSoftwareCheckerContent()
	{
		assertTrue("Content not detected", harryBot.softwareCheckerContent("Spring Framework"));
		assertTrue("Content not detected", harryBot.softwareCheckerContent("Java EE"));
		assertTrue("Content not detected", harryBot.softwareCheckerContent("Angular JS"));
		assertTrue("Content not detected", harryBot.softwareCheckerContent("Django"));
		assertTrue("Content not detected", harryBot.softwareCheckerContent("Git"));
		assertTrue("Content not detected", harryBot.softwareCheckerContent("Jira"));
		assertTrue("Content not detected", harryBot.softwareCheckerContent("Maven"));
		assertTrue("Content not detected", harryBot.softwareCheckerContent("Machine Learning"));
		assertTrue("Content not detected", harryBot.softwareCheckerContent("Unit Testing"));
		assertTrue("Content not detected", harryBot.softwareCheckerContent("DevOps"));
	}
	
	@Test
	public void testOSTContentChecker()
	{
		assertTrue("Content not detected", harryBot.ostContentChecker("Blade Runner Soundtrack"));
		assertTrue("Content not detected", harryBot.ostContentChecker("Interstellar Soundtrack"));
		assertTrue("Content not detected", harryBot.ostContentChecker("The Social Network Soundtrack"));
		assertTrue("Content not detected", harryBot.ostContentChecker("Oblivion Soundtrack"));
		assertTrue("Content not detected", harryBot.ostContentChecker("Tron Legacy Soundtrack"));
		assertTrue("Content not detected", harryBot.ostContentChecker("Cloud Atlas Soundtrack"));
		assertTrue("Content not detected", harryBot.ostContentChecker("Gravity Soundtrack"));
		assertTrue("Content not detected", harryBot.ostContentChecker("Inception Soundtrack"));
		assertTrue("Content not detected", harryBot.ostContentChecker("2001: A Space Odyssey Soundtrack"));
		assertTrue("Content not detected", harryBot.ostContentChecker("Pulp Fiction Soundtrack"));
	}
	
	@Test
	public void testFilmContentChecker()
	{
		assertTrue("Content not detected", harryBot.filmContentChecker("Blade Runner"));
		assertTrue("Content not detected", harryBot.filmContentChecker("Interstellar"));
		assertTrue("Content not detected", harryBot.filmContentChecker("The Social Network"));
		assertTrue("Content not detected", harryBot.filmContentChecker("Terminator 2: Judgement Day"));
		assertTrue("Content not detected", harryBot.filmContentChecker("Solaris"));
		assertTrue("Content not detected", harryBot.filmContentChecker("Cloud Atlas"));
		assertTrue("Content not detected", harryBot.filmContentChecker("The Martian"));
		assertTrue("Content not detected", harryBot.filmContentChecker("Apocalypse Now"));
		assertTrue("Content not detected", harryBot.filmContentChecker("2001: A Space Odyssey"));
		assertTrue("Content not detected", harryBot.filmContentChecker("Citizen Kane"));
	}
	
	@Test
	public void testScifiAuthorContentChecker()
	{
		assertTrue("Content not detected", harryBot.scifiAuthorContentChecker("Robert Heinlein"));
		assertTrue("Content not detected", harryBot.scifiAuthorContentChecker("Isaac Asimov"));
		assertTrue("Content not detected", harryBot.scifiAuthorContentChecker("Arthur C. Clarke"));
		assertTrue("Content not detected", harryBot.scifiAuthorContentChecker("Orson Scott Card"));
		assertTrue("Content not detected", harryBot.scifiAuthorContentChecker("Phillip K. Dick"));
		assertTrue("Content not detected", harryBot.scifiAuthorContentChecker("Ray Bradbury"));
		assertTrue("Content not detected", harryBot.scifiAuthorContentChecker("Jules Verne"));
		assertTrue("Content not detected", harryBot.scifiAuthorContentChecker("H.G Wells"));
		assertTrue("Content not detected", harryBot.scifiAuthorContentChecker("Frank Herbert"));
		assertTrue("Content not detected", harryBot.scifiAuthorContentChecker("William Gibson"));
	}
	
	@Test
	public void testMusicGenreContentChecker()
	{
		assertTrue("Content not detected", harryBot.musicGenreContentChecker("Rock"));
		assertTrue("Content not detected", harryBot.musicGenreContentChecker("Ambient"));
		assertTrue("Content not detected", harryBot.musicGenreContentChecker("Industrial"));
		assertTrue("Content not detected", harryBot.musicGenreContentChecker("Electronic"));
		assertTrue("Content not detected", harryBot.musicGenreContentChecker("Love"));
		assertTrue("Content not detected", harryBot.musicGenreContentChecker("Acoustic"));
		assertTrue("Content not detected", harryBot.musicGenreContentChecker("Blues"));
		assertTrue("Content not detected", harryBot.musicGenreContentChecker("Folk"));
		assertTrue("Content not detected", harryBot.musicGenreContentChecker("Indie"));
		assertTrue("Content not detected", harryBot.musicGenreContentChecker("Classical"));
	}
	
	@Test
	public void testFavoriteGameContentChecker()
	{
		assertTrue("Content not detected", harryBot.favoriteGameContentChecker("Deus Ex Series"));
		assertTrue("Content not detected", harryBot.favoriteGameContentChecker("Mass Effect Series"));
		assertTrue("Content not detected", harryBot.favoriteGameContentChecker("Mario Series"));
		assertTrue("Content not detected", harryBot.favoriteGameContentChecker("Tomb Raider Series"));
		assertTrue("Content not detected", harryBot.favoriteGameContentChecker("Uncharted Series"));
		assertTrue("Content not detected", harryBot.favoriteGameContentChecker("Doom Series"));
		assertTrue("Content not detected", harryBot.favoriteGameContentChecker("Quake Series"));
		assertTrue("Content not detected", harryBot.favoriteGameContentChecker("Crysis Series"));
		assertTrue("Content not detected", harryBot.favoriteGameContentChecker("Metal Gear Series"));
		assertTrue("Content not detected", harryBot.favoriteGameContentChecker("The Witcher Series"));
	}
	
	@Test
	public void testFavoriteFoodContentChecker()
	{
		assertTrue("Content not detected", harryBot.favoriteFoodContentChecker("Pasta"));
		assertTrue("Content not detected", harryBot.favoriteFoodContentChecker("Eggs"));
		assertTrue("Content not detected", harryBot.favoriteFoodContentChecker("Bread"));
		assertTrue("Content not detected", harryBot.favoriteFoodContentChecker("Cinnamon Rolls"));
		assertTrue("Content not detected", harryBot.favoriteFoodContentChecker("Grapes"));
		assertTrue("Content not detected", harryBot.favoriteFoodContentChecker("Rolls"));
		assertTrue("Content not detected", harryBot.favoriteFoodContentChecker("Biscuits"));
		assertTrue("Content not detected", harryBot.favoriteFoodContentChecker("Lasagna"));
		assertTrue("Content not detected", harryBot.favoriteFoodContentChecker("Salad"));
		assertTrue("Content not detected", harryBot.favoriteFoodContentChecker("Steak"));
	}
	
	@Test
	public void testNASAInventionsContentChecker()
	{
		assertTrue("Content not detected", harryBot.nasaInventionsContentChecker("Memory Foam"));
		assertTrue("Content not detected", harryBot.nasaInventionsContentChecker("Anti-corrosion Coating"));
		assertTrue("Content not detected", harryBot.nasaInventionsContentChecker("ArterioVision"));
		assertTrue("Content not detected", harryBot.nasaInventionsContentChecker("Cochlear Implants"));
		assertTrue("Content not detected", harryBot.nasaInventionsContentChecker("Scratch-resistant Eyeglass Lenses"));
		assertTrue("Content not detected", harryBot.nasaInventionsContentChecker("Emulsified Iron"));
		assertTrue("Content not detected", harryBot.nasaInventionsContentChecker("Insulin Pump"));
		assertTrue("Content not detected", harryBot.nasaInventionsContentChecker("Lifeshears"));
		assertTrue("Content not detected", harryBot.nasaInventionsContentChecker("Charge-coupled Device"));
		assertTrue("Content not detected", harryBot.nasaInventionsContentChecker("Water Filters"));
	}
	
	@Test
	public void testBiologyScientistsContentChecker()
	{
		assertTrue("Content not detected", harryBot.biologyScientistsContentChecker("Charles Darwin"));
		assertTrue("Content not detected", harryBot.biologyScientistsContentChecker("Gregor Mendel"));
		assertTrue("Content not detected", harryBot.biologyScientistsContentChecker("Aristotle"));
		assertTrue("Content not detected", harryBot.biologyScientistsContentChecker("Hippocrates"));
		assertTrue("Content not detected", harryBot.biologyScientistsContentChecker("Robert Hooke"));
		assertTrue("Content not detected", harryBot.biologyScientistsContentChecker("Louis Pasteur"));
		assertTrue("Content not detected", harryBot.biologyScientistsContentChecker("Edward Jenner"));
		assertTrue("Content not detected", harryBot.biologyScientistsContentChecker("Claude Bernard"));
		assertTrue("Content not detected", harryBot.biologyScientistsContentChecker("Robert Brown"));
		assertTrue("Content not detected", harryBot.biologyScientistsContentChecker("Galen"));
	}
	
	@Test
	public void testMemeContentChecker()
	{
		assertTrue("Content not detected", harryBot.memeContentChecker("Squadala!"));
		assertTrue("Content not detected", harryBot.memeContentChecker("Mah Boi!"));
		assertTrue("Content not detected", harryBot.memeContentChecker("Gee, It sure is boring around here!"));
		assertTrue("Content not detected", harryBot.memeContentChecker("Enclosed Instruction Book"));
		assertTrue("Content not detected", harryBot.memeContentChecker("I can't wait to bomb some Dodongos!"));
		assertTrue("Content not detected", harryBot.memeContentChecker("Everything about Hotel Mario"));
		assertTrue("Content not detected", harryBot.memeContentChecker("YTP"));
		assertTrue("Content not detected", harryBot.memeContentChecker("Snooping as usual I see!"));
		assertTrue("Content not detected", harryBot.memeContentChecker("These are the faces of evil!"));
		assertTrue("Content not detected", harryBot.memeContentChecker("Enough!"));
	}
	
	@Test
	public void testSpookyDeathContentChecker()
	{
		assertTrue("Content not detected", harryBot.spookyDeathContentChecker("Drowning"));
		assertTrue("Content not detected", harryBot.spookyDeathContentChecker("Immolation"));
		assertTrue("Content not detected", harryBot.spookyDeathContentChecker("Spaghettification"));
		assertTrue("Content not detected", harryBot.spookyDeathContentChecker("Inquisition Tortures"));
		assertTrue("Content not detected", harryBot.spookyDeathContentChecker("Shredding"));
		assertTrue("Content not detected", harryBot.spookyDeathContentChecker("Amusement Park Rides"));
		assertTrue("Content not detected", harryBot.spookyDeathContentChecker("Decapitation"));
		assertTrue("Content not detected", harryBot.spookyDeathContentChecker("Vacuum Exposure"));
		assertTrue("Content not detected", harryBot.spookyDeathContentChecker("Viruses"));
		assertTrue("Content not detected", harryBot.spookyDeathContentChecker("Acid"));
	}
	
	@Test
	public void testBadJobsContentChecker()
	{
		assertTrue("Content not detected", harryBot.badJobsContentChecker("Mail Carrier"));
		assertTrue("Content not detected", harryBot.badJobsContentChecker("Firefighter"));
		assertTrue("Content not detected", harryBot.badJobsContentChecker("Taxi Driver"));
		assertTrue("Content not detected", harryBot.badJobsContentChecker("Corrections Officer"));
		assertTrue("Content not detected", harryBot.badJobsContentChecker("Photojournalist"));
		assertTrue("Content not detected", harryBot.badJobsContentChecker("Broadcaster"));
		assertTrue("Content not detected", harryBot.badJobsContentChecker("Cook"));
		assertTrue("Content not detected", harryBot.badJobsContentChecker("Lumberjack"));
		assertTrue("Content not detected", harryBot.badJobsContentChecker("Garbageman?"));
		assertTrue("Content not detected", harryBot.badJobsContentChecker("Newspaper Reporter"));
	}
	
	@Test
	public void testSoftwareSchoolsContentChecker()
	{
		assertTrue("Content not detected", harryBot.softwareSchoolsContentChecker("Harvard"));
		assertTrue("Content not detected", harryBot.softwareSchoolsContentChecker("Carnegie Mellon"));
		assertTrue("Content not detected", harryBot.softwareSchoolsContentChecker("Boston"));
		assertTrue("Content not detected", harryBot.softwareSchoolsContentChecker("Santa Clara"));
		assertTrue("Content not detected", harryBot.softwareSchoolsContentChecker("Villanova"));
		assertTrue("Content not detected", harryBot.softwareSchoolsContentChecker("Denver"));
		assertTrue("Content not detected", harryBot.softwareSchoolsContentChecker("Seattle"));
		assertTrue("Content not detected", harryBot.softwareSchoolsContentChecker("Fairfield"));
		assertTrue("Content not detected", harryBot.softwareSchoolsContentChecker("Rochester"));
		assertTrue("Content not detected", harryBot.softwareSchoolsContentChecker("George Mason"));
	}
	
	@Test
	public void testSadTopicsContentChecker()
	{
		assertTrue("Content not detected", harryBot.sadTopicsContentChecker("Death"));
		assertTrue("Content not detected", harryBot.sadTopicsContentChecker("Heat Death"));
		assertTrue("Content not detected", harryBot.sadTopicsContentChecker("Entropy"));
		assertTrue("Content not detected", harryBot.sadTopicsContentChecker("Loneliness"));
		assertTrue("Content not detected", harryBot.sadTopicsContentChecker("Poverty"));
		assertTrue("Content not detected", harryBot.sadTopicsContentChecker("Starvation"));
		assertTrue("Content not detected", harryBot.sadTopicsContentChecker("Widow"));
		assertTrue("Content not detected", harryBot.sadTopicsContentChecker("Loss"));
		assertTrue("Content not detected", harryBot.sadTopicsContentChecker("Guilt"));
		assertTrue("Content not detected", harryBot.sadTopicsContentChecker("Anxiety?"));
	}
	
	@Test
	public void testDataTopicsContentChecker()
	{
		assertTrue("Content not detected", harryBot.dataTopicsContentChecker("Algorithms and Data Structures"));
		assertTrue("Content not detected", harryBot.dataTopicsContentChecker("Sorting & Searching"));
		assertTrue("Content not detected", harryBot.dataTopicsContentChecker("Trees"));
		assertTrue("Content not detected", harryBot.dataTopicsContentChecker("Hash Tables"));
		assertTrue("Content not detected", harryBot.dataTopicsContentChecker("Graphs"));
		assertTrue("Content not detected", harryBot.dataTopicsContentChecker("Sorting Algorithms"));
		assertTrue("Content not detected", harryBot.dataTopicsContentChecker("Databases"));
		assertTrue("Content not detected", harryBot.dataTopicsContentChecker("Bindings"));
		assertTrue("Content not detected", harryBot.dataTopicsContentChecker("Documentation"));
		assertTrue("Content not detected", harryBot.dataTopicsContentChecker("Technical Writing"));
	}
	
	@Test
	public void testFastCarTopicsContentChecker()
	{
		assertTrue("Content not detected", harryBot.fastCarTopicsContentChecker("Hennessey Venom GT"));
		assertTrue("Content not detected", harryBot.fastCarTopicsContentChecker("Bugatti Chiron"));
		assertTrue("Content not detected", harryBot.fastCarTopicsContentChecker("Bugatti Veyron Super Sport"));
		assertTrue("Content not detected", harryBot.fastCarTopicsContentChecker("SSC Ultimate Aero"));
		assertTrue("Content not detected", harryBot.fastCarTopicsContentChecker("Koenigsegg CCR"));
		assertTrue("Content not detected", harryBot.fastCarTopicsContentChecker("McLaren F1"));
		assertTrue("Content not detected", harryBot.fastCarTopicsContentChecker("Aston Martin One-77"));
		assertTrue("Content not detected", harryBot.fastCarTopicsContentChecker("Jaguar XJ220"));
		assertTrue("Content not detected", harryBot.fastCarTopicsContentChecker("Ferrari LaFerrari"));
		assertTrue("Content not detected", harryBot.fastCarTopicsContentChecker("McLaren P1"));
	}
	
	@Test
	public void testDeadliestPlacesContentChecker()
	{
		assertTrue("Content not detected", harryBot.deadliestPlacesContentChecker("Russia"));
		assertTrue("Content not detected", harryBot.deadliestPlacesContentChecker("Brazil"));
		assertTrue("Content not detected", harryBot.deadliestPlacesContentChecker("South Africa"));
		assertTrue("Content not detected", harryBot.deadliestPlacesContentChecker("Burundi"));
		assertTrue("Content not detected", harryBot.deadliestPlacesContentChecker("Antarctica"));
		assertTrue("Content not detected", harryBot.deadliestPlacesContentChecker("Afghanistan"));
		assertTrue("Content not detected", harryBot.deadliestPlacesContentChecker("Somalia"));
		assertTrue("Content not detected", harryBot.deadliestPlacesContentChecker("Sudan"));
		assertTrue("Content not detected", harryBot.deadliestPlacesContentChecker("Colombia"));
		assertTrue("Content not detected", harryBot.deadliestPlacesContentChecker("Iraq"));
	}
	
	@Test
	public void testBestWesternChecker()
	{
		assertTrue("Content not detected", harryBot.bestWesternChecker("Rancho Notorious"));
		assertTrue("Content not detected", harryBot.bestWesternChecker("The Assassination of Jesse James"));
		assertTrue("Content not detected", harryBot.bestWesternChecker("Red River"));
		assertTrue("Content not detected", harryBot.bestWesternChecker("High Noon"));
		assertTrue("Content not detected", harryBot.bestWesternChecker("Unforgiven"));
		assertTrue("Content not detected", harryBot.bestWesternChecker("McCabe & Mrs Miller"));
		assertTrue("Content not detected", harryBot.bestWesternChecker("Butch Cassidy and the Sundance Kid"));
		assertTrue("Content not detected", harryBot.bestWesternChecker("The Searchers"));
		assertTrue("Content not detected", harryBot.bestWesternChecker("The Wild Bunch"));
		assertTrue("Content not detected", harryBot.bestWesternChecker("Once Upon a Time in the West"));
	}
	
	@Test
	public void testStrangeThingsChecker()
	{
		assertTrue("Content not detected", harryBot.strangeThingsChecker("Antimatter"));
		assertTrue("Content not detected", harryBot.strangeThingsChecker("IMBH"));
		assertTrue("Content not detected", harryBot.strangeThingsChecker("Cosmic Microwave Background"));
		assertTrue("Content not detected", harryBot.strangeThingsChecker("Dark Matter"));
		assertTrue("Content not detected", harryBot.strangeThingsChecker("Exoplanets"));
		assertTrue("Content not detected", harryBot.strangeThingsChecker("Gravitational Waves"));
		assertTrue("Content not detected", harryBot.strangeThingsChecker("Galactic Cannibalism"));
		assertTrue("Content not detected", harryBot.strangeThingsChecker("Neutrinos"));
		assertTrue("Content not detected", harryBot.strangeThingsChecker("Quasars"));
		assertTrue("Content not detected", harryBot.strangeThingsChecker("Vacuum Energy"));
	}
	
	@Test
	public void testExtremeLifeChecker()
	{
		assertTrue("Content not detected", harryBot.extremeLifeChecker("Blue Whale"));
		assertTrue("Content not detected", harryBot.extremeLifeChecker("Playtpus"));
		assertTrue("Content not detected", harryBot.extremeLifeChecker("Komodo Dragon"));
		assertTrue("Content not detected", harryBot.extremeLifeChecker("Ocean Quahog"));
		assertTrue("Content not detected", harryBot.extremeLifeChecker("MRL Mouse"));
		assertTrue("Content not detected", harryBot.extremeLifeChecker("Pompeii Worm"));
		assertTrue("Content not detected", harryBot.extremeLifeChecker("Deinococcus Radiodurans"));
		assertTrue("Content not detected", harryBot.extremeLifeChecker("Tardigrade"));
		assertTrue("Content not detected", harryBot.extremeLifeChecker("Archaea"));
		assertTrue("Content not detected", harryBot.extremeLifeChecker("Mankind"));
	}
	
	@Test
	public void testBestPainterChecker()
	{
		assertTrue("Content not detected", harryBot.bestPainterChecker("Paul Cezanne"));
		assertTrue("Content not detected", harryBot.bestPainterChecker("Jan Vermeer"));
		assertTrue("Content not detected", harryBot.bestPainterChecker("August Renoir"));
		assertTrue("Content not detected", harryBot.bestPainterChecker("Raphael"));
		assertTrue("Content not detected", harryBot.bestPainterChecker("Pablo Picasso"));
		assertTrue("Content not detected", harryBot.bestPainterChecker("Claude Monet"));
		assertTrue("Content not detected", harryBot.bestPainterChecker("Michelangelo"));
		assertTrue("Content not detected", harryBot.bestPainterChecker("Rembrandt"));
		assertTrue("Content not detected", harryBot.bestPainterChecker("Vincent Van Gogh"));
		assertTrue("Content not detected", harryBot.bestPainterChecker("Leonardo Da Vinci"));
	}
	
	@Test
	public void testFilmAIChecker()
	{
		assertTrue("Content not detected", harryBot.filmAIChecker("HAL 9000"));
		assertTrue("Content not detected", harryBot.filmAIChecker("David"));
		assertTrue("Content not detected", harryBot.filmAIChecker("Replicants"));
		assertTrue("Content not detected", harryBot.filmAIChecker("Colossus"));
		assertTrue("Content not detected", harryBot.filmAIChecker("Proteus IV"));
		assertTrue("Content not detected", harryBot.filmAIChecker("The Puppet Master"));
		assertTrue("Content not detected", harryBot.filmAIChecker("The Matrix"));
		assertTrue("Content not detected", harryBot.filmAIChecker("Maria"));
		assertTrue("Content not detected", harryBot.filmAIChecker("Skynet"));
		assertTrue("Content not detected", harryBot.filmAIChecker("SAL 9000"));
	}
	
	@Test
	public void testLifePointersChecker()
	{
		assertTrue("Content not detected", harryBot.lifePointersChecker("Be comfortable in your own skin"));
		assertTrue("Content not detected", harryBot.lifePointersChecker("Never compare yourself with others"));
		assertTrue("Content not detected", harryBot.lifePointersChecker("See the positive in every situation"));
		assertTrue("Content not detected", harryBot.lifePointersChecker("Let go of your need to control"));
		assertTrue("Content not detected", harryBot.lifePointersChecker("Drop the resentment within"));
		assertTrue("Content not detected", harryBot.lifePointersChecker("Live in the moment"));
		assertTrue("Content not detected", harryBot.lifePointersChecker("Avoid overanalyzing"));
		assertTrue("Content not detected", harryBot.lifePointersChecker("Stop worrying about the future"));
		assertTrue("Content not detected", harryBot.lifePointersChecker("Drop your ego and be true"));
		assertTrue("Content not detected", harryBot.lifePointersChecker("Have an open mind"));
	}
	
	@Test
	public void testInfluentialInstrumentsChecker()
	{
		assertTrue("Content not detected", harryBot.influentialInstrumentsChecker("Electric Guitar"));
		assertTrue("Content not detected", harryBot.influentialInstrumentsChecker("Piano"));
		assertTrue("Content not detected", harryBot.influentialInstrumentsChecker("Drums"));
		assertTrue("Content not detected", harryBot.influentialInstrumentsChecker("Saxophone"));
		assertTrue("Content not detected", harryBot.influentialInstrumentsChecker("Bass Guitar"));
		assertTrue("Content not detected", harryBot.influentialInstrumentsChecker("Voilin"));
		assertTrue("Content not detected", harryBot.influentialInstrumentsChecker("Acoustic Guitar"));
		assertTrue("Content not detected", harryBot.influentialInstrumentsChecker("Flute"));
		assertTrue("Content not detected", harryBot.influentialInstrumentsChecker("Guitar"));
		assertTrue("Content not detected", harryBot.influentialInstrumentsChecker("Clarinet"));
	}
	
	@Test
	public void testBadFandomChecker()
	{
		assertTrue("Content not detected", harryBot.badFandomChecker("Sonic Fans"));
		assertTrue("Content not detected", harryBot.badFandomChecker("90s Kids"));
		assertTrue("Content not detected", harryBot.badFandomChecker("Feminists"));
		assertTrue("Content not detected", harryBot.badFandomChecker("Saxophone"));
		assertTrue("Content not detected", harryBot.badFandomChecker("Weaboo's"));
		assertTrue("Content not detected", harryBot.badFandomChecker("Worst of the Worst"));
		assertTrue("Content not detected", harryBot.badFandomChecker("Extremists"));
		assertTrue("Content not detected", harryBot.badFandomChecker("Haters"));
		assertTrue("Content not detected", harryBot.badFandomChecker("Bronies?"));
		assertTrue("Content not detected", harryBot.badFandomChecker("What else was there..."));
	}
	
	@Test
	public void testGroupMashupChecker()
	{
		assertTrue("Content not detected", harryBot.groupMashupChecker("Stayin' Alive In The Wall"));
		assertTrue("Content not detected", harryBot.groupMashupChecker("Gimmie Shelter In The Deep"));
		assertTrue("Content not detected", harryBot.groupMashupChecker("Golden Teardrops"));
		assertTrue("Content not detected", harryBot.groupMashupChecker("Hey Scientist"));
		assertTrue("Content not detected", harryBot.groupMashupChecker("Technological Griefers"));
		assertTrue("Content not detected", harryBot.groupMashupChecker("Come Closer"));
		assertTrue("Content not detected", harryBot.groupMashupChecker("Thunder Busters"));
		assertTrue("Content not detected", harryBot.groupMashupChecker("Panama Beat"));
		assertTrue("Content not detected", harryBot.groupMashupChecker("Billie Jean Get Lucky"));
		assertTrue("Content not detected", harryBot.groupMashupChecker("Whole Lotta Helter Skelter"));
	}
	
	@Test
	public void testBestPastimeChecker()
	{
		assertTrue("Content not detected", harryBot.bestPastimeChecker("Listening to Music"));
		assertTrue("Content not detected", harryBot.bestPastimeChecker("Surfing the Web"));
		assertTrue("Content not detected", harryBot.bestPastimeChecker("Relaxing"));
		assertTrue("Content not detected", harryBot.bestPastimeChecker("Watching TV"));
		assertTrue("Content not detected", harryBot.bestPastimeChecker("Eating"));
		assertTrue("Content not detected", harryBot.bestPastimeChecker("Playing Video Games"));
		assertTrue("Content not detected", harryBot.bestPastimeChecker("Reading"));
		assertTrue("Content not detected", harryBot.bestPastimeChecker("Sleeping"));
		assertTrue("Content not detected", harryBot.bestPastimeChecker("Going to a Movie"));
		assertTrue("Content not detected", harryBot.bestPastimeChecker("Swimming"));
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
