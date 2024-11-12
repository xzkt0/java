package lab2;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class XmlSerializer<T> implements Serializer<T> {
    private final XmlMapper xmlMapper;

    public XmlSerializer() {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());  // Реєструємо модуль для роботи з LocalDate
    }

    @Override
    public String serialize(T object) throws IOException {
        return xmlMapper.writeValueAsString(object);
    }

    @Override
    public T deserialize(String content, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(content, clazz);
    }

    @Override
    public void writeToFile(T object, File file) throws IOException {
        xmlMapper.writeValue(file, object);
    }

    @Override
    public T readFromFile(File file, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(file, clazz);
    }
}
