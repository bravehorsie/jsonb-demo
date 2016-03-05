package com.oracle.jsonbdemo.model.transport;

import com.oracle.jsonbdemo.model.Hero;

/**
 * Request with hero from frontend to unmarshall.
 * @author Roman Grigoriadi
 */
public class Request {

    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
