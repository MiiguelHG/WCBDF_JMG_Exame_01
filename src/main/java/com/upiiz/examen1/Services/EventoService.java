package com.upiiz.examen1.Services;

import com.upiiz.examen1.Models.Evento;
import com.upiiz.examen1.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    //Requiero inyectar el repositorio
    @Autowired
    private EventoRepository eventoRepository;

    //Constructor - Cuando crear la instanica le pasa el repositorio
    public EventoService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    //GET
    public List<Evento> getAllEventos (){
        return eventoRepository.findAll();
    }

    //GET by Id
    public Evento getEventoById(Long id){
        return eventoRepository.findById(id);
    }

    //POST
    public Evento save(Evento evento){
        return eventoRepository.save(evento);
    }

    //PUT
    public Evento update(Evento evento){
        return eventoRepository.update(evento);
    }
    //DELETE
    public void delete(Long id){
        eventoRepository.deleteById(id);
    }
}
