package by.asalalaiko.repo;

import by.asalalaiko.model.Transaction;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TransactionRepositoryBasedToList implements TransactionRepository {

    private Map<Integer, Transaction> transactions = new HashMap<>();

    @Override
    public Transaction getTransactionById(Integer id) {
        Transaction transaction = transactions.get(id);
        if (transaction == null) {
            return null;
        }
        return transaction;
    }

    @Override
    public Collection<Transaction> getAllTransaction() {
        return transactions.values();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactions.put(transaction.getId(), transaction);
    }
}
