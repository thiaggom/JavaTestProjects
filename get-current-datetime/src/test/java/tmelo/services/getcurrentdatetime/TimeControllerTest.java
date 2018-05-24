package tmelo.services.getcurrentdatetime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.MutableDateTime;
import org.junit.After;
import org.junit.Before;
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
public class TimeControllerTest {

	@Autowired
	private MockMvc mock;

	@Before
	public void init() {
		// setting current date of the system for test.
		MutableDateTime fixedTime = new MutableDateTime(2018, 1, 16, 0, 0, 0, 0);
		DateTimeUtils.setCurrentMillisFixed(fixedTime.getMillis());
	}

	@After
	public void cleanUp() {
		// return the system configuration
		DateTimeUtils.setCurrentMillisSystem();
	}

	@Test
	public void currentTimeShouldReturnTime() throws Exception {
		mock.perform(get("/time/current")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$").value(new DateTime(DateTimeUtils.currentTimeMillis()).toString()));

	}

}
