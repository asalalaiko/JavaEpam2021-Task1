package by.asalalaiko.repo;

import by.asalalaiko.model.Bill;
import by.asalalaiko.model.Customer;

import java.util.Collection;

public interface BillRepository {


    Bill getBillById (Integer id);
    Collection<Bill> getAllBill();
    void saveBill(Bill bill);
    Integer getQuantityBillsByCustomer(Customer customer);


}
