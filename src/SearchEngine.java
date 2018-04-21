import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Kevin, Ezra
 *
 */
public class SearchEngine 
{
	//The name for the url
	private String myURL;
	//The word index
	private Map<String, List<String>> myIndex;
	
<<<<<<< HEAD
	/**
	 * Saves url in myUrl; initializes myIndex to an empty HashMap with an initial capacity of 20,000
	 * @param url
	 */
	public SearchEngine(String url)
	{
		this.myURL = url;
		myIndex = new HashMap<String, List<String>>(20000);
=======
	public String getURL()
	{
		return myURL;
	}
	
	public void add(String line)
	{
		
	}
	
	public List<String> getHits(String word)
	{
		
	}
	
	private Set<String> parseWords(String line);
	{
		
>>>>>>> 695f9a25c61371e63ef603a098775c8687750c81
	}
	
}
