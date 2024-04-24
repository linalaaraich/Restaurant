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



    //Implement the createOrder method: This method should generate the final order based
    // on the orders placed by the customers at the table.

    //Ensuring that the order is correctly formatted.
    String toString(Order order){
        return customer + ": " + order;
    }


    public int getTableID() {
        return tableID;
    }
}
