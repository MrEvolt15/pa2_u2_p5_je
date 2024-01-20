package com.uce.edu.repository.modelo;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
@NamedQuery(name = "Estudiante.queryBuscarPorApellido",query = "SELECT e from Estudiante e WHERE e.apellido = :apellido")
@NamedQuery(name = "Estudiante.queryBuscarPorFecha",query = "SELECT e from Estudiante e WHERE e.fechaNacimiento > :fecha")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name = "seq",sequenceName = "seq_estudiante",allocationSize = 1)
    @Column(name = "estu_id")
    private Integer id;
    @Column(name = "estu_nombre")
    private String nombre;
    @Column(name = "estu_cedula")
    private String cedula;
    @Column(name = "estu_apellido")
    private String apellido;
    @Column(name = "estu_fecha_nacimiento")
    private LocalDateTime fechaNacimiento;

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + ", apellido=" + apellido + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
