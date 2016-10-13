/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Car;
import facade.Facade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author rasmus
 */
@Path("car")
public class CarService {
    
    Facade fac = new Facade(Persistence.createEntityManagerFactory("pu"));
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarService
     */
    public CarService() {
    }

    /**
     * Retrieves representation of an instance of rest.CarService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCarsJSON() {
        List<Car> cars = fac.getCars();
        return gson.toJson(cars);
//        return "[]";
    }

    /**
     * PUT method for updating or creating an instance of CarService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putCarJSON(String content) {
    }
}
