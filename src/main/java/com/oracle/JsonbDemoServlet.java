package com.oracle;

import com.oracle.model.*;
import com.oracle.model.transport.Request;
import com.oracle.model.transport.Response;

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
import java.util.ArrayList;

/**
 * @author Roman Grigoriadi
 */
public class JsonbDemoServlet extends HttpServlet {

    private Jsonb jsonb;

    @Override
    public void init(ServletConfig config) throws ServletException {
        JsonbConfig jsonbConfig = new JsonbConfig();
        jsonbConfig.withFormatting(true);
        jsonb = JsonbBuilder.create(jsonbConfig);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("req = " + req);
        String json = req.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

        Request request = jsonb.fromJson(json, Request.class);

        resp.getWriter().write(jsonb.toJson(new Response(generateHero(), generateCombatLog())));
    }

    private Hero generateHero() {
        Hero hero = new Hero();
        hero.setName("Jason");
        hero.setHeroClass(HeroClass.BARBARIAN);
        Item item = new Item();
        item.setName("Sword of the Skeleton king");
        final ArrayList<Stat> stats = new ArrayList<>();
        stats.add(new Stat("strength", 110));
        stats.add(new Stat("vitality", 80));
        item.setStats(stats);
        hero.getItems().put(ItemSlot.WEAPON.name(), item);
        return hero;
    }

    private CombatLog generateCombatLog() {
        CombatLog combatLog = new CombatLog();
        combatLog.getMessages().add("Jason encounters group of skeletons with a spider queen.");
        combatLog.getMessages().add("Jason breaks spines of all five skeletons in one sword swing.");
        combatLog.getMessages().add("Jason pours a spider queen with a canister of gas and burns it to ashes.");
        combatLog.getMessages().add("That was way too easy fight for Jason.");
        combatLog.getMessages().add("Gained 1250 experience.");
        return combatLog;
    }
}
