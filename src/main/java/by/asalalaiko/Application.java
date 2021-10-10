package by.asalalaiko;


import by.asalalaiko.model.Bill;
import by.asalalaiko.model.Customer;
import by.asalalaiko.model.Transaction;
import by.asalalaiko.repo.BillRepositoryBasedToList;
import by.asalalaiko.repo.TransactionRepositoryBasedToList;
import by.asalalaiko.service.BillService;
import by.asalalaiko.service.TransactionService;

import java.util.concurrent.ThreadLocalRandom;

public class Application {
    public static void main(String[] args) {
        TransactionRepositoryBasedToList repoTransaction = new TransactionRepositoryBasedToList();
        BillRepositoryBasedToList repoBill = new BillRepositoryBasedToList();

        TransactionService serviceTransaction = new TransactionService(repoTransaction);
        BillService serviceBill = new BillService(repoBill);




        System.out.println("Hello java!");

        Customer cs = new Customer();
        cs.setId(1);
        cs.setFirstName("Ivan");
        cs.setLastName("Ivanov");
        //save
        cs.prt();

        for (int i=0; i<=2; i++)  {
            Bill b = new Bill();
            b.setId(i);
            b.setCustomer(cs);
            b.setBlocked(ThreadLocalRandom.current().nextBoolean());
            serviceBill.saveBill(b);
            //save
            b.prt();
            for (int j=0; j<=5; j++){
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
        System.out.println("Sum Tr 5 --> "+serviceTransaction.getTransaction(5).getSum());

        System.out.println("==============================================");
        Bill bill = new Bill();
        bill.setId(2);
        serviceTransaction.prTrToBill(bill);



/*
        ListBasedUserRepository repo = new ListBasedUserRepository();
        UserService underTest = new UserService(repo);
        User user = new User();
        user.setId(1);
        user.setFirstName("Maxim");
        user.setLastName("Naumovich");

 */






    }

}
