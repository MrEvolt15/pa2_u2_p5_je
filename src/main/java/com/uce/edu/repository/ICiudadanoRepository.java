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
}
