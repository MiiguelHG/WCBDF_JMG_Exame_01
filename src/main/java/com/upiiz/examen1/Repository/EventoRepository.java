package com.upiiz.examen1.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.upiiz.examen1.Models.Evento;
import com.upiiz.examen1.Utils.JsonUtil;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EventoRepository {
    private AtomicLong nextId = new AtomicLong();

    // Guardar un evento
    public Evento save(Evento evento) {
        try {
            List<Evento> eventos = JsonUtil.readJsonFile(new TypeReference<List<Evento>>() {});
            evento.setId(nextId.incrementAndGet());
            eventos.add(evento);
            JsonUtil.writeJsonFile(eventos);
            return evento;
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el evento", e);
        }
    }

    // Obtener todos los eventos
    public List<Evento> findAll() {
        try {
            return JsonUtil.readJsonFile(new TypeReference<List<Evento>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error al obtener los eventos", e);
        }
    }

    // Obtener un evento por su id
    public Evento findById(Long id) {
        try {
            List<Evento> eventos = JsonUtil.readJsonFile(new TypeReference<List<Evento>>() {});
            return eventos.stream().filter(evento -> evento.getId().equals(id)).findFirst().orElse(null);
        } catch (IOException e) {
            throw new RuntimeException("Error al obtener el evento", e);
        }
    }

    // Eliminar un evento por su id
    public void deleteById(Long id) {
        try {
            List<Evento> eventos = JsonUtil.readJsonFile(new TypeReference<List<Evento>>() {});
            eventos.removeIf(evento -> evento.getId().equals(id));
            JsonUtil.writeJsonFile(eventos);
        } catch (IOException e) {
            throw new RuntimeException("Error al eliminar el evento", e);
        }
    }

    public Evento update(Evento evento) {
    try {
        List<Evento> eventos = JsonUtil.readJsonFile(new TypeReference<List<Evento>>() {});
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getId().equals(evento.getId())) {
                eventos.set(i, evento);
                JsonUtil.writeJsonFile(eventos);
                return evento;
            }
        }
        throw new RuntimeException("Evento no encontrado");
    } catch (IOException e) {
        throw new RuntimeException("Error al actualizar el evento", e);
    }
}
}
