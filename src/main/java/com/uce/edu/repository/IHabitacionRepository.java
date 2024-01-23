package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Habitacion;

public interface IHabitacionRepository {
    public List<Habitacion> seleccionarPorClase(String clase);
    public Habitacion seleccionarPorNumero(String numero);
    public Habitacion seleccionarPorNumeroCriteria(String numero);

    public Habitacion seleccionarPrimeroContiene(String numero);
}
