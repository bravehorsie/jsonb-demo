package com.oracle.jsonbdemo;

import com.oracle.jsonbdemo.model.ItemSlot;

import java.security.SecureRandom;
import java.util.*;

/**
 * Game database
 *
 * @author Roman Grigoriadi
 */
public class Db {

    private static final Db instance = new Db();

    private static final SecureRandom random = new SecureRandom();

    private final Map<ItemSlot, List<String>> lootDb;

    private final List<String[]> combatLogDb;

    private Db() {
        this.lootDb = initialiseLoot();
        this.combatLogDb = initialiseCombatLog();
    }

    private List<String[]> initialiseCombatLog() {
        List<String[]> result = new ArrayList<>();
        String[] skeletonCombatLog = new String[5];
        skeletonCombatLog[0] = "%s encounters group of skeletons with a spider queen.";
        skeletonCombatLog[1] = "%s breaks spines of all five skeletons in one sword swing.";
        skeletonCombatLog[2] = "%s pours a spider queen with a canister of gas and burns it to ashes.";
        skeletonCombatLog[3] = "That was way too easy fight for %s.";
        skeletonCombatLog[4] = "%s gained 1250 experience.";
        result.add(skeletonCombatLog);

        String[] deathAngelsCombatLog = new String[3];
        deathAngelsCombatLog[0] = "%s encounters group of Death Angels.";
        deathAngelsCombatLog[1] = "Death Angels are flying away, when they seen %s.";
        deathAngelsCombatLog[2] = "%s gained 1111 experience.";
        result.add(deathAngelsCombatLog);

        String[] zombieLog = new String[7];
        zombieLog[0] = "%s encounters group of zombies with a Grotesque.";
        zombieLog[1] = "%s smashes heads of zombies with a shield. ";
        zombieLog[2] = "Zombies are way too slow and weak to resist %s's attack.";
        zombieLog[3] = "%s Jumps to a Grotesque and and rips its abdominal.";
        zombieLog[4] = "Guts of grotesque falls on the floor.";
        zombieLog[5] = "Grotesque is unable to move and dies in a slow pain.";
        zombieLog[6] = "Gained 2100 experience.";
        result.add(zombieLog);

        return result;
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

    public String[] getCombatLog() {
        return combatLogDb.get(random.nextInt(combatLogDb.size()));
    }
}
