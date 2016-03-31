package com.oracle.jsonbdemo.model;

import java.util.Objects;

/**
 * @author Roman Grigoriadi
 */
public class ItemSlot {

    private final Long id;

    private final String name;

    public ItemSlot(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ItemSlot itemSlot = (ItemSlot) o;
        return Objects.equals(id, itemSlot.id) &&
                Objects.equals(name, itemSlot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
