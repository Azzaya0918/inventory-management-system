package mn.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class StockCalculatorTest {

    @Test
    void sum_1_plus_2_equals_3() {
        assertEquals(3, StockCalculator.sum(1, 2));
    }

        @Test
    void sum_negative_quantity_throws_exception() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> StockCalculator.sum(-1, 2)
        );
        assertEquals("Тоо сөрөг байж болохгүй!", ex.getMessage());
    }
}