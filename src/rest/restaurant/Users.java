package rest.restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import soap.User;
import soap.UserImplService;

public class Users {

	public static String registerUser(String firstname, String lastname, String email, String birthyear) {

		UserImplService us=new UserImplService();
		User u = us.getUserImplPort();
		
		String output=u.checkUser(firstname, lastname, email, birthyear);

		return output;
	}

	public static String getUserID(String firstname, String lastname,String email,String birthyear) {
		String result=null;

		String uri =
				"https://sde-storage-ws.herokuapp.com/rdb/users?firstname="+firstname+"&lastname="+lastname+"&email="+email+"&birthyear="+birthyear;
		URL url;

		try {
			url = new URL(uri);

			HttpURLConnection connection =
					(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");


			BufferedReader in = new BufferedReader
					(new InputStreamReader(connection.getInputStream()));
			String inputLine=null;

			while ((inputLine = in.readLine()) != null) {
				result=(inputLine);
			}


			in.close();
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
}
