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
	
	/**
	 * Saves url in myUrl; initializes myIndex to an empty HashMap with an initial capacity of 20,000
	 * @param url
	 */
	public SearchEngine(String url)
	{
		this.myURL = url;
		myIndex = new HashMap<String, List<String>>(20000);
	}
	
}
