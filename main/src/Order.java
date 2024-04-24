package main.src;

public class Order {
    private final String order;
    private String customer;
    private final int tableID;

    public Order(String order, int tableID) {
        this.order = order;
        this.tableID = tableID;
    }
    public Order(String order, String customer, int tableID) {
        this.order = order;
        this.customer = customer;
        this.tableID = tableID;
    }

    public String getOrder() {
        return order;
    }

    public String getCustomer() {
        return customer;
    }

    String toString(Order order){
        return customer + ": " + order;
    }
    public int getTableID() {
        return tableID;
    }
}
