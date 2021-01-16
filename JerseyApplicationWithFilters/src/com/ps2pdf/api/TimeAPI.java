package com.ps2pdf.api;

import java.time.Instant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ps2pdf.api.filters.NoCache;

@Path("/time")
public class TimeAPI {
	
	@GET
	@Path("/now")
	@Produces(MediaType.TEXT_PLAIN)
	@NoCache
	public Response getCurrentTime() {
		Instant now = Instant.now();
		return Response.ok(now.toString()).build();
	}
}
