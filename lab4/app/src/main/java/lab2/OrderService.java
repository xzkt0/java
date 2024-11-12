package lab2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private final Order order;
    //сортування меню за ціною (використовує Comparator)
public OrderService(Order order){
    this.order = order;
}
public List<MenuItem> sortMenuItemsByPrice() {
    return order.getMenuItems().stream()
            .sorted(Comparator.comparingDouble(MenuItem::getPrice))
            .collect(Collectors.toList());
}


    //Отримання списку унікальних клієнтів із колекції замовлень
    public List<Customer> getUniqueCustomers(List<Order> orders) {
        return orders.stream()
                .map(Order::getCustomer)
                .distinct()
                .collect(Collectors.toList());
    }

    //Підрахунок загальної суми замовлення
    public double calculateTotalOrderPrice() {
        return order.getMenuItems().stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }
}