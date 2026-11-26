package de.thws.calculator.boundary;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("calc")
public class CalculatorResource {

    @GET
    public Integer calculate() {
        return 42;
    }
}
