package com.mofakhar.info.server;

import javassist.bytecode.stackmap.TypeData;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * Created by pangan on 08/03/2017.
 */
@Path("/hello")
public class Server {

    private static final Logger LOGGER = Logger.getLogger( TypeData.ClassName.class.getName());

    public Server() throws IOException {
        Handler fh = new FileHandler("%t/tomcatrest.log");
        fh.setFormatter(new SimpleFormatter());
        LOGGER.getLogger("").addHandler(fh);
        LOGGER.info("start");
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello(){
        LOGGER.info("GET method received.");
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
        LOGGER.info(String.format("PUT method received : %s", sb.toString()));
        return ret_value;
    }
}