package main.src;

import java.util.List;

public class Table {
    private int tableID;
    private int tableCapacity;
    private List<Order> tableOrders;

    public Table(int tableCapacity) {
        this.tableCapacity = tableCapacity;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public int getTableCapacity() {
        return tableCapacity;
    }

    public void setTableCapacity(int tableCapacity) {
        this.tableCapacity = tableCapacity;
    }
    public List<Order> getTableOrders() {
        return tableOrders;
    }





}
