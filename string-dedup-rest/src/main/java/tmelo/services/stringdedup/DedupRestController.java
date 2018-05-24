package tmelo.services.stringdedup;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tmelo.utils.StringOrder;
import tmelo.utils.StringUtils;

/**
 * Class that exposes a REST service for ordering a String without duplicate characters.
 * Every request must be done using http verb GET.
 * 
 * @author Thiago Melo
 *
 */
@RestController
public class DedupRestController {

	/**
	 * Service operation responsible for ordering a String without duplicate characters. 
	 * You can request to ordering a String in ascending order or descending order. 
	 * 
	 * @param paramValue required parameter.
	 * @param paramOrdering optional parameter. If not informed 'asc' value would be used. 
	 * @return String ordered as requested
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/stringDedup", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DedupRestResponseVO> dedup(@RequestParam(value = "value") String paramValue,
			@RequestParam(value = "ord", defaultValue = "asc") String paramOrdering) {

		DedupRestResponseVO resp;
		ResponseEntity<DedupRestResponseVO> respBody = null;

		if (paramValue.trim().length() > 30) {
			respBody = new ResponseEntity<>(
					new DedupRestResponseVO("'value' parameter cannot greater than 30 characters."),
					HttpStatus.BAD_REQUEST);

		} else if (paramOrdering != null && !paramOrdering.trim().equals("asc")
				&& !paramOrdering.trim().equals("dsc")) {
			respBody = new ResponseEntity<>(new DedupRestResponseVO("'ord' parameter must be 'asc' or 'dsc'"),
					HttpStatus.BAD_REQUEST);
		} else if (paramOrdering.trim().equals("dsc")) {
			resp = new DedupRestResponseVO(StringUtils.dedup(paramValue, StringOrder.DESCENDING));
			respBody = new ResponseEntity<>(resp, HttpStatus.OK);
		} else {
			resp = new DedupRestResponseVO(StringUtils.dedup(paramValue, StringOrder.ASCENDING));
			respBody = new ResponseEntity<>(resp, HttpStatus.OK);
		}

		return respBody;
	}

}
