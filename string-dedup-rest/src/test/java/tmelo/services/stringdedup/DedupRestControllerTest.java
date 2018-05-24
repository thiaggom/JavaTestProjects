package tmelo.services.stringdedup;

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
public class DedupRestControllerTest {

	@Autowired
	private MockMvc moc;

	/*
	 * Test of succeed ascending string
	 */
	@Test
	public void dedupAscending() throws Exception {

		moc.perform(get("/stringDedup?value=dawb")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("abdw"));

	}

	/*
	 * Test of succeed descending string
	 */
	@Test
	public void dedupDescending() throws Exception {

		moc.perform(get("/stringDedup?value=dawb&ord=dsc")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("wdba"));

	}

	/*
	 * Test of request with value parameter greater then 30 characters.
	 */
	@Test
	public void dedupInvalidValueParameter() throws Exception {
		moc.perform(get("/stringDedup?value=alkdahdkjhfakjfhkajfhkahfkahfkahkfhkafhkahfk")).andDo(print())
				.andExpect(status().isBadRequest());
	}

	/*
	 * Test of request with invalid value of 'ord' parameter.
	 */
	@Test
	public void dedupInvalidOrdParameter() throws Exception {
		moc.perform(get("/stringDedup?value=alkda&ord=aaa")).andDo(print())
		.andExpect(status().isBadRequest());
	}
	
}
