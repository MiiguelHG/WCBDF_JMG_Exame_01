package com.upiiz.examen1.Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private static final String FILE_PATH = "eventos.json";

    public static <T> List<T> readJsonFile(TypeReference<List<T>> typeReference) throws IOException {
        File file = new File(FILE_PATH);

        // Si el archivo no existe, crea una nueva lista vacía y retorna
        if (!file.exists()) {
            file.createNewFile();
            writeJsonFile(new ArrayList<>()); // Crear archivo vacío con una lista vacía
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
            return new ArrayList<>(); // Retorna una lista mutable vacía en caso de error
        }
    }

    public static <T> void writeJsonFile(List<T> list) throws IOException {
        objectMapper.writeValue(new File(FILE_PATH), list);
    }
}
