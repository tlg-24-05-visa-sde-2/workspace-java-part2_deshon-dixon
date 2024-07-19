package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv1;
    private Television tv2;
    private Television tv3;


    @Before
    public void setUp() {
        tv1 = new Television("Samsung", 50, DisplayType.LED);
        tv2 = new Television("Samsung", 50, DisplayType.LED);
        tv3 = new Television("LG", 60, DisplayType.OLED);
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv1.setVolume(Television.MIN_VOLUME);
        assertEquals(Television.MIN_VOLUME, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        tv1.setVolume(Television.MAX_VOLUME);
        assertEquals(Television.MAX_VOLUME, tv1.getVolume());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws Exception {
        tv1.changeChannel(1);
        assertEquals(1, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws Exception {
        tv1.changeChannel(999);
        assertEquals(999, tv1.getCurrentChannel());
    }

    @Test
    public void testEquals() {
        assertEquals(tv1, tv1);
        assertEquals(tv1, tv2);
        assertNotEquals(tv1, tv3);
        assertNotEquals(tv2, tv3);
    }

    @Test
    public void testHashCode() {
        assertEquals(tv1.hashCode(), tv1.hashCode());
    }
}