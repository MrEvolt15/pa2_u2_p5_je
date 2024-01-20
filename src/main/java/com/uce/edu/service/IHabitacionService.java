package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Habitacion;

public interface IHabitacionService {
    public List<Habitacion> buscarPorClase(String clase);
    public Habitacion buscarPorNumero(String numero);
}
