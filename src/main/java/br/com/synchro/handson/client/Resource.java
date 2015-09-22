package br.com.synchro.handson.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author cvs
 * @create Sep 19, 2015
 */
@Path("/handson-jsf-client")
public class Resource {

    /**
     * @return message
     */
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public String print() {
	return "message";
    }
}
