package by.asalalaiko.service;

import by.asalalaiko.model.Customer;
import by.asalalaiko.repo.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;

public class CustomerServiceTest {

    private static CustomerService underTest;
    public static CustomerRepository repoMock;

    @BeforeAll
    public static void init(){
        repoMock = Mockito.mock(CustomerRepository.class);
        underTest = new CustomerService(repoMock);
    }

    @AfterEach
    public  void resetMock(){
        Mockito.reset(repoMock);
    }

    @Test
    public void testBillSave() {
        //GIVEN
        Customer source = new Customer();

        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);

        doNothing().when(repoMock).saveCustomer(captor.capture());


        //WHEN
        underTest.saveCustomer(source);

        //THEN
        Assertions.assertEquals(source, captor.getValue());
    }

}
