/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
//         testFindById();
//         testFindByKeyword();
//         testFindByCategory();
//         testSize();
//         testGetAll();
//         testFindBySelfTitle();
//         testFindRockLessThan();
//         testGenreCount();
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem item = catalog.findById(6L);
        System.out.println(item);

        MusicItem notFound = catalog.findById(66L);
        System.out.println(notFound);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> items = catalog.findByKeyword("Diva");
        dump(items);
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        dump(items);
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        int items = catalog.size();
        System.out.println(items);
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> items = catalog.getAll();
        dump(items);
    }

    private static void testFindBySelfTitle() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> items = catalog.findBySelfTitle();
        dump(items);
    }

    private static void testFindRockLessThan() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> items = catalog.findRockLessThan(12.00);
        dump(items);
    }

    private static void testGenreCount() {
        InMemoryCatalog catalog = new InMemoryCatalog();
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