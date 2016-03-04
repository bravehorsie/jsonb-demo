package com.oracle.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Hero to play with.
 *
 * @author Roman Grigoriadi
 */
public class Hero {

    private String name;

    private HeroClass heroClass;

    private Map<String, Item> items = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }

    public Map<String, Item> getItems() {
        return items;
    }

}
