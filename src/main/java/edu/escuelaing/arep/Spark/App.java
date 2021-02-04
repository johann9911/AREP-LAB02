package edu.escuelaing.arep.Spark;

import static spark.Spark.*;

import java.util.HashMap;

import edu.escuelaing.arep.Calculator.Calculator;
import spark.Request;
import spark.Response;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		port(getPort());
		
		get("/", (req, res) -> {
			String page = "<!DOCTYPE html>\n" 
	                + "<html>\n" 
	                + "<body>\n"
	                + "<h1>Calculator to get mean and deviation</h1>\n"
	                + "<p>Given a set of numbers separated by a space, the program calculates the mean and deviation</p>\n"
	                + "<p>Write the numbers in the space:</p>\n"
	                + "<form method=\"get\" action=\"/calculate\">"
	                + "<input type=\"text\" name=\"listNumbers\" placeholder=\"Numbers\"><br>\n"
	                + "<button type=\"submit\">Calculate\n"
	                + "</form>\n"
	                + "</body>\n" 
	                + "</html>\n";
	        return page;
		});
		
        get("/calculate", (req, res) -> {
        	Calculator c = new Calculator();
    		HashMap<String,Double> resul = new HashMap<String,Double>(); 
    		resul = c.calculate(req.queryParams("listNumbers"));
    		String page = "<!DOCTYPE html>" 
                    + "<html>" 
                    + "<body>"
                    + "<h1>Results</h1>\n"
                    + "<p>Mean:" + resul.get("Mean") +"<br>"
                    + "<p>Deviation:" + resul.get("Deviation") +"<br>"
                    + "<a href=\"/\">Back</a>"
                    + "</body>" 
                    + "</html>";
           
            return page;
        });
	}

	static int getPort() {
		 if (System.getenv("PORT") != null) {
			 return Integer.parseInt(System.getenv("PORT"));
		 }
		 return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
	}
}
