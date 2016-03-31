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
    protected void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {

        //Unmarshall json to Request object with Hero inside.
        Request request = jsonb.fromJson(httpRequest.getInputStream(), Request.class);
        Hero hero = request.getHero();


        //Generate combat log and loot.
        CombatLog combatLog = combatEngine.generateCombatLog(hero);
        combatEngine.generateLoot(hero);


        //Marshall our hero back to JSON object.
        jsonb.toJson(new Response(hero, combatLog), Response.class, httpResponse.getOutputStream());
    }

}
