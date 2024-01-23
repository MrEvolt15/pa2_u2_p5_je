package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {
    public void insertar(Ciudadano ciudadano);
    public Ciudadano select(Integer id);
    public void eliminar(Integer id);
    public void actualizar(Ciudadano ciudadano);

    public Empleado seleccionarPorCedula(String cedula);
    public Ciudadano seleccionarPorCedulaCiu(String cedula);
    public Ciudadano seleccionarPorApellido(String apellido);

    //Funcionalidad que cuando sea el ciudadano de Pichincha busque por nombre 
    //cuando sea de cotopaxi lo busque por apellido 
    //cuando no sea ninguna de las 2 
    public Ciudadano seleccionarPorCriteria(String nombre,String apellido,String cedula);
    public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);
}
