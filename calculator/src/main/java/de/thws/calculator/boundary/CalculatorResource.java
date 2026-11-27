package de.thws.calculator.boundary;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("calc")
public class CalculatorResource {

    @GET
    public Integer calculate() {
        return 42;
    }

    @GET
    @Path("complex/{multi}")
    public Integer complex(@PathParam("multi") int multi) {
        return 42 * multi;
    }
}
