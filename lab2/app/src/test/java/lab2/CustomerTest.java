package lab2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest {

    @Test
    public void testGetters() {
        Customer customer = new Customer("John Doe", "john@example.com");
        Assert.assertEquals(customer.getName(), "John Doe");
        Assert.assertEquals(customer.getEmail(), "john@example.com");
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("John Doe", "john@example.com");
        Assert.assertEquals(customer.toString(), "Customer{name='John Doe', email='john@example.com'}");
    }

    @Test
    public void testEqualsAndHashCode() {
        Customer customer1 = new Customer("John Doe", "john@example.com");
        Customer customer2 = new Customer("John Doe", "john@example.com");
        Customer customer3 = new Customer("Jane Doe", "jane@example.com");

        Assert.assertEquals(customer1, customer2);
        Assert.assertNotEquals(customer1, customer3);
        Assert.assertEquals(customer1.hashCode(), customer2.hashCode());
    }
}
