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

    public CombatLog sendHeroFighting(Hero hero) {
        CombatLog combatLog = new CombatLog();
        String heroName = hero.getName();
        combatLog.getMessages().add(heroName + " encounters group of skeletons with a spider queen.");
        combatLog.getMessages().add(heroName + " breaks spines of all five skeletons in one sword swing.");
        combatLog.getMessages().add(heroName + " pours a spider queen with a canister of gas and burns it to ashes.");
        combatLog.getMessages().add("That was way too easy fight for "+heroName + ".");
        combatLog.getMessages().add(heroName + " gained 1250 experience.");
        return combatLog;
    }

    public void dropLoot(Hero hero) {
        final ItemSlot[] slotValues = ItemSlot.values();
        ItemSlot slot;
        do {
            slot = slotValues[random.nextInt(slotValues.length)];
        } while (hero.getItems().containsKey(slot.name()) && hero.getItems().size() < slotValues.length);

        Item item = new Item();
        item.setName(db.getItem(slot));
        final ArrayList<Stat> stats = new ArrayList<>();
        stats.add(new Stat("strength", 100 + random.nextInt(100)));
        stats.add(new Stat("vitality", 50 + random.nextInt(50)));
        item.setStats(stats);
        hero.getItems().put(slot.name(), item);
    }
}
