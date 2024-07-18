package com.entertainment.client;

import com.entertainment.Television;
import com.entertainment.TelevisionChannelComparator;

import java.util.ArrayList;
import java.util.List;

class TelevisionTestSort {

    public static void main(String[] args) {
        List<Television> tv = new ArrayList<Television>();

        tv.add(new Television("Sony", 50));
        tv.add(new Television("Sony", 32));
        tv.add(new Television("Zenith", 30));
        tv.add(new Television("Zenith", 92));
        tv.add(new Television("Hitachi", 40));
        tv.add(new Television("Hitachi", 32));
        tv.add(new Television("Panasonic", 20));
        tv.add(new Television("Panasonic", 200));

        tv.get(0).changeChannel(20);
        tv.get(1).changeChannel(65);
        tv.get(2).changeChannel(44);
        tv.get(3).changeChannel(10);
        tv.get(4).changeChannel(15);
        tv.get(5).changeChannel(123);
        tv.get(6).changeChannel(1);
        tv.get(7).changeChannel(300);

        System.out.println();
        System.out.println("Sorting by natural order (brand)");
        tv.sort(null);
        dump(tv);
        System.out.println();

        System.out.println("Sort by channel");
        tv.sort(new TelevisionChannelComparator());
        dump(tv);
        System.out.println();

        System.out.println("Sort by brand or channel");
        tv.sort(new TelevisionChannelComparator());
        dump(tv);
        System.out.println();

    }

    private static void dump(List<Television> tvList) {
        for (Television tv : tvList) {
            System.out.println(tv);
        }
    }
}