package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {
    public void guardar(Ciudadano ciudadano);
    public Ciudadano buscar(Integer id);
    public void eliminar(Integer id);
    public void actualizar(Ciudadano ciudadano);

    public Empleado busacarPorCedula(String cedula);
    public Ciudadano buscarPorCedulaCiu(String cedula);

    public Ciudadano buscarPorApellido(String apellido);
    public Ciudadano buscarPorCriteria(String nombre,String apellido,String cedula);
    public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula);
}
