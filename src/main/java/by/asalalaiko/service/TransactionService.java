package by.asalalaiko.service;

import by.asalalaiko.model.Bill;
import by.asalalaiko.model.Transaction;
import by.asalalaiko.repo.TransactionRepository;

import java.util.Collection;

public class TransactionService {
    private TransactionRepository repo;

    public TransactionService(TransactionRepository repo){
        this.repo = repo;
    }

    public Transaction getTransaction(Integer id){
        Transaction transaction = repo.getTransactionById(id);
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
