package com.rquoteapi.quoteapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuoteapiApplicationTests {

	@Autowired
    private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/quote"))
		.andDo(document("home", responseFields(
        fieldWithPath("message").description("The welcome message for the user.");
    }

}
