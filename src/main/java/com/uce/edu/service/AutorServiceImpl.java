package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAutorRepository;
import com.uce.edu.repository.modelo.Autor;

@Service
public class AutorServiceImpl implements IAutorService{
    @Autowired
    private IAutorRepository autorRepository;
    @Override
    public void guardar(Autor autor) {
        this.autorRepository.insertar(autor);
    }

    @Override
    public Autor buscar(Integer id) {
       return this.autorRepository.seleccionar(id);
    }

    @Override
    public void actualizar(Autor autor) {
        this.autorRepository.actualizar(autor);
    }

    @Override
    public void borrar(Integer id) {
       this.autorRepository.eliminar(id);
    }

    @Override
    public Autor buscarPorApellido(String apellido) {
        return this.autorRepository.seleccionarPorApellido(apellido);
    }

    @Override
    public Autor buscarPorNombre(String nombre) {
        return this.autorRepository.seleccionarPorNombre(nombre);

    }

    @Override
    public List<Autor> buscarPorTitulo(String titulo) {
        return this.autorRepository.seleccionarPorTitulo(titulo);
    }

    @Override
    public Autor buscarPorNombreNamed(String nombre) {
        return this.autorRepository.seleccionarPorNombreNamed(nombre);
    }

}
