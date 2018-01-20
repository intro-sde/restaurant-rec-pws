package rest.restaurant;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Feedback {
	
	
	public static String savePreferences(String userId,String itemId) {
		
		String result="your preferences";
		
		String uri ="https://sde-storage-ws.herokuapp.com/rdb/preferences?userId="+userId+"&itemId="+itemId;
			
		URL url;
		List<String> list = new LinkedList<>();
		try {
			url = new URL(uri);
			
			HttpURLConnection connection =
					(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			
			
			InputStream xml = connection.getInputStream();

			 
			connection.disconnect();
		
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		return result;
	}
	public static String saveRating(String userId,String itemId, String rating) {
		String result="your ratings";
			
		String uri ="https://sde-storage-ws.herokuapp.com/rdb/ratings?userId="+userId+"&itemId="+itemId+"&rating="+rating;
			
		URL url;
		List<String> list = new LinkedList<>();
		try {
			url = new URL(uri);
			
			HttpURLConnection connection =
					(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			
			
			InputStream xml = connection.getInputStream();

			
			connection.disconnect();
		
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		return result;
	}
	public static String getFeedback(String itemId, String userId, String rating) {
		String prefResult = Feedback.savePreferences(userId, itemId);
		String ratingResult = Feedback.saveRating(userId, itemId, rating);
		return "Thank you for your feedback! We saved " + prefResult + " and " + ratingResult + " in our system!";
	}
}
