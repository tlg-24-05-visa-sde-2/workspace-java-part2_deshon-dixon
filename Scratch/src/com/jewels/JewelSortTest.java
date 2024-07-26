package com.jewels;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class JewelSortTest {

    public static void main(String[] args) {
        List<String> jewels = new ArrayList<>();
        jewels.add("opal");
        jewels.add("emerald");
        jewels.add("onyx");
        jewels.add("sapphire");
        jewels.add("diamond");
        jewels.add("malachite");

        jewels.sort(null);
        dump(jewels);
        System.out.println();

        jewels.sort((jewel1, jewel2) -> Integer.compare(jewel1.length(), jewel2.length()));
        dump(jewels);
        System.out.println();
    }

    private static void dump(List<String> jewelsList) {
        for (String jewel : jewelsList) {
            System.out.println(jewel);
        }
    }

}