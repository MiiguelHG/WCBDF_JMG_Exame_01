package com.upiiz.examen1.Models;

import java.time.LocalDateTime;

public class Evento {
    private Long id;
    private String titulo;
    private LocalDateTime fechaHora;
    private String lugar;

    // Constructor
    public Evento() {}

    public Evento(Long id, String titulo, LocalDateTime fechaHora, String lugar) {
        this.id = id;
        this.titulo = titulo;
        this.fechaHora = fechaHora;
        this.lugar = lugar;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
