package tmelo.utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class contains only static methods to perform operations in String values.
 * 
 * @author Thiago Melo
 */
public class StringUtils {
	
	public static String dedup(String stringValue, StringOrder order ) {
		
		SortedSet<Character> setString;
		
		if (order == StringOrder.DESCENDING) {
			setString = new TreeSet<>(Collections.reverseOrder());
		} else {
			setString = new TreeSet<>();
		}
		
		
		for (int a=0; a < stringValue.length(); a++) {
			setString.add(stringValue.charAt(a));
		}	
		
		
		Iterator<Character> it = setString.iterator();
		
		StringBuilder returnString = new StringBuilder(setString.size());
		while (it.hasNext()) {
			returnString.append(it.next());
		}
		
		return returnString.toString();
	}
	
}
