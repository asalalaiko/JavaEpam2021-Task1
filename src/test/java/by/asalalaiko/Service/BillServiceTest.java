package by.asalalaiko.Service;

import by.asalalaiko.model.Bill;
import by.asalalaiko.repo.BillRepository;
import by.asalalaiko.service.BillService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class BillServiceTest {
    private static BillService underTest;
    public static BillRepository repoMock;

    @BeforeAll
    public static void init(){
        repoMock = Mockito.mock(BillRepository.class);
        underTest = new BillService(repoMock);
    }

    @AfterEach
    public  void resetMock(){
        Mockito.reset(repoMock);
    }

    @Test
    public void testGetBill(){
        //GIVEN
        Bill source = new Bill();
        when(repoMock.getBillById(eq(1))).thenReturn(source);

        //WHEN
        Bill bill = underTest.getBill(1);

        //THEN
        Assertions.assertEquals(source, bill);
        verify(repoMock, times(1)).getBillById(any());
    }

    @Test
    public void testGetTransactions(){
        //GIVEN
        Bill source = new Bill();
        when(repoMock.getAllBill()).thenReturn(Arrays.asList(source));

        //WHEN
        Collection<Bill> bills = underTest.getBills();

        //THEN
        Assertions.assertEquals(Arrays.asList(source), bills);
    }

    @Test
    public void testBillSave() {
        //GIVEN
        Bill source = new Bill();

        ArgumentCaptor<Bill> captor = ArgumentCaptor.forClass(Bill.class);

        doNothing().when(repoMock).saveBill(captor.capture());


        //WHEN
        underTest.saveBill(source);

        //THEN
        Assertions.assertEquals(source, captor.getValue());
    }


}
