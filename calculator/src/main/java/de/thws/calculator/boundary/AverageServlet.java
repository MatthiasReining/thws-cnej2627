package de.thws.calculator.boundary;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/average")
public class AverageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("queryString: " + req.getQueryString());

        resp.setHeader("thws-status", "date: " + new Date());
        var p1 = req.getParameter("p1");
        var p2 = req.getParameter("p2");

        if (p1 == null || p2 == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Both p1 and p2 are required.");
            return;
        }

        BigDecimal average;
        try {
            average = new BigDecimal(p1).add(new BigDecimal(p2)).divide(BigDecimal.TWO);
        } catch (NumberFormatException invalidNumber) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Both p1 and p2 must be numbers.");
            return;
        }

        String result = "{'result':" + average + "}";
        resp.setContentType("application/json");
        resp.getWriter().print(result);
    }

}
