package com.oracle.jsonbdemo;

import com.oracle.jsonbdemo.model.*;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Generates combat log and some loot for Hero.
 * @author Roman Grigoriadi
 */
public class CombatEngine {

    private static final CombatEngine instance = new CombatEngine();

    private final Db db = Db.getInstance();

    private static final SecureRandom random = new SecureRandom();

    public static CombatEngine getInstance() {
        return instance;
    }

    public CombatLog generateCombatLog(Hero hero) {
        CombatLog combatLog = new CombatLog();
        String heroName = hero.getName();
        for (String msg : db.getRandomCombatLog()) {
            combatLog.getMessages().add(String.format(msg, heroName));
        }
        return combatLog;
    }

    public void generateLoot(Hero hero) {
        final ItemSlotEnum[] slotValues = ItemSlotEnum.values();
        Item item = new Item();
        //generate random item slot
        ItemSlotEnum slot;
        ItemSlot itemSlot;
        do {
            slot = slotValues[random.nextInt(slotValues.length)];
            itemSlot = new ItemSlot(slot.getId(), slot.name());
        } while (hero.getItems().containsKey(itemSlot) && hero.getItems().size() < slotValues.length);
        hero.getItems().put(itemSlot, item);

        //get a random item for given slot
        item.setName(db.getRandomItemForSlot(slot));
        final ArrayList<Stat> stats = new ArrayList<>();
        stats.add(new Stat("strength", 100 + random.nextInt(100)));
        stats.add(new Stat("vitality", 50 + random.nextInt(50)));
        item.setStats(stats);
    }
}
