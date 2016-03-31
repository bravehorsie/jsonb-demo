package com.oracle.jsonbdemo.adapters;

import com.oracle.jsonbdemo.model.Item;
import com.oracle.jsonbdemo.model.ItemSlot;
import com.oracle.jsonbdemo.model.ItemSlotEnum;

import javax.json.bind.adapter.JsonbAdapter;
import java.util.HashMap;
import java.util.Map;

/**
 * Adapts a map with object keys to map with string keys.
 *
 * @author Roman Grigoriadi
 */
public class ItemsAdapter implements JsonbAdapter<Map<ItemSlot, Item>, Map<String, Item>> {

    @Override
    public Map<String, Item> adaptToJson(Map<ItemSlot, Item> obj) throws Exception {
        final Map<String, Item> result = new HashMap<>();
        for (Map.Entry<ItemSlot, Item> entry : obj.entrySet()) {
            //convert ItemSlot object key to string key
            result.put(entry.getKey().getName(), entry.getValue());
        }
        return result;
    }

    @Override
    public Map<ItemSlot, Item> adaptFromJson(Map<String, Item> obj) throws Exception {
        final Map<ItemSlot, Item> result = new HashMap<>();
        for (Map.Entry<String, Item> entry : obj.entrySet()) {
            //find enum by string key
            ItemSlotEnum slotEnum = ItemSlotEnum.valueOf(entry.getKey());
            //create and put object ItemSlot as a key
            result.put(new ItemSlot(slotEnum.getId(), slotEnum.name()), entry.getValue());
        }
        return result;
    }
}
