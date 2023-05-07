package Hw6_21002139_PhamNgocHai.ex5;

import java.util.Random;

import Hw6_21002139_PhamNgocHai.ex1.Entry;
import Hw6_21002139_PhamNgocHai.ex1.ex1_4.SortedLinkedPriorityQueue;

public class SimulationAirTrafficControlSystem {

    private static SortedLinkedPriorityQueue<Long, Byte> system = new SortedLinkedPriorityQueue<>();
    private static long[] eventTime = new long[100];
    private static byte[] eventType = new byte[100];
    private static int i = 0;
    private static long start = System.nanoTime();
    private static long end = start + 30 * 1000 * 1000 * 1000; // run in 30s

    public static void main(String[] args) {
        generateData();
        MyRunnableOne r1 = new MyRunnableOne();
        MyRunnableTwo r2 = new MyRunnableTwo();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }

    static class MyRunnableOne implements Runnable {
        public void run() {
            while (i < 100) {
                try {
                    synchronized (system) {
                        addEvent(eventTime[i], eventType[i]);
                        ++i;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyRunnableTwo implements Runnable {
        public void run() {
            while (System.nanoTime() < end) {
                try {
                    synchronized (system) {
                        extractEvent();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static synchronized void addEvent(long timeStamp, byte type) {
        if (timeStamp < System.nanoTime()) {
            System.out.println("Event can't acceptable!");
            return;
        }
        system.insert(timeStamp, type);
        System.out.print("Added event has time: " + timeStamp + "ns. ");
        String typeEvent = type == 48 ? "landings" : "takeoffs";
        System.out.println("And it is " + typeEvent);
    }

    private static synchronized void extractEvent() {
        Entry<Long, Byte> nextEvent = system.removeMin();
        if (nextEvent == null)
            return;
        System.out.print("Next event has time: " + nextEvent.getKey() + "ns. ");
        String typeEvent = nextEvent.getValue() == 48 ? "landings" : "takeoffs";
        System.out.println("And it is " + typeEvent);
    }

    private static void generateData() {
        Random random = new Random(97);
        for (int i = 0; i < 100; i++) {
            eventTime[i] = random.nextLong(System.nanoTime(), System.nanoTime() + 1000000000);
            eventType[i] = (byte) (48 + random.nextInt(2));
        }
    }

}
