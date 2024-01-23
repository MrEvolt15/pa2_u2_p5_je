package com.uce.edu.repository;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;

public interface ILibroRepository {
    public void insertar(Libro libro);
    public Libro seleccionar(Integer id);
    public void actualizar(Libro libro);
    public void eliminar(Integer id);
    public Libro seleccionarPorNombre(String nombre);
    public Libro seleccionarPorTitulo(String titulo);
    public List<Libro> seleccionarPorFecha(LocalDate fechaPublicacion);
    public List<Libro> seleccionarPorFechaTyped(LocalDate fechaPublicacion);
    public Libro seleccionarPorTituloNamed(String titulo);
    public List<Libro> seleccionarPorFechaNamed(LocalDate fechaPublicacion);

    public Libro seleccionarPorTituloMasFecha(String titulo, LocalDate fechaPublicaion);
    public Libro seleccionarSegundoTItulo(String titulo);
}
