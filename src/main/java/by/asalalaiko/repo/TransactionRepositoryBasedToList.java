package by.asalalaiko.repo;

import by.asalalaiko.model.Bill;
import by.asalalaiko.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TransactionRepositoryBasedToList implements TransactionRepository {

    private Map<Integer, Transaction> transactions = new HashMap<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionRepositoryBasedToList.class);

    @Override
    public Transaction getTransactionById(Integer id) {
        LOGGER.debug("REPOSITORY: Transaction with id {} getOperation", id);
        Transaction transaction = transactions.get(id);
        if (transaction == null) {
            LOGGER.warn("REPOSITORY: Transaction with id {} not found", id);
            return null;
        }
        LOGGER.info("REPOSITORY: Transaction with id {} retrieved value {}", id, transaction);
        return transaction;
    }

    @Override
    public Collection<Transaction> getAllTransaction() {
        LOGGER.info("REPOSITORY: Get Transaction  value {}", transactions);
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
        LOGGER.debug("REPOSITORY: Save Transaction ", transaction);
        transactions.put(transaction.getId(), transaction);
        LOGGER.info("REPOSITORY: Save Transaction", transaction.getId());
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
