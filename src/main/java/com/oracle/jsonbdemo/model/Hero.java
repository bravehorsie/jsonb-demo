package com.oracle.jsonbdemo.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    /**
     * Get total strength of the hero.
     * Demonstrating getter without field.
     *
     * @return total strength
     */
    public Long getTotalStrength() {
        return getTotalStat("strength");
    }

    /**
     * Get total strength of the hero.
     * Demonstrating getter without field.
     *
     * @return total strength
     */
    public Long getTotalVitality() {
        return getTotalStat("vitality");
    }

    private Long getTotalStat(String statName) {
        return items.values().stream().collect(Collectors.summarizingLong(item -> {
            return item.getStats().stream().filter(stat -> stat.getName().equals(statName))
                    .collect(Collectors.summarizingLong(stat -> stat.getValue())).getSum();
        })).getSum();
    }
}
