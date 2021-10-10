package by.asalalaiko.repo;

import by.asalalaiko.model.Bill;

import java.util.Collection;

public interface BillRepository {


    Bill getBillById (Integer id);
    Collection<Bill> getAllBill();
    // Collection<Bill> getTransactionByCustomer(Customer customer);
    void saveBill(Bill bill);

}
