package com.rquoteapi.quoteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import quotes.QuoteManager;

@SpringBootApplication
public class QuoteapiApplication {

	public static void main(String[] args) {
		//Init QuoteManager here
		QuoteManager.grabQuotes();

		SpringApplication.run(QuoteapiApplication.class, args);
	}

}
