package by.asalalaiko.service;

import by.asalalaiko.model.Bill;
import by.asalalaiko.model.Transaction;
import by.asalalaiko.repo.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class TransactionService {
    private TransactionRepository repo;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    public TransactionService(TransactionRepository repo){
        this.repo = repo;
    }

    public Transaction getTransaction(Integer id){
        Transaction transaction = repo.getTransactionById(id);
        LOGGER.info("SERVICE: Transaction with id {} retrieved value {}", id, transaction);
        return transaction;
    }

    public Collection<Transaction> getTransactions(){

        return  repo.getAllTransaction();
    }

    public void saveTransaction(Transaction transaction){
        repo.saveTransaction(transaction);
    }

    public Integer getSumByBill(Bill bill){return repo.getSummByBill(bill);}

    public  Integer getSumByAllBill(){ return repo.getSummByAllBill();}

/*
    public  void  prTrToBill(Bill bill)
    {

        System.out.println(repo.getTransactionByBill(bill).size());

    }
*/
}
