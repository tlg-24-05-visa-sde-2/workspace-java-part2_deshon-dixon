package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {

    private TelevisionBrandChannelComparator comparator;
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        comparator = new TelevisionBrandChannelComparator();
        tv1 = new Television();
        tv2 = new Television();
    }

    @Test
    public void testCompare_DifferentBrands() {
        tv1.setBrand("Sony");
        tv2.setBrand("LG");
        assertTrue(comparator.compare(tv1, tv2) > 0);
        assertTrue(comparator.compare(tv2, tv1) < 0);
    }

    @Test
    public void testCompare_SameBrandDifferentChannels() throws InvalidChannelException {
        tv1.setBrand("Sony");
        tv2.setBrand("Sony");
        tv1.changeChannel(5);
        tv2.changeChannel(10);
        assertTrue(comparator.compare(tv1, tv2) < 0);
        assertTrue(comparator.compare(tv2, tv1) > 0);
    }

    @Test
    public void testCompare_SameBrandSameChannel() throws InvalidChannelException {
        tv1.setBrand("Sony");
        tv2.setBrand("Sony");
        tv1.changeChannel(5);
        tv2.changeChannel(5);
        assertEquals(0, comparator.compare(tv1, tv2));
        assertEquals(0, comparator.compare(tv2, tv1));
    }
}
