package com.uce.edu.repository.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor2_libro2")
public class AutorLibro {

    private Integer id;

    private Autor2 autor2;

    private Libro2 libro2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Autor2 getAutor2() {
        return autor2;
    }

    public void setAutor2(Autor2 autor2) {
        this.autor2 = autor2;
    }

    public Libro2 getLibro2() {
        return libro2;
    }

    public void setLibro2(Libro2 libro2) {
        this.libro2 = libro2;
    }

    
}
