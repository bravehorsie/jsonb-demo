package com.oracle.jsonbdemo;

import com.oracle.jsonbdemo.model.ItemSlotEnum;

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

    private final Map<ItemSlotEnum, List<String>> lootDb;

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
        deathAngelsCombatLog[1] = "Death Angels are horrified by Jason's s mask, they are flying away from %s as fast as possible.";
        deathAngelsCombatLog[2] = "%s gained 1111 experience.";
        result.add(deathAngelsCombatLog);

        String[] zombieLog = new String[4];
        zombieLog[0] = "%s encounters group of zombies.";
        zombieLog[1] = "%s jumps into zombies smashing their heads with his heavy shield.";
        zombieLog[2] = "Zombies are way too slow and weak to resist such a fast and destructive attack.";
        zombieLog[3] = "Gained 2100 experience.";
        result.add(zombieLog);

        String[] olympicLog = new String[5];
        olympicLog[0] = "%s encounters an epic olympic barbell loaded with countless red plates.";
        olympicLog[1] = "%s engages a barbell, sits down with a straight back into olympic snatch starting position.";
        olympicLog[2] = "Snatching a barbell above his head, %s jumps underneath it into a full deep squat.";
        olympicLog[3] = "With a barbell locked in arms above his head, %s pushes with his massive glutes and hamstrings to stand upright.";
        olympicLog[4] = "All monsters in 50 yard radius are mesmerized and cannot move or make any action for 20sec.";
        result.add(olympicLog);

        return result;
    }

    private Map<ItemSlotEnum, List<String>> initialiseLoot() {
        Map<ItemSlotEnum, List<String>> items = new HashMap<>();
        items.put(ItemSlotEnum.BELT, Arrays.asList("Vigilante belt", "Highlord Kruul's Final Curse", "Al'maiesh, the Cord of Hope"));
        items.put(ItemSlotEnum.BOOTS, Arrays.asList("Ice walkers","Aman'Thul's Stride"));
        items.put(ItemSlotEnum.CHEST, Arrays.asList("Tyrael's might", "Heart of Iron", "Cindercoat"));
        items.put(ItemSlotEnum.GLOVES, Arrays.asList("Bear claws", "Gloves of whorship"));
        items.put(ItemSlotEnum.HEAD, Arrays.asList("Bad mojo mask", "Andariel's visage", "Gaze of Justice"));
        items.put(ItemSlotEnum.NECK, Arrays.asList("Binding of the lost", "Eye of Etlich", "Hellfire amulet"));
        items.put(ItemSlotEnum.SHOULDERS, Arrays.asList("Shiny plates", "Death watch mantle"));
        items.put(ItemSlotEnum.PANTS, Arrays.asList("Hexing pants of Mr. Yan", "Death's bargain"));
        items.put(ItemSlotEnum.WEAPON, Arrays.asList("Sword of the Skeleton king", "Butcher's Carver", "Maximus"));

        return items;
    }

    public static Db getInstance() {
        return instance;
    }

    /**
     * Get random item for a slot.
     */
    public String getRandomItemForSlot(ItemSlotEnum slot) {
        final List<String> itemNames = lootDb.get(slot);
        return itemNames.get(random.nextInt(itemNames.size()));
    }

    public String[] getRandomCombatLog() {
        return combatLogDb.get(random.nextInt(combatLogDb.size()));
    }
}
