package md.tekwill.finalSpringboot.product;

import md.tekwill.finalSpringboot.cart.Cart;
import md.tekwill.finalSpringboot.cart.CartRepository;
import md.tekwill.finalSpringboot.order.Order;
import md.tekwill.finalSpringboot.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;
    @Autowired
    private CartRepository cartRepo;
    @Autowired
    private OrderRepository orderRepo;

    public List<Product> listAll() {
        return (List<Product>) repo.findAll();
    }

    public void save(Product product) {
        repo.save(product);
    }

    public Product get(Integer id) throws ProductNotFoundException {
        Optional<Product> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ProductNotFoundException("Could not find any products with ID " + id);
    }

    public void delete(Integer id) throws ProductNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new ProductNotFoundException("Could not find any products with ID " + id);
        }
        repo.deleteById(id);
    }

    public void addToCart(Cart cartItem) {
        cartRepo.save(cartItem);
    }

    public void placeOrder() {
        List<Cart> cartItems = (List<Cart>) cartRepo.findAll();
        Order order = new Order();
        for (Cart cartItem : cartItems) {
            order.addCartItem(cartItem);
        }
        orderRepo.save(order);
        cartRepo.deleteAll();
    }
}


