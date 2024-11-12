package lab2;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class YamlSerializer<T> implements Serializer<T> {
    private final YAMLMapper yamlMapper;

    public YamlSerializer() {
        yamlMapper = new YAMLMapper();
        yamlMapper.registerModule(new JavaTimeModule());  // Реєструємо модуль для роботи з LocalDate
    }

    @Override
    public String serialize(T object) throws IOException {
        return yamlMapper.writeValueAsString(object);
    }

    @Override
    public T deserialize(String content, Class<T> clazz) throws IOException {
        return yamlMapper.readValue(content, clazz);
    }

    @Override
    public void writeToFile(T object, File file) throws IOException {
        yamlMapper.writeValue(file, object);
    }

    @Override
    public T readFromFile(File file, Class<T> clazz) throws IOException {
        return yamlMapper.readValue(file, clazz);
    }
}
