package by.asalalaiko.repo;

import by.asalalaiko.model.Bill;
import by.asalalaiko.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BillRepositoryEntityMap implements BillRepository {

    private Map<Integer, Bill> bills = new HashMap<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(BillRepositoryEntityMap.class);

    @Override
    public Bill getBillById(Integer id) {
        LOGGER.debug("REPOSITORY: Bill with id {} getOperation", id);
        Bill bill = bills.get(id);
        if (bill == null) {
            LOGGER.warn("REPOSITORY: Bill with id {} not found", id);
            return null;
        }
        LOGGER.info("REPOSITORY: Bill with id {} retrieved value {}", id, bill);
        return bill;
    }

    @Override
    public Collection<Bill> getAllBill() {
        LOGGER.info("REPOSITORY: Get Bills  value {}", bills);
        return bills.values();
    }

    @Override
    public void saveBill(Bill bill) {
        LOGGER.debug("REPOSITORY: Save Bill ", bill);
        bills.put(bill.getId(), bill);
        LOGGER.info("REPOSITORY: Save Bill", bill.getId());
    }

    @Override
    public Integer getQuantityBillsByCustomer(Customer customer) {
        LOGGER.debug("REPOSITORY: Get Quantity Bills By Customer:", customer);
        Integer q = 0;
        if  (customer == null) {
            LOGGER.warn("REPOSITORY: Get Quantity Bills By Customer NULL", customer.getId());
            return null;
        }
        for(Map.Entry<Integer, Bill> entry: bills.entrySet()) {
                if (entry.getValue().getCustomer().equals(customer)) {q++;}
        }
        LOGGER.info("REPOSITORY: Get Quantity Bills By Customer value {}", q);
        return q;
    }
}

