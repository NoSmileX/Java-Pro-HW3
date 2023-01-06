package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Deserialize {
    public static Object restore(Object obj) {
        Object desObj = null;
        try {
            Class<?> cls = obj.getClass();

            try (BufferedReader br = new BufferedReader(new FileReader("serialized.txt"))) {
                desObj = cls.getDeclaredConstructor().newInstance();
                String line;

                while ((line = br.readLine()) != null) {
                    if (line.matches(".+:.+:.+")) {
                        String[] split = line.split(":");
                        String type = split[0];
                        String name = split[1];
                        String value = split[2];

                        for (Field field : cls.getDeclaredFields()) {
                            if (field.getName().equals(name) && field.getType().getSimpleName().equals(type)) {
                                field.setAccessible(true);

                                switch (field.getType().getSimpleName()) {
                                    case "byte" -> field.setInt(desObj, Byte.parseByte(value));
                                    case "short" -> field.setInt(desObj, Short.parseShort(value));
                                    case "int" -> field.setInt(desObj, Integer.parseInt(value));
                                    case "long" -> field.setLong(desObj, Long.parseLong(value));
                                    case "float" -> field.setDouble(desObj, Float.parseFloat(value));
                                    case "double" -> field.setDouble(desObj, Double.parseDouble(value));
                                    case "boolean" -> field.setBoolean(desObj, Boolean.parseBoolean(value));
                                    case "char" -> field.setChar(desObj, value.charAt(0));
                                    default -> field.set(desObj, value);
                                }
                            }
                        }
                    }
                }
            } catch (IOException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return desObj;
    }
}
