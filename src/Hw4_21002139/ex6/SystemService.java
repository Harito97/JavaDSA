package Hw4_21002139.ex6;

// import java.util.concurrent.Executors;
// import java.util.concurrent.ScheduledExecutorService;
// import java.util.concurrent.TimeUnit;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SystemService {
    private static int numberOfCustomerComeToSystemService;
    private static Random random = new Random();
    private static Queue<Customer> customers = new LinkedList<>();
    private static int numberTransaction = random.nextInt(10) + 1; // create random number transaction from 1 to 10
    private static TransactionCounter[] transactionCounters = new TransactionCounter[numberTransaction];
    private static Object lock = new Object(); // object for synchronization

    private static boolean flag = true;
    private static long start = System.currentTimeMillis();
    private static long end = start + 15; // 1 giây * 1000 ms/giây

    public static Queue<Customer> getCustomers() {
        return customers;
    }

    public static void main(String[] args) {
        for (int i = 0; i < numberTransaction; i++) {
            transactionCounters[i] = new TransactionCounter();
        }
        // Thúc thi 1 ngay phúc vu (gia su chi diên ra trong 180s)
        System.out.println("Thoi gian SystemService phúc vu la: 180s");
        System.out.println("Hay ngoi doi 180s de chung toi thu tháp dược du lieu thong ke :)\n");

        // Tao ra 1 luồng chay chương trinh

        while (flag) {
            if (System.currentTimeMillis() > end) {
                flag = false;
            }
            // Một số hoạt động tốn kém trên mục.
            MyRunnableOne r1 = new MyRunnableOne("Khách den SystemService de dược phúc vu");
            MyRunnableTwo r2 = new MyRunnableTwo("Qua trinh phúc vu trong SystemService");

            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r2);
            t1.start();
            t2.start();
        }

        System.out.println();
        statisticalData();
        System.exit(0);
    }

    static void statisticalData() {
        System.out.println("So khách den SystemService la: " + numberOfCustomerComeToSystemService);
        System.out.println(
                "So khách da dược phúc vu la: " + (numberOfCustomerComeToSystemService - customers.size()) + "\n");
        for (int i = 0; i < transactionCounters.length; i++) {
            System.out.println("Information of transaction counter " + i + " is: ");
            System.out.println(transactionCounters[i].toStringInformation());
        }
    }

    static class MyRunnableOne implements Runnable {
        // Luồng 1 lam việc ngau nhiên them 1 khách vao danh sách khách den
        // SystemService cho  phúc vu
        //private String name;

        public MyRunnableOne(String name) {
            //this.name = name;
        }

        public void run() {
            while (flag) {
                try {
                    synchronized (lock) {
                        ++numberOfCustomerComeToSystemService;
                        customers.add(new Customer(numberOfCustomerComeToSystemService));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (System.currentTimeMillis() > end) {
                flag = false;
            }
        }
    }

    static class MyRunnableTwo implements Runnable {
        // Luồng 2 lam cac cong việc phúc vu khách trong SystemService
        //private String name;

        public MyRunnableTwo(String name) {
            //this.name = name;
        }

        public void run() {
            while (flag) {
                try {
                    synchronized (lock) {
                        transactionCounters[random.nextInt(numberTransaction)].getDoneACustomer();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (System.currentTimeMillis() > end) {
                flag = false;
            }
        }
    }
}
