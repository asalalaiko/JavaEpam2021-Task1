package by.asalalaiko.service;

import by.asalalaiko.model.Bill;
import by.asalalaiko.repo.BillRepository;

import java.util.Collection;


public class BillService {
    private BillRepository repo;

    public BillService(BillRepository repo){
        this.repo = repo;
    }

    public Bill getBill(Integer id){
        Bill bill = repo.getBillById(id);
        return bill;
    }


    public Collection<Bill> getBills(){
        return  repo.getAllBill();
    }


    public  void  saveBill(Bill bill){
        repo.saveBill(bill);
    }

    //public  Integer getSunPositiveBills(){}

    //public  Integer getSumNegativeBills(){}


}
