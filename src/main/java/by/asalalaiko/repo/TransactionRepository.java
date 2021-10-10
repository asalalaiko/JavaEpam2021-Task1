package by.asalalaiko.repo;

import by.asalalaiko.model.Bill;
import by.asalalaiko.model.Transaction;
import java.util.Collection;

public interface TransactionRepository {

    Transaction getTransactionById (Integer id);
    Collection<Transaction> getAllTransaction();
    Collection<Transaction> getTransactionByBill(Bill bill);
    void saveTransaction(Transaction transaction);
    Integer getSummByBill(Bill bill);
    Integer getSummByAllBill();



}
