package com.crisp;

import java.util.Comparator;

public class RadishGuysOnTopComparator implements Comparator<Radish> {

    public int compare(Radish r1, Radish r2) {
        return Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop());
    }

}