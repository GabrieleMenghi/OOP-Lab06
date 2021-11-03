package it.unibo.oop.lab.collections1;

import java.util.*;


/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	private static final int FIRSTINDEX = 0;
	private static final int SUB = 1;
	private static final int ELEM = 100_000;
	private static final int CONV = 1_000_000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final List<Integer> list = new ArrayList<>();
    	for(int i = 1000; i < 2000; i++) {
    		list.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final List<Integer> llist = new LinkedList<>(List.copyOf(list));
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int newFirst = list.get(list.size()-SUB);
    	int newLast = list.get(FIRSTINDEX);
    	list.set(FIRSTINDEX, newFirst);
    	list.set(list.size()-SUB, newLast);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for(int i : list) {
    		System.out.print(i + " ");
    	}
    	System.out.println();
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime();
    	for(int i = 0; i < ELEM; i++) {
    		list.add(FIRSTINDEX, (int)Math.random());
    	}
    	time = System.nanoTime() - time;
    	
    	long time1 = System.nanoTime();
    	for(int j = 0; j < ELEM; j++) {
    		llist.add(FIRSTINDEX, (int)Math.random());
    	}
    	time1 = System.nanoTime() - time1;
    	
    	System.out.println("Tempo per aggiunta di 100.000 elementi in ArrayList : " + time / CONV + " ms ");
    	System.out.println("Tempo per aggiunta di 100.000 elementi in LinkedList : " + time1 / CONV + " ms ");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	long time2 = System.nanoTime();
    	for(int i = 0; i < 1000; i++) {
    		list.get((list.size() - SUB) / 2);
    	}
    	time2 = System.nanoTime() - time2;
    	
    	long time3 = System.nanoTime();
    	for(int j = 0; j < 1000; j++) {
    		llist.get((llist.size() - SUB) / 2);
    	}
    	time3 = System.nanoTime() - time3;
    	
    	System.out.println("Tempo per lettura di un elemento al centro da ArrayList 1.000 volte : " + time2 / 1000 + " mics ");
    	System.out.println("Tempo per lettura di un elemento al centro della LinkedList 1.000 volte : " + time3 / 1000 + " mics ");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	final Map<String, Long> continents = new TreeMap<>();
    	continents.put("Africa", 1_110_635_000L);
    	continents.put("Americas", 972_005_000L);
    	continents.put("Antarctica", 0L);
    	continents.put("Asia", 4_298_723_000L);
    	continents.put("Europe", 742_452_000L);
    	continents.put("Oceania", 38_304_000L);
    	
    	System.out.println(continents);
        /*
         * 8) Compute the population of the world
         */
    	long totPopulation = 0;
    	for(final long popul : continents.values()) {
    		totPopulation += popul;
    	}
    	System.out.println(totPopulation);
    	
    }
}
