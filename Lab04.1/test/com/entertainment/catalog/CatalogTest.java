/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    @Test
    public void testRemoveDuplicates() {
        Collection<Television> inventory = Catalog.getInventory();
        Set<Television> uniqueInventory = new HashSet<>(inventory);

        assertTrue(uniqueInventory.size() < inventory.size());
        assertEquals(23, uniqueInventory.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getInventory_shouldReturnUnmodifiableCollection() {
        Collection<Television> inventory = Catalog.getInventory();
        inventory.add(new Television("Test", 0));
    }

    @Test
    public void findByBrands_shouldReturnPopulatedMap_oneRowPerBrandPassed_severalBrands() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Zenith", "NO-MATCHES");

        assertEquals(3, tvMap.size());

        Collection<Television> sonyTvs = tvMap.get("Sony");
        assertNotNull(sonyTvs);
        assertEquals(7, sonyTvs.size());

        Collection<Television> zenithTvs = tvMap.get("Zenith");
        assertNotNull(zenithTvs);
        assertEquals(9, zenithTvs.size());

        Collection<Television> notFound = tvMap.get("NO-MATCHES");
        assertNotNull(notFound);
        assertEquals(0, notFound.size());

        for (String brand : new String[]{"Sony", "Zenith", "NO-MATCHES"}) {
            for (Television tv : tvMap.get(brand)) {
                assertEquals(brand, tv.getBrand());
            }
        }
    }

    @Test
    public void findByBrands_shouldReturnPopulatedMap_oneRowPerBrandPassed_singleBrand() {
        Map<String, Collection<Television>> singleBrandMap = Catalog.findByBrands("Sony");

        assertEquals(1, singleBrandMap.size());

        Collection<Television> sonyTvs = singleBrandMap.get("Sony");
        assertEquals(7, sonyTvs.size());

        for (Television tv : sonyTvs) {
            assertEquals("Sony", tv.getBrand());
        }
    }

    @Test
    public void findByBrand_shouldReturnCollectionWithMatchingBrand_whenBrandFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");

        assertEquals(7, tvs.size());

        for (Television tv : tvs) {
            assertEquals("Sony", tv.getBrand());
        }

    }

    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void findByBrand_shouldEmptyCollection_brandNotFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        assertNotNull(tvs);
        assertTrue(tvs.isEmpty());
    }
}