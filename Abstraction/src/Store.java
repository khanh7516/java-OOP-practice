import java.util.ArrayList;

record OrderItem (int qty, ProductForSale product){};
public class Store {


    private static ArrayList <ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {
        storeProducts.add(new ArtObject("Oil Painting", 1250, "Impressionistic work by ABF"));
        storeProducts.add(new ArtObject("Sculpture", 2000, "Bronze work by JKF, produced in 1950"));
        storeProducts.add(new ArtObject("Oil Painting", 1250, "Impressionistic work by ABF"));
        storeProducts.add(new ArtObject("Oil Painting", 1250, "Impressionistic work by ABF"));

        listProducts();
        System.out.println("\nOrder 1");
        ArrayList <OrderItem> order1 = new ArrayList<>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);

    }

    public static void listProducts() {
        for (var item : storeProducts) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty) {
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order) {
        double salesTotal = 0;
        for (var item: order) {
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Total = $%6.2f %n", salesTotal);
    }
}
