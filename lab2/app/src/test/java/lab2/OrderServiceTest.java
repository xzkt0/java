package lab2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderServiceTest {

    private OrderService orderService;
    private List<Order> orders;
    private Customer customer1; 
    private Customer customer2;
    private MenuItem menuItem1;
    private MenuItem menuItem2;
    private MenuItem menuItem3;

    @BeforeMethod
    public void setUp() {
        // Ініціалізуємо тестові дані перед кожним тестом
        customer1 = new Customer("John Doe", "john@example.com");
        customer2 = new Customer("Jane Doe", "jane@example.com");

        menuItem1 = new MenuItem("Burger", 9.99, "Delicious beef burger");
        menuItem2 = new MenuItem("Fries", 3.99, "Crispy french fries");
        menuItem3 = new MenuItem("Salad", 5.49, "Healthy green salad");

        Order order1 = new Order.Builder()
                .setCustomer(customer1)
                .addMenuItem(menuItem3)
                .addMenuItem(menuItem2)
                .addMenuItem(menuItem1)
                .setDate(LocalDate.now())
                .build();

        Order order2 = new Order.Builder()
                .setCustomer(customer2)
                .addMenuItem(menuItem2)
                .addMenuItem(menuItem3)
                .setDate(LocalDate.now().minusDays(1))
                .build();

        orders = Arrays.asList(order1, order2);
        
        
        orderService = new OrderService(order1); 
    }

    // Сортує елементи меню за ціною
    @Test
    public void testSortMenuItemsByPrice() {
        List<MenuItem> sortedMenu = orderService.sortMenuItemsByPrice();
    
        List<MenuItem> expectedSortedMenu = Arrays.asList(menuItem2, menuItem3, menuItem1); 
        Assert.assertEquals(sortedMenu, expectedSortedMenu);
    }

    // Отримує список унікальних клієнтів
    @Test
    public void testGetUniqueCustomers() {
        List<Customer> uniqueCustomers = orderService.getUniqueCustomers(orders);
        assertEquals(uniqueCustomers.size(), 2);
        assertTrue(uniqueCustomers.stream().anyMatch(c -> c.getName().equals("John Doe")));
        assertTrue(uniqueCustomers.stream().anyMatch(c -> c.getName().equals("Jane Doe")));
    }
}
