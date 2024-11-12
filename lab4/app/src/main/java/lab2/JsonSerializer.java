package lab2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonSerializer<T> implements Serializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

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
