package com.rquoteapi.quoteapi;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuoteController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
class QuoteapiApplicationTests {

	@Autowired
    private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/quote")).andDo(print()).andExpect(status().isOk())
				.andDo(document("home"));
    }

}
