package mn.inventory.repository;

import mn.inventory.model.Product;
import java.util.List;
import java.util.Optional;

/** Барааны хадгалалтын интерфейс. Дараагийн sprint-д MySQL хэрэгжүүлэлт нэмэгдэнэ. */
public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findByBarcode(String barcode);
    List<Product> findAll();
}
