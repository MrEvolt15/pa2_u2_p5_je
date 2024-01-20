package com.uce.edu.repository.modelo;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
@NamedQuery(name = "Hotel.queryBuscarPorNombre",query = "SELECT h from Hotel h WHERE h.nombre = :nombre")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hotel")
    @SequenceGenerator(name = "seq_hotel", sequenceName = "seq_hotel", allocationSize = 1)
    @Column(name = "hot_id")
    private Integer id;
    @Column(name = "hot_nombre")
    private String nombre;
    @Column(name = "hot_direccion")
    private String direccion;

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private List<Habitacion> habitaciones;

    public Integer getId() {
        return id;
    }
    //
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    
}
