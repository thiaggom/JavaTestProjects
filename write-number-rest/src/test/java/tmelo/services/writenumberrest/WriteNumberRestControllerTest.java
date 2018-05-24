package tmelo.services.writenumberrest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WriteNumberRestControllerTest {

	@Autowired
	MockMvc mock;
	
	/*
	 * Test of succeed spelling number
	 */
	@Test
	public void suceedSpellNumber() throws Exception {

		mock.perform(get("/writeNumber?value=100282")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("One hundred thousand, two hundred eighty two"));

	}

	/*
	 * Test of number minor then 0.
	 */
	@Test
	public void numberMinorThenZero() throws Exception {
		mock.perform(get("/writeNumber?value=-4")).andDo(print()).andExpect(status().isBadRequest());
	}
	
	/*
	 * Test of number greater then 999999.
	 */
	@Test
	public void numberMilionNumber() throws Exception {
		mock.perform(get("/writeNumber?value=1000000")).andDo(print()).andExpect(status().isBadRequest());
	}
	
}
