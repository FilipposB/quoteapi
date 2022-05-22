package quotes;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//This is a POJO class
//We will load the data that we will capture from "https://zenquotes.io/api/quotes" into objects of this class
public class Quote {
    //This tells us in what order the data will be placed in the resulting JSON
    @JsonPropertyOrder({ "q", "a" ,"c", "h"})

    private  String q;
    private  String a;
    private  int c;
    private  String h;

    private Quote() {
    }

    public Quote(String q, String a, int c, String h){
        this();

        this.q = q; 
        this.a = a;
        this.c = c;
        this.h = h;
    }


    public String getH() {
        return h;
    }

    public int getC() {
        return c;
    }

    public String getA() {
        return a;
    }

    public String getQ() {
        return q;
    }
}
