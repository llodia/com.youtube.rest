package com.youtube.rest.status;

import java.util.Calendar;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.youtube.db.*;


/*
 * @ = annotation, tell Jeresy what to look for and how to handle requests
 * @GET = HTTP verb
 * @Produces(MediaType.TEXT_HTML) = how its going to be encoded 
 * static = means there is only one instance
 * @POST = used to insert/ add data or submitting
 * @PUT = used mainly for updating
 * @HEAD = used to return meta-data of resource
 * @consumes = tells the application to expect data to be sent in the body
 *  of the HTTP message
 */



@Path("/v1/status") //to route java class
public class V1_status
{

	private static final String api_version ="00.01.00";
	private Calendar today;
	
@GET
@Produces(MediaType.TEXT_HTML)
public String returnTitle()
{
	return "<p> Java web Services</p>";
}


@Path("/version") // route to specific method
@GET
@Produces(MediaType.TEXT_HTML)
public String returnVersion()
{	
 return "<p>Version:</p> " + api_version;
}


@Path("/name")
@GET
@Produces(MediaType.TEXT_HTML)
public String getName()
{
	return "My name is David Diallo";
}


@Path("/database")
@GET
@Produces(MediaType.TEXT_HTML)
public String databaseConnection()
{
	PostgresDb db = new PostgresDb();
	return null;
	
	
	
}

}
