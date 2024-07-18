package com.entertainment;

import java.util.Objects;

/*
 * Natural order is defined by 'brand' (String).
 *
 * To be "consistent with equals, " whatever fields are used for "equals"
 * MUST ALSO BE USED FOR "compareTo".
 */

public class Television implements Comparable<Television> {

    // FIELDS
    private String brand;
    private int volume;

    private final Tuner tuner = new Tuner();

    // METHODS
    public Television() {
    }

    public Television(String brand, int volume) {
        this.brand = brand;
        this.volume = volume;
    }

    // ACCESSOR METHODS
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel); // delegate to contained Tuner object
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Television that = (Television) obj;
        return this.getVolume() == that.getVolume() && Objects.equals(getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }

    /*
     * Natural order is defined by 'brand' (String), and secondarily by 'volume' (int)
     * when tied on brand
     */
    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());
        if (result == 0) {
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " [brand=" + getBrand()
                + ", volume=" + getVolume()
                + ", currentChannel="
                + getCurrentChannel() + "]";
    }
}