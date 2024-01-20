package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Autor;


public interface IAutorRepository {
    public void insertar(Autor autor);
    public Autor seleccionar(Integer id);
    public void actualizar(Autor autor);
    public void eliminar(Integer id);
    public Autor seleccionarPorApellido(String apellido);
    public Autor seleccionarPorNombre(String nombre);
    public List<Autor> seleccionarPorTitulo(String titulo);
    public Autor seleccionarPorNombreNamed(String nombre);
}
