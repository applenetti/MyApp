package com.myapp.rsservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/example")
public class Example {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getServiceName() {
		return "example";
	}
}
