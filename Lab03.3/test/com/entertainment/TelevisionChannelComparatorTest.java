package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private TelevisionChannelComparator comparator;

    @Before
    public void setUp() {
        tv1 = new Television();
        tv2 = new Television();
        comparator = new TelevisionChannelComparator();
    }

    @Test
    public void testCompare_DifferentChannels() throws InvalidChannelException {
        tv1.changeChannel(5);
        tv2.changeChannel(10);
        assertTrue(comparator.compare(tv1, tv2) < 0);
        assertTrue(comparator.compare(tv2, tv1) > 0);
    }

    @Test
    public void testCompare_SameChannel() throws InvalidChannelException {
        tv1.changeChannel(5);
        tv2.changeChannel(5);
        assertEquals(0, comparator.compare(tv1, tv2));
        assertEquals(0, comparator.compare(tv2, tv1));
    }
}