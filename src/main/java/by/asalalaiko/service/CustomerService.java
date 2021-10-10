package by.asalalaiko.service;

import by.asalalaiko.model.Customer;
import by.asalalaiko.repo.CustomerRepository;

public class CustomerService {
    private CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }


    public void saveCustomer(Customer customer){
        repo.saveCustomer(customer);
    }
}
