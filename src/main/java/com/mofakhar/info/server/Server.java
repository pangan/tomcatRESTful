package com.mofakhar.info.server;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by pangan on 08/03/2017.
 */
@Path("/hello")
public class Server {

    // This method is called if TEXT_PLAIN is request
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello GET method!";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPutHello(){
        return "Hello PUT method!";
    }
}