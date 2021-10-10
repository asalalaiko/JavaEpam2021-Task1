package by.asalalaiko.repo;

import by.asalalaiko.model.Transaction;
import java.util.Collection;

public interface TransactionRepository {

    Transaction getTransactionById (Integer id);
    Collection<Transaction> getAllTransaction();
    Collection<Transaction> getAllTransaction();
    void saveTransaction(Transaction transaction);



}
