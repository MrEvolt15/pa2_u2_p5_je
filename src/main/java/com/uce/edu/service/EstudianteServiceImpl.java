package com.uce.edu.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
    @Autowired
    private IEstudianteRepository estudianteRepository;
    @Override
    public Estudiante buscar(Integer id) {
        return this.estudianteRepository.seleccionar(id);
    }

    @Override
    public void guardar(Estudiante estudiante) {
       this.estudianteRepository.insertar(estudiante);
    }

    @Override
    public void actulizar(Estudiante estudiante) {
       this.estudianteRepository.actualizar(estudiante);
    }

    @Override
    public void borrar(Integer id) {
        this.estudianteRepository.eliminar(id);
    }

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
        return this.estudianteRepository.seleccionarPorCedula(cedula);
    }

    @Override
    public Estudiante buscarPorApellidoNamed(String apellido) {
        return this.estudianteRepository.seleccionarPorApellidoNamed(apellido);
    }

    @Override
    public List<Estudiante> buscarPorFecha(LocalDateTime fecha) {
        return this.estudianteRepository.seleccionarPorFecha(fecha);
    }

}
