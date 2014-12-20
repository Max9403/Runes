package com.ers.runes.runeium;

/**
 * Created by Benjamin on 2014-12-16.
 */
public interface RuneiumStorage {
    int getStored();
    boolean charge(int amount);
    boolean discharge(int amount);
}
