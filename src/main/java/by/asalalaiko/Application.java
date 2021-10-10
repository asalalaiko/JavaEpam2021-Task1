package by.asalalaiko;


import by.asalalaiko.model.Bill;
import by.asalalaiko.model.Customer;
import by.asalalaiko.model.Transaction;
import by.asalalaiko.repo.BillRepositoryBasedToList;
import by.asalalaiko.repo.CustomerRepositoryByList;
import by.asalalaiko.repo.TransactionRepositoryBasedToList;
import by.asalalaiko.service.BillService;
import by.asalalaiko.service.CustomerService;
import by.asalalaiko.service.TransactionService;


import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Salalaiko Alex
 * @my.task 1. Счета.
 *  Клиент может иметь несколько счетов в банке.
 *  Учитывать возможность блокировки\разблокировки счета.
 *  Реализовать поиск и сортировку счетов.
 *  Вычисление общей суммы по счетам.
 *  Вычисление суммы по всем счетам,
 *  имеющим положительный и отрицательный балансы отдельно.
 * @since 11.10.21
 */


public class Application {
    public static void main(String[] args) {
        TransactionRepositoryBasedToList repoTransaction = new TransactionRepositoryBasedToList();
        BillRepositoryBasedToList repoBill = new BillRepositoryBasedToList();
        CustomerRepositoryByList repoCustomer = new CustomerRepositoryByList();

        TransactionService serviceTransaction = new TransactionService(repoTransaction);
        BillService serviceBill = new BillService(repoBill);
        CustomerService serviceCustomer = new CustomerService(repoCustomer);





        System.out.println("Hello java!");

        Customer cs = new Customer();
        cs.setId(1);
        cs.setFirstName("Ivan");
        cs.setLastName("Ivanov");
        serviceCustomer.saveCustomer(cs);
        //
        cs.prt();

        for (int i=0; i<=2; i++)  {
            Bill b = new Bill();
            b.setId(i);
            b.setCustomer(cs);
            b.setBlocked(ThreadLocalRandom.current().nextBoolean());
            serviceBill.saveBill(b);
            //
            b.prt();
            for (int j=0; j<=3; j++){
                Transaction tr = new Transaction();
                tr.setId(i*10+j);
                tr.setBill(b);
                tr.setSum(ThreadLocalRandom.current().nextInt(-1000, 1000));
                serviceTransaction.saveTransaction(tr);
            //
                tr.prt();
            }
        }



        System.out.println("==============================================");
        System.out.println("Sum Transaction 3 --> "+ serviceTransaction.getTransaction(3).getSum());

        System.out.println("==============================================");
        Bill bill = new Bill();
        bill = serviceBill.getBill(2);
        System.out.println("Sum by Bill  2 --> "+ serviceTransaction.getSumByBill(bill));

        System.out.println("==============================================");
        System.out.println("Sum by All Bills  --> "+ serviceTransaction.getSumByAllBill());



//        serviceTransaction.prTrToBill(bill);



    }

}
