package by.asalalaiko.repo;

import by.asalalaiko.model.Bill;
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
    public Collection<Transaction> getTransactionByBill(Bill bill) {
        Collection<Transaction> returnTr = (Collection<Transaction>) new Transaction();
        for(Map.Entry<Integer, Transaction> entry: transactions.entrySet()) {
          if (entry.getValue().getBill()==bill) {returnTr.add(entry.getValue());}
        }
        return returnTr;
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactions.put(transaction.getId(), transaction);
    }

    @Override
    public Integer getSummByBill(Bill bill) {
        Integer sum=0;
        for(Map.Entry<Integer, Transaction> entry: transactions.entrySet()) {
            if (entry.getValue().getBill()==bill) {sum=sum + entry.getValue().getSum().intValue();}
        }
        return sum;
    }

    @Override
    public Integer getSummByAllBill() {
        Integer sum=0;
        for(Map.Entry<Integer, Transaction> entry: transactions.entrySet()) {
            sum=sum + entry.getValue().getSum().intValue();
        }
        return sum;
    }
}
