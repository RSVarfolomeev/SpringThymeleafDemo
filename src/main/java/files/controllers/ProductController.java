package files.controllers;

import files.cart.Cart;
import files.entity.Product;
import files.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    private Cart cart;

    //    http://localhost:8080/app/v1/products
    @GetMapping
    public String index(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);
        model.addAttribute("cart", cart.getProductCart());
        model.addAttribute("string", "Products");
        return "index";
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @DeleteMapping("/delete")
    public String deleteProduct(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/v1/products";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/v1/products";
    }

    @PostMapping("/updateproduct")
    public String updateProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/v1/products";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "update-product";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Product product,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            return "index";
        }
        productRepository.save(product);
        return "redirect:/v1/products";
    }

    @DeleteMapping("/deleteidcart")
    public String deleteIdCart(@RequestParam(name = "id") Long id) {
        cart.deleteProductInCartById(id);
        return "redirect:/v1/products";
    }

    @PostMapping("/addcart")
    public String addProductToCart(@ModelAttribute Product product) {
        cart.addProduct(product);
        return "redirect:/v1/products";
    }

    @DeleteMapping("/clearcart")
    public String clearCart() {
        cart.clear();
        return "redirect:/v1/products";
    }
}