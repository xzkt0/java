package lab1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuItemTest {

    @Test
    public void testGetters() {
        MenuItem menuItem = new MenuItem("Burger", 9.99, "Delicious beef burger");
        Assert.assertEquals(menuItem.getName(), "Burger");
        Assert.assertEquals(menuItem.getPrice(), 9.99);
        Assert.assertEquals(menuItem.getDescription(), "Delicious beef burger");
    }

    @Test
    public void testToString() {
        MenuItem menuItem = new MenuItem("Burger", 9.99, "Delicious beef burger");
        Assert.assertEquals(menuItem.toString(), "MenuItem{name='Burger', price=9.99, description='Delicious beef burger'}");
    }

    @Test
    public void testEqualsAndHashCode() {
        MenuItem menuItem1 = new MenuItem("Burger", 9.99, "Delicious beef burger");
        MenuItem menuItem2 = new MenuItem("Burger", 9.99, "Delicious beef burger");
        MenuItem menuItem3 = new MenuItem("Fries", 3.99, "Crispy french fries");

        Assert.assertEquals(menuItem1, menuItem2);
        Assert.assertNotEquals(menuItem1, menuItem3);
        Assert.assertEquals(menuItem1.hashCode(), menuItem2.hashCode());
    }
}
