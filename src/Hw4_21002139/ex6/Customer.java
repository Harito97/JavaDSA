package Hw4_21002139.ex6;

public class Customer {
    //private int serviceCode;
    private long timeCome;
    private long timeGetInTransaction;
    private long timeDone;

    public Customer(int serviceCode) {
        //this.serviceCode = serviceCode;
        this.timeCome = System.nanoTime();
    }

    public void getCustomerToTransaction() {
        this.timeGetInTransaction = System.nanoTime();
    }

    public void getDone() {
        this.timeDone = System.nanoTime();
    }

    public long getTimeWaitToComeTransaction() {
        return timeGetInTransaction - timeCome;
    }

    public long getTimeBeServicedInTransaction() {
        return timeDone - timeGetInTransaction;
    }

    // public int getServiceCode() {
    //     return serviceCode;
    // }

    // public long getTimeCome() {
    //     return timeCome;
    // }

    // public long getTimeGetInTransaction() {
    //     return timeGetInTransaction;
    // }

    // public long getTimeDone() {
    //     return timeDone;
    // }
}
