package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAlumnoRepository;
import com.uce.edu.repository.modelo.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService{
    @Autowired
    private IAlumnoRepository alumnoRepository;
    @Override
    public Alumno buscar(Integer id) {
       return this.alumnoRepository.seleccionar(id);
    }

    @Override
    public void guardar(Alumno alumno) {
        this.alumnoRepository.insertar(alumno);
    }

    @Override
    public void actulizar(Alumno alumno) {
        this.alumnoRepository.actualizar(alumno);
    }

    @Override
    public void borrar(Integer id) {
        this.alumnoRepository.eliminar(id);
    }

}
