package lab2;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

    public class Main {
    public static void main(String[] args) {
        try {
            // Створення продукту з датою
            Product product = new Product("Burger", 5.99, "Delicious cheeseburger", LocalDate.now());
            
            // Серіалізація продукту і дати окремо в JSON, XML, YAML

            // JSON
            Serializer<Object> jsonSerializer = new JsonSerializer<>();
            String jsonProduct = jsonSerializer.serialize(product);
            System.out.println("Product with date in JSON: " + jsonProduct);
            jsonSerializer.writeToFile(product, new File("product.json"));

            // XML
            Serializer<Object> xmlSerializer = new XmlSerializer<>();
            String xmlProduct = xmlSerializer.serialize(product);
            System.out.println("Product with date in XML: " + xmlProduct);
            xmlSerializer.writeToFile(product, new File("product.xml"));

            // YAML
            Serializer<Object> yamlSerializer = new YamlSerializer<>();
            String yamlProduct = yamlSerializer.serialize(product);
            System.out.println("Product with date in YAML: " + yamlProduct);
            yamlSerializer.writeToFile(product, new File("product.yaml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
