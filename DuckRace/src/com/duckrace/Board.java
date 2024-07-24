package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    /*
     * Updates the board (racerMap) by making a DuckRacer win.
     *
     * This could mean fetching an existing DuckRacer from racerMap,
     * or we might need to create a new DuckRacer(), put() it in the map,
     * and then make it win().
     *
     * Either way, it needs to win().
     */
    public void update(int id, Reward reward) {
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) {
            racer = racerMap.get(id);

        } else {
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        racer.win(reward);
    }

    /*
     * TODO: render the data as we see it in the "real" application
     */
    public void show() {
        // if (racerMap.isEmpty())
        //        there are currently no results to show
        // else
        //    do the work below
        Collection<DuckRacer> racers = racerMap.values();

        String header = """
            
            Duck Race Results
            =================
            
            id    name      wins     rewards
            --    ----      ----     -------""";
        System.out.println(header);

            for (DuckRacer racer : racers) {
                System.out.println(racer.getId() + "     " + racer.getName() + "     " + racer.getWins() + "       " + racer.getRewards());
            }
    }

    // FOR TESTING ONLY
    void dumpStudentIdMap() {
        Collection<Integer> studentIds = studentIdMap.keySet();

        for (Integer studentId : studentIds) {
            System.out.println(studentIdMap.get(studentId));
        }
    }

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> studentIdMap = new HashMap<>();

        // read all lines from CSV file, and process each one into an integer and a string
        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            // for each line, "split" the string into "tokens"
            for (String line : lines) {
                String[] tokens = line.split(","); // "1" and "Bullen"
                Integer studentId = Integer.valueOf(tokens[0]);
                String studentName = tokens[1];
                studentIdMap.put(studentId, studentName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentIdMap;
    }
}