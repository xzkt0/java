package lab2;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Product product = new Product.Builder()
                    .setName("Burger")
                    .setPrice(5.99)
                    .setDescription("Delicious cheeseburger")
                    .build();

            Serializer<Product> jsonSerializer = new JsonSerializer<>();
            jsonSerializer.writeToFile(product, new File("product.json"));

        } catch (IOException e) {
            System.err.println("File operation failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Product creation failed: " + e.getMessage());
        }
    }
}
