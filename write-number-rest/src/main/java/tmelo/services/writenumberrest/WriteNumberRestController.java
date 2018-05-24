package tmelo.services.writenumberrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tmelo.utils.NumberSpelling;

/**
 * Class that exposes a REST service for spelling numbers in english language.
 * Every request must be done using http verb GET.
 * 
 * @author Thiago Melo
 *
 */
@RestController
public class WriteNumberRestController {

	/**
	 * Service operation responsible for spelling a given number in english language.
	 * 
	 * @param paramNumber required parameter.
	 * @return String representing the informed number
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/writeNumber", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WriteNumberResponseVO> writeNumber(@RequestParam(value = "value") int paramNumber) {
		ResponseEntity<WriteNumberResponseVO> resp = null;

		if (paramNumber < 0 || paramNumber > 999999) {
			resp = new ResponseEntity<>(
					new WriteNumberResponseVO("'value' parameter must be positive and minor then 999999"),
					HttpStatus.BAD_REQUEST);
		} else {
			resp = new ResponseEntity<>(new WriteNumberResponseVO(NumberSpelling.spellNumber(paramNumber)),
					HttpStatus.OK);
		}

		return resp;
	}
	
}
