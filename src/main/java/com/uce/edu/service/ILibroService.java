package com.uce.edu.service;

import com.uce.edu.repository.modelo.Libro;

public interface ILibroService {
    public void guardar(Libro libro);
    public Libro buscar(Integer id);
    public void actualizar(Libro libro);
    public void borrar(Integer id);
}
