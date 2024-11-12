package lab2;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private final String name;
    private final double price;
    private final String description;

    private Product(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.description = builder.description;
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
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private double price;
        private String description;

        private static final double MIN_PRICE = 1;
        private static final double MAX_PRICE = 1000;
        private static final int MAX_NAME_LENGTH = 50;
        private static final String NAME_PATTERN = "^[A-Za-z0-9 ]+$";

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            List<String> errors = new ArrayList<>();

            if (name == null || name.isEmpty()) {
                errors.add("Name cannot be null or empty.");
            } else if (name.length() > MAX_NAME_LENGTH) {
                errors.add("Name is too long (max " + MAX_NAME_LENGTH + " characters).");
            } else if (!name.matches(NAME_PATTERN)) {
                errors.add("Name contains invalid characters.");
            }

            if (price < MIN_PRICE || price > MAX_PRICE) {
                errors.add("Price must be between " + MIN_PRICE + " and " + MAX_PRICE + ".");
            }

            if (description == null || description.isEmpty()) {
                errors.add("Description cannot be null or empty.");
            }

            if (!errors.isEmpty()) {
                throw new IllegalArgumentException("Invalid fields: " + String.join("; ", errors));
            }

            return new Product(this);
        }
    }
}
