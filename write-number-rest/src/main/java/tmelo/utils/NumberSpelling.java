package tmelo.utils;

import org.springframework.util.StringUtils;

/**
 * Utility class used to perform spelling operation on numbers.
 * 
 * @author Thiago Melo
 *
 */
public class NumberSpelling {

	public static String spellNumber(int numberValue) {
		
		String resp = null;
		
		
		int div = numberValue/1000;
		int rem = numberValue%1000;
		
		// number less then 1000
		if (div == 0) {
			resp = numberLessThenThousand(numberValue);
		} else {
			// if number bigger then 100 then spell thousand
			if (rem == 0) {
				resp = numberLessThenThousand(div)+" thousand";
			} else {
				resp = numberLessThenThousand(div)+" thousand, "+numberLessThenThousand(rem);
			}
		}
		
		return StringUtils.capitalize(resp);
	}

	
    /**
     * Return text from numbers less then 20.
     * 
     * @param teenNumber
     * @return 
     */
    private static String teenNumberText(int teenNumber) {
    	String result = null;
    	switch (teenNumber) {
			case 0: result = "zero"; break;
			case 1: result = "one"; break;
			case 2: result = "two"; break;
			case 3: result = "three"; break;
			case 4: result = "four"; break;
			case 5: result = "five"; break;
			case 6: result = "six"; break;
			case 7: result = "seven"; break;
			case 8: result = "eight"; break;
			case 9: result = "nine"; break;
			case 10: result = "ten"; break;
			case 11: result = "eleven"; break;
			case 12: result = "twelve"; break;
			case 13: result = "thirteen"; break;
			case 14: result = "fourteen"; break;
			case 15: result = "fifteen"; break;
			case 16: result = "sixteen"; break;
			case 17: result = "seventeen"; break;
			case 18: result = "eighteen"; break;
			case 19: result = "nineteen";
    	}
    	return result;
    }
    
    /**
     * Return the tens text of the numbers.
     * 
     * @param tenNumber
     * @return
     */
    private static String tensNumberText(int tenNumber) {
    	String resp = null;
    	
    	switch (tenNumber) {
			case 1: resp = "ten"; break;
			case 2: resp = "twenty"; break;
			case 3: resp = "thirty"; break;
			case 4: resp = "forty"; break;
			case 5: resp = "fifty"; break;
			case 6: resp = "sixty"; break;
			case 7: resp = "seventy"; break;
			case 8: resp = "eighty"; break;
			case 9: resp = "ninety"; break;
		}
    	
    	return resp;
    }
    
    public static void main(String[] args) {

    	int[] numerosTeste = {999999, 151000, 787321, 1900, 300000};
    	
    	for (int numero : numerosTeste) {
    		System.out.println("## spelling "+numero+" ==> "+NumberSpelling.spellNumber(numero));
    	}
    	
		
	}
    
    /**
     * Return the text of a value less then 1000.
     * 
     * @param numberValue
     *            the number (< 1000) to be spelled.
     * @return text of the numberValue.
     */
    private static String numberLessThenThousand(int numberValue) {

    	// if number is less then 20 then get the text within teenNumberText method.
        if (numberValue < 20) {
            return teenNumberText(numberValue);
        } else if (numberValue < 100) {
            
        	// otherwise, verify number until 99
            int div = numberValue / 10;
            int rem = numberValue % 10;

            if (rem == 0) {
                // spell only the integer part.
                return tensNumberText(div);
            } else {
                // spell both integer and decimal part
                return tensNumberText(div) + " " + teenNumberText(rem);
            }
        } else {
            // otherwise, verify number greater then 99 and multiplus of 100.
            int div = numberValue / 100;
            int rem = numberValue % 100;

            if (rem == 0) {
                return teenNumberText(div) + " hundred";
            } else {
                return teenNumberText(div) + " hundred " + numberLessThenThousand(rem);
            }
        }
    }

}
