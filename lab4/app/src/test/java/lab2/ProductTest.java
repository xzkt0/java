package lab2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product.Builder()
                .setName("Burger")
                .setPrice(5.99)
                .setDescription("Delicious cheeseburger")
                .build();

        assertEquals(product.getName(), "Burger");
        assertEquals(product.getPrice(), 5.99);
        assertEquals(product.getDescription(), "Delicious cheeseburger");
    }

    @Test
    public void testInvalidProduct() {
        // Ініціалізуємо exception до початку блоку try-catch
        IllegalArgumentException exception = null;

        try {
            new Product.Builder()
                    .setName("") // Неприпустиме ім'я
                    .setPrice(5.99)
                    .setDescription("Delicious cheeseburger")
                    .build();
        } catch (IllegalArgumentException e) {
            exception = e;
        }

        assertTrue(exception != null, "Expected IllegalArgumentException to be thrown");
        if (exception != null) {
            assertTrue(exception.getMessage().contains("Name cannot be null or empty."));
        }
    }
}