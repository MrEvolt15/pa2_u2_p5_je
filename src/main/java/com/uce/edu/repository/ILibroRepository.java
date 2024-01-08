package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Libro;

public interface ILibroRepository {
    public void insertar(Libro libro);
    public Libro seleccionar(Integer id);
    public void actualizar(Libro libro);
    public void eliminar(Integer id);
}
