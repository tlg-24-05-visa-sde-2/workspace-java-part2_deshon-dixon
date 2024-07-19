package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionTest {
    // FIELDS
    private Television tv1;
    private Television tv2;
    private Television tv3;

    // SETUP METHODS
    @Before
    public void setUp() {
        tv1 = new Television("Sony", 50, DisplayType.PLASMA); // channel is 3
        tv2 = new Television("Sony", 50, DisplayType.PLASMA); // channel is 3
        tv3 = new Television("Samsung", 20, DisplayType.OLED);
    }

    // EQUALS TEST
    @Test
    public void testEquals_EqualObjects() {
        try {
            assertEquals(tv1, tv2);
            assertEquals(tv2, tv1);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testEquals_DifferentBrand() {
        try {
            assertNotEquals(tv1, tv3);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testEquals_DifferentVolume() {
        try {
            assertNotEquals(tv2, tv3);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testEquals_DifferentVolumeAndDisplay() {
        try {
            assertNotEquals(tv1, tv3);
            assertNotEquals(tv2, tv3);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    // HASHCODE TESTS
    @Test
    public void testHashCode() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    // CHANNEL TESTS
    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_upperBound() {
        try {
            tv1.changeChannel(1000);
            fail("Should throw InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            String expected = "Invalid channel: 1000. Allowed range: [1,999].";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() {
        try {
            tv1.changeChannel(0);
            fail("Should throw InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            String expected = "Invalid channel: 0. Allowed range: [1,999].";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws Exception {
        tv1.changeChannel(999);
        assertEquals(999, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws Exception {
        tv1.changeChannel(1);
        assertEquals(1, tv1.getCurrentChannel());
    }

    // VOLUME TESTS
    @Test
    public void setVolume_shouldStoreValue_whenValid() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
            tv1.setVolume(-1);
            fail("Expected IllegalArgumentException was not thrown");
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        tv1.setVolume(Television.MAX_VOLUME);
        assertEquals(Television.MAX_VOLUME, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv1.setVolume(Television.MIN_VOLUME);
        assertEquals(Television.MIN_VOLUME, tv1.getVolume());
    }
}