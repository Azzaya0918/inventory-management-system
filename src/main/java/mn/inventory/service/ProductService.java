package mn.inventory.service;

import mn.inventory.model.Product;
import mn.inventory.repository.ProductRepository;

/** Барааны бүртгэлийн бизнес логик. */
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Шинэ бараа бүртгэлд нэмнэ.
     *
     * @return id оноогдсон, хадгалагдсан бараа
     * @throws IllegalArgumentException нэр хоосон, үнэ 0 эсвэл түүнээс бага,
     *                                  эсвэл баркод давхцсан бол
     */
    public Product addProduct(String name, String barcode, double price, String category) {
        validate(name, barcode, price);
        return repository.save(new Product(name, barcode, price, category));
    }

    private void validate(String name, String barcode, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Барааны нэр хоосон байж болохгүй!");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Үнэ 0-ээс их байх ёстой!");
        }
        if (repository.findByBarcode(barcode).isPresent()) {
            throw new IllegalArgumentException("Ийм баркодтой бараа бүртгэлтэй байна!");
        }
    }
}
