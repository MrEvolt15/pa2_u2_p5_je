package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {
    public void insertar(Ciudadano ciudadano);
    public Ciudadano select(Integer id);
    public void eliminar(Integer id);
    public void actualizar(Ciudadano ciudadano);
}
