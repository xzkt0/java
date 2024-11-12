package lab2;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;

public class YamlSerializer<T> implements Serializer<T> {
    private final YAMLMapper yamlMapper = new YAMLMapper();

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
