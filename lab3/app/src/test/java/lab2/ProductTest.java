    package lab2;

    import java.time.LocalDate;

    import org.testng.Assert;
    import org.testng.annotations.Test;

    public class ProductTest {

        @Test
        public void testGetters() {
            LocalDate date = LocalDate.now();  // Створюємо поточну дату
            Product product = new Product("Coffee", 2.99, "Hot brewed coffee", date);
            Assert.assertEquals(product.getName(), "Coffee");
            Assert.assertEquals(product.getPrice(), 2.99);
            Assert.assertEquals(product.getDescription(), "Hot brewed coffee");
            Assert.assertEquals(product.getDate(), date);  // Перевіряємо дату
        }

        @Test
        public void testToString() {
            LocalDate date = LocalDate.now();  // Створюємо поточну дату
            Product product = new Product("Coffee", 2.99, "Hot brewed coffee", date);
            Assert.assertEquals(product.toString(), "Product{name='Coffee', price=2.99, description='Hot brewed coffee', date=" + date + "}");
        }

        @Test
        public void testEqualsAndHashCode() {
            LocalDate date = LocalDate.now();  // Створюємо поточну дату
            Product product1 = new Product("Coffee", 2.99, "Hot brewed coffee", date);
            Product product2 = new Product("Coffee", 2.99, "Hot brewed coffee", date);
            Product product3 = new Product("Tea", 1.99, "Green tea", date);

            Assert.assertEquals(product1, product2);  // Продукти з однаковими даними мають бути рівні
            Assert.assertNotEquals(product1, product3);  // Продукти з різними даними не повинні бути рівні
            Assert.assertEquals(product1.hashCode(), product2.hashCode());  // Перевірка hashCode
        }
    }
