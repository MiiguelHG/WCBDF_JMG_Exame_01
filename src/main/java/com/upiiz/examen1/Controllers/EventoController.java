package com.upiiz.examen1.Controllers;

import com.upiiz.examen1.Models.Evento;
import com.upiiz.examen1.Services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evento")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }

    //GET
    @GetMapping
    public ResponseEntity<List<Evento>> getEventos(){
        return ResponseEntity.ok(eventoService.getAllEventos());
    }

    //GET by Id
    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id){
        return ResponseEntity.ok(eventoService.getEventoById(id));
    }

    //POST
    @PostMapping
    public ResponseEntity<Evento> save(@RequestBody Evento evento) {
            Evento savedEvento = eventoService.save(evento);
            return ResponseEntity.ok(savedEvento);
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Evento> update(@PathVariable Long id, @RequestBody Evento evento){
        evento.setId(id);
        return ResponseEntity.ok(eventoService.update(evento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        eventoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
