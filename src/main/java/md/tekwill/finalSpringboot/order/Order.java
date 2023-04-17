package md.tekwill.finalSpringboot.order;

import jakarta.persistence.*;
import md.tekwill.finalSpringboot.cart.Cart;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity; // New column for quantity

    @Column(name = "total_price") // Renamed to total_price
    private double totalPricePerProduct; // New column for TotalPricePerProduct

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPricePerProduct() {
        return totalPricePerProduct;
    }

    public void setTotalPricePerProduct(double totalPricePerProduct) {
        this.totalPricePerProduct = totalPricePerProduct;
    }


    public void updateTotalPricePerProduct() {
        this.totalPricePerProduct = price * quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPricePerProduct=" + totalPricePerProduct +
                '}';
    }

    public void addItem(Object product, int quantity) {
    }

    public <OrderItem> void addOrderItem(OrderItem orderItem) {
    }

    public void addCartItem(Cart cartItem) {
    }
}
