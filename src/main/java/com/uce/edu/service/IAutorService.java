package com.uce.edu.service;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorService {
    public void guardar(Autor autor);
    public Autor buscar(Integer id);
    public void actualizar(Autor autor);
    public void borrar(Integer id);
}
