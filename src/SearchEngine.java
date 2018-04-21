import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Kevin, Ezra
 * Date: 4/21/2018
 * 
 * This class models a Search Engine for text files - 'Giggle'. 
 */
public class SearchEngine 
{
	//The name for the url (file name)
	private String myURL;
	
	//The word index
	private Map<String, List<String>> myIndex;
	
	/**
	 * Constructor for SearchEngine
	 * saves url in myUrl
	 * initializes myIndex to an empty HashMap with an initial capacity of 20,000
	 */
	public SearchEngine(String url)
	{
		this.myURL = url;
		myIndex = new HashMap<String, List<String>>(20000);
	}
	
	/**
	 * Used in the displaying of the name of the file in which hits were found
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
		//Obtain TreeSet<String> of each word in line
		TreeSet<String> words = (TreeSet<String>) parseWords(line);
		
		//For each word
		for (String word: words)
		{
			//Attempt to retrieve the list associated with the key 'word' in myIndex
			List<String> list = myIndex.get(word);
			
			//Successfully found object associated with key
			if(list != null)
			{
				//Add the line
				list.add(line);
			}
			
			//myIndex does not have the key 'word'
			else
			{
				//Create and add new LinkedList<String> to put into the Hashmap
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
		//Result to return
		TreeSet<String> result = new TreeSet<String>();
		
		//Obtain array of all individual words in line
		String[] words = line.split("\\W+");
		
		//Add each word to the resulting array, in lowercase
		for (String word : words)
			result.add(word.toLowerCase());
		
		
		return result;
	}
	
}
