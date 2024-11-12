package lab2;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    private String name;
    private double price;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")  // Формат для серіалізації LocalDate
    private LocalDate date;  // Додаємо поле для дати

    public Product() {}

    @JsonCreator
    public Product(@JsonProperty("name") String name,
                   @JsonProperty("price") double price,
                   @JsonProperty("description") String description,
                   @JsonProperty("date") LocalDate date) {  // Додаємо параметр для дати
        this.name = name;
        this.price = price;
        this.description = description;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", date=" + date +  // Виводимо дату в toString
                '}';
    }

    // Геттери та сеттери
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
