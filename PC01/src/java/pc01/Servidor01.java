/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc01;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

/**
 * REST Web Service
 *
 * @author ds799
 */
@Path("generic")
public class Servidor01 {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public Servidor01() {
    }

    /**
     * Retrieves representation of an instance of pc01.Servidor01
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        return "testando";
    }
    
    @POST
    @Path("imagem")
    @Produces("application/json")
    public String media(){
        OpencvDoCarai op = new OpencvDoCarai("C:\\Users\\ds799\\OneDrive\\Imagens\\CSGO_GEEK\\IMG_9581.jpg");
    
        return "ppp";
    }
    

    /**
     * PUT method for updating or creating an instance of SDService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}