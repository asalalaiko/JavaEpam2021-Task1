package by.asalalaiko.model;

public class Transaction {
    private Integer id;
    private Bill bill;
    private Integer sum ;

    public Transaction(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public void prt() {
        System.out.println("Transaction: "+this.id+"|"+this.bill+"|"+this.sum+"|");
    }
}
