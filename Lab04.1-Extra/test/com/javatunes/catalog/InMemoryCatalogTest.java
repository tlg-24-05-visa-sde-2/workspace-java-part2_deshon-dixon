package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collection;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findByCategory_shouldReturnCollectionWithThatCategory() {
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
        assertEquals(4, popItems.size());

        for (MusicItem item : popItems) {
            assertEquals(MusicCategory.POP, item.getMusicCategory());
        }
    }

    @Test
    public void findById_shouldReturnMusicItemWithThatId_idFound() {
        MusicItem item = catalog.findById(18L);

        assertNotNull(item);
        assertEquals(18L, item.getId().longValue());
    }

    @Test
    public void findById_shouldReturnNull_idNotFound() {
        MusicItem item = catalog.findById(1001L);
        assertNull(item);
    }

    @Test
    public void testFindById() {
        MusicItem item = catalog.findById(6L);
        System.out.println(item);

        MusicItem notFound = catalog.findById(66L);
        System.out.println(notFound);
    }

    @Test
    public void testFindByKeyword() {
        Collection<MusicItem> items = catalog.findByKeyword("Diva");
        dump(items);
    }

    @Test
    public void testFindByCategory() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        dump(items);
    }

    @Test
    public void testSize() {
        int items = catalog.size();
        System.out.println(items);
    }

    @Test
    public void testGetAll() {
        Collection<MusicItem> items = catalog.getAll();
        dump(items);
    }

    @Test
    public void testFindBySelfTitle() {
        Collection<MusicItem> items = catalog.findBySelfTitle();
        dump(items);
    }

    @Test
    public void testFindRockLessThan() {
        Collection<MusicItem> items = catalog.findRockLessThan(12.00);
        dump(items);
    }

    @Test
    public void testGenreCount() {
        int count = catalog.genreCount();
        System.out.println(count);
    }

    // dump dont touch
    private static void dump(Collection<MusicItem> items) {
        for (MusicItem item : items) {
            System.out.println(item);
        }
    }

}