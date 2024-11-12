package lab2;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonSerializer<T> implements Serializer<T> {
    private final ObjectMapper objectMapper;

    public JsonSerializer() {
        // Ініціалізуємо ObjectMapper і реєструємо модуль для Java 8 Date/Time API
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());  // Реєструємо модуль для роботи з LocalDate
    }

    @Override
    public String serialize(T object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    @Override
    public T deserialize(String content, Class<T> clazz) throws IOException {
        return objectMapper.readValue(content, clazz);
    }

    @Override
    public void writeToFile(T object, File file) throws IOException {
        objectMapper.writeValue(file, object);
    }

    @Override
    public T readFromFile(File file, Class<T> clazz) throws IOException {
        return objectMapper.readValue(file, clazz);
    }
}
