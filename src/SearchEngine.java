import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Kevin, Ezra
 *
 */
public class SearchEngine 
{
	//The name for the url (file name)
	private String myURL;
	//The word index
	private Map<String, List<String>> myIndex;
	
	/**
	 * Constructor for SearchEngine
	 * Saves url in myUrl; initializes myIndex to an empty HashMap with an initial capacity of 20,000
	 * @param url
	 */
	public SearchEngine(String url)
	{
		this.myURL = url;
		myIndex = new HashMap<String, List<String>>(20000);
	}
	
	/**
	 * @return myUrl
	 */
	public String getURL()
	{
		return myURL;
	}
	
	/**
	 * Extracts all the words from param line, and, for each word, adds line to its list of lines in myIndex
	 * @param line
	 */
	public void add(String line)
	{
		TreeSet<String> words = (TreeSet<String>) parseWords(line);
		
		for (String word: words)
		{
			List<String> list = myIndex.get(word);
			
			if(list != null)
			{
				list.add(line);
			}
			
			else
			{
				List<String> newList = new LinkedList<String>();
				newList.add(line);
				myIndex.put(word, newList);
			}
		}
	}
	
	/**
	 * @return the list of lines associated with word in myIndex
	 */
	public List<String> getHits(String word)
	{
		return myIndex.get(word);
	}
	
	/**
	 * @return a set of all words in line
	 */
	private Set<String> parseWords(String line)
	{
		TreeSet<String> result = new TreeSet<String>();
		
		String[] words = line.split("\\W+");
		for (String word : words)
			result.add(word.toLowerCase());
		
		
		return result;
	}
	
}
