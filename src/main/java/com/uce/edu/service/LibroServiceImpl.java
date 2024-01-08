package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ILibroRepository;
import com.uce.edu.repository.modelo.Libro;

@Service
public class LibroServiceImpl implements ILibroService{
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

}
