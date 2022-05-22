package com.rquoteapi.quoteapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import quotes.Quote;
import quotes.QuoteManager;

@RestController
public class QuoteController {

	Logger logger = LoggerFactory.getLogger(QuoteController.class);

	//GET endpoint name quote , when caled uppon it returns a quote in a json format
	@GetMapping(value = "/quote", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Quote> greeting() {
		
		//Attempt to get a random quote
		Quote quote = QuoteManager.randomQuote();
		//If something goes wrong and there isn't any quote available
		if (quote == null) {
			logger.error("Failed !");
			return new ResponseEntity<Quote>(HttpStatus.FAILED_DEPENDENCY);
		}

		//If the process is succesful
		logger.info("Quote Served !");
		return new ResponseEntity<Quote>(quote, HttpStatus.OK);
	}

}