package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHabitacionRepository;
import com.uce.edu.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService{
    @Autowired
    private IHabitacionRepository habitacionRepository;
    @Override
    public List<Habitacion> buscarPorClase(String clase) {
        return this.habitacionRepository.seleccionarPorClase(clase);
    }
    @Override
    public Habitacion buscarPorNumero(String numero) {
        return this.habitacionRepository.seleccionarPorNumero(numero);
    }

}
