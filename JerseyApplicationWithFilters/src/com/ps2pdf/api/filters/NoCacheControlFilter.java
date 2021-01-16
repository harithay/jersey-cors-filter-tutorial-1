package com.ps2pdf.api.filters;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

@Provider
public class NoCacheControlFilter implements ContainerResponseFilter {
	@Override
	public void filter(ContainerRequestContext pRequestContext, ContainerResponseContext pResponseContext) throws IOException {
		for (Annotation a : pResponseContext.getEntityAnnotations()) {
			if (a.annotationType() == NoCache.class) {
				String value = ((NoCache) a).value();
				pResponseContext.getHeaders().putSingle(HttpHeaders.CACHE_CONTROL, value);
				break;
			}
		}
	}

}