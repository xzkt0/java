package lab2;

import java.io.File;
import java.io.IOException;

public interface Serializer<T> {
    String serialize(T object) throws IOException;
    
    T deserialize(String content, Class<T> clazz) throws IOException;

    void writeToFile(T object, File file) throws IOException;

    T readFromFile(File file, Class<T> clazz) throws IOException;
}
