package com.duckrace.client;

import com.duckrace.DuckRacer;
import com.duckrace.Reward;

import java.util.Collection;

class DuckRacerClient {

    public static void main(String[] args) {
        DuckRacer duckRacer = new DuckRacer(4, "DeShon");

        System.out.println(duckRacer);
        System.out.println();

        duckRacer.win(Reward.PRIZES);
        duckRacer.win(Reward.PRIZES);
        duckRacer.win(Reward.DEBIT_CARD);

        Collection<Reward> rewards = duckRacer.getRewards();
        System.out.println(rewards);

        duckRacer.win(Reward.DEBIT_CARD);
        System.out.println(rewards);

    }
}