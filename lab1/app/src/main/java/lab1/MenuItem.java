package lab1;

import java.util.Objects;

/**
 * Клас, що представляє елемент меню в ресторані.
 */
public class MenuItem {
    private final String name;
    private final double price;
    private final String description;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;
        MenuItem menuItem = (MenuItem) o;
        return Double.compare(menuItem.price, price) == 0 &&
                name.equals(menuItem.name) &&
                description.equals(menuItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description);
    }
}
