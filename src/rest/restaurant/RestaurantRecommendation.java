package rest.restaurant;

import java.net.URI;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class RestaurantRecommendation {
	public static WebTarget config() {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget service = client.target(getBaseURI());
		System.out.println("Calling " + getBaseURI() ); 
		return service;
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"https://sde-recommendation-ws.herokuapp.com").build();
	}
	public static String recommendRestaurants(String userId,String city) {
		
		String type = "restaurant";
		
		WebTarget service = config();
		Response resp = service.path("/recommend").queryParam("userId", userId).queryParam("type", type).queryParam("city", city).request().accept(MediaType.APPLICATION_JSON).get();
		String response = resp.readEntity(String.class);
		
		
		return response;
}

	
	
	

}
