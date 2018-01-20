# restaurant-rec-pws
RESTful process centric service for recommending restaurants. This layer serves all requests coming directly from application interface. The process centric services are the gateway to all other modules/services in an application context.

We have an internal method which has an array of strings holding five motivational quotes about food. These quotes are taken from google. With the help of random generator iterator, these quotes are randomly retrieved during the method call.

The following operations for the https://sde-restaurant-rec-pws.herokuapp.com/process endpoint are available in this service:

- /quotes @GET | [] | Returns a food related random quote from internal method.
- /user/registration @POST | [firstname, lastname, email, birthyear] | Saves input data if new user.
- /user/id @GET | [firstname, lastname, email, birthyear] | Returns id of given user.
- /recommendation @GET | [userId, city] | Get 5 recommended restaurants.
- /feedback @POST | [itemId, userId, rating] | Saves item as user preference and adds rating.


