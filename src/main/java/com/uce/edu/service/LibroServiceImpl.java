package com.uce.edu.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ILibroRepository;
import com.uce.edu.repository.modelo.Libro;

@Service
public class LibroServiceImpl implements ILibroService {
    @Autowired
    private ILibroRepository iLibroRepository;

    @Override
    public void guardar(Libro libro) {
        this.iLibroRepository.insertar(libro);
    }

    @Override
    public Libro buscar(Integer id) {
        return this.iLibroRepository.seleccionar(id);
    }

    @Override
    public void actualizar(Libro libro) {
        this.iLibroRepository.actualizar(libro);
    }

    @Override
    public void borrar(Integer id) {
        this.iLibroRepository.eliminar(id);
    }

    @Override
    public List<Libro> buscarPorFecha(LocalDate fecha) {
        return this.iLibroRepository.seleccionarPorFecha(fecha);
    }

    @Override
    public Libro buscarPorNombre(String nombre) {
        return this.iLibroRepository.seleccionarPorNombre(nombre);
    }

    @Override
    public Libro buscarPorTitulo(String titulo) {
        return this.iLibroRepository.seleccionarPorTitulo(titulo);
    }

    @Override
    public List<Libro> buscarPorFechaTyped(LocalDate fecha) {
        return this.iLibroRepository.seleccionarPorFechaTyped(fecha);
    }

    @Override
    public Libro buscarPorTituloNamed(String titulo) {
        return this.iLibroRepository.seleccionarPorTituloNamed(titulo);
    }

    @Override
    public List<Libro> buscarPorFechaNamed(LocalDate fecha) {
        return this.iLibroRepository.seleccionarPorFechaNamed(fecha);
    }

}
