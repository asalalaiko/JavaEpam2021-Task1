package by.asalalaiko.Service;

import by.asalalaiko.model.Transaction;
import by.asalalaiko.repo.TransactionRepository;
import by.asalalaiko.service.TransactionService;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {

    private static TransactionService underTest;
    public static TransactionRepository repoMock;

    @BeforeAll
    public static void init(){
        repoMock = Mockito.mock(TransactionRepository.class);
        underTest = new TransactionService(repoMock);
    }

    @AfterEach
    public  void resetMock(){
        Mockito.reset(repoMock);
    }

    @Test
    public void testGetTransaction(){
        //GIVEN
        Transaction source = new Transaction();
        when(repoMock.getTransactionById(eq(1))).thenReturn(source);

        //WHEN
        Transaction transaction = underTest.getTransaction(1);

        //THEN
        Assertions.assertEquals(source, transaction);
        verify(repoMock, times(1)).getTransactionById(any());
    }

    @Test
    public void testGetTransactions(){
        //GIVEN
        Transaction source = new Transaction();
        when(repoMock.getAllTransaction()).thenReturn(Arrays.asList(source));

        //WHEN
        Collection<Transaction> transactions = underTest.getTransactions();

        //THEN
        Assertions.assertEquals(Arrays.asList(source), transactions);
    }

    @Test
    public void testTransactionSave() {
        //GIVEN
        Transaction source = new Transaction();

        ArgumentCaptor<Transaction> captor = ArgumentCaptor.forClass(Transaction.class);

        doNothing().when(repoMock).saveTransaction(captor.capture());


        //WHEN
        underTest.saveTransaction(source);

        //THEN
        Assertions.assertEquals(source, captor.getValue());
    }





}
