package org.example;

import org.example.annotations.Save;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class Serialize {
    public static void save(Object obj) {
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder();

        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(Save.class)) {
                field.setAccessible(true);
                String value = "";

                try {
                    value = switch (field.getType().getSimpleName()) {
                        case "byte" -> String.format("%s", field.getByte(obj));
                        case "short" -> String.format("%s", field.getShort(obj));
                        case "int" -> String.format("%s", field.getInt(obj));
                        case "long" -> String.format("%s", field.getLong(obj));
                        case "float" -> String.format("%s", field.getFloat(obj));
                        case "double" -> String.format("%s", field.getDouble(obj));
                        case "boolean" -> String.format("%s", field.getBoolean(obj));
                        case "char" -> String.format("%s", field.getChar(obj));
                        default -> (String) field.get(obj);
                    };
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                sb.append(String.format("%s:%s:%s\n", field.getType().getSimpleName(), field.getName(), value));
            }
        }

        String filename = "serialized.txt";
        try (PrintWriter pw = new PrintWriter(filename)) {
            pw.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
