package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorService {
    public void guardar(Autor autor);
    public Autor buscar(Integer id);
    public void actualizar(Autor autor);
    public void borrar(Integer id);
    public Autor buscarPorApellido(String apellido);
    public Autor buscarPorNombre(String nombre);
    public List<Autor> buscarPorTitulo(String titulo);
    public Autor buscarPorNombreNamed(String nombre);
}
