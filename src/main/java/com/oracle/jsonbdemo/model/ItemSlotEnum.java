package com.oracle.jsonbdemo.model;

/**
 * Slot to equip item in.
 *
 * @author Roman Grigoriadi
 */
public enum ItemSlotEnum {
    WEAPON(10L),
    HEAD(20L),
    SHOULDERS(30L),
    GLOVES(40L),
    NECK(50L),
    CHEST(60L),
    BELT(70L),
    PANTS(80L),
    BOOTS(90L);

    ItemSlotEnum(Long id) {
        this.id = id;
    }

    private final Long id;

    public Long getId() {
        return id;
    }

    public static ItemSlotEnum findById(Long id) {
        for (ItemSlotEnum slotEnum : values()) {
            if (slotEnum.id.equals(id)) {
                return slotEnum;
            }
        }
        throw new IllegalStateException("Item slot ID " + id + " not found!");
    }

}
