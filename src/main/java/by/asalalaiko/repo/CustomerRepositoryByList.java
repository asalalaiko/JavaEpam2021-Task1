package by.asalalaiko.repo;

import by.asalalaiko.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryByList implements CustomerRepository {
    private Map<Integer, Customer> customers = new HashMap<>();


    @Override
    public void saveCustomer(Customer customer) {
        customers.put(customer.getId(), customer);


    }
}
