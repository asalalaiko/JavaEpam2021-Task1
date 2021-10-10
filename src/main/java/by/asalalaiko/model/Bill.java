package by.asalalaiko.model;


public class Bill {
    private Integer id;
    private Customer customer;
    private boolean blocked;

    public Bill(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void prt() {
        System.out.println("Bill: "+this.id+"|"+this.customer+"|"+this.blocked+"|");
    }
}

