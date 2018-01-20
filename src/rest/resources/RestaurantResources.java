package rest.resources;

import java.io.IOException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recombee.api_client.exceptions.ApiException;

import rest.restaurant.Feedback;
import rest.restaurant.Quotes;
import rest.restaurant.RestaurantRecommendation;
import rest.restaurant.Users;

@Stateless
@LocalBean
@Path("/process")
public class RestaurantResources {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/quotes")
	public String getQuote() throws Exception {
		System.out.println("--> RestaurantResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		String quote = Quotes.getRandomQuotes();
		return quote;
	}
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/user/registration")
	public String register(@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname, @QueryParam("email") String email,@QueryParam("birthyear") String birthyear) throws ApiException, IOException {
		System.out.println("--> RestaurantResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		String result = Users.registerUser(firstname, lastname, email, birthyear);
		return result;
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Path("/user/id")
	public String getUserId(@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname, @QueryParam("email") String email,@QueryParam("birthyear") String birthyear) throws ApiException, IOException {
		System.out.println("--> RestaurantResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		String id = Users.getUserID(firstname, lastname, email, birthyear);
		return id;
	}
	
	 public static String format(String jsonString) throws IOException {
		 ObjectMapper mapper = new ObjectMapper();
		 Object json = mapper.readValue(jsonString, Object.class);
		 String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

	      return prettyJson;
}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Path("/recommendation")
	public String getRecommendation(@QueryParam("userId") String userId, @QueryParam("city") String city) throws ApiException, IOException {
		System.out.println("--> RestaurantResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		String recommendations = RestaurantRecommendation.recommendRestaurants(userId, city);
		return format(recommendations);
	}
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Path("/feedback")
	public String getFeedback(@QueryParam("itemId") String itemId, @QueryParam("userId") String userId, @QueryParam("rating") String rating) throws ApiException, IOException {
		System.out.println("--> RestaurantResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		String result = Feedback.getFeedback(itemId, userId, rating);
		return result;
	}

	
}
