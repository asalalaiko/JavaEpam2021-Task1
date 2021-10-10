package by.asalalaiko;


import by.asalalaiko.model.Bill;
import by.asalalaiko.model.Customer;
import by.asalalaiko.model.Transaction;
import by.asalalaiko.repo.TransactionRepositoryBasedToList;
import by.asalalaiko.service.TransactionService;

import java.util.concurrent.ThreadLocalRandom;

public class Application {
    public static void main(String[] args) {
        TransactionRepositoryBasedToList repoTransaction = new TransactionRepositoryBasedToList();
        TransactionService serviceTransaction = new TransactionService(repoTransaction);




        System.out.println("Hello java!");

        Customer cs = new Customer();
        cs.setId(1);
        cs.setFirstName("Ivan");
        cs.setLastName("Ivanov");
        //save
        cs.prt();

        for (int i=0; i<=9; i++)  {
            Bill b = new Bill();
            b.setId(i);
            b.setCustomer(cs);
            b.setBlocked(ThreadLocalRandom.current().nextBoolean());
            //save
            b.prt();
            for (int j=0; j<=9; j++){
                Transaction tr = new Transaction();
                tr.setId(i*10+j);
                tr.setBill(b);
                tr.setSum(ThreadLocalRandom.current().nextInt(-1000, 1000));
                serviceTransaction.saveTransaction(tr);
            //save
                tr.prt();
            }
        }



        System.out.println("==============================================");

        System.out.println("Sum Tr 50 --> "+serviceTransaction.getTransaction(50).getSum());


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
