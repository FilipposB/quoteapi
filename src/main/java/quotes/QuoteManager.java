package quotes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

//This class gives access to only one public method randomQuote that returns either a Quote object or null
public class QuoteManager {
    //Quotes from the JSON will be loaded here
    private static Quote[] quotes = null;
    //This is used to loop over the array
    private static int quote_counter = 0;

	private static Logger logger = LoggerFactory.getLogger(QuoteManager.class);


    public static Quote randomQuote(){
        //If the quotes array isn't yet initialized
        if (quotes == null){
            //init it
            grabQuotes();
            quote_counter = 0;

            //If it's still null then there was some kind of error that prevented it from being initialized
            if (quotes == null){
                logger.error("Failed to load quotes !");
                return null;
            }
        }
        //reset the counter if we reach the end of the array
        else if (quote_counter >= quotes.length){
            quote_counter = 0;
        }

        //On success return the quote
        logger.info("Succesfully returning quote");
        return quotes[quote_counter++];
    }

    //This method loads the quotes from the website into the array quotes
    private static void grabQuotes() {
        String url = "https://zenquotes.io/api/quotes";
        RestTemplate restTemplate = new RestTemplate();
        try{
            String resp = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            try {
                quotes = mapper.readValue(resp, Quote[].class);
            } catch (JsonMappingException e1) {
                logger.error("JsonMappingException");
            } catch (JsonProcessingException e1) {
                logger.error("JsonProcessingException");
            }
        }
        catch (Exception e){
            logger.error("Couldn't load the JSON data !");
        } 
    }
}
