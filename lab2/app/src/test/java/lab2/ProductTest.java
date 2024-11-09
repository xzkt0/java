    package lab2;

    import org.testng.Assert;
    import org.testng.annotations.Test;

    public class ProductTest {

        @Test
        public void testGetters() {
            Product product = new Product("Coffee", 2.99, "Hot brewed coffee");
            Assert.assertEquals(product.getName(), "Coffee");
            Assert.assertEquals(product.getPrice(), 2.99);
            Assert.assertEquals(product.getDescription(), "Hot brewed coffee");
        }

        @Test
        public void testToString() {
            Product product = new Product("Coffee", 2.99, "Hot brewed coffee");
            Assert.assertEquals(product.toString(), "Product{name='Coffee', price=2.99, description='Hot brewed coffee'}");
        }

        @Test
        public void testEqualsAndHashCode() {
            Product product1 = new Product("Coffee", 2.99, "Hot brewed coffee");
            Product product2 = new Product("Coffee", 2.99, "Hot brewed coffee");
            Product product3 = new Product("Tea", 1.99, "Green tea");

            Assert.assertEquals(product1, product2);
            Assert.assertNotEquals(product1, product3);
            Assert.assertEquals(product1.hashCode(), product2.hashCode());
        }
    }
