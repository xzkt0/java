package lab2;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XmlSerializer<T> implements Serializer<T> {
    private final XmlMapper xmlMapper = new XmlMapper();

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
