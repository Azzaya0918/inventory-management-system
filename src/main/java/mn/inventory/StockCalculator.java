package mn.inventory;

public class StockCalculator {

    /**
     * Одоогийн үлдэгдэл дээр орж ирсэн тоог нэмнэ.
     *
     * @param a эхний хэмжээ (0 буюу түүнээс их)
     * @param b хоёр дахь хэмжээ (0 буюу түүнээс их)
     * @return нийлбэр
     * @throws IllegalArgumentException аль нэг тоо сөрөг бол
     */
    public static int sum(int a, int b) {
        validate(a);
        validate(b);
        return a + b;
    }

private static void validate(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Тоо сөрөг байж болохгүй!");
        }
    }
}