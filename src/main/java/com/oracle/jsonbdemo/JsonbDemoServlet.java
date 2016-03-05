package com.oracle.jsonbdemo;

import com.oracle.jsonbdemo.model.CombatLog;
import com.oracle.jsonbdemo.model.Hero;
import com.oracle.jsonbdemo.model.transport.Request;
import com.oracle.jsonbdemo.model.transport.Response;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Main servlet dispatching JSON requests.
 * @author Roman Grigoriadi
 */
public class JsonbDemoServlet extends HttpServlet {

    private Jsonb jsonb;

    private CombatEngine combatEngine;

    @Override
    public void init(ServletConfig config) throws ServletException {
        JsonbConfig jsonbConfig = new JsonbConfig();
        jsonbConfig.withFormatting(true);
        jsonb = JsonbBuilder.create(jsonbConfig);
        combatEngine = CombatEngine.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get JSON body from POST
        String jsonBody = req.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

        //Unmarshall json to Request object with Hero inside.
        Request request = jsonb.fromJson(jsonBody, Request.class);
        Hero hero = request.getHero();
        CombatLog combatLog = combatEngine.sendHeroFighting(hero);
        combatEngine.dropLoot(hero);

        //Marshall our hero back to JSON object.
        resp.getWriter().write(jsonb.toJson(new Response(hero, combatLog)));
    }

}
