package com.duckrace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class DuckRacer implements Serializable {
    // FIELDS
    private final int id;
    private final String name;
    private final Collection<Reward> rewards = new ArrayList<>();

    // CONSTRUCTORS
    public DuckRacer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // METHODS
    public void win(Reward reward) {
        rewards.add(reward);
    }

    // ACCESSOR METHODS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return rewards.size();
    }

    public Collection<Reward> getRewards() {
        return Collections.unmodifiableCollection(rewards);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": "
                + "id=" + getId()
                + ", name=" + getName()
                + ", wins=" + getWins()
                + ", rewards=" + getRewards();
    }
}