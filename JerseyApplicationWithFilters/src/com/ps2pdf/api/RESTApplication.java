package com.ps2pdf.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class RESTApplication extends ResourceConfig {
	public RESTApplication() {
		packages("com.ps2pdf.api.filters");
		register(TimeAPI.class);
	}
}
