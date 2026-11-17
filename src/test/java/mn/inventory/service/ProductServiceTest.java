package mn.inventory.service;

import mn.inventory.model.Product;
import mn.inventory.repository.InMemoryProductRepository;
import mn.inventory.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductRepository repository;
    private ProductService service;

    @BeforeEach
    void setUp() {
        repository = new InMemoryProductRepository();
        service = new ProductService(repository);
    }

    @Test
    void addProduct_validData_savesProduct() {
        Product p = service.addProduct("Ус 0.5л", "4600001", 1200, "Ундаа");

        assertTrue(p.getId() > 0);
        assertEquals(1, repository.findAll().size());
        assertEquals("Ус 0.5л", repository.findAll().get(0).getName());
    }

    @Test
    void addProduct_emptyName_throwsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> service.addProduct("  ", "4600002", 1000, "Ундаа"));
        assertEquals("Барааны нэр хоосон байж болохгүй!", ex.getMessage());
    }

    @Test
    void addProduct_nonPositivePrice_throwsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> service.addProduct("Талх", "4600003", 0, "Хүнс"));
        assertEquals("Үнэ 0-ээс их байх ёстой!", ex.getMessage());
    }

    @Test
    void addProduct_duplicateBarcode_throwsException() {
        service.addProduct("Ус 0.5л", "4600001", 1200, "Ундаа");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> service.addProduct("Ус 1л", "4600001", 1800, "Ундаа"));
        assertEquals("Ийм баркодтой бараа бүртгэлтэй байна!", ex.getMessage());
        assertEquals(1, repository.findAll().size());
    }
}
