package lab1;

import java.time.LocalDate;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest {

    @Test
    public void testBuilder() {
        Customer customer = new Customer("John Doe", "john@example.com");
        MenuItem menuItem1 = new MenuItem("Burger", 9.99, "Delicious beef burger");
        MenuItem menuItem2 = new MenuItem("Fries", 3.99, "Crispy french fries");
        LocalDate date = LocalDate.now();

        Order order = new Order.Builder()
                .setCustomer(customer)
                .addMenuItem(menuItem1)
                .addMenuItem(menuItem2)
                .setDate(date)
                .build();

        Assert.assertEquals(order.getCustomer(), customer);
        Assert.assertEquals(order.getMenuItems(), Arrays.asList(menuItem1, menuItem2));
        Assert.assertEquals(order.getDate(), date);
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("John Doe", "john@example.com");
        MenuItem menuItem = new MenuItem("Burger", 9.99, "Delicious beef burger");
        Order order = new Order.Builder().setCustomer(customer).addMenuItem(menuItem).build();

        String expected = "Order{customer=Customer{name='John Doe', email='john@example.com'}, menuItems=[MenuItem{name='Burger', price=9.99, description='Delicious beef burger'}], date=" + order.getDate() + "}";
        Assert.assertEquals(order.toString(), expected);
    }

    @Test
    public void testEqualsAndHashCode() {
        Customer customer = new Customer("John Doe", "john@example.com");
        MenuItem menuItem = new MenuItem("Burger", 9.99, "Delicious beef burger");

        Order order1 = new Order.Builder().setCustomer(customer).addMenuItem(menuItem).build();
        Order order2 = new Order.Builder().setCustomer(customer).addMenuItem(menuItem).build();
        Order order3 = new Order.Builder().setCustomer(new Customer("Jane Doe", "jane@example.com")).addMenuItem(menuItem).build();

        Assert.assertEquals(order1, order2);
        Assert.assertNotEquals(order1, order3);
        Assert.assertEquals(order1.hashCode(), order2.hashCode());
    }
}
