import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Restaurant {


    private int maxTables;
    private List<Table> tables;
    private List<Order> orders;
    private int lastTableID = 0;

    public Restaurant(int maxTables) {
        this.maxTables = maxTables;
    }
    public Restaurant() {
    }

    //Implement the customerSays method: This method should allow customers to place their orders at
    // the specified table.
    public void customerSays(int tableId, String customerOrder){ //customerOrder : " Joe: Pizza"
        List<String> parts = Arrays.stream(customerOrder.split(":"))
                                        .map(String::trim)
                                        .collect(Collectors.toList());
        Order newOrder = new Order(parts.get(1), parts.get(0), tableId);
        orders.add(newOrder);
        for(Table table : tables){
            if(table.getTableID() == tableId){
                createOrder(tableId);
            }
        }
    }
    Table initTable(int tableCapacity){
        Table table = new Table(tableCapacity);
        table.setTableID(lastTableID++);
        tables.add(table);
        lastTableID++;
        return table;
    }

    String createOrder(int tableID){
        String fullOrder = "";
        for (Table table : tables) {
            if(table.getTableID() == tableID) {
                for (Order order : table.getTableOrders()) {
                    if (order.getTableID() == tableID) {
                        fullOrder += order.getOrder();
                        fullOrder += ", ";
                    }
                }
            }
        }
        return fullOrder;
    }
    //You'll need to consider various scenarios and edge cases, such as:
    //Handling orders from multiple customers at the same table.

    //Handling cases where not all customers have placed an order.
    //Handling cases where a dish is meant for a specific number of people.
}
