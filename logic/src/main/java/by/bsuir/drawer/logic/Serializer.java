package by.bsuir.drawer.logic;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.undercouch.bson4jackson.BsonFactory;

public class Serializer {

    public static void serialize(List<Object> objects, String filePath) {
        BsonFactory factory = new BsonFactory();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectMapper mapper = new ObjectMapper(factory);
        try {
            mapper.writeValue(baos, objects);
            File file = new File(filePath);
            boolean success = file.delete();
            success &= file.createNewFile();
            baos.writeTo(new FileOutputStream(new File(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Object> deserialize(byte[] bytes) {
        BsonFactory factory = new BsonFactory();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectMapper mapper = new ObjectMapper(factory);
        try {
            return mapper.readValue(bytes, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
