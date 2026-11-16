package mn.inventory.model;

/** Агуулахад бүртгэгдсэн бараа. */
public class Product {
    private long id;
    private final String name;
    private final String barcode;
    private final double price;
    private final String category;
    private int quantity = 0;

    public Product(String name, String barcode, double price, String category) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.category = category;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public String getBarcode() { return barcode; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
}
