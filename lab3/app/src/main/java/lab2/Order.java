package lab2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private final Customer customer;
    private final List<MenuItem> menuItems;
    private final LocalDate date;

    private Order(Customer customer, List<MenuItem> menuItems, LocalDate date) {
        this.customer = customer;
        this.menuItems = menuItems;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", menuItems=" + menuItems +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return customer.equals(order.customer) &&
                menuItems.equals(order.menuItems) &&
                date.equals(order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, menuItems, date);
    }

    public static class Builder {
        private Customer customer;
        private final List<MenuItem> menuItems = new ArrayList<>();
        private LocalDate date = LocalDate.now();

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder addMenuItem(MenuItem menuItem) {
            this.menuItems.add(menuItem);
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Order build() {
            return new Order(customer, menuItems, date);
        }
    }
}
