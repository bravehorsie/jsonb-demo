package com.oracle.jsonbdemo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Grigoriadi
 */
public class CombatLog {

    private List<String> messages = new ArrayList<>();

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
