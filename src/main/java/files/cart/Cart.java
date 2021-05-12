package files.cart;

import files.entity.Product;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@NoArgsConstructor
public class Cart {
    private List<Product> productCart;

    @PostConstruct
    public void init() {
        productCart = new ArrayList<>();
    }

    public List<Product> getProductCart() {
        return productCart;
    }

    public void deleteProductInCartById(Long longId) {
        int id = longId.intValue();
        for (int i = 0; i < productCart.size(); i++) {
            if (id == productCart.get(i).getId()) {
                productCart.remove(i);
            }
        }
    }

    public void addProduct(Product product) {
        productCart.add(product);
    }

    public void clear() {
        productCart.clear();
    }
}
