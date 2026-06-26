package codewatch.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LeetCodeService {

    public static String getData(String username) throws Exception {

    	 String apiUrl =
    	            "https://alfa-leetcode-api.onrender.com/" +
    	            username +
    	            "/solved";

        URL url = new URL(apiUrl);

        HttpURLConnection con =
            (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        BufferedReader br =
            new BufferedReader(
                new InputStreamReader(con.getInputStream())
            );

        String line;
        StringBuilder response = new StringBuilder();

        while((line = br.readLine()) != null) {
            response.append(line);
        }

        br.close();

        return response.toString();
    }
    public static String getProfile(String username) throws Exception
    {
    	String apiUrl="https://alfa-leetcode-api.onrender.com/userProfile/" +
    	        username;
    	URL url=new URL(apiUrl);
    	
    	HttpURLConnection con=(HttpURLConnection)url.openConnection();
    	con.setRequestMethod("GET");
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
    	String line;
    	StringBuilder response=new StringBuilder();
    	
    	while((line=br.readLine())!= null)
    	{
    		response.append(line);
    	}
    	br.close();
    	return response.toString();
    }
    public static String getRecentSubmission(String username) throws Exception
    {
    	String apiUrl="https://alfa-leetcode-api.onrender.com/"+username+"/submission";
    	URL url=new URL(apiUrl);
    	HttpURLConnection con=(HttpURLConnection)url.openConnection();
    	
    	con.setRequestMethod("GET");
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
    	String line;
    	StringBuilder response=new StringBuilder();
    	
    	while((line=br.readLine())!=null)
    	{
    		response.append(line);
    		
    	}
    	br.close();
    	return response.toString();
    	
    }
    
}