package com.oracle.jsonbdemo.model;

/**
 * Characteristics of an item. Strength, vitality, etc.
 *
 * @author Roman Grigoriadi
 */
public class Stat {

    public Stat() {
    }

    public Stat(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
