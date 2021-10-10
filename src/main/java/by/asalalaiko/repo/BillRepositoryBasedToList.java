package by.asalalaiko.repo;

import by.asalalaiko.model.Bill;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BillRepositoryBasedToList implements BillRepository {

    private Map<Integer, Bill> bills = new HashMap<>();

    @Override
    public Bill getBillById(Integer id) {
        Bill bill = bills.get(id);
        if (bill == null) {
            return null;
        }
        return bill;
    }

    @Override
    public Collection<Bill> getAllBill() {
        return bills.values();
    }

    @Override
    public void saveBill(Bill bill) {
        bills.put(bill.getId(),bill);

    }
}

