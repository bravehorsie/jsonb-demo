package com.oracle.model;

import java.util.List;

/**
 * Dropped loot.
 * Hero items, which can be equipped.
 *
 * @author Roman Grigoriadi
 */
public class Item {

    private String name;

    private List<Stat> stats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }
}
