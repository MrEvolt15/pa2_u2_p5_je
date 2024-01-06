package com.uce.edu.repository.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro2")
public class Libro2 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro2")
    @SequenceGenerator(name = "seq_libro2", sequenceName = "seq_libro2", allocationSize = 1)
    @Column(name = "lib_id")
    private Integer id;
    @Column(name = "lib_titulo")
    private String titulo;
    @Column(name = "lib_fecha_publicacion")
    private LocalDate fechaPublicacion;
    
    private List<AutorLibro> autoresLibros;

    //SETS Y GETS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
}
