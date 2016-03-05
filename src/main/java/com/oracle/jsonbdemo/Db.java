package com.oracle.jsonbdemo;

import com.oracle.jsonbdemo.model.ItemSlot;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Game database
 *
 * @author Roman Grigoriadi
 */
public class Db {

    private static final Db instance = new Db();

    private static final SecureRandom random = new SecureRandom();

    private final Map<ItemSlot, List<String>> lootDb;

    private Db() {
        this.lootDb = initialiseLoot();
    }

    private Map<ItemSlot, List<String>> initialiseLoot() {
        Map<ItemSlot, List<String>> items = new HashMap<>();
        items.put(ItemSlot.BELT, Arrays.asList("Vigilante belt", "Highlord Kruul's Final Curse", "Al'maiesh, the Cord of Hope"));
        items.put(ItemSlot.BOOTS, Arrays.asList("Ice walkers","Aman'Thul's Stride"));
        items.put(ItemSlot.CHEST, Arrays.asList("Tyrael's might", "Heart of Iron", "Cindercoat"));
        items.put(ItemSlot.GLOVES, Arrays.asList("Bear claws", "Gloves of whorship"));
        items.put(ItemSlot.HEAD, Arrays.asList("Bad mojo mask", "Andariel's visage", "Gaze of Justice"));
        items.put(ItemSlot.NECK, Arrays.asList("Binding of the lost", "Eye of Etlich", "Hellfire amulet"));
        items.put(ItemSlot.SHOULDERS, Arrays.asList("Shiny plates", "Death watch mantle"));
        items.put(ItemSlot.PANTS, Arrays.asList("Hexing pants of Mr. Yan", "Death's bargain"));
        items.put(ItemSlot.WEAPON, Arrays.asList("Sword of the Skeleton king", "Butcher's Carver", "Maximus"));

        return items;
    }

    public static Db getInstance() {
        return instance;
    }

    /**
     * Get random item for a slot.
     */
    public String getItem(ItemSlot slot) {
        final List<String> itemNames = lootDb.get(slot);
        return itemNames.get(random.nextInt(itemNames.size()));
    }
}
