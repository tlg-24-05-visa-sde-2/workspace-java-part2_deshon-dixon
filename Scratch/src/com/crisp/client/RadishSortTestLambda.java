package com.crisp.client;

import com.crisp.Radish;
import com.crisp.RadishColorComparator;
import com.crisp.RadishGuysOnTopComparator;

import java.util.ArrayList;
import java.util.List;

class RadishSortTestLambda {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<Radish>();

        radishes.add(new Radish("red", 2.75, 0.0, 7));
        radishes.add(new Radish("pink", 1.1, 2.1, 2));
        radishes.add(new Radish("red", 0.7, 3.3, 0));
        radishes.add(new Radish("black", 1.9, 0.0, 0));

        System.out.println("Original list:");
        dump(radishes);
        System.out.println();

        System.out.println("Sort by natural order (size)");
        radishes.sort(null);  // null means natural order
        dump(radishes);
        System.out.println();

        System.out.println("Sort by guysOnTop, via Comparator");
        radishes.sort( (r1, r2) -> Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop()));
        dump(radishes);
        System.out.println();

        System.out.println("Sort by color, via Comparator");
        radishes.sort( (r1, r2) -> r1.getColor().compareTo(r2.getColor()));
        dump(radishes);
        System.out.println();

        System.out.println("Sort by tailLength, via lambda for the Comparator");
        radishes.sort( (r1, r2) -> Double.compare(r2.getTailLength(), r1.getTailLength()));
        dump(radishes);
        System.out.println();
    }

    private static void dump(List<Radish> radishList) {
        for (Radish radish : radishList) {
            System.out.println(radish);
        }
    }

}