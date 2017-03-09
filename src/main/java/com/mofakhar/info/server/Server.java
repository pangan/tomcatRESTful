package com.mofakhar.info.server;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by pangan on 08/03/2017.
 */
@Path("/hello")
public class Server {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello GET method!";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPutHello(InputStream data){

        
        String line = "";
        StringBuilder sb = new  StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(data));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String ret_value = String.format("Received data: %s \n", sb.toString());

        return ret_value;
    }
}