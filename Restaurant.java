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

    public void customerSays(int tableId, String customerOrder){ //customerOrder : " Joe: Pizza"
        List<String> parts = Arrays.stream(customerOrder.split(":"))
                .map(String::trim)
                .collect(Collectors.toList());
        int quantity = 1;

        if (parts.size() >= 3 && parts.get(2).startsWith("for")) {
            quantity = Integer.parseInt(parts.get(2).split("\\s+")[1]);
            
        }
        Order newOrder = new Order(parts.get(1), parts.get(0), tableId);
        orders.add(newOrder);
        for(Table table : tables){
            if(table.getTableID() == tableId){
                createOrder(tableId);
            }
        }
    }
    int initTable(int tableCapacity){
        Table table = new Table(tableCapacity);
        lastTableID++;
        table.setTableID(lastTableID);
        tables.add(table);
        return lastTableID;
    }

    String createOrder(int tableID){
        int missing = 10;
        String fullOrder = "";
        for (Table table : tables) {
            if(table.getTableID() == tableID) {
                missing = table.getTableCapacity()-table.getTableOrders().size();
                for (Order order : table.getTableOrders()) {
                    if (order.getTableID() == tableID) {
                        fullOrder += order.getOrder();
                        fullOrder += ", ";
                    }
                }
            }
            else return "ERROR";
        }
        if(missing == 0) return fullOrder;
        else return "Missing " + missing;

    }

}
