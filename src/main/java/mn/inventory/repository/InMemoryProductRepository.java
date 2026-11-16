package mn.inventory.repository;

import mn.inventory.model.Product;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Барааг санах ойд хадгалах хэрэгжүүлэлт. */
public class InMemoryProductRepository implements ProductRepository {
    private final Map<Long, Product> store = new LinkedHashMap<>();
    private long nextId = 1;

    @Override
    public Product save(Product product) {
        product.setId(nextId++);
        store.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findByBarcode(String barcode) {
        return store.values().stream()
                .filter(p -> p.getBarcode().equals(barcode))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }
}
