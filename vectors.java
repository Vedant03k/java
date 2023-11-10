//Vectors in Java

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;



public class vectors {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("This for the Implementing the vectors");

        //This is the Logic for the ArrayList
        int size = 1000000;
        List<Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Added " + size + " elements to ArrayList:" + (end - start) + "ms");

        //This is the Logic for the Vectors
        List<Integer> vector = new Vector<>();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            vector.add(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("Added " + size + " elements to Vector:" + (end1 - start1) + "ms");


        List<Integer> multithreadedList = Collections.synchronizedList(new ArrayList<>());//This is actually helpful for doing Multithreaded Programing with the Threads
        start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedList.add(i);
            }
        });

        //start= System.currentTimeMillis();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedList.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();
        System.out.println("Added elements in a Multithreaded way to ArrayList:" + (end - start) + "ms");
        System.out.println("Size is:"+multithreadedList.size());

        List<Integer> multithreadedVector = new Vector<>();
        start = System.currentTimeMillis();
        t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedVector.add(i);
            }
        });


        t2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedVector.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();
        System.out.println("Added elements in a Multithreaded way to Vector:" + (end - start) + "ms");
        System.out.println("Size is:"+multithreadedVector.size());


        //System.out.println("Added elements in a Multithreaded way to Vector:"+(end-start)+"ms");
    }
}
 
