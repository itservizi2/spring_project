package md.tekwill.finalSpringboot.cart;

import md.tekwill.finalSpringboot.product.Product;
import md.tekwill.finalSpringboot.product.ProductNotFoundException;
import md.tekwill.finalSpringboot.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showCart(Model model) {
        List<Product> products = productService.listAll();
        model.addAttribute("products", products);
        return "cart";
    }

    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id, @RequestParam("quantity") int quantity) throws ProductNotFoundException {
        Product product = productService.get(id);
        Cart cartItem = new Cart();
        cartItem.setId(product.getId());
        cartItem.setName(product.getName());
        cartItem.setDescription(product.getDescription());
        cartItem.setPrice(product.getPrice());
        cartItem.setQuantity(quantity);
        productService.addToCart(cartItem);
        return "redirect:/cart";
    }

    @PostMapping("/placeorder")
    public String placeOrder() throws IOException {
        productService.placeOrder();
        return "redirect:/cart";
    }
}

