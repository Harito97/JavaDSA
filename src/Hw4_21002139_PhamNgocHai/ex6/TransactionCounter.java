package Hw4_21002139_PhamNgocHai.ex6;

import java.util.LinkedList;

public class TransactionCounter {
    private Customer beingServedCustomer;
    private LinkedList<Customer> servicedCustomer = new LinkedList<>();

    public int numberOfCustomerServiced() {
        return servicedCustomer.size();
    }

    public long averageTimeService() {
        if (servicedCustomer == null || servicedCustomer.size() == 0) {
            return 0;
        }
        long averageTimeService = 0;
        for (int i = 0; i < servicedCustomer.size(); i++) {
            averageTimeService += servicedCustomer.get(i).getTimeBeServicedInTransaction();
        }
        return averageTimeService / servicedCustomer.size() / 1000000;
    }

    public void getDoneACustomer() {
        // Neu ban dau chua co khach de phuc vu thi nhan khach
        if (beingServedCustomer == null) {
            Customer temp = SystemService.getCustomers().poll();
            if (temp == null) {
                return;
            }
            beingServedCustomer = temp;
            beingServedCustomer.getCustomerToTransaction();
            return;
        }
        
        servicedCustomer.add(beingServedCustomer);
        beingServedCustomer.getDone();

        beingServedCustomer = SystemService.getCustomers().poll();
        if (beingServedCustomer == null)
            return;
        beingServedCustomer.getCustomerToTransaction();
    }

    public String toStringInformation() {
        return "    Number Of Customer Serviced = " + numberOfCustomerServiced() + "\n    Average Time Service = "
                + averageTimeService() + "ms\n"; 
    }
}
