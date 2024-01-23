package com.uce.edu.service;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;

public interface ILibroService {
    public void guardar(Libro libro);
    public Libro buscar(Integer id);
    public void actualizar(Libro libro);
    public void borrar(Integer id);
    public Libro buscarPorNombre(String nombre);
    public Libro buscarPorTitulo(String titulo);
    public Libro buscarPorTituloNamed(String titulo);
    public List<Libro> buscarPorFecha(LocalDate fecha);
    public List<Libro> buscarPorFechaTyped(LocalDate fecha);
    public List<Libro> buscarPorFechaNamed(LocalDate fecha);

    public Libro buscarPorTituloMasFecha(String titulo, LocalDate fechaPublicaion);
    public Libro buscarSegundoTitulo(String titulo);
}
