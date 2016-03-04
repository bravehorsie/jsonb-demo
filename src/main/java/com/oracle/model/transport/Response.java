package com.oracle.model.transport;

import com.oracle.model.CombatLog;
import com.oracle.model.Hero;

/**
 * Response from backend.
 *
 * @author Roman Grigoriadi
 */
public class Response {

    public Response() {
    }

    public Response(Hero hero, CombatLog combatLog) {
        this.hero = hero;
        this.combatLog = combatLog;
    }

    private Hero hero;

    private CombatLog combatLog;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public CombatLog getCombatLog() {
        return combatLog;
    }

    public void setCombatLog(CombatLog combatLog) {
        this.combatLog = combatLog;
    }
}
