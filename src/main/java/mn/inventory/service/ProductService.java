package mn.inventory.service;

import mn.inventory.model.Product;
import mn.inventory.repository.ProductRepository;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product addProduct(String name, String barcode, double price, String category) {
        return repository.save(new Product(name, barcode, price, category));
    }
}
