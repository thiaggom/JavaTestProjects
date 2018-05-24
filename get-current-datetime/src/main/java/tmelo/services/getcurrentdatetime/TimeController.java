package tmelo.services.getcurrentdatetime;

import org.joda.time.MutableDateTime;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class that exposes a REST service the current Date and Time.
 * 
 * @author Thiago Melo
 *
 */
@RestController
@RequestMapping(path="/time")
public class TimeController {

	/**
	 * Return the current Date and Time of the system.
	 * @return String 
	 */
	@RequestMapping(method=RequestMethod.GET, path="/current", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String sayCurrentTime() {
		MutableDateTime now = new MutableDateTime();
		return now.toString();
	}	
	
}
