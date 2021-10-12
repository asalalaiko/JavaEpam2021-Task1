package by.asalalaiko.repo;

import by.asalalaiko.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryEntityMap implements CustomerRepository {
    private Map<Integer, Customer> customers = new HashMap<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRepositoryEntityMap.class);


    @Override
    public void saveCustomer(Customer customer) {
        LOGGER.debug("REPOSITORY: Save Customer ", customer);
        customers.put(customer.getId(), customer);
        LOGGER.info("REPOSITORY: Save Customer", customer.getId());


    }
}
